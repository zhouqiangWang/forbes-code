import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> (o2[0]*o2[0] + o2[1]*o2[1]) - (o1[0]*o1[0] - o1[1]*o1[1]));
        maxHeap.isEmpty();



        int[][] matrix = new int[2][3];
        int[][] dirs = new int[][]{ {1, 2, 3}, {4, 5, 6} };
        pw.println(dirs.length);
        pw.println(matrix[0].length);
        List<Integer> num = new ArrayList<>();
        num.add(3);
        num.add(4);
        pw.println(num);
        num.add(0, 2);
        pw.println(num);
        Collections.reverse(num);
        pw.println(num);
        Queue queue = new LinkedList<int[]>();
        int[] newPos = new int[2];
        queue.offer(newPos);
        int[] headPos =(int[]) queue.poll();
        pw.println(headPos.length);
        pw.println(queue.poll());
        System.out.println();
        List<String> list = Arrays.asList("qwe", "rty", "asd");
        String str = list.toString();
        str = str.substring(1, str.indexOf(']'));

        pw.println(str);

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

                switch (c) {
                    case "N":
                        for (int k = y + 1; k <= Q; k++) {
                            yList[k] ++;
                        }
                        break;
                    case "S":
                        for (int k = 0; k < y; k++) {
                            yList[k] ++;
                        }
                        break;
                    case "W":
                        for (int k = 0; k < x; k++) {
                            xList[k] ++;
                        }
                        break;
                    case "E":
                        for (int k = x + 1; k <= Q; k++) {
                            xList[k] ++;
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

        byte[] test = new byte[]{1};
        byte[] test2 = new byte[]{8, 6, 12, 11, 13, 1, 2, 3, 4, 5, 6};
        byte[] test3 = new byte[]{1, 127};
        BigInteger bigTest = new BigInteger(test);
        pw.println(bigTest.intValue());
        BigInteger bigTest2 = new BigInteger(test2);
        pw.println(bigTest2.intValue());

        pw.println(Hex.encodeHex(test2));
        pw.println(Arrays.toString(test2));
        pw.println(Hex.encodeHex(test3));
        pw.println(Arrays.toString(test3));

        pw.flush();
        pw.close();
        sc.close();
    }
}

