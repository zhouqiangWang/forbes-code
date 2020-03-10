import java.util.*;

public class SquareRoot {
    public static void main(String[] arg) {
        System.out.println(sqrt(5, 0.0001f));
    }

    static double sqrt(int N, float P) {
        float guess = N/2;
        while (Math.abs(guess * guess - N) > P) {
            guess = (guess + N / guess) / 2;
        }
        return guess;
    }
}
