import java.io.IOException;
import java.util.*;

public class AutocompleteSystem {
    HashMap<String, Integer>[] alphabet;
    class Node {
        String sentence;
        int times;
        Node(String sentence, int times) {
            this.sentence = sentence;
            this.times = times;
            sentence.charAt(sentence.length() - 1);
        }
    }
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < 26; i++) {
            alphabet[i] = new HashMap<String, Integer>();
        }
        for (int i = 0; i < sentences.length; i++) {
            alphabet[sentences[i].charAt(0) - 'a'].put(sentences[i], times[i]);
        }
    }
    private String curSentence = "";
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            int curTimes = alphabet[curSentence.charAt(0) - 'a'].getOrDefault(curSentence, 0);
            alphabet[curSentence.charAt(0) - 'a'].put(curSentence, curTimes + 1);
            curSentence = "";
        } else {
            curSentence += c;
            List<Node> matches = new ArrayList<>();
            Map<String, Integer> matchMap = alphabet[curSentence.charAt(0) - 'a'];
            for (String key : matchMap.keySet()) {
                if (key.startsWith(curSentence)) {
                    matches.add(new Node(key, matchMap.get(key)));
                }
            }
            Collections.sort(matches, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for (int i = 0; i < Math.min(3, matches.size()); i++) {
                result.add(matches.get(i).sentence);
            }
        }

        return result;
    }

    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException {
        String[] sentences = new String[] {"i love you","island","iroman","i love leetcode"};
        int[] times = new int[] {5,3,2,2};
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        List<String> result = obj.input('i');

        System.out.println(result);
    }
}
