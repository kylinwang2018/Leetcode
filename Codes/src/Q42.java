/*
Given n non-negative integers representing an elevation map 
    where the width of each bar is 1, compute how much water it 
    is able to trap after raining.

Example:
    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
*/

public class Q42 {
    public static void main(String[] args) {
        Solution result = new Solution();
        int[] question = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(result.trap(question));
    }
}

class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        
        // Computer max from left
        int max = 0;
        for(int i=0;i<height.length;i++) {
            max = Math.max(max,height[i]);
            
            maxLeft[i] = max;
        }
        
        // Compute max from right
        max = 0;
        for(int i=height.length-1;i>=0;i--) {
            max = Math.max(max,height[i]);
            
            maxRight[i] = max;
        }
        
        // Compute water stored
        int water = 0;
        
        for(int i=0;i<height.length;i++) {
            water+= Math.min(maxLeft[i],maxRight[i])-height[i];
        }
        
        return water;
    }
}