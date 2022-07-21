import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.io.FileInputStream;
import java.lang.Math;

public class App {

 


    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        String arquivo = "./dados.properties";
        prop.load(new FileInputStream(arquivo));
        var chave = prop.getProperty("chave");

       //String url = "https://imdb-api.com/en/API/Top250Movies/" + chave;
       String url = "https://alura-imdb-api.herokuapp.com/movies";  
       Dados data = new Dados();
       var body = data.dados(url);              
       JsonParse jsonParse = new JsonParse();

       System.out.println(); 
       System.out.println(); 
       System.out.println("======================================================================================================================================");
       System.out.println("\u001b[1m \u001b[41m \u001b[5m  MELHORES 250 FILMES \u001b[m");
       System.out.println("======================================================================================================================================");
       List<Map<String, String>> listaDeFilmes = jsonParse.parse(body);       
       for (Map<String,String> filme : listaDeFilmes) {

            var pont =  Float.parseFloat(filme.get("imDbRating"));
            var ponto = Math.round(pont);

            System.out.println("\u001b[1m \u001b[36m Título: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[1m \u001b[36m Poster: \u001b[m" + filme.get("image"));
            System.out.println("\u001b[1m \u001b[36m\u001b[41m Classificação: " + filme.get("imDbRating") + "\u001b[m");
            for (int i = 0; i < ponto; i++) {
                System.out.print(" \uD83D\uDC99");
            }
            System.out.println(); 
            System.out.println();          
       }

       System.out.println(); 
       System.out.println(); 
       System.out.println("======================================================================================================================================");
       System.out.println("\u001b[1m \u001b[45m \u001b[5m  FILMES MAIS POPULARES \u001b[m");
       System.out.println("======================================================================================================================================");

       String urlFilmPopular = "https://imdb-api.com/en/API/Top250Movies/" + chave;
       Dados dataPopular = new Dados();
       var bodyPopular = dataPopular.dados(urlFilmPopular);              
       JsonParse jsonParsedataPopular = new JsonParse();

       List<Map<String, String>> listaDeFilmesPopular = jsonParsedataPopular.parse(bodyPopular);       
       for (Map<String,String> filme : listaDeFilmesPopular) {

            var pont =  Float.parseFloat(filme.get("imDbRating"));
            var ponto = Math.round(pont);

            System.out.println("\u001b[1m \u001b[36m Título: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[1m \u001b[36m Poster: \u001b[m" + filme.get("image"));
            System.out.println("\u001b[1m \u001b[36m\u001b[41m Classificação: " + filme.get("imDbRating") + "\u001b[m");
            for (int i = 0; i < ponto; i++) {
                System.out.print(" \uD83D\uDC99");
            }
            System.out.println(); 
            System.out.println();          
       }


       System.out.println(); 
       System.out.println(); 
       System.out.println("======================================================================================================================================");
       System.out.println("\u001b[1m \u001b[44m \u001b[5m  MELHORES SERIES \u001b[m");
       System.out.println("======================================================================================================================================");

       String urlSeries = "https://imdb-api.com/en/API/Top250Movies/" + chave;
       Dados dataSeries = new Dados();
       var bodySeries = dataSeries.dados(urlSeries);              
       JsonParse jsonParsedataPSeries = new JsonParse();

       List<Map<String, String>> listaDeSeriesPopular = jsonParsedataPSeries.parse(bodySeries);       
       for (Map<String,String> filme : listaDeSeriesPopular) {

            var pont =  Float.parseFloat(filme.get("imDbRating"));
            var ponto = Math.round(pont);

            System.out.println("\u001b[1m \u001b[36m Título: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[1m \u001b[36m Poster: \u001b[m" + filme.get("image"));
            System.out.println("\u001b[1m \u001b[36m\u001b[41m Classificação: " + filme.get("imDbRating") + "\u001b[m");
            for (int i = 0; i < ponto; i++) {
                System.out.print(" \uD83D\uDC99");
            }
            System.out.println(); 
            System.out.println();          
       }



       System.out.println(); 
       System.out.println(); 
       System.out.println("======================================================================================================================================");
       System.out.println("\u001b[1m \u001b[42m \u001b[5m  SERIES MAIS POPULARES \u001b[m");
       System.out.println("======================================================================================================================================");


       String urlSeriesPopular = "https://imdb-api.com/en/API/Top250Movies/" + chave;
       Dados dataSeriePopular = new Dados();
       var bodySeriePopular = dataSeriePopular.dados(urlSeriesPopular);              
       JsonParse jsonParsedataSeriePopular = new JsonParse();

       List<Map<String, String>> listaDeSeries= jsonParsedataSeriePopular.parse(bodySeriePopular);       
       for (Map<String,String> filme : listaDeSeries) {

            var pont =  Float.parseFloat(filme.get("imDbRating"));
            var ponto = Math.round(pont);

            System.out.println("\u001b[1m \u001b[36m Título: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[1m \u001b[36m Poster: \u001b[m" + filme.get("image"));
            System.out.println("\u001b[1m \u001b[36m\u001b[41m Classificação: " + filme.get("imDbRating") + "\u001b[m");
            for (int i = 0; i < ponto; i++) {
                System.out.print(" \uD83D\uDC99");
            }
            System.out.println(); 
            System.out.println();          
       }



    }
}
