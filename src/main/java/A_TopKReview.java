import java.util.*;

public class A_TopKReview {
    private PriorityQueue<Map.Entry<String, Integer>> minHeap;

    static List<String> getTopK(int k, String[] keywords, String[] reviews) {
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> frequentMap = new HashMap<>();

        for (String review : reviews) {
            String[] words = review.split("\\W");
            Set<String> seen = new HashSet<>();
            for (String word : words) {
                word = word.toLowerCase();
                if (set.contains(word) && !seen.contains(word)) {
                    frequentMap.put(word, frequentMap.getOrDefault(word, 0) + 1);
                    seen.add(word);
                }
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>((entry1, entry2) -> entry1.getValue() - entry2.getValue() == 0 ?
                        entry2.getKey().compareTo(entry1.getKey()) :
                        entry1.getValue() - entry2.getValue());

        for (Map.Entry<String, Integer> entry : frequentMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
//            if (minHeap.size() < k) {
//                minHeap.add(entry);
//            } else {
//                int diff = minHeap.peek().getValue() - entry.getValue();
//                if (diff < 0 || (diff == 0 && minHeap.peek().getKey().compareTo(entry.getKey()) > 0) ) {
//                    minHeap.poll();
//                    minHeap.add(entry);
//                }
//            }
        }

        List<String> res = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey());
        }
        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(getTopK(3, keywords2, reviews2));
    }
}
