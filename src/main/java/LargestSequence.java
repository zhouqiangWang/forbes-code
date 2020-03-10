import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Calendar.MONTH;

public class LargestSequence {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    /** n= 9
     *  i = 6
     *  k = 4
     *  i - n + k
     *  3 1 4 7 1 5 9 2 6
     *  | | | | | | | | |
     *  0 1 2 3 4 5 6 7 8
     * */
    String getLargest(String num, int k) {
        StringBuilder res = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int n = num.length();
        stack.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            char c = num.charAt(i);
            int leastNum = Math.max(0, i - n + k);
            if (stack.peek() <= c || stack.size() <= leastNum) {
                while (stack.size() > leastNum && stack.peek() < c) {
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(FILE_INPUT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        LargestSequence instance = new LargestSequence();

        pw.println(instance.getLargest("3141592653", 4));

        pw.flush();
        pw.close();
        sc.close();
    }
}
