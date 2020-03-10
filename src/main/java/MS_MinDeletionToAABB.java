public class MS_MinDeletionToAABB {
    static int solution(String str) {
        char[] chs = str.toCharArray();

        int nA = 0;
        int nB = 0;
        for (char c : chs) {
            if (c == 'A') {
                nA++;
            }
        }

        int res = nA;
        for (char c : chs) {
            if (c == 'B') {
                nB++;
            } else {
                nA--;
            }

            res = Math.min(res, nB + nA);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("BAAABAB"));
        System.out.println(solution("BBABAA"));
        System.out.println(solution("AAAAAAAAA"));
        System.out.println(solution("BBBBBBB"));
    }
}
