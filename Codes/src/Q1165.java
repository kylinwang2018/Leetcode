import java.util.ArrayList;

public class Q1165 {
    public int calculateTime(String keyboard, String word) {
        ArrayList<Character> keyb = new ArrayList<Character>();
        for (int i = 0; i < keyboard.length(); ++i) {
            char ch = keyboard.charAt(i);
            keyb.add(ch);
        }

        int finger = 0;
        int move = 0;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            move += Math.abs(finger - keyb.indexOf(ch));
            finger = keyb.indexOf(ch);
        }
        return move;
    }
}
