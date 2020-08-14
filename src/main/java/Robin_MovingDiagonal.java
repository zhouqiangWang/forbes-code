import java.io.PrintWriter;

public class Robin_MovingDiagonal {
    static final PrintWriter pw = new PrintWriter(System.out);

    int movingDiagonal(int n, int m, int x1, int y1, int x2, int y2) {
        int dx = 1, dy = 1;

        int[][] visited = new int[n][m];

        int step = 0;
        while (x1 != x2 || y1 != y2) {
            visited[x1][y1] |= flag(dx, dy);
            step++;
            int nx = x1 + dx;
            int ny = y1 + dy;
            if (nx < 0 || nx >= n) {
                dx = -dx;
                nx += dx;
                ny = y1;
            }
            if (ny < 0 || ny >= m) {
                dy = -dy;
                ny += dy;
                nx = x1;
            }
            x1 = nx; y1 = ny;
            if ((visited[x1][y1] & flag(dx, dy)) > 0) {
                return -1;
            }
        }

        return step;
    }

    int flag(int x, int y) {
        if (x == 1 && y == 1) return 8;
        if (x == 1 && y == -1) return 4;
        if (x == -1 && y == 1) return 2;

        return 1;
    }

    public static void main(String[] args) {
        Robin_MovingDiagonal ins = new Robin_MovingDiagonal();
        pw.println(ins.movingDiagonal(5, 5, 2, 1, 1, 2));

        pw.flush();
        pw.close();
    }
}
