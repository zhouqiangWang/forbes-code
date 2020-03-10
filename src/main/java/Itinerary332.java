import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Itinerary332 {
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            String to = pair.get(1);
            map.putIfAbsent(from, new ArrayList<String>());
            map.get(from).add(to);
        }
        map.values().forEach(list -> list.sort(String::compareTo));
        List<String> cur = new ArrayList<>();

        String start = "JFK";
        cur.add(start);
        dfs(start, cur, tickets.size() + 1, map);

        return res;
    }

    void dfs(String start, List<String> cur, int total, Map<String, List<String>> map) {
        if (!res.isEmpty()) {
            return;
        }
        if (cur.size() == total) {
            res = new ArrayList<String>(cur);
            return;
        }
        if (start == null || start.isEmpty()) {
            return;
        }
        List<String> nexts = map.get(start);
        if (nexts != null && !nexts.isEmpty()) {
            for (int i = 0; i < nexts.size(); i++) {
                String next = nexts.get(i);
                cur.add(next);
                List<String> newList = new ArrayList<>(nexts);
                newList.remove(i);
                map.put(start, newList);
                dfs(next, cur, total, map);
                map.put(start, newList);
                cur.remove(next);
            }
        }
    }

    public static void main(String[] args) {
        Itinerary332 instance = new Itinerary332();
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("JFK");
        t1.add("KUL");
        tickets.add(t1);
        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("NRT");
        tickets.add(t2);
        List<String> t3 = new ArrayList<>();
        t3.add("NRT");
        t3.add("JFK");
        tickets.add(t3);

        System.out.println(instance.findItinerary(tickets));
    }
}
