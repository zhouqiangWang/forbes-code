import java.util.HashMap;
import java.util.Map;

/*
int[] alphet = new int[26];
x : -1,
y : -1,
z : -1.
0.
str.
|   |
"xyyzyzx"

Set<>
[x y z]
count = 2
xyy
xyyzazxyz

count >

alphet[] = 0.

r - l = len

minLen = Math.min()

O(n)
26..
Map<Character, Integer> map
str.length = n
O(n)
space : O(m)

*/
class SmallestSubstring {

    static String getShortestUniqueSubstring(char[] arr, String str) {
        Map<Character, Integer> occur = new HashMap<>();
        for (char c : arr) {
            occur.put(c, -1);
        }
        int count = 0;
        int left = 0, right = 0;
        int minLeft = 0, minRight = str.length();
        // xyyzy
        // x -> 0
        // y -> 1
        // count = 2
        while (right < str.length()) {
            char c = str.charAt(right);
            if (occur.containsKey(c)) {
                if (occur.get(c) < 0) {
                    count++;
                    if (count == arr.length) {
                        if (right - left < minRight - minLeft) {
                            minLeft = left;
                            minRight = right;
                        }
                        System.out.println(left + ", " + right);
                    }
                }
                occur.put(c, occur.get(c) + 1);
            }

            // move the left pointer.
            while (count == arr.length && left < right) {
                char charL = str.charAt(left);
                left++;
                int occ = occur.getOrDefault(charL, -1);
                if (occ >= 0) {
                    occ--;
                    occur.put(charL, occ);
                    if (occ < 0) {
                        count--;
                        continue;
                    }
                }

                if (right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }
            }
            right++;
        }
        if (minRight == str.length()) {
            return "";
        }
        return str.substring(minLeft, minRight+1);
    }


    public static void main(String[] args) {
        char[] arr = {'y'};
        String str = "x";
        System.out.println(getShortestUniqueSubstring(arr, str));
    }

}