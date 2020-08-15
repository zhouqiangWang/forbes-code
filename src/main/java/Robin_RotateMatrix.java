import java.io.PrintWriter;
import java.util.Arrays;

public class Robin_RotateMatrix {

    char[][] rotateMatrixWithObstacle(String[] mat) {
        int m = mat.length;
        int n = mat[0].length();

        char[][] res = new char[n][m];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = mat[i].charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            int start = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (res[j][i] == '#') {
                    res[start--][i] = res[j][i];
                } else if (res[j][i] == '*') {
                    while (start > j) {
                        res[start--][i] = '.';
                    }
                    res[start--][i] = '*';
                }
            }
            while (start >= 0) {
                res[start--][i] = '.';
            }
        }

        return res;
    }

    static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Robin_RotateMatrix test = new Robin_RotateMatrix();
        char[][] res = test.rotateMatrixWithObstacle(new String[]{"...##.....*#.", "...####......"});
        for (char[] chs : res) {
            pw.println(Arrays.toString(chs));
        }

        pw.flush();
        pw.close();
    }
}
