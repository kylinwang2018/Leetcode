import java.util.LinkedList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>(); // LinkedList is way faster than ArrayList
        if (nums.length < 1)
            return res;
        
        int prev = 0;
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < nums.length; ++i) {
            if (Math.abs(nums[i]-nums[i-1]) > 1) {
                s.append(nums[prev]);
                if ((i-prev) > 1)
                    s.append("->").append(nums[i-1]);
                res.add(s.toString());
                s.setLength(0);
                prev = i;
            }
        }
        
        int len = nums.length;
        s.append(nums[prev]);
        if ((len-prev) > 1)
            s.append("->").append(nums[len-1]);
        res.add(s.toString());
        
        return res;
    }

}

