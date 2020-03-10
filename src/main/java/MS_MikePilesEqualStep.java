import java.util.Arrays;
import java.util.Collections;

public class MS_MikePilesEqualStep {
    public static int step(Integer[] input){
        if(input == null || input.length == 0){
            return 0;
        }

        int steps = 0;
        Arrays.sort(input, Collections.reverseOrder());

        for( int i=1; i<input.length; i++){
            if(input[i] < input[i-1]){
                steps += i;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(step(new Integer[]{5,2,1}));
        System.out.println(step(new Integer[]{4,5,5,4,2}));
    }
}
