import java.util.HashMap;
import java.util.Map;

class FlattenDict {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> res = new HashMap<>();
        dfs(res, "", dict);

        return res;
    }

    static void dfs(HashMap<String, String> res, String cur, Object value) {
        if (!(value instanceof Map)) {
            res.put(cur, value.toString());
            return;
        }
        Map<String, Object> valMap = (Map) value;
        for (String key : valMap.keySet()) {
            if (key.isEmpty()) {
                dfs(res, cur, valMap.get(key));
            } else {
                String original = cur;
                if (cur.isEmpty()) {
                    cur = key;
                } else {
                    cur = cur + "." + key;
                }
                dfs(res, cur, valMap.get(key));
                cur = original;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Object> root = new HashMap<>();
        root.put("key1", "1");
        HashMap<String, Object> val2 = new HashMap<>();
        val2.put("a", "2");
        val2.put("", 3);
        HashMap<String, Object> valc = new HashMap<>();
        valc.put("d",3);
        val2.put("c", valc);
        root.put("key2", val2);


        System.out.println(flattenDictionary(root));
    }

}