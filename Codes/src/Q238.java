/*

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class Q238 {
    
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // res[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so res[0] would be 1
        res[0] = 1;
        for(int i=1;i<nums.length;++i){
            // res[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            res[i] = res[i-1] * nums[i-1];
        }
        
        int R=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] = res[i] * R;
            R = R * nums[i];
        }
        return res;
    }
}