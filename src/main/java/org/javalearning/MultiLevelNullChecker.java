package org.javalearning;

import org.omg.CORBA.PERSIST_STORE;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MultiLevelNullChecker {


    boolean isNull(Class clazz, String path, Object o) throws Exception {


        String p[] = path.split("\\.");

        return isNull(clazz, p, o, 0);

    }


    String capitalize(String s) {

        return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
    }

    boolean isNull(Class clazz, String path[], Object o, int index) throws Exception {

        String currentPath = path[index];

        // Field field = clazz.getField(currentPath);
        Method method = null;
        try {
            method = clazz.getDeclaredMethod("get" + capitalize(currentPath));
        } catch (NoSuchMethodException e) {
            throw new ProcessingException("Wrong Path specified");
        }


        Object res = method.invoke(o);
        if (res == null) {
            return true;
        }

        if (index == path.length - 1) {
            return false;
        }

        return isNull(res.getClass(), path, res, index + 1);


    }

    public static void main(String args[]) throws Exception {
        Address address = new Address();
        address.setCity("Bangalore");

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setAddress(address);

        Employee employee = new Employee();
        employee.setPersonalInfo(personalInfo);

        MultiLevelNullChecker multiLevelNullChecker = new MultiLevelNullChecker();

        boolean isNull = multiLevelNullChecker.isNull(employee.getClass(), "personalInfo.addres1s.city", employee);
        System.out.println(isNull);

    }


}

class Address {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class PersonalInfo {

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Employee {

    private PersonalInfo personalInfo;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
}

class ProcessingException extends Exception {

    String info;

    ProcessingException(String info) {
        super(info);
    }

}