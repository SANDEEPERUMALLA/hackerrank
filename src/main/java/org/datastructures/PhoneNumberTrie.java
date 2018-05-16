package org.datastructures;


import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class TrieNode {
    public char number;
    public boolean isLeaf = false;

    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Character, TrieNode> children = new HashMap<>();


    public TrieNode(char number) {
        this.number = number;
    }

    public char getNumber() {
        return number;
    }
}

class Contact {

    private String name;
    private String number;

    public Contact(String name, String number) {

        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

public class PhoneNumberTrie {

    List<Contact> contactList = new ArrayList<>();
    Map<String, TrieNode> prefixStringAndNodeMapping = new HashMap<>();

    public TrieNode rootNode = new TrieNode('$');

    public PhoneNumberTrie() {
        for (int i = 0; i <= 9; i++) {
            char ch = ((char) ('0' + i));
            rootNode.children.put(ch, new TrieNode((char) (ch)));
        }
    }


    void insert(TrieNode node, String number, String name, int index) {


        char ch = number.charAt(index);
        TrieNode n = node.children.get(ch);
        if (n == null) {
            n = new TrieNode(ch);
            node.children.put(ch, n);

        }

        if (index == number.length() - 1) {
            n.isLeaf = true;
            n.setName(name);
            return;
        }

        insert(n, number, name, index + 1);

    }

    public void insertContact(String name, String number) {

        char ch = number.charAt(0);

        insert(rootNode.children.get(ch), number, name, 1);

    }

    private void findAllChildren(TrieNode node, StringBuilder sb) {


        if (node.isLeaf) {
            contactList.add(new Contact(node.getName(), sb.toString()));
        }


        for (char ch : node.children.keySet()) {

            sb.append(ch);
            TrieNode n = node.children.get(ch);
            findAllChildren(n, sb);

            sb.replace(sb.length() - 1, sb.length(), "");


        }

    }

    private void search(TrieNode node, String number, int index) {

        TrieNode n = node.children.get(number.charAt(index));
        if (n == null) {
            return;
        }

        if (index == number.length() - 1) {

            prefixStringAndNodeMapping.put(number, n);
            findAllChildren(n, new StringBuilder());
            return;
        }
        search(n, number, index + 1);


    }


    public void search(String number) {

        contactList.clear();

        if (prefixStringAndNodeMapping.containsKey(number)) {
            findAllChildren(prefixStringAndNodeMapping.get(number), new StringBuilder());
            return;
        }

        search(rootNode.children.get(number.charAt(0)), number, 1);

    }

    public static void main(String args[]) {

        StringBuilder sb = new StringBuilder();
        sb.append("ab");
        sb.replace(sb.length() - 1, sb.length(), "");
        System.out.println(sb.toString());
        PhoneNumberTrie pt = new PhoneNumberTrie();

        pt.insertContact("Sandeep", "9160681311");
        pt.insertContact("Kumar", "9160684567");
        pt.insertContact("Gupta", "9160681237");

        System.out.println(pt);
        String searchNumber = "9160";
        pt.search(searchNumber);

        for (Contact contact : pt.contactList) {
            System.out.println(contact.getName() + ":" + searchNumber + contact.getNumber());
        }

    }
}
