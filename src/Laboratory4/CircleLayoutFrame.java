package Laboratory4;

import Laboratory3.CircleLayout;

import javax.swing.*;
//Фрейм для демонстрации круговой компоновки
public class CircleLayoutFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    public CircleLayoutFrame()
    {
        setLayout(new CircleLayout());
        add(new JButton("Yellow"));
        add(new JButton("Blue"));
        add(new JButton("Red"));
        add(new JButton("Green"));
        add(new JButton("Orange"));
        add(new JButton("Fuchsia"));
        add(new JButton("Indigo"));
        pack();
    }
}
