package Laboratory6;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class MouseExample {
    public static void main(String[] args) {

        JFrame f = new JFrame("??????? ????");

        Toolkit tk=f.getToolkit();

        Dimension scrdim = tk.getScreenSize();

        int scrX=scrdim.width; int scrY=scrdim.height;

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.addMouseListener(new MObr(f));
        f.addMouseMotionListener(new MObr(f));
        f.addMouseWheelListener(new MObr(f));

        f.setSize(500,500);
        f.setVisible(true);
    }
}

