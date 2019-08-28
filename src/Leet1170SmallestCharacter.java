import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Leet1170SmallestCharacter {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsCount = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsCount[i] = smallestFrequency(words[i]);
        }
        Arrays.sort(wordsCount);
        System.out.println(Arrays.toString(wordsCount));

        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answers[i] = findSmallerCount(wordsCount, smallestFrequency(queries[i]));
        }

        return answers;
    }

    private Map<Integer, Integer> cache = new HashMap<>();
    private int findSmallerCount(int[] arr, int target) {
        if(cache.containsKey(target)) {
            return cache.get(target);
        }
        int left = 0, right = arr.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int largerNum = arr.length - right;
        cache.put(target, largerNum);

        return largerNum;
    }

    private int smallestFrequency(String word) {
        int[] alphabet = new int[26];
        int s = 27;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (index < s) {
                s = index;
            }
            alphabet[index] ++;
        }

        return alphabet[s];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        Leet1170SmallestCharacter instance = new Leet1170SmallestCharacter();

        String[] strings = new String[]{"bbb","cc"};
        String[] words = new String[] {"a","aa","aaa","aaaa"};
        List<String> list = new ArrayList<>();


        int[] ans = instance.numSmallerByFrequency(strings, words);


        pw.flush();
        pw.close();
        sc.close();
    }
}

