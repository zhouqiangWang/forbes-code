public class MS_Plan4Seats {
    static int solution(String str, int n) {
        int res = 0;

        int[][] map = new int[n][11];
        String[] reserved = str.split(" ");

        for (String s : reserved) {
            int row = Integer.parseInt(s.substring(0, s.length() - 1)) - 1;
            int seat = s.charAt(s.length() - 1) - 'A';
            map[row][seat] = 1;
        }

        int B = 2;
        int C = 3;
        int D = 4;
        int E = 5;
        int F = 6;
        int G = 7;
        int H = 8;
        int J = 10;

        for (int i = 0; i < n; i++) {
            if (map[i][B] == 0 && map[i][C] == 0 && map[i][D] == 0 && map[i][E] == 0) {
                res++;
                map[i][D] = 1;
            }
            if (map[i][D] == 0 && map[i][E] == 0 && map[i][F] == 0 && map[i][G] == 0) {
                res++;
                map[i][G] = 1;
            }
            if (map[i][F] == 0 && map[i][G] == 0 && map[i][H] == 0 && map[i][J] == 0) {
                res++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(solution("1A 2F 1C", 2));
    }
}
