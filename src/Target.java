import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Target {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    void targetSum(int[] list, int target) {

    }

    int helper(int[] list, int start, int end, int target) {

        for (int i = 0; i < list.length; i++) {
            if (helper(list, start, i, target) + helper(list, i+1, end, target) == target) {

            }
        }

        return 0;
    }

    Random random;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        Random random = new Random();
        Character.isDigit('1');

        pw.flush();
        pw.close();
        sc.close();
    }
}

