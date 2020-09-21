import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeepTruckIn_ValidateIPs {

    List<String> allPossibleIps(int[] nums) {
        List<String> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        dfs(map, res, "", 0, 1);

        return res;
    }

    void dfs(Map<Integer, Integer> map, List<String> res, String curIP, int cur, int idx) {
        if (map.isEmpty()) {
            if (idx == 4) {
                res.add(curIP + cur);
            }
            return;
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int k : keys) {
//            if (cur == 0 && k == 0) continue;
            int next = cur * 10 + k;
            if (next > 255) continue;
            map.put(k, map.get(k) - 1);
            if (map.get(k) == 0) {
                map.remove(k);
            }
            dfs(map, res, curIP, next, idx);
            if (idx < 4) {
                dfs(map, res, curIP + next  + "." , 0,idx + 1);
            }
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        KeepTruckIn_ValidateIPs ins = new KeepTruckIn_ValidateIPs();

        pw.println(ins.allPossibleIps(new int[]{1, 2, 3, 0, 4}));

        pw.flush();
        pw.close();
    }
}
