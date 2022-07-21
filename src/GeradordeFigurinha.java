import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


import javax.imageio.ImageIO;

public class GeradordeFigurinha {

    public void criar(InputStream inputStream, String nomearquivo) throws Exception{

        //leitura da imagem direto de um arquivo no projeto
        //BufferedImage imageOriginal = ImageIO.read(new File("assets/filmemaior.jpg")); 

        //Leitura da imagem que pode ser de url ou arquivo
        //InputStream inputStream =  new FileInputStream("assets/filmemaior.jpg"); //aqui de arquivo

        //aqui de url
        //InputStream inputStream =  new URL("https://i.shafacdn.net/images/298128-65-auto-auto-93y-9EXQz5g.jpg").openStream();
        BufferedImage imageOriginal = ImageIO.read(inputStream);

        //criar nova imagem em memoria com transparencia e com tamanho novo
        int width = imageOriginal.getWidth();
        int height = imageOriginal.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
      

        //copiar a imagem original pra novo imagem (em memoria)
        Graphics2D graphics = (Graphics2D ) newImage.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);


        //configurar fonte
        Font font = new Font(Font.SANS_SERIF,Font.BOLD, 50);
        graphics.setFont(font);
        graphics.setColor(Color.RED);

       
        //escrever uma frase na imagem
        graphics.drawString("STICKETS CRIADO COM JAVA", 50, newHeight - 100);
        graphics.drawString("BY HUGO", 300, newHeight - 50);

         //escrever mensagem na imagem
         ImageIO.write(newImage, "png", new File("assets/Geradas/"+nomearquivo));

    }
    
}
