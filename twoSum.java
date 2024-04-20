import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // K = integer in nums, V = index of integer in nums
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] output = new int[2];
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