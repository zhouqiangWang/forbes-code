import java.io.*;
import java.util.*;

public class SolutionR1BP1 {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";


    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        int caseN = sc.nextInt();
        for (int i = 1; i <= caseN; i++) {
            // solution from here.
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int[] xList = new int[Q + 1];
            int[] yList = new int[Q + 1];
            int minX = 0;
            int xMaxCount = 0;
            int minY = 0;
            int yMaxCount = 0;

            for (int j = 0; j < P; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                String c = sc.next();
//                pw.print("x = " + x + ", y = " + y + ", c = " + c + "\n");
                switch (c) {
                    case "N":
                        for (int k = y + 1; k <= Q; k++) {
                            yList[k] ++;
//                            if (yMaxCount < yList[k]) {
//                                minY = k;
//                                yMaxCount = yList[k];
//                            }
                        }
                        break;
                    case "S":
                        for (int k = 0; k < y; k++) {
                            yList[k] ++;
//                            if (yMaxCount < yList[k]) {
//                                minY = k;
//                                yMaxCount = yList[k];
//                            }
                        }
                        break;
                    case "W":
                        for (int k = 0; k < x; k++) {
                            xList[k] ++;
//                            if (xMaxCount < xList[k]) {
//                                minX = k;
//                                xMaxCount = xList[k];
//                            }
                        }
                        break;
                    case "E":
                        for (int k = x + 1; k <= Q; k++) {
                            xList[k] ++;
//                            if (xMaxCount < xList[k]) {
//                                minX = k;
//                                xMaxCount = xList[k];
//                            }
                        }
                        break;
                }
            }
            for (int j = 0; j <= Q; j++) {
                if (yMaxCount < yList[j]) {
                    minY = j;
                    yMaxCount = yList[j];
                }
            }
            for (int j = 0; j <= Q; j++) {
                if (xMaxCount < xList[j]) {
                    minX = j;
                    xMaxCount = xList[j];
                }
            }

            pw.println("Case #" + i + ": " + minX + " " + minY);
        }

        pw.flush();
        pw.close();
        sc.close();
    }
}

