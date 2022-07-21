import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.Math;
import java.net.URL;

public class App {

 


    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        String arquivo = "./dados.properties";
        prop.load(new FileInputStream(arquivo));
        //var chave = prop.getProperty("chave");

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
       
       GeradordeFigurinha geradordeFigurinha = new GeradordeFigurinha();

       for (Map<String,String> filme : listaDeFilmes) {

            var pont =  Float.parseFloat(filme.get("imDbRating"));
            var ponto = Math.round(pont);

            String image = filme.get("image");
            String[] nomeImageAlter = image.split("._V1");
            String urlImage = nomeImageAlter[0] + ".jpg";
            String title = filme.get("title");
            String nomearquivo = title + ".png";
       

           InputStream  inputStream = new URL(urlImage).openStream();
           geradordeFigurinha.criar(inputStream, nomearquivo);

           System.out.println("\u001b[1m \u001b[36m Título: \u001b[m" + filme.get("title"));
           System.out.println("\u001b[1m \u001b[36m Poster: \u001b[m" + urlImage);
           System.out.println("\u001b[1m \u001b[36m\u001b[41m Classificação: " + filme.get("imDbRating") + "\u001b[m");
           for (int i = 0; i < ponto; i++) {
               System.out.print(" \uD83D\uDC99");
           }
          
            System.out.println(); 
            System.out.println();          
       }

      
      
    }
}
