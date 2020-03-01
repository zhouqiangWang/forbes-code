import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MS_MinDeletions {

    int getMinDeletions(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for(int count : map.values()) {
            while (set.contains(count) && count > 0) {
                count--;
                res++;
            }
            if (count > 0) {
                set.add(count);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MS_MinDeletions ins = new MS_MinDeletions();

        System.out.println(ins.getMinDeletions("eeeeffff"));
        System.out.println(ins.getMinDeletions("aabbffddeaee"));
        System.out.println(ins.getMinDeletions("llll"));
        System.out.println(ins.getMinDeletions("example"));
    }
}
