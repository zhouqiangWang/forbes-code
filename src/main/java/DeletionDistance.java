
class DeletionDistance {

    static int deletionDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= str2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int minDistance = Math.min(dp[i][j] + 2, dp[i+1][j] + 1);
                    minDistance = Math.min(minDistance, dp[i][j+1] + 1);
                    dp[i+1][j+1] = minDistance;
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(deletionDistance("d", "fr"));
    }

}