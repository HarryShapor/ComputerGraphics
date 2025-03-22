package Laboratory7;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ReadImage
{
    public static void main( String[] args )
    {
        BufferedImage image = null;
        try {
//Если адрес изображения с заглавной страницы сайта РГРТУ изменился, то укажите новый //URL //Интернет должен быть подключен!!!
            URL url = new URL("https://trikky.ru/wp-content/blogs.dir/1/files/2021/11/07/screenshot-20211107-125118-chrome.png");
            File f = new File("src/images/MyFile2.png");

            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
//Определяем ширину и высоту изображения
        int w = image.getWidth();
        int h = image.getHeight();

//Создаем фрейм и определяем его размеры
        JFrame frame = new JFrame("Фотография с сайта РГРТУ");
        frame.setSize(w, h);
//Размещаем изображение на JLabel и выводим его
//Класс IconImage изучите самостоятельно!!!
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }
}
