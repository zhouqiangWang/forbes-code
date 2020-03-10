import java.util.ArrayList;
import java.util.List;

public class MS_MinAdjSwapToGroup {

    static int solution(String str) {
        // get R list;
        List<Integer> rIndices = new ArrayList<>();

        for (int i = 0; i< str.length(); i++) {
            if (str.charAt(i) == 'R') {
                rIndices.add(i);
            }
        }

        int mid = rIndices.size() / 2;
        int midIndex = rIndices.get(mid);

        long res = 0;
        for (int i = 0; i < rIndices.size(); i++) {
            res += Math.abs(rIndices.get(i) - midIndex) - Math.abs(i - mid);
        }
        if (res > Integer.MAX_VALUE) {
            return -1;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(solution("WRRWWR"));
        System.out.println(solution("WWRWWWRWR"));
    }
}
