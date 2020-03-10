import java.io.*;
import java.util.Scanner;

public class Solution2 {
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
            int N = sc.nextInt();
            String path = sc.next();
            char[] pathArray = path.toCharArray();
//            pw.println(path);

            StringBuffer result = new StringBuffer();
            int pathLen = pathArray.length;

            char first = pathArray[0];
            char last = pathArray[pathLen - 1];
            char opFirst;
            if (first == 'E') {
                opFirst = 'S';
            } else {
                opFirst = 'E';
            }
            if (first != last) {
                for (int j = 0; j < N - 1; j++) {
                    result.append(last);
                }
                for (int j = 0; j < N - 1; j++) {
                    result.append(first);
                }
            } else {
                // find cross point
                int crossPoint = 0;
                for (int j = 1; j < pathLen - 1; j++) {
                    if (pathArray[j] != first) {
                        crossPoint ++;
                        if (pathArray[j + 1] != first) {
                            break;
                        } else {
                            j++;
                        }
                    }
                }
//                pw.println("cross = " + crossPoint);

                for (int j = 0; j < crossPoint; j++) {
                    result.append(opFirst);
                }
                for (int j = 0; j < N - 1; j++) {
                    result.append(first);
                }
                for (int j = crossPoint; j < N - 1; j++) {
                    result.append(opFirst);
                }
            }

            pw.println("Case #" + i + ": " + result.toString());
        }

        pw.flush();
        pw.close();
        sc.close();
    }
}
