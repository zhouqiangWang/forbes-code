import java.io.PrintWriter;
import java.util.Set;

public class StringCompression1531 {

    Integer[][][][] memo;
    public int getLengthOfOptimalCompression(String s, int k) {
        int len = s.length();
        memo = new Integer[len + 1][k + 1][27][len + 1];

        return dfs(0, k, (char)('a' + 26), 0, s);
    }

    int dfs(int index, int k, char prev, int cnt, String s) {
        if (k < 0) return Integer.MAX_VALUE;
        if (index >= s.length()) return 0;

        if (memo[index][k][prev - 'a'][cnt] != null) {
            return memo[index][k][prev - 'a'][cnt];
        }

        int res = 0;
        char cur = s.charAt(index);
        if (cur == prev) {
            // keep;
            res = dfs(index + 1, k, prev, cnt + 1, s) + increase(cnt);
        } else {
            // keep or delete
            res = Math.min(dfs(index + 1, k , cur, 1, s) + 1 , dfs(index + 1, k - 1, prev, cnt, s));
        }

        memo[index][k][prev - 'a'][cnt] = res;

        return res;
    }

    int increase(int sameCharLen) {
        return (sameCharLen == 1 || sameCharLen == 9 || sameCharLen == 99) ? 1 : 0;
    }

    Integer[][][][] dp;
    public int getLengthOfOptimalCompression2(String s, int k) {
        int len = s.length();
        dp = new Integer[len + 1][27][len + 1][k + 1];
        return dfs(s, 0, (char) ('a' + 26), 0, k);
    }
    // idx, current index, p, previous char, cnt, previous char count, k, num of char removable
    private int dfs(String s, int idx, char p, int cnt, int k) {
        if (k < 0) return Integer.MAX_VALUE;
        if (idx >= s.length()) return 0;
        if (dp[idx][p - 'a'][cnt][k] != null) return dp[idx][p - 'a'][cnt][k];
        int res = 0;
        if (s.charAt(idx) == p) res = dfs(s, idx + 1, p, cnt + 1, k) + increase(cnt);
        else res = Math.min(dfs(s, idx + 1, s.charAt(idx), 1, k) + 1, dfs(s, idx + 1, p, cnt, k - 1));
        dp[idx][p - 'a'][cnt][k] = res;
        return res;
    }

    public static void main(String[] arr) {
        PrintWriter pw = new PrintWriter(System.out);

        StringCompression1531 ins = new StringCompression1531();
        System.out.println(ins.getLengthOfOptimalCompression("bcccd", 2));
        System.out.println(ins.getLengthOfOptimalCompression2("bcccd", 2));

        pw.flush();
        pw.close();
    }
}
