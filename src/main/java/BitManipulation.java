import java.io.PrintWriter;

public class BitManipulation {
    public int reverseBits(int n) {
        n = ((n >> 16) & 0x0000ffff) | (n << 16);
        n = (((n & 0xff00ff00) >> 8) & 0x00ff00ff) | ((n & 0x00ff00ff) << 8);
        n = (((n & 0xf0f0f0f0) >> 4) & 0x0f0f0f0f) | ((n & 0x0f0f0f0f) << 4);
        n = (((n & 0xcccccccc) >> 2) & 0x33333333) | ((n & 0x33333333) << 2);
        n = (((n & 0xaaaaaaaa) >> 1) & 0x55555555) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] arg) {
        PrintWriter pw = new PrintWriter(System.out);

        BitManipulation ins = new BitManipulation();
        int n = 43261596;

        pw.println(Integer.toBinaryString(ins.reverseBits(n)));

        pw.println(Integer.toBinaryString(-1 >> 2));
        pw.println(Integer.toBinaryString(Integer.MAX_VALUE >> 2));

        pw.flush();
        pw.close();
    }
}
