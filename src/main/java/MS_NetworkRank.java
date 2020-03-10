public class MS_NetworkRank {
    int getMax(int[] A, int[] B, int N) {
        int[] memo = new int[N+1];

        for (int i = 0; i < A.length; i++) {
            memo[A[i]] ++;
            memo[B[i]] ++;
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = Math.max(memo[A[i]] + memo[B[i]] - 1, res);
        }

        return res;
    }

    public static void main(String[] args) {
        MS_NetworkRank ins = new MS_NetworkRank();
        System.out.println(ins.getMax(new int[]{1, 2, 3, 3}, new int[]{2, 3, 1, 4}, 4));
    }
}
