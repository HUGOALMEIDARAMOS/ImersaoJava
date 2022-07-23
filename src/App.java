import java.util.List;
import java.io.InputStream;
import java.net.URL;

public class App {

    public static void main(String[] args) throws Exception {

        //Properties prop = new Properties();
        //String arquivo = "./dados.properties";
       // prop.load(new FileInputStream(arquivo));
        //var chave = prop.getProperty("chave");       
        //String url = "https://imdb-api.com/en/API/Top250Movies/" + chave;

       //String url = "https://alura-imdb-api.herokuapp.com/movies";  
      // ExtratorDeConteudoDoImdb extrator = new ExtratorDeConteudoDoImdb();
      
       String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-01&end_date=2022-06-15";  
       ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();

       CleintHttp http = new CleintHttp();
       String  json = http.buscaDados(url);            

       List<Conteudo> extrairConteudo = extrator.extrairConteudo(json);       
       GeradordeFigurinha geradordeFigurinha = new GeradordeFigurinha();

       for (int i=0; i < extrairConteudo.size(); i++) {
           Conteudo conteudo = extrairConteudo.get(i);      
           String nomearquivo = conteudo.getTitulo() + ".png";  
           InputStream  inputStream = new URL(conteudo.getUrlImage()).openStream();
           geradordeFigurinha.criar(inputStream, nomearquivo);
         
           System.out.println(conteudo.getTitulo()); 
           System.out.println();          
       }
      
      
    }
}
