import java.util.Stack;

/*


Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

*/

public class Q20 {
    public static void main(String[] args) {
        Solution20 result = new Solution20();
        System.out.println(result.isValid("([)]"));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length()%2==1)return false;
        for(char c:s.toCharArray()){
            if(c=='(') st.push(')');
            else if(c=='[') st.push(']');
            else if(c=='{') st.push('}');
            else if(!st.isEmpty()){
                if(c!=st.peek()) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}