import java.util.LinkedList;
import java.util.Queue;

class SolutionQ {
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here
        //System.out.println("hello");
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[] start = {sr, sc};
        queue.offer(start);
//        System.out.println(queue.size());
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len ++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                grid[pos[0]][pos[1]] = 0;
                if (pos[0] == tr && pos[1] == tc) {
                    return len;
                }
                for (int j = 0; j < 4; j++) {
                    int newR = pos[0] + dirs[j][0];
                    int newC = pos[1] + dirs[j][1];
                    if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 1) {
                        int[] newP = {newR, newC};
                        queue.offer(newP);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}};

        System.out.println(shortestCellPath(grid, 0, 0, 2, 0));
    }
}