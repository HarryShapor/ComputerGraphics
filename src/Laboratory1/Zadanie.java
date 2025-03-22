package Laboratory1;

import javax.swing.*;
import java.awt.*;

public class Zadanie extends JFrame {

    Zadanie(String name){
        super(name);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        int i = 50;
//        g.setColor(new Color(37, 104, 3));
//        for (i = 50; i < 400; i += 1) {
//            //g.drawOval(i,i,40,40);
//            g.fillOval(i, i, 40, 40);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            g.setXORMode(new Color(255, 255, 255));
//            //g.drawOval(i,i,40,40);
//            g.fillOval(i, i, 40, 40);
//        }

//        g.drawOval(400,400,40,40);
//        g.fillOval(400,400,40,40);

        double R = 300;
        double R2 = 500;
        double i, j;
        double t_ = 0.001;
        double oTheta = 0.1; // depending on your framerate, the more you add, the faster it will orbit
        for (double t = 0; t < 30 * Math.PI; t += t_) {
            i = R * Math.cos(t) + 50 + R2 * Math.cos(oTheta);
            j = R * Math.sin(t) + 500 + R2 * Math.sin(oTheta);
            g.setColor(new Color(37, 104, 3));
            g.fillOval((int) i, (int) j, 40, 40);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            g.setXORMode(new Color(255, 255, 255));
            g.fillOval((int) (i), (int) (j), 40, 40);
        }
    }
    public static void main(String[] args) {

        Zadanie zadanie = new Zadanie("Перемещающийся кружочек");

        zadanie.setSize(1000,1000);
        zadanie.setResizable(false);
       // zadanie.setForeground(new Color(255,255,255));
        zadanie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zadanie.setVisible(true);

    }
}
