package Laboratory2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;

public class Variant4 extends JFrame{

    public void paint(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

//        g2.setColor(new Color(0,0,0));
//        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Double(300,300, 100,100,15,15);
//        g2.rotate(30,300,300);
//        g2.draw(roundRectangle2D);

        g2.setColor(new Color(255, 0, 0));
        g2.setStroke(new BasicStroke(3.0F));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawLine(70,70,170,70);
        g2.drawLine(170,70,170,170);
        g2.drawLine(170,170,270,170);


        g2.setColor(new Color(25, 145, 0));
        float[] dash = {2.0F, 5.0F};
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3.0F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 15.0F, dash, 0));
        g2.drawLine(190,150,290,150);
        g2.drawLine(290,150,290,250);
        g2.drawLine(290,250,390,250);

        g2.setColor(new Color(0,0,255));
        g2.setStroke(new BasicStroke(1.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        CubicCurve2D cubicCurve2D = new CubicCurve2D.Double(210, 210, 430, 420, 230, 70, 410, 200);
        g2.draw(cubicCurve2D);

        g2.setColor(new Color(0,0,0));
        g2.setStroke(new BasicStroke(1.0F));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(30,120);
        generalPath.lineTo(30,200);
        generalPath.lineTo(150,200);
        generalPath.lineTo(150,90);
        generalPath.lineTo(30,120);
        g2.draw(generalPath);

        g2.setPaint(new GradientPaint(30,120, new Color(0, 166, 255),
                30,160, new Color(255, 239, 0)));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(generalPath);

        g2.setColor(new Color(2, 141, 0));
        float[] pynkt = {2F,2F};
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 15.0f, pynkt,0));
        Arc2D arc2D = new Arc2D.Double(170, 20, 100, 100, 250, 120, Arc2D.CHORD);
        g2.scale(2,2);
        g2.draw(arc2D);
//        CubicCurve2D cubcurve = new CubicCurve2D.Float(30, 400, 150, 400, 200, 500, 350, 450);
//        g2.draw(cubcurve);

    }


    public static void main(String[] args) {
        Variant4 gd = new Variant4();
// Определяем заголовок окна
        gd.setTitle("Вариант 4");
// Определяем размер окна
        gd.setSize(600, 350);
// Запрещаем пользователю изменять размеры окна
        gd.setResizable(false);
// Определяем, что при закрытии окна заканчивается работа
// программы
        gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно видимым
        gd.setVisible(true);
    }

}
