import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

class Q15 {
    public static void main(String[] args) {

    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // avoid duplicate
                continue;
            if (nums[i] > 0) // all > 0, impossible
                break;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0)
                    res.add(Arrays.asList(new Integer[] { nums[i], nums[l], nums[r] }));
                if (sum <= 0) {
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) // avoid duplicate
                        l++;
                }
                if (sum >= 0) {
                    r--;
                    while (nums[r] == nums[r + 1] && l < r) // avoid duplicate
                        r--;
                }

            }
        }
        return res;
    }
}