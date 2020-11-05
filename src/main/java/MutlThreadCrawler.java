import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.*;

public class MutlThreadCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        Deque<Future> tasks = new ArrayDeque<>();

        queue.offer(startUrl);

        ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        while (true) {
            String url = queue.poll();
            break;
        }

        return res;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);


        pw.flush();
        pw.close();
    }
}
