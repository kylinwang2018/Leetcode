
/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

public class Q3 {
    public static void main(String[] args) {
        Solution3 result = new Solution3();
        System.out.println(result.lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int longest = 0;
        char[] array = s.toCharArray();
        int sl = 0;
        int f = 0;
        boolean[] seen = new boolean[128];
        while (sl < array.length && f < array.length) {
            if (!seen[array[f]]) {
                seen[array[f]] = true;
                f++;
                longest = Math.max(f - sl, longest);
            } else {
                while (seen[array[f]]) {
                    seen[array[sl]] = false;
                    sl++;
                }
            }
        }
        return longest;
    }
}