import java.util.ArrayList;
import java.util.List;


/**
 *  0  1  2  3  4  5  6  7
 *  1 -1 -1  1  1 -1 -1  1
 *  x  y  x  y  x  y  x  y
 * */

public class SpiralLine {
    List<List<Integer>> draw(int x, int y, int len) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(x, y));

        int n = 2 * len - 1;

        int preX = x;
        int preY = y;
        int factor = 1;
        for (int i = 0; i < n; i++) {
            int step = i / 2 + 1;
            int nx = preX;
            int ny = preY;
            if (i % 2 == 0) {
                // x
                nx = preX + step * factor;
            } else {
                factor = -factor;
                ny = preY + step * factor;
            }
            res.add(List.of(nx, ny));
            preX = nx;
            preY = ny;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralLine instance = new SpiralLine();

        System.out.println(instance.draw(1, 1, 5));
    }
}
