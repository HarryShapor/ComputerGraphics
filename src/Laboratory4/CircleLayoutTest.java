package Laboratory4;

import java.awt.*;
import javax.swing.*;
// Автор - Cay Horstmann
public class CircleLayoutTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            CircleLayoutFrame frame = new CircleLayoutFrame();
            frame.setTitle("CircleLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });



    }
}

