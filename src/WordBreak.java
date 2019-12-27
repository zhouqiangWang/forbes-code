import java.util.*;

public class WordBreak {
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
        WordBreak ins = new WordBreak();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] dic = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        ins.wordBreak(s, Arrays.asList(dic));
    }
}