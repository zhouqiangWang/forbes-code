import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A_ZombieMatrix {
    static int minHours(int row, int col, int[][] grid) {
        int hours = 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    count++;
                }
            }
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (count == row * col) {
                return hours;
            }
            hours++;
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int newR = pos[0] + dir[0];
                    int newC = pos[1] + dir[1];
                    if (newC >= 0 &&  newC < col && newR >= 0 && newR < row && grid[newR][newC] == 0) {
                        count++;
                        queue.add(new int[]{newR, newC});
                        grid[newR][newC] = 1;
                    }
                }
            }
        }

        System.out.println(count);
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };

        System.out.println(minHours(4, 5, grid));
    }
}
