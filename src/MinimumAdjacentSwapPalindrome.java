public class MinimumAdjacentSwapPalindrome {

    int getMinSwap(String s) {
        int[] counter = new int[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            counter[c-'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (counter[i] % 2 == 1) {
                odd++;
                if (odd > 1) {
                    return -1;
                }
            }
        }

        int res = 0;

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (chs[l] == chs[r]) {
                l++;
                r--;
                continue;
            }
            int sl = l + 1, sr = r - 1;
            while (sl < r && sr > l) {
                if (chs[sl] == chs[r]) {
                    for (int i = l + 1; i <= sl; i++) {
                        res++;
                        chs[i] = chs[i-1];
                    }
                    chs[l] = chs[r];
                }
                if (chs[sr] == chs[l]) {
                    for (int i = r - 1; i >= sr; i--) {
                        res++;
                        chs[i] = chs[i + 1];
                    }
                    chs[r] = chs[l];
                }
                sl++;
                sr--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumAdjacentSwapPalindrome ins = new MinimumAdjacentSwapPalindrome();

        System.out.println(ins.getMinSwap("mamad"));
        System.out.println(ins.getMinSwap("asflkj"));
        System.out.println(ins.getMinSwap("aabb"));
        System.out.println(ins.getMinSwap("ntiin"));
    }
}
