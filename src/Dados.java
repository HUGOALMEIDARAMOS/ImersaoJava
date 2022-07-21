import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Dados {
    
    public String dados(String url) throws IOException, InterruptedException{
        URI endereco = URI.create(url);
        HttpClient newHttpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = newHttpClient.send(request, BodyHandlers.ofString());
        String body = response.body();
        return body;
     } 
}
