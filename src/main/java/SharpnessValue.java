import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class SharpnessValue {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    int sharpnessValue(int[][] matrix) {
        int width = matrix.length;
        int length = matrix[0].length;

        int[][] map = new int[width][length];
        for (int i = 0; i < width; i++) {
            map[i][0] = matrix[i][0];
            System.out.println(map[i][0]);
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int currentMin = map[j][i - 1];
                if (j > 0) {
                    currentMin = Math.max(currentMin, map[j - 1][i - 1]);
                }
                if (j < width - 1) {
                    currentMin = Math.max(currentMin, map[j + 1][i - 1]);
                }
                map[j][i] = Math.min(currentMin, matrix[j][i]);
            }
        }

        for (int i = 0; i < width; i++) {
            System.out.println(map[i][3]);
        }

        int result = 0;
        for (int i = 0; i < width; i++) {
            result = Math.max(result, map[i][length - 1]);
           // System.out.println(map[i][length - 1]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> (o2[0]*o2[0] + o2[1]*o2[1]) - (o1[0]*o1[0] - o1[1]*o1[1]));
        maxHeap.isEmpty();

        SharpnessValue instance = new SharpnessValue();
        int[][] dirs = new int[][]{ {1, 2, 3, 9}, {8, 6, 10, 8}, {9, 4, 11, 12} };
        BigInteger integer = new BigInteger("12");

//        pw.println(instance.sharpnessValue(dirs));
        System.out.println(instance.sharpnessValue(dirs));
    }
}

