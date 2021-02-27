import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MS_OA_0204 {
    public int solution(String A, String B) {
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (char c : A.toCharArray()) {
            countA[c - 'a']++;
        }
        for (char c : B.toCharArray()) {
            countB[c - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(countA[i] - countB[i]);
        }

        return sum;
    }

    public int sumOfFirsts(int[] nums) {
        int l = 0;
        int res = 0;
        // time complexity: O(n*n);
        while (l < nums.length) {
            int first = nums[l];
            System.out.println(l);
            int next = l;
            for (int j = l; j < nums.length; j++) {
                if (nums[j] < first) {
                    res += first;
                    l = next;
                    System.out.println(l);
                    break;
                } else {
                    nums[j] -= first;
                    if (nums[j] == 0 && next == j) {
                        next++;
                    }
                }
            }
        }
        return res;
    }

    int combineTheGivenNumber(int[] numbers, int x) {
        List<String> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(String.valueOf(i));
        }
        String xStr = String.valueOf(x);
        int n = numbers.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            String str1 = list.get(i);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (Integer.parseInt(str1 + list.get(j)) == x) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MS_OA_0204 ins = new MS_OA_0204();
        int[] arr = new int[]{3, 3 ,5, 2, 3};
//        int[] numbers = new int[]{1, 212, 12, 12};
        int[] numbers = new int[]{777, 7, 777, 77, 77};

        System.out.println(ins.combineTheGivenNumber(numbers, 7777));
    }

    @Override
    public String toString() {
        return "(x, y)";
    }
}
