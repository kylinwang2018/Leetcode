
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Q53 {
    public static void main(String[] args) {
        Solution53 result = new Solution53();
        int[] question = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(result.maxSubArray(question));
    }
}

// https://www.baeldung.com/java-maximum-subarray#:~:text=The%20maximum%20subarray%20problem%20is,sum%20in%20any%20given%20array.&text=In%20this%20tutorial%2C%20we'll,n)%20time%20and%20space%20complexity.

class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}