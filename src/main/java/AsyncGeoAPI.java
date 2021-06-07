import com.bape.map.GoogleGeoResponse;
import com.bape.map.JsonBodyHandler;
import com.bape.map.Location;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AsyncGeoAPI {

    private static final String GEO_API = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String DISTANCE_API = "https://maps.googleapis.com/maps/api/distancematrix/json";

    private static final String API_KEY = "AIzaSyA92zQXh2pdnqjFfAptSxJMbHOjjXM2PjA";

    private final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws URISyntaxException, ExecutionException, InterruptedException {
        AsyncGeoAPI geoAPI = new AsyncGeoAPI();

        String addr1 = "1600 Amphitheatre Parkway, Mountain View, CA";
        String addr2 = "3473 N 1st Street, San Jose, CA";
//        String addr1 = "423 Buena Vista Ave E, San Francisco, CA 94117, USA";
//        String addr2 = "154 Alpine Terrace, San Francisco, CA 94117, USA";

        CompletableFuture<HttpResponse<GoogleGeoResponse>> responseFuture1 = geoAPI.getGeocode(addr1);
        CompletableFuture<HttpResponse<GoogleGeoResponse>> responseFuture2 = geoAPI.getGeocode(addr2);
        List<CompletableFuture<HttpResponse<GoogleGeoResponse>>> geoFutures = List.of(responseFuture1,
                responseFuture2);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(responseFuture1, responseFuture2);

        CompletableFuture<Object> disResponse =
                allFutures.thenApply(future -> geoFutures.stream().map(responseFuture -> responseFuture.join()).collect(Collectors.toList()))
                .thenApply(resList -> resList.stream()
                        .map(response -> response.body().getResults()[0].getGeometry().getLocation())
                        .collect(Collectors.toList()))
                .thenApply(locations -> geoAPI.getDistance(locations.get(0),locations.get(1))).thenApply(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return CompletableFuture.completedFuture(null);
                });

//        Location originalGeo = responseFuture1.get().body().getResults()[0].getGeometry().getLocation();
//        Location desGeo = responseFuture2.get().body().getResults()[0].getGeometry().getLocation();
//
//        System.out.println(originalGeo);
//
//        CompletableFuture<HttpResponse<String>> distanceResponse = geoAPI.getDistance(originalGeo, desGeo);
//        System.out.println(distanceResponse.get().body());

        HttpResponse<String> res = (HttpResponse<String>) disResponse.get();
        System.out.println(res.body());
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

    CompletableFuture<HttpResponse<String>> getDistance(Location originGeo, Location desGeo) {
        StringBuilder url = new StringBuilder(DISTANCE_API).append("?origins=").append(originGeo.getLat()).append(",")
                        .append(originGeo.getLng()).append("&destinations=side_of_road:")
                        .append(desGeo.getLat()).append(",").append(desGeo.getLng())
                        .append("&key=").append(API_KEY);

        System.out.println(url);
        // URI.create("https://maps.googleapis.com/maps/api/distancematrix/json?origins=37.7680296,-122
        // .4375126&destinations=side_of_road:37.7663444,-122.4412006&key=xxx")

        HttpRequest request = HttpRequest.newBuilder(URI.create(url.toString()))
                .header("accept", "application/json")
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }
}
