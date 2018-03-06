package leet.code;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for(int i = 0; i < nums.length;i++){
            int sum = nums[i] + nums[i+1];
            if(sum == target) {
                array = new int[]{i, i + 1};
            }
        }
        return array;
    }
}
