package Laboratory3;

import javax.swing.*;

public class MainLaboratory3 {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JDesktopPane jDesktopPane = new JDesktopPane();


        for (int i=0; i<6; i++){
            JInternalFrame jInternalFrame = new JInternalFrame();
            jInternalFrame.setSize(50,50);
            jInternalFrame.add(new JButton("окно"));
            jInternalFrame.add(new JButton("окно"));
            jInternalFrame.add(new JButton("окно"));
            jInternalFrame.add(new JButton("окно"));
            jInternalFrame.setLayout(new CircleLayout());
            jInternalFrame.setVisible(true);
            jDesktopPane.add(jInternalFrame);
        }
        jDesktopPane.setLayout(new CircleLayout());

        jDesktopPane.setSize(500,500);

        jDesktopPane.setVisible(true);
        frame.setSize(500,500);
        frame.add(jDesktopPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
