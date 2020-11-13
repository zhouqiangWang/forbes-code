import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompassStringMapping {

    static String translate(String sentence, Map<String, String> dict) {
        final Pattern p = Pattern.compile("\\{(.*)\\}");
        final Matcher matcher = p.matcher(sentence);
        while (matcher.find()) {
            String key = matcher.group(1);
            System.out.println(key);
        }
        return sentence;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        String sentence = "ab{c}{d}";
        Map<String, String> dict = Map.of("c", "hello");
        pw.println(translate(sentence, dict));

        pw.flush();
        pw.close();
    }
}
