import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {
    static void selectKItems(int[] streams, int k) {
        int[] reservoir = new int[k];
        int i = 0;
        for (; i < k; i++) {
            reservoir[i] = streams[i];
        }
        Random random = new Random();

        for (; i < streams.length; i++) {
            int j = random.nextInt(i + 1);
            if (j < k) {
                reservoir[j] = streams[i];
            }
        }

        System.out.println("Randomly selected k elements are as follows:");
        System.out.println(Arrays.toString(reservoir));
    }
    public static void main(String[] args) {
        int[] stream = {1, 2, 3, 4 ,5 , 6, 7, 8, 9, 10};
        selectKItems(stream, 5);
    }
}
