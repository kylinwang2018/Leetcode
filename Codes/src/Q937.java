import java.util.Arrays;

/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, 
    with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 

Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
*/

public class Q937 {
    public static void main(String[] args) {
        Solution937 result = new Solution937();
        String[] question = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(result.reorderLogFiles(question)));
    }
}

class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length==0) return logs;
        
        int nums = 0;
        for(int i = logs.length-1; i >= 0; i--) {
            // Move number to the end in order
            if(Character.isDigit(logs[i].charAt(logs[i].indexOf(" ")+1))) {
                swap(logs, i, logs.length-1-nums);
                nums++;
            }
        }
        
        // Sort the non-number part in the front
        Arrays.sort(logs, 0, logs.length-nums, 
            (a,b)->{
                String a1 = a.substring(a.indexOf(" ")+1);
                String b1 = b.substring(b.indexOf(" ")+1);
                int i = a1.compareTo(b1);
                if(i!=0) return i;
                else return a.compareTo(b);
            });
        
        return logs;
    }
    
    private void swap(String[] logs, int a, int b) {
        String t = logs[a];
        logs[a] = logs[b];
        logs[b] = t;
    }
}