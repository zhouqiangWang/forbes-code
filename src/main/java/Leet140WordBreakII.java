import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet140WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int len = 0;
        for (String word : wordDict) {
            set.add(word);
            len = Math.max(len, word.length());
        }
        List<String> res = new ArrayList<>();

        dfs(s, set, res, "", len);

        return res;
    }

    void dfs(String s, Set<String> wordDict, List<String> res, String cur, int len) {
        if (s.isEmpty()) {
            res.add(cur);
            return;
        }
        int size = Math.min(len, s.length());
        for (int i = 1; i <= size; i++) {
            String pre = s.substring(0, i);
            if (wordDict.contains(pre)) {
                String newString = pre;
                if (!cur.isEmpty()) {
                    newString = cur + " " + pre;
                }
                dfs(s.substring(i), wordDict, res, newString, len);
            }
        }
    }

    public static void main(String[] args) {
        Leet140WordBreakII test = new Leet140WordBreakII();
        String s = "aaecaaadaaabcaabc";
        List<String> dict = List.of("a", "aae", "ad", "abc", "aab","c");

        Instant t1 = Instant.now();
        System.out.println(test.wordBreak(s, dict).size());
        Instant t2 = Instant.now();
        System.out.println(Duration.between(t1, t2));
    }
}
