package Laboratory1;

import javax.swing.*;
import java.awt.*;

public class Variant28 extends JFrame {

    @Override
    public void paint(Graphics g){
        super.paint(g);

        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,500,300);
        g.setColor(new Color(255,0,0));
        g.setFont(new Font("Times New Roman",Font.BOLD,48));
        g.drawString("Графика", 275,90);
        g.drawRect(30,210,20,40);
        g.drawRect(65,210,40,40);
        g.drawPolyline(new int[]{120, 340, 340, 470, 340, 340, 120, 120},
                new int[]{210, 210, 190, 230, 270, 250, 250, 210},8);

        g.setColor(new Color(0,0,0));
        g.drawRect(25,50, 225,3);
        g.fillRect(25,50, 225,3);
        g.drawRect(250,50, 3,50);
        g.fillRect(250,50, 3,50);
        g.drawRect(250,100, 225,3);
        g.fillRect(250,100, 225,3);

        int j = 65;
        for(int i=40; i<120; i+=20){
            g.setColor(new Color(255,255,255));
            g.fillRect(i,j, 100,70);
            g.setColor(new Color(0,0,0));
            g.drawRect(i,j, 100,70);
            j += 20;
        }

        g.setColor(new Color(255,255,255));
        g.fillOval(400, 115, 75,75);
        g.setColor(new Color(0,0,0));
        g.drawOval(400, 115, 75,75);

    }

    public static void main(String[] args) {

        Variant28 variant = new Variant28();
        variant.setName("Вариант 4");
        variant.setSize(500,300);
        variant.setResizable(false);
        variant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        variant.setVisible(true);
    }
}
