import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FileAccess {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    static boolean hasAccess(Set<String> access, String[][] fs, String fileName) {
        Map<String, String> fileTree = new HashMap<>();
        for (String[] item: fs) {
            fileTree.put(item[1], item[0]);
        }
        if (access.contains(fileName)) {
            return true;
        }
        String nextFile = fileName;
        while (fileTree.containsKey(nextFile)) {
            nextFile = fileTree.get(nextFile);
            if (access.contains(nextFile)) {
                return true;
            }
        }
        return false;
    }

    static void dfs(Set<String> visit, Map<String, List<String>> fileTree, Set<String> redundant, String current, Set<String> access) {
        if (access.contains(current)) {
            redundant.add(current);
        }
        if (!fileTree.containsKey(current)) {
            return;
        }

        if (visit.contains(current)) {
            return;
        }
        if (access.contains(current)) {
            visit.add(current);
        }
        for(String child : fileTree.get(current)) {
            dfs(visit, fileTree, redundant, child, access);
        }
    }

    static List<String> removeRedundant(Set<String> access, String[][] fs) {
        Map<String, List<String>> fileTable = new HashMap<>();
        for (String[] item: fs) {
            List<String> children = fileTable.getOrDefault(item[0], new ArrayList<>());
            children.add(item[1]);
            fileTable.put(item[0], children);
        }
        Set<String> visits = new HashSet<>();
        Set<String> redundancy = new HashSet<>();
        for (String fileName : access) {
            visits.add(fileName);
            if (fileTable.containsKey(fileName)) {
                for (String child: fileTable.get(fileName)) {
                    dfs(visits, fileTable, redundancy, child, access);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String file : access) {
            if (!redundancy.contains(file)) {
                result.add(file);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        Set<String> access = new HashSet<>();
        access.add("A");
        access.add("H");
        access.add("C");

        /**
         * A
         * | - B
         *     | - E
         *     | - F
         * | - C
         *     | - G
         *     | - H
         */
        String[][] fs = new String[][]{{"A", "B"}, {"A", "C"}, {"B", "E"}, {"B", "F"}, {"C", "G"}, {"C", "H"}};

        pw.println(hasAccess(access, fs, "A"));

        pw.println(removeRedundant(access, fs));

        pw.flush();
        pw.close();
        sc.close();
    }
}

