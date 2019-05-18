import java.io.*;
import java.util.*;

public class SolutionRound1A {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public int count(List<String> list, int layer, int amount) {
        if (amount < 2) {
            return 0;
        }
        if (list.size() < 2) {
            return 0;
        }
        Map<Character, List<String>> map = new HashMap<>();
        Character ch = '0';
        for (String word: list) {
            if (word.length() >= layer) {
                ch = word.charAt(word.length() - layer);
                if (!map.containsKey(ch)) {
                    map.put(ch, new ArrayList<>());
                }
                map.get(ch).add(word);
            }
        }
        if (map.size() == 0) {
            return 0;
        }

        int total = 0;
        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            Character c = entry.getKey();
            List<String> subList = entry.getValue();
            if (subList.size() > 1) {
                total += 2;
                total += count(subList, layer + 1, Math.min(subList.size(), amount) - 2);
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        int caseN = sc.nextInt();
        for (int i = 1; i <= caseN; i++) {
            // solutionRound1A from here.
            int N = sc.nextInt();
            List<String> words = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                words.add(sc.next());
            }
            SolutionRound1A solutionRound1A = new SolutionRound1A();
            int total = solutionRound1A.count(words, 1, N);

            pw.println("Case #" + i + ": " + total);
        }

        pw.flush();
        pw.close();
        sc.close();
    }
}

