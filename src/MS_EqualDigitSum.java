import java.util.HashMap;
import java.util.Map;

public class MS_EqualDigitSum {
    public int solution(int[] A) {
        int res = -1;

        Map<Integer, int[]> sumMap = new HashMap<>();
        for (int n : A) {
            int sum = getDigitSum(n);
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, new int[]{n, 0});
            } else {
                int[] arr = sumMap.get(sum);
                if (arr[0] < n) {
                    arr[1] = arr[0];
                    arr[0] = n;
                } else if (arr[1] < n) {
                    arr[1] = n;
                }
            }
        }

        for (int[] arr : sumMap.values()) {
            if (arr[1] != 0) {
                res = Math.max(arr[0] + arr[1], res);
            }
        }

        return res;
    }

    int getDigitSum (int n) {
        int sum = 0;

        while(n > 0) {
            sum += n % 10;
            n = n/10;
        }

        return sum;
    }

    public static void main(String[] args) {
        MS_EqualDigitSum ins = new MS_EqualDigitSum();

        System.out.println(ins.solution(new int[]{51, 71, 17, 42}));
        System.out.println(ins.solution(new int[]{42, 33, 60}));
        System.out.println(ins.solution(new int[]{51, 32, 43}));
    }
}
