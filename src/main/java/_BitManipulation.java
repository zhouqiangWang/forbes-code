import java.io.PrintWriter;

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

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        int n = 6;
        // remove the most right 1.
        pw.println(n & (n - 1));

        // countSetBits
        pw.println(countSetBits(6));

        pw.println(isPower2(8));

        pw.println(lowBit(6));

        pw.flush();
        pw.close();
    }
}
