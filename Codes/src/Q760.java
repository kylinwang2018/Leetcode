import java.util.ArrayList;

public class Q760 {
    public int[] anagramMappings(int[] A, int[] B) {
        ArrayList<Integer> alB = new ArrayList<>();
        for (int b : B){
            alB.add(b);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length;++i){
            res[i] = alB.indexOf(A[i]);
        }
        return res;
    }
}
