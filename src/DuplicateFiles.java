import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class DuplicateFiles {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    static List<List<String>> duplicate(String path) {
        List<List<String>> dups = new ArrayList<>();

        Map<String, Set<String>> map = new HashMap<>();

        dfs(path, map);

        for (Set<String> dupSet : map.values()) {
            List<String> dupList = new ArrayList<>(dupSet);
            dups.add(dupList);
        }

        return dups;
    }

    static void dfs(String path, Map<String, Set<String>> map) {
        File cur = new File(path);
        if (!cur.isDirectory()) {
//            System.out.println(path);
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");

                System.out.println(cur.getAbsolutePath());
                FileInputStream fileInputStream = new FileInputStream(cur.getAbsoluteFile());

                long before = new Date().getTime();
                byte[] allBytes = fileInputStream.readAllBytes();
                long time1 = new Date().getTime() - before;
                System.out.println(time1);
                byte[] messageDigest = md5.digest(allBytes);
                time1 = new Date().getTime() - before;
                System.out.println(time1);

                long len = cur.length();
                time1 = new Date().getTime() - before;
                System.out.println("len = " + len);
                System.out.println(time1);
                BigInteger no = new BigInteger(messageDigest);

                String hashText = no.toString(16);

                Set<String> dupFiles = map.getOrDefault(hashText, new HashSet<>());
                dupFiles.add(cur.getAbsolutePath());
                map.put(hashText, dupFiles);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] children = cur.list();
            if (children != null) {
                for (String sub : cur.list()) {
                    dfs(path + "/" + sub, map);
                }
            } else {
                System.out.println(path);
            }
        }
    }

    private final int CHUNK_LEN = 3;
    private final FileInputStream inputStream;
    private int index = 0;
    private int readLen = 0;
    private byte[] chunk = new byte[CHUNK_LEN];

    public DuplicateFiles (String path) throws FileNotFoundException {
        File file = new File(path);
        inputStream = new FileInputStream(file);
        this.index = 0;
    }

    private byte nextByte() {
        int curIndex = index % CHUNK_LEN;
        System.out.println("index = " + index);
        index ++;
        if (curIndex > 0) {
            return chunk[curIndex];
        }
        try {
            readLen = inputStream.read(chunk);
            System.out.println(readLen);
            if (readLen <= 0) {
                return -1;
            }
            return chunk[curIndex];
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }
    int findStr(String target) {
        byte[] targetBytes = target.getBytes();

        System.out.println(Arrays.toString(targetBytes));
        int targetLen = target.length();
        byte[] buffer = new byte[target.length()];
        for (int i = 0; i < targetLen - 1; i++) {
            buffer[i] = nextByte();
        }

        int curIndex = targetLen - 2;
        byte next;
        while ((next = nextByte()) != -1) {
            curIndex = (curIndex + 1) % targetLen;
            buffer[curIndex] = next;
            for (int i = 0; i < targetLen; i++) {
                int x = (curIndex + targetLen + 1 + i) % targetLen;
                System.out.println("buffer index = " + x);
                if (buffer[(curIndex + 1 + i) % targetLen] != targetBytes[i]) {
                    break;
                }
                if (i == targetLen - 1) {
                    return index - targetLen;
                }
            }
        }

        return -1;
    }

//    static boolean isTwoFileSameByBytes(String path1, String path2) {
//        try {
//            FileInputStream file1 = new FileInputStream(path1);
//            FileInputStream file2 = new FileInputStream(path2);
//            byte[] buffer1 = new byte[1000000];
//            int len = file1.read(buffer1);
//            byte[] bytes2 = file2.readAllBytes();
//
//            byte byte1 = nextByte(paht1);
//            byte byte2 = nextByte(paht2);
//
//            while (byte1 == byte2) {
//                if (byte1 != -1) {
//
//                }
//                byte1 = nextByte(path1);
//                byte2 = nextByte(path2);
//            }
//            int a = ;
//            if (a == )
//            return false;
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

//        List<List<String>> dups = duplicate("/Users/zhouqiangw/Desktop/duptest");
//        pw.println(dups);

//        File file = new File("./");
        DuplicateFiles instance = new DuplicateFiles("/Users/zhouqiangw/Desktop/duptest/dup/test");
        pw.println(instance.findStr("45"));

        pw.flush();
        pw.close();
        sc.close();
    }
}

