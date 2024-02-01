package org.example;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int target = 12;

        HashMap<Integer, Integer> intMap = new HashMap<>();

        //put the index of a value into a hashmap with the key being the difference
        for (int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            intMap.put(difference, i); //the key points to the index
        }

        //iterate through the array and if the key in the hashMap exists, there is a solution
        for (int i = 0; i < nums.length; i++) {
            if (intMap.containsKey(nums[i]) && (i != intMap.get(nums[i]))){
                System.out.println("[" + i + "," + intMap.get(nums[i]) + "]");
            }
        }
    }
}