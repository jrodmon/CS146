import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-5,0,5,10,-10,0};
        //int[] nums = new int[]{-5, -5, 0, 5, 10, -10, -10, 0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {             //this for loop will run until index i equals the third element from the end
            if (i == 0 || nums[i] != nums[i - 1]) {             //runs if i is the starting element i is not the same value as the previous element. (skips duplicate values)
                int j = i + 1;                          //sets j to the value after index i
                int k = nums.length - 1;                //sets k to the end of the sorted array

                while (j < k) {                             //will run until the beginning overlaps the end
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {              //if the sum is negative, the magnitude of j(negative) must shrink, because k(positive) is already the largest it will be.
                        j++;
                    } else if (sum > 0) {       //if the sum is positive, then we must shrink k for the same reasoning above^.
                        k--;
                    } else {                                                     //if the sum == 0
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));    //add to result
                        j++;
                        k--;                                                //inc beginning and dec end
                        while (j < k && nums[j] == nums[j - 1]) {           //skip dupes from left
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {           //skip dupes from right
                            k--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
