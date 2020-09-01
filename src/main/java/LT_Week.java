import java.io.PrintWriter;

public class LT_Week {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (m * k > arr.length) return false;
        int len = arr.length;
        for (int i = 0; i <= len - m * k; i++) {
            boolean found = true;
            for (int j = 1; j < k; j++) {
                for (int a = 0; a < m; a++) {
                    if (arr[i + a] != arr[i + j * m + a]) {
                        found = false;
                        break;
                    }
                }
                if (!found) break;
            }
            if (found) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        LT_Week ins = new LT_Week();

        pw.println(ins.containsPattern(new int[]{1,2,4,4,4,4}, 1, 3));
        pw.println(ins.containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2, 2));
        pw.println(ins.containsPattern(new int[]{2,2,2,2}, 2, 3));
        

        pw.flush();
        pw.close();
    }
}
