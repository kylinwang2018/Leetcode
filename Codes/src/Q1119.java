public class Q1119 {
    public String removeVowels(String S) {
        StringBuilder newString = new StringBuilder();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            switch (ch){
                case 'a':
                case 'e':
                case 'i':
                case 'u':
                case 'o':
                    break;
                default:
                    newString.append(ch);
                    break;
            }
        }
        return newString.toString();
    }
}
