import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * NASA selects Dropbox as its official partner, and we’re tasked with managing
 * a panorama for the universe. The Hubble telescope (or some other voyager we
 * have out there) will occasionally snap a photo of a sector of the universe,
 * and transmit it to us. You are to help write a data structure to manage this.
 * For the purpose of this problem, assume that the observable universe has been
 * divided into 2D sectors. Sectors are indexed by x- and y-coordinates.
 */
//interface File {
//    public Boolean exists();
//    public byte[] read();
//    public void write(byte[] bytes);
//}

interface Image {
    byte[] getBytes(); // no more than 1MB in size
}

class Sector {
    private int x;
    private int y;
    public Sector(int x, int y) {
        this.x = x;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
}

/**
 * row-major indexing to be consistent.
 */
public class SpacePanorama {
    /**
     * initializes the data structure. rows x cols is the sector layout.
     * width, height can be as large as 1K each.
     */
    public SpacePanorama(int rows, int cols) {}

    /**
     * The Hubble will occasionally call this (via some radio wave communication)
     * to report new imagery for the sector at (y, x)
     * Images can be up to 1MB in size.
     */
    public void update(int y, int x, Image image) {}

    /**
     * NASA will occasionally call this to check the view of a particular sector.
     */
    public Image fetch(int y, int x) {
        throw new IllegalArgumentException("");
    }

    /**
     * return the 2D index of the sector that has the stalest data.
     * the idea is that this may help the telescope decide where to aim next.
     */
    public Sector getStalestSector() {
        return null;
    }

    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(FILE_INPUT));
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        pw.flush();
        pw.close();
        sc.close();
    }
}
