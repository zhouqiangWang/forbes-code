import java.io.PrintWriter;
import java.util.*;

public class ThroneInheritance {
    Map<String, List<String>> rels = new HashMap<>();
    String king;
    Set<String> d = new HashSet<>();
    public ThroneInheritance(String kingName) {
        this.king = kingName;
    }

    public void birth(String parentName, String childName) {
        rels.computeIfAbsent(parentName, k -> new LinkedList<>()).add(childName);
    }

    public void death(String name) {
        d.add(name);
    }

    Map<String, Queue<String>> tmp = new HashMap<>();
    public List<String> getInheritanceOrder() {
        // tmp = new HashMap<>();
        List<String> res = new ArrayList<>();
        sucessor(res, king);
        // rels = tmp;

        return res;
    }

    void sucessor(List<String> order, String p) {
        if (!d.contains(p)) {
            order.add(p);
        }

        for (String child : rels.get(p)) {
            sucessor(order, child);
        }
//         while (!children.isEmpty()) {
//             String child = children.poll();
//             tmp.computeIfAbsent(p, k -> new LinkedList<>()).add(child);

//         }
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        ThroneInheritance t = new ThroneInheritance("king");

        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "ca");
        t.birth("andy", "ma");
        t.birth("bob", "alex");
        t.birth("bob", "asha");

        pw.println(t.getInheritanceOrder());

        pw.flush();
        pw.close();
    }
}
