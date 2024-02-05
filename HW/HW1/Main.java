package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Too hot to hoot."));
    }

    public static boolean isPalindrome(String s) {
        String lowerString;
        String newString = "";
        lowerString = s.toLowerCase();

        //make lowercase and remove non digit and non letters
        char[] ch = new char[s.length()];
        for (int i = 0; i < lowerString.length(); i++) {
            ch[i] = lowerString.charAt(i);
        }
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i]) || Character.isLetter(ch[i])) {
                newString += ch[i];
            }
        }

        int index1 = 0;
        int index2 = newString.length() - 1;
        while (index1 <= index2) {  //want it to run while index1 and index2 do not overlap
            if (newString.charAt(index1) != newString.charAt(index2)) {
                return false;
            }
            index1++;
            index2--;
        }

        return true;
    }
}

/*
    Thought Process:
    convert all uppercase to lowercase & remove all non-alphanumeric characters
        1. i think the method is called .toLower
        2. to remove non-alphanumeric, add alphanumeric chars to a new string
            a. convert the string into a character array and use isDigit and isLetter methods

    reads the same forward and backwards
    racecar
        1. we can have two indices, where one iterates up the string, and the other down the string
        2. compare the values at these two indices, if != return false
        3. if the two indices overlap, that means it made it to the end. return true
 */