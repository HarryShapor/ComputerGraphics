package Laboratory7;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.*;
public class ConvolveDemo extends Frame{
    private static final long serialVersionUID = 1L;
    private BufferedImage bi;
    // Конструктор
    public ConvolveDemo(String s) {
        super (s) ;
        URL url = null;
// Адрес изображения на сайте РГРТУ
        try {
            url = new URL("https://avatars.mds.yandex.net/get-mpic/4809583/img_id6683192475412444831.jpeg/orig");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//Читаем изображение с сайта РГРТУ
        BufferedImage img = null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
// Создаем объект BufferedImage
        bi = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);
// Выводим
        Graphics2D big = bi.createGraphics();
        big.drawImage(img, 0, 0, this);
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        int w = this.getSize().width;
        int bw = bi.getWidth(null);
        int bh = bi.getHeight(null);
        BufferedImage bimg = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg1 = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg2 = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg3 = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg4 = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg5 = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg6 = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
        BufferedImage bimg6_1 = new BufferedImage(bw, bh, BufferedImage.TYPE_INT_RGB);
//Матрица фильтра размытия для ядра свёртки
        float[] wl = {
                0.11111111f, 0.11111111f, 0.11111111f,
                0.11111111f, 0.11111111f, 0.11111111f,
                0.11111111f, 0.11111111f, 0.11111111f };

        //Фильтр размытия Гаусса
        float[] wl1 = {
                0.003f, 0.013f, 0.022f, 0.013f, 0.003f,
                0.013f, 0.059f, 0.097f, 0.059f, 0.013f,
                0.022f, 0.097f, 0.159f, 0.097f, 0.022f,
                0.013f, 0.059f, 0.097f, 0.059f, 0.013f,
                0.003f, 0.013f, 0.022f, 0.013f, 0.003f};
        //Фильт размытия с ядром
        float[] wl2 = {
                0.05f, 0.05f, 0.05f,
                0.05f, 0.60f, 0.05f,
                0.05f, 0.05f, 0.05f };
        //Фильтр повышения яркости с ядром
        float[] wl3 = {
                -1/10f, -2/10f, -1/10f,
                -2/10f, 22/10f, -2/10f,
                -1/10f, -2/10f, -1/10f };
        //Фильтр выделения границ с ядром
        float[] wl4 = {
                0, 1, 0,
                1, -3, 1,
                0, 1, 0 };
        //Фильтр теснения с ядром
        float[] wl5 = {
                -2, -1, 0,
                -1, 1, 1,
                0, 1, 2 };
        //Акварельный фильтр
        //1 шаг
        float[] wl6 = {
                1/16f, 2/16f, 1/16f,
                2/16f, 4/16f, 2/16f,
                1/16f, 2/16f, 1/16f };
        //2 шаг
        float[] wl6_1 = {
                -0.5f, -0.5f, -0.5f,
                -0.5f, 5, -0.5f,
                -0.5f, -0.5f, -0.5f };

// Ядро свертки
        Kernel kern = new Kernel(3, 3, wl);
        Kernel kern1 = new Kernel(5, 5, wl1);
        Kernel kern2 = new Kernel(3, 3, wl2);
        Kernel kern3 = new Kernel(3, 3, wl3);
        Kernel kern4 = new Kernel(3, 3, wl4);
        Kernel kern5 = new Kernel(3, 3, wl5);
        Kernel kern6 = new Kernel(3, 3, wl6);
        Kernel kern6_1 = new Kernel(3, 3, wl6_1);
// Обънкт ConvolveOp
        ConvolveOp cop = new ConvolveOp(kern, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop1 = new ConvolveOp(kern1, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop2 = new ConvolveOp(kern2, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop3 = new ConvolveOp(kern3, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop4 = new ConvolveOp(kern4, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop5 = new ConvolveOp(kern5, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop6 = new ConvolveOp(kern6, ConvolveOp.EDGE_NO_OP, null);
        ConvolveOp cop6_1 = new ConvolveOp(kern6_1, ConvolveOp.EDGE_NO_OP, null);
// Применение свертки
        cop.filter(bi, bimg);
        cop1.filter(bi, bimg1);
        cop2.filter(bi, bimg2);
        cop3.filter(bi, bimg3);
        cop4.filter(bi, bimg4);
        cop5.filter(bi, bimg5);
        cop6.filter(bi, bimg6);
        cop6_1.filter(bimg6, bimg6_1);
        File outputfile = new File("src/Laboratory7/images/bimg.jpg");
        File outputfile1 = new File("src/Laboratory7/images/bimg1.jpg");
        File outputfile2 = new File("src/Laboratory7/images/bimg2.jpg");
        File outputfile3 = new File("src/Laboratory7/images/bimg3.jpg");
        File outputfile4 = new File("src/Laboratory7/images/bimg4.jpg");
        File outputfile5 = new File("src/Laboratory7/images/bimg5.jpg");
        File outputfile6 = new File("src/Laboratory7/images/bimg6_1.jpg");
        try {
            ImageIO.write(bimg, "jpg", outputfile);
            ImageIO.write(bimg1, "jpg", outputfile1);
            ImageIO.write(bimg2, "jpg", outputfile2);
            ImageIO.write(bimg3, "jpg", outputfile3);
            ImageIO.write(bimg4, "jpg", outputfile4);
            ImageIO.write(bimg5, "jpg", outputfile5);
            ImageIO.write(bimg6_1, "jpg", outputfile6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
// Выводим исходное и размытое изображения
        g2.drawImage(bi, null, 0, 0);
        g2.drawImage(bimg6_1, null, w/2, 0);
    }
    public static void main(String args[]){
        Frame f = new ConvolveDemo("ConvolveDemo - Исходное и размытое изображения");
        f.addWindowListener(new WindowAdapter(){
                                public void windowClosing(WindowEvent e) {
                                    System.exit(0);
                                }
                            }
        );
        f.setSize(800,300);
        f.setResizable(false);
        f.setVisible(true);
    }
}