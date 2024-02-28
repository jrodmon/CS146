import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int palindromeLength = 0;
        boolean isOdd = false;
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c,0) + 1);
        }

        for (int i : charCount.values()) {  // uses i as each of hashvalue
            if (i % 2 == 0) {           // if the hashvalue is even
                palindromeLength += i;
                System.out.println(palindromeLength);
            }
            //use a boolean bc you can't just add one for every hashvalue of 1
            else {     //if hashvalue is odd
                palindromeLength += i - 1;
                isOdd = true;
            }
        }


        if (isOdd) {
            palindromeLength++;
        }

        return palindromeLength;
    }
}
