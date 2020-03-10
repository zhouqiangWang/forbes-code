import java.util.HashMap;
import java.util.Map;

public class MS_DayOfWeek {
    public static String solution(String s, int k){
        String[] week = new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 7; i ++){
            map.put(week[i], i);
        }
        return week[(map.get(s) + k) % 7];
    }

    public static void main(String[] args) {
        System.out.println(solution("Sat", 23));
    }
}
