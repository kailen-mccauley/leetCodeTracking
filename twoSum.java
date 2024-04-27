
/*
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 */
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // K = integer in nums, V = index of integer in nums
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] output = new int[2];

        // Basically, we are adding to our map elements from our array
        // We check if the target - the current element in our aray is in the map
        // If it is, that means we have 2 elements that can sum to the target so we return
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                output[0] = map.get(target - nums[i]);
                output[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return output;
    }
}