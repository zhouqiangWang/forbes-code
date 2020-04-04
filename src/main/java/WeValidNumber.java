public class WeValidNumber {

    static boolean validNumber(String num) {
        char[] chs = num.toCharArray();
        boolean hasNum = false;
        boolean hasPoint = false;

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '-' || chs[i] == '+') {
                if (i > 0) {
                    return false;
                }
            } else if (chs[i] > '0' && chs[i] <= '9') {
                hasNum = true;
            } else if (chs[i] == '0') {
                if (!hasNum && !hasPoint) {
                    if (i < chs.length - 1 && chs[i + 1] != '.') {
                        return false;
                    }
                }
                hasNum = true;
            } else if (chs[i] == '.') {
                if (hasPoint) {
                    return false;
                }
                hasPoint = true;
                hasNum = false;
            } else {
                return false;
            }
        }
        num.trim();
        return hasNum;
    }

    public static void main(String[] args) {
        System.out.println(validNumber("1.0"));
        System.out.println(validNumber("-.1"));
        System.out.println(validNumber("01"));
        System.out.println(validNumber(".01"));
        System.out.println(validNumber("100.01"));
    }
}
