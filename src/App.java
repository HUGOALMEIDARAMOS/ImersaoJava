import java.util.List;
import java.io.InputStream;
import java.net.URL;

public class App {

    public static void main(String[] args) throws Exception {

      
       String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-01&end_date=2022-06-15";  
       ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();

       ClientHttp http = new ClientHttp();
       String  json = http.buscaDados(url);            

       List<Conteudo> extrairConteudo = extrator.extrairConteudo(json);       
       GeradordeFigurinha geradordeFigurinha = new GeradordeFigurinha();

       for (int i=0; i < extrairConteudo.size(); i++) {
           Conteudo conteudo = extrairConteudo.get(i);      
           String nomearquivo = conteudo.titulo() + ".png";  
           InputStream  inputStream = new URL(conteudo.urlImage()).openStream();
           geradordeFigurinha.criar(inputStream, nomearquivo);
         
           System.out.println(conteudo.titulo()); 
           System.out.println();          
       }
      
      
    }
}
