import java.io.PrintWriter;
import java.net.URI;

public class UriTest {

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        URI uri = URI.create("https://www.google.com/test?u=uer&n=name#frag123");

        pw.println(uri);
        pw.println("schema: " + uri.getScheme());
        pw.println("host: " + uri.getHost());
        pw.println("path: " + uri.getPath());
        pw.println("query: " + uri.getQuery());
        pw.println("query: " + uri.getFragment());

        URI uri2 = URI.create("www.google.com/test?u=uer&n=name#frag123");

        pw.println(uri2);
        pw.println("schema: " + uri2.getScheme());
        pw.println("host: " + uri2.getHost());
        pw.println("path: " + uri2.getPath());
        pw.println("query: " + uri2.getQuery());
        pw.println("query: " + uri2.getFragment());

        pw.flush();
        pw.close();
    }
}
