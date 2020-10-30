import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TrieTree {
    TrieNode root = new TrieNode();
    TrieTree() {}
    void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) {
                cur.next[i] = new TrieNode();
            }
            cur = cur.next[i];
        }
        cur.word = word;
    }

    boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    boolean dfs(char[] word, int i, TrieNode root) {
        if (i == word.length) return root != null && root.word != null;
        if (root == null) return false;
        if (word[i] == '.') {
            for (int j = 0; j < 26; j++) {
                if (dfs(word, i + 1, root.next[j])) {
                    return true;
                }
            }
            return false;
        }
        return dfs(word, i + 1, root.next[word[i] - 'a']);
    }

    List<String> findAllMatch(String word) {
        List<String> res = new ArrayList<>();

        dfs(word.toCharArray(), 0, root, res);

        return res;
    }

    void dfs(char[] word, int i, TrieNode root, List<String> matches) {
        if (i == word.length) {
            if (root != null && root.word != null) {
                matches.add(root.word);
            }
            return;
        }
        if (root == null) return;
        if (word[i] == '.') {
            for (int j = 0; j < 26; j++) {
                dfs(word, i + 1, root.next[j], matches);
            }
        } else {
            dfs(word, i + 1, root.next[word[i] - 'a'], matches);
        }
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        TrieTree trieTree = new TrieTree();

        trieTree.addWord("mad");
        trieTree.addWord("dad");
        trieTree.addWord("bad");

        pw.println(trieTree.search("dad"));
        pw.println(trieTree.search(".ad"));

        pw.println(trieTree.findAllMatch(".ad"));
        pw.println(trieTree.findAllMatch("tad"));
        pw.println(trieTree.findAllMatch("bad"));

        pw.flush();
        pw.close();
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word = null;
    TrieNode() {}
}
