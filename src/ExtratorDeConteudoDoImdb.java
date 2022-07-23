import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb implements ExtratorDeConteudo{
    
    public List<Conteudo> extrairConteudo(String json){
        
        JsonParse jsonParse = new JsonParse();      
        List<Map<String, String>> listaDeAtributos = jsonParse.parse(json);  

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String title = atributos.get("title");
            String urlImage = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            Conteudo conteudo = new Conteudo(title, urlImage);
            conteudos.add(conteudo);
        }
        
        return conteudos;

    }
}
