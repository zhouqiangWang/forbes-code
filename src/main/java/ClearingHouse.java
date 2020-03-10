import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClearingHouse {

    List<Transaction> settleDown(String[] records) {
        Map<String, Double> amountMap = new HashMap<>();

        for (String record : records) {
            Transaction trans = Transaction.parseFrom(record);
            double payeeA = amountMap.getOrDefault(trans.payee, 0.0);
            double payerA = amountMap.getOrDefault(trans.payer, 0.0);
            amountMap.put(trans.payee, payeeA + trans.amount);
            amountMap.put(trans.payer, payerA - trans.amount);
        }
        System.out.println(amountMap);

        List<Map.Entry<String, Double>> nonZeros = amountMap.entrySet().stream()
                .filter(stringDoubleEntry -> stringDoubleEntry.getValue() != 0)
                .collect(Collectors.toList());

        dfs(0, nonZeros, new ArrayList<>(), 0);

        return minPath;
    }

    int min = Integer.MAX_VALUE;
    List<Transaction> minPath;

    void dfs(int index, List<Map.Entry<String, Double>> list, List<Transaction> path, int steps) {
        while (index < list.size() && list.get(index).getValue() == 0) {
            index ++;
        }
        if (index == list.size()) {
            if (steps < min) {
                min = steps;
                minPath = List.copyOf(path);
            }
            return;
        }

        String curName = list.get(index).getKey();
        double curAmount = list.get(index).getValue();
        for (int i = index + 1; i < list.size(); i++) {
            Map.Entry<String, Double> next = list.get(i);
            if (next.getValue() * curAmount < 0) {
                if (curAmount > 0) {
//                    path.add(new Transaction(curName, curAmount, next.getKey()));
                    double newAmount = curAmount + next.getValue();
                    if (newAmount < 0) {
                        path.add(new Transaction(curName, curAmount, next.getKey()));
                        list.set(i, Map.entry(next.getKey(), newAmount));
                    } else {
                        path.add(new Transaction(curName, 0 - next.getValue(), next.getKey()));
                        list.set(i, Map.entry(curName, newAmount));
                    }
                } else {
                    double newAmount = curAmount + next.getValue();
                    if (newAmount < 0) {
                        path.add(new Transaction(curName, next.getValue(), next.getKey()));
                        list.set(i, Map.entry(curName, newAmount));
                    } else {
                        path.add(new Transaction(next.getKey(), 0 - curAmount, curName));
                        list.set(i, Map.entry(next.getKey(), newAmount));
                    }
                }

                dfs(index + 1, list, path, steps + 1);

                list.set(i, next);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("begin settle down : ");
        Transaction transaction = Transaction.parseFrom("{\"payee\": \"BoA\", \"amount\": 132, \"payer\": \"Chase\"}");
//        System.out.println(transaction);

        String[] records = {
                "{\"payee\": \"BoA\", \"amount\": 132, \"payer\": \"Chase\"}",
                "{\"payee\": \"BoA\", \"amount\": 827, \"payer\": \"Chase\"}",
                "{\"payee\": \"Well Fargo\", \"amount\": 751, \"payer\": \"BoA\"}",
                "{\"payee\": \"BoA\", \"amount\": 585, \"payer\": \"Chase\"}",
                "{\"payee\": \"Chase\", \"amount\": 877, \"payer\": \"Well Fargo\"}",
                "{\"payee\": \"Well Fargo\", \"amount\": 157, \"payer\": \"Chase\"}",
                "{\"payee\": \"Well Fargo\", \"amount\": 904, \"payer\": \"Chase\"}",
                "{\"payee\": \"Chase\", \"amount\": 548, \"payer\": \"Well Fargo\"}",
                "{\"payee\": \"Chase\", \"amount\": 976, \"payer\": \"BoA\"}",
                "{\"payee\": \"BoA\", \"amount\": 872, \"payer\": \"Well Fargo\"}",
                "{\"payee\": \"Well Fargo\", \"amount\": 571, \"payer\": \"Chase\"}",
                "{\"payee\": \"Well Fargo\", \"amount\": 200, \"payer\": \"citi\"}",
                "{\"payee\": \"BoA\", \"amount\": 200, \"payer\": \"citi\"}",
                "{\"payee\": \"citi\", \"amount\": 200, \"payer\": \"Chase\"}"
        };

        ClearingHouse instance = new ClearingHouse();
        System.out.println(instance.settleDown(records));
    }
}

class Transaction {
    String payee;
    String payer;
    double amount;

    public static Transaction parseFrom(String trans) {
        String[] items = trans.split("\"");
        String amountStr = items[6];
        double a = Double.valueOf(amountStr.substring(1, amountStr.length() - 2));
        return new Transaction(items[3], a, items[9]);
    }

    Transaction(String payee, double amount, String payer) {
        this.payee = payee;
        this.payer = payer;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{\"payee\": " + payee + ", \"amount\": " + amount + ", \"payer\": " + payer + "}";
    }
}
