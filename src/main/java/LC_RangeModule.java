import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class LC_RangeModule {

    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public LC_RangeModule() {

    }

    public void addRange(int left, int right) {
        Integer floorL = map.floorKey(left);
        Integer floorR = map.floorKey(right);

        if (floorR == null) {
            map.put(left, right);
            return;
        } else if (floorL == null || map.get(floorL) < left) {
            map.put(left, Math.max(right, map.get(floorR)));
        } else {
            map.put(floorL, Math.max(right, map.get(floorR)));
        }
        Map<Integer, Integer> sub = map.subMap(left, false, right, true);

        map.keySet().removeAll(sub.keySet());
    }

    public boolean queryRange(int left, int right) {
        Integer floor = map.floorKey(left);
        if (floor == null) return false;
        return map.get(floor) >= right;
    }

    public void removeRange(int left, int right) {
        Integer begin = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (begin != null && map.get(begin) > left) {
            map.put(begin, left);
        }

        Map<Integer, Integer> sub = map.subMap(left, true, right, false);
        map.keySet().removeAll(sub.keySet());
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        LC_RangeModule ins = new LC_RangeModule();

        ins.addRange(10, 180);
        ins.addRange(150, 200);
        ins.addRange(250, 500);
        ins.removeRange(14, 16);
        pw.println(ins.queryRange(10, 14));
        pw.println(ins.queryRange(13, 15));
        pw.println(ins.queryRange(16, 17));

        pw.flush();
        pw.close();
    }

}
