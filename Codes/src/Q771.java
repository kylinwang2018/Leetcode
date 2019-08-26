public class Q771 {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for(int i=0;i<J.length();i++){
            char ch = J.charAt(i);
            for(int j=0;j<S.length();j++){
                char ch2 = S.charAt(j);
                if (ch == ch2){
                    result++;
                }
            }
        }
        return result;
    }
}
