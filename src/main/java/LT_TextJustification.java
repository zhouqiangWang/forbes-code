import java.util.ArrayList;
import java.util.List;

public class LT_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < words.length) {
            int size = -1;
            int r = i;
            for (; r < words.length; r++) {
                int n = size + 1 + words[r].length();
                if (n <= maxWidth) {
                    size = n;
                } else {
                    break;
                }
            }
            res.add(justify(words, i, r, maxWidth, size));
            i = r;
        }

        return res;
    }

    private String justify(String[] words, int l, int r, int maxWidth, int size) {
        StringBuilder sb = new StringBuilder();

        int gap = (maxWidth - size) / (r - l - 1);
        int oneMore = (maxWidth - size) % (r - l - 1);
        sb.append(words[l]);
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
