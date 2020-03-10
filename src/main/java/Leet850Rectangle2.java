import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Leet850Rectangle2 {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    class Edge {
        int x;
        int yMin;
        int yMax;
        int type; // 0: begin, 1: end.
        public Edge(int x, int yMin, int yMax, int type) {
            this.x = x;
            this.yMin = yMin;
            this.yMax = yMax;
            this.type = type;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + type + ", " + yMin + ", " + yMax + "]";
        }
    }

    public int rectangleArea(int[][] rectangles) {
        List<Edge> edges = new ArrayList<>();
        for (int[] rect : rectangles) {
            Edge eLeft = new Edge(rect[0], rect[1], rect[3], 0);
            Edge eRight = new Edge(rect[2], rect[1], rect[3], 1);
            edges.add(eLeft);
            edges.add(eRight);
        }
        edges.sort((e1, e2) -> {
            int diff = e1.x - e2.x;
            if (diff != 0) {
                return diff;
            }
            return e1.type - e2.type;
        });

        TreeMap<Integer, Integer> yMap = new TreeMap();
        int preX = -1;
        long preH = 0;
        long result = 0;
        for (Edge e : edges) {
            if (e.type == 0) {
                yMap.put(e.yMin, yMap.getOrDefault(e.yMin, 0) - 1);
                yMap.put(e.yMax, yMap.getOrDefault(e.yMax, 0) + 1);
            } else {
                yMap.put(e.yMin, yMap.getOrDefault(e.yMin, 0) + 1);
                yMap.put(e.yMax, yMap.getOrDefault(e.yMax, 0) - 1);
            }
            int preY = -1;
            int count = 0;
            int height = 0;
            for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
                int y = entry.getKey();
                if (preY >= 0 && count < 0) {
                    height += (y - preY);
                }
                preY = y;
                count += entry.getValue();
            }
            if (preX >= 0) {
                result += preH * (e.x - preX);
            }
            preX = e.x;
            preH = height;
        }
        result = result % 1000000007;
        return (int)result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        Leet850Rectangle2 instance = new Leet850Rectangle2();
//        int[][] test = new int[][] {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
        int[][] test = new int[][] {{0,0,1000000000,1000000000}};
        pw.println(instance.rectangleArea(test));

        List<Integer> res = new ArrayList<>(10);
        StringBuilder builder = new StringBuilder();
        pw.println(Integer.MAX_VALUE);

        pw.flush();
        pw.close();
        sc.close();
    }
}

