import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class DependencyResolver {
    List<String> printLibraries(List<String> libs, Map<String, Set<String>> dependency) {
        Set<String> all = new HashSet<>(libs);
        Map<String, Set<String>> parents = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : dependency.entrySet()) {
            String parent = entry.getKey();
            all.add(parent);
            for (String s : entry.getValue()) {
                all.add(s);
                parents.putIfAbsent(s, new HashSet<>());
                parents.get(s).add(parent);
            }
        }
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        int total = all.size();
        int count = 0;

        for (String lib : all) {
            if (!dependency.containsKey(lib)) {
                queue.offer(lib);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String lib = queue.poll();
                res.add(lib);
                if (parents.containsKey(lib)) {
                    for (String p : parents.get(lib)) {
                        if (dependency.containsKey(p)) {
                            dependency.get(p).remove(lib);
                            if (dependency.get(p).isEmpty()) {
                                dependency.remove(p);
                                queue.add(p);
                            }
                        }
                    }
                }
            }
        }

        if (dependency.isEmpty()) {
            return res;
        } else {
            res = new ArrayList<>();
            res.add("Circle");
            // find circle.
            Set<String> circles = new HashSet<>();
            Map.Entry<String, Set<String>> entry = dependency.entrySet().iterator().next();
            String start = entry.getKey();
            res.add(start);
            Stack<String> stack = new Stack<>();
            stack.add(start);
            while (!stack.isEmpty()) {
                circles.add(stack.peek());
                for(String next : dependency.get(stack.peek())) {
                    if (circles.contains(next)) {
                        while (!stack.isEmpty()) {
                            res.add(stack.pop());
                        }
                        break;
                    }
                    if (dependency.containsKey(next)) {
                        stack.push(next);
                        break;
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);

        DependencyResolver resolver = new DependencyResolver();
        List<String> libs = Arrays.asList("z", "a", "b", "c", "d");
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> setA = new HashSet<>();
        setA.add("b");
        setA.add("d");
        map.put("a", setA);
        Set<String> setB = new HashSet<>();
        setB.add("c");
        setB.add("d");
        map.put("b", setB);
        Set<String> setC = new HashSet<>();
        setC.add("g");
        setC.add("b");
        map.put("c", setC);
        Set<String> setD = new HashSet<>();
        setD.add("e");
        map.put("d", setD);
        Set<String> setf = new HashSet<>();
        setf.add("g");
        map.put("f", setf);

        pw.println(resolver.printLibraries(libs, map));

        pw.flush();
        pw.close();
        sc.close();
    }
}
