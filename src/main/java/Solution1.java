import java.io.*;
import java.util.Scanner;

public class Solution1 {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException {
        System.out.println();
//        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        int caseN = sc.nextInt();
        for (int i = 1; i <= caseN; i++) {
            // solution from here.
            int num = sc.nextInt();
            int a = 0,b = 0;
            int base = 1;
            int iNum = num;
            while (iNum > 0) {
                if (iNum % 10 == 4) {
                    b += base;
                }
                base *= 10;
                iNum = iNum / 10;
            }
            a = num - b;

            pw.println("Case #" + i + ":" + a + " " + b);
        }

        pw.flush();
        pw.close();
        sc.close();
    }
}
