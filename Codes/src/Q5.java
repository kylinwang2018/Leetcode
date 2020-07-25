/*

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

public class Q5 {
    public static void main(String[] args) {
        Solution5 result = new Solution5();
        System.out.println(result.longestPalindrome("abcdefedsdabcdeeeeeedcba"));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        String cur = "";
        for (int i = 0; i < s.length(); ++i) {
            // start l = i
            int l = i;
            int r = i;

            // find "root", e.g. "bb" for "abba" when i == 1
            while (r + 1 < s.length() && s.charAt(r + 1) == s.charAt(i)) {
                r++;
            }

            // check if it's possible to have longer palindrome than we already find
            // min(what we have at "root" sides) x 2 + (size of "root")
            if (cur.length() > 0 && cur.length() > Math.min(l, s.length() - (r - 1)) * 2 + (r + 1 - l))
                break;

            // expand while we can
            while (l > 0 && r < s.length() - 1) {
                if (s.charAt(l - 1) != s.charAt(r + 1))
                    break;
                l--;
                r++;
            }

            if (r + 1 - l > cur.length())
                cur = s.substring(l, r + 1);
            System.out.println("r:" + r + "; l:" + l + "; cur:" + cur);
        }
        return cur;
    }
}