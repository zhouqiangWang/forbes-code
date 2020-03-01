public class MinMoveWithout3 {
    int getMinMove(String str) {
        int res = 0;

        char pre = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur != pre) {
                pre = cur;
                count = 1;
            } else {
                count++;
                if (count == 3) {
                    res++;
                    if (i < str.length() - 2 && str.charAt(i + 1) != cur && str.charAt(i + 2) != cur) {
                        count = 1;
                        pre = cur;
                    } else {
                        count = 1;
                        if (cur == 'a') {
                            pre = 'b';
                        } else {
                            pre = 'a';
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MinMoveWithout3 ins = new MinMoveWithout3();
        System.out.println(ins.getMinMove("ababa"));
        System.out.println(ins.getMinMove("baaaaa"));
        System.out.println(ins.getMinMove("baaabbaabbbba"));
    }
}
