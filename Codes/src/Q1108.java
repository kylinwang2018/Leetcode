public class Q1108 {
    public String defangIPaddr(String address) {
        StringBuilder newS = new StringBuilder();
        for(int i=0;i<address.length();i++){
            char ch = address.charAt(i);
            if (ch == '.'){
                newS.append("[.]");
            }else{
                newS.append(ch);
            }
        }
        return newS.toString();
    }
}
