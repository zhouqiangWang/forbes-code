import java.io.PrintWriter;
import java.util.List;

public class CountWaters {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    List<Integer> countWaters(int row, int col, int[][] positions) {
        return List.of();
    }

    int countWater(int row, int col, int[][] map) {
        return 0;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        CountWaters test = new CountWaters();
        int[][] pos = new int[][]{{1, 1},{0, 1},{2, 1}};

        pw.println(test.countWaters(3, 3, pos));

        pw.flush();
        pw.close();
    }
}
