import java.io.PrintWriter;
import java.util.TreeMap;

public class _BitManipulation {
    /**
     * Remove the most right bit of a integer.
     */
    static int mostRight1(int n) {
        return n & (n - 1);
    }

    /**
     * Return the most right bit of a integer.
     */
    static int lowBit(int i){
        return -i & i;
    }

    static int countSetBits(int x){
        int count = 0;
        while (x != 0) {
            x &= (x-1);
            count++;
        }
        return count;
    }

    static boolean isPower2(int n) {
        return (n>0 && ((n&(n-1)) == 0));
    }


    public static int reverseBits(int n) {
        n = ((n >> 16) & 0x0000ffff) | (n << 16);
        n = (((n & 0xff00ff00) >> 8) & 0x00ff00ff) | ((n & 0x00ff00ff) << 8);
        n = (((n & 0xf0f0f0f0) >> 4) & 0x0f0f0f0f) | ((n & 0x0f0f0f0f) << 4);
        n = (((n & 0xcccccccc) >> 2) & 0x33333333) | ((n & 0x33333333) << 2);
        n = (((n & 0xaaaaaaaa) >> 1) & 0x55555555) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        int n = 6;
        // remove the most right 1.
        pw.println(n & (n - 1));

        // countSetBits
        pw.println(countSetBits(6));

        pw.println(isPower2(8));

        pw.println(lowBit(6));

        n = 43261596;
        pw.println(Integer.toBinaryString(n));
        pw.println(Integer.toBinaryString(reverseBits(n)));

        pw.println(Integer.toBinaryString(Integer.MIN_VALUE >> 2));
        pw.println(Integer.toBinaryString(Integer.MIN_VALUE >>> 2));
        pw.println(Integer.toBinaryString(Integer.MAX_VALUE >> 2));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 100);
        treeMap.put(2, 200);
        treeMap.put(4, 400);
        pw.println(treeMap.floorKey(0));
        pw.println("floorKey(2) = " + treeMap.floorKey(2));
        pw.println(treeMap.floorKey(3));

        pw.flush();
        pw.close();
    }
}
