package org.hackerrank.solutions;

import java.util.*;
import java.util.stream.Collectors;

public class CharsOrderInAWord {


    static class WordObject {

        String name;
        Integer position;

        public WordObject(String name, Integer position) {
            this.name = name;
            this.position = position;
        }
    }

    static private List<String> combinations = new ArrayList<>();

    static void findCombinations(String str, Map<Integer, String> m, int index, char res[]) {

        if (index == str.length()) {
            combinations.add(new String(res));
            return;
        }

        int num = str.charAt(index) - 48;

        String s = m.get(num);

        for (int i = 0; i < s.length(); i++) {

            res[index] = s.charAt(i);
            findCombinations(str, m, index + 1, res);
        }


    }

    static void findCombinationWrapper(String in, Map<Integer, String> m) {


        findCombinations(in, m, 0, new char[in.length()]);

    }


    public static boolean wordHasCharsOrder(String word, String chars) {

        if (chars.length() == 0) {
            return true;
        }

        char ch = chars.charAt(0);

        int index = word.indexOf(ch);
        if (index == -1 || (index + 1 >= word.length() && chars.length() > 1)) {
            return false;
        }

        return wordHasCharsOrder(word.substring(index + 1), chars.substring(1));

    }


    static public List<String> getNames() {

        return Arrays.asList("sandeep", "gupta", "kumar", "deepgup", "pcnxbf", "pan", "sam");
    }


    static WordObject nameMatchesWithCombination(String name) {


        for (int i = 0; i < combinations.size(); i++) {
            if (wordHasCharsOrder(name, combinations.get(i))) {
                return new WordObject(name, i);
            }
        }
        return null;
    }

    public static void main(String args[]) {


        System.out.println(wordHasCharsOrder("sam", "sam"));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "$");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "+");
        findCombinationWrapper("726", map);


        List<String> matches = getNames()
                .stream()
                .map(name -> nameMatchesWithCombination(name))
                .filter(wo -> wo != null)
                .sorted((wo1, wo2) -> {
                    int res = wo1.position.compareTo(wo2.position);
                    if (res == 0) {
                        return wo1.name.compareTo(wo2.name);
                    }
                    return res;
                })
                .map(wo -> wo.name)
                .collect(Collectors.toList());

        System.out.println(matches);


    }
}
