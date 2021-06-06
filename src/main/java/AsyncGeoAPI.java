import com.bape.map.Address;
import com.bape.map.GoogleGeoResponse;
import com.bape.map.JsonBodyHandler;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncGeoAPI {

    private static final String GEO_API = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String DISTANCE_API = "https://maps.googleapis.com/maps/api/distancematrix/json";

    private static final String API_KEY = "AIzaSyA92zQXh2pdnqjFfAptSxJMbHOjjXM2PjA";

    private final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws URISyntaxException, ExecutionException, InterruptedException {
        AsyncGeoAPI geoAPI = new AsyncGeoAPI();

        String addr1 = "1600 Amphitheatre Parkway, Mountain View, CA";
        String addr2 = "3473 N 1st Street, San Jose, CA";

        CompletableFuture<HttpResponse<GoogleGeoResponse>> responseFuture1 = geoAPI.getGeocode(addr1);
//        CompletableFuture<HttpResponse<GoogleGeoResponse>> responseFuture2 = geoAPI.getGeocode(addr2);

        Address[] addresses1 = responseFuture1.get().body().getResults();
        System.out.println(addresses1[0].getGeometry().getLocation());
//        System.out.println(responseFuture2.get().body());
    }

    CompletableFuture<HttpResponse<GoogleGeoResponse>> getGeocode(String address) throws URISyntaxException {
        URI uri = new URIBuilder(GEO_API)
                .addParameter("address", address)
                .addParameter("key", API_KEY)
                .build();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("accept", "application/json")
                .GET()
                .build();

        return client.sendAsync(request, new JsonBodyHandler<>(GoogleGeoResponse.class));
    }

    CompletableFuture<HttpResponse<String>> getDistance(String originGeo, String desGeo) throws URISyntaxException {
        URI uri = new URIBuilder(GEO_API)
                .addParameter("origins", originGeo)
                .addParameter("destinations", "side_of_road:" + desGeo)
                .addParameter("key", API_KEY)
                .build();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("accept", "application/json")
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }
}

