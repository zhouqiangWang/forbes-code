public class We_CurrencyRecognition {
    public static boolean isCurrency(String amount) {
        if (amount.isEmpty()) {
            return false;
        }
        char c0 = amount.charAt(0);
        if (isCurrencySymbol(c0)) {
            String num = amount.substring(1);
            return isValidNum(num, c0 != '¥');
        } else if (c0 == '-') {
            if (amount.length() < 3) {
                return false;
            }
            char c1 = amount.charAt(1);
            if (isCurrencySymbol(c1)) {
                String num = amount.substring(2);
                return isValidNum(num, c1 != '¥');
            } else {
                return false;
            }
        } else if (c0 == '(') {
            int len = amount.length();
            if (amount.charAt(len - 1) != ')') {
                return false;
            }
            if (amount.length() < 3) {
                return false;
            }
            if (isCurrencySymbol(amount.charAt(1))) {
                String num = amount.substring(2, len - 1);
                return isValidNum(num, amount.charAt(1) != '¥');
            } else {
                return false;
            }
        }
        return false;
    }
    private static boolean isCurrencySymbol(char c) {
        return c == '$' || c == '€' || c == '¥';
    }

    private static boolean isValidNum(String num, boolean hasCent) {
        int len = num.length();
        if (len == 0) return false;
        char c0 = num.charAt(0);
        if (!Character.isDigit(c0)) return false;
        if (c0 == '0') {
            if (len == 1) return true;
            if (num.charAt(1) != '.') {
                return false;
            }
        }

        int thousand = -1;
        for (int i = 1; i < len; i++) {
            char c = num.charAt((i));
            if (c == ',') {
                if ((thousand == -1 && i - thousand <= 4 ) || i - thousand == 4) {
                    thousand = i;
                } else {
                    return false;
                }
            } else if (c == '.') {
                if (thousand == -1 || i - thousand == 4) {
                    if (i == len - 3) {
                        return Character.isDigit(num.charAt(i + 1)) && Character.isDigit(num.charAt(i + 2));
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isCurrency("$450"));
//        System.out.println(isCurrency("-€23"));
//        System.out.println(isCurrency("(¥2400)"));
//        System.out.println(isCurrency("$4,500.00"));
        System.out.println(isCurrency("€0.25"));
        System.out.println(isCurrency("£25"));
        System.out.println(isCurrency("€43.25"));
        System.out.println(isCurrency("cat"));
        System.out.println(isCurrency("¥2400,000"));

        System.out.println(isCurrency("¥01"));
    }
}
