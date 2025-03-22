package Laboratory1;
import java.awt.*;
import javax.swing.*;

public class ButtonDemo extends JButton {

    ButtonDemo(String name){
        super(name);
        this.setMaximumSize(new Dimension(50,50));
        this.setSize(30,30);
    }

    @Override
    public void paint(Graphics g){
        //g.create(0,0,50,30);

        super.paint(g);
        g.setColor(new Color(199, 4, 4));
        g.fillOval(250,10,20,20);

    }
}
