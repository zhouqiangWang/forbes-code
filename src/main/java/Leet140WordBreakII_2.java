import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Leet140WordBreakII_2 {
    Map<String, List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    List<String> dfs(String s, List<String> dict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> sub = dfs(s.substring(word.length()), dict);
                for (String last : sub) {
                    if (last.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + last);
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Leet140WordBreakII_2 test = new Leet140WordBreakII_2();
        String s = "aaecaaadaaabcaabc";
        List<String> dict = List.of("a", "aae", "ad", "abc", "aab","c");

        Instant t1 = Instant.now();
        System.out.println(test.wordBreak(s, dict).size());
        Instant t2 = Instant.now();
        System.out.println(Duration.between(t1, t2));
    }
}
