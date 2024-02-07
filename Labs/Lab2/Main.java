package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "abcdefG";
        String t = "Gfedcba";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayS);
        Arrays.sort(charArrayT);

        s = new String (charArrayS);
        t = new String (charArrayT);

        if (!s.equals(t)) {
            return false;
        }


        //if it makes it to the end it is true.
        return true;
    }
}

/*
Thought process.
0. check if the the two strings are the same length
1. Sort each string by alphabetical order
2. compare the new strings of s and t. If they are not equal return false.
3. else, if it makes it to the end, return true.


 */
