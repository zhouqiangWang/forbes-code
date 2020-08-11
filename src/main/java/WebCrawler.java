import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class WebCrawler {
    String hostName;
    Set<String> done = ConcurrentHashMap.newKeySet();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        try {
            URL url = new URL(startUrl);
            hostName = url.getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ForkJoinPool.commonPool().execute(new FJT(startUrl, htmlParser));

        return new ArrayList<>(done);
    }

    class FJT extends ForkJoinTask<String> {
        String url;
        HtmlParser htmlParser;

        public FJT(String url, HtmlParser htmlParser) {
            this.url = url;
            this.htmlParser = htmlParser;
        }

        @Override
        public String getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(String value) {

        }

        @Override
        protected boolean exec() {
            List<FJT> newTasks = new ArrayList<>();
            if (done.contains(url)) return true;

            List<String> newUrls = htmlParser.getUrls(url);
            for (String url : newUrls) {
                if (done.contains(url)) continue;
                try {
                    URL parsedUrl = new URL(url);
                    if (!parsedUrl.getHost().equalsIgnoreCase(hostName)) {
                        newTasks.add(new FJT(url, htmlParser));
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            done.add(url);
            invokeAll(newTasks);

            return false;
        }
    }

    public static void main(String[] args) {

    }
}

interface HtmlParser {
    public List<String> getUrls(String url);
}