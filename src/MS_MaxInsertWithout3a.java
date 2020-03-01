public class MS_MaxInsertWithout3a {
    static int solution(String str) {
        int res = 0;
        int left = 2;
        for (char c : str.toCharArray()) {
            if (c != 'a') {
                res += left;
                left = 2;
            } else {
                left --;
                if (left < 0) {
                    return -1;
                }
            }
        }
        if (str.charAt(str.length() - 1) != 'a') {
            res += 2;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabab"));
        System.out.println(solution("dog"));
        System.out.println(solution("aa"));
        System.out.println(solution("baaaa"));
    }
}
