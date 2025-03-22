package Laboratory4;

import java.awt.*;

public class Diagonlayout implements LayoutManager {

    private int COUNTCOMPONENT = 0;
    public int BeginSizeX = 0;
    public int BeginSizeY = 0;
    public void addLayoutComponent(String name, Component comp) {
    }
    public void removeLayoutComponent(Component comp) {

    }
    private Dimension calculateBestSize(Container c) {
        return null;
    }
    public Dimension preferredLayoutSize(Container c) {
        return calculateBestSize(c);
    }
    public Dimension minimumLayoutSize(Container c) {
        return calculateBestSize(c);
    }
    public void layoutContainer(Container c) {
        int height = c.getHeight();
        int width = c.getWidth();
        Component comps[] = c.getComponents();
        COUNTCOMPONENT = comps.length;
        if (COUNTCOMPONENT != 0) {
            height = height / COUNTCOMPONENT;
            width = width / COUNTCOMPONENT;
        }
        for (Component comp : comps) {
            Dimension pref = comp.getPreferredSize();
            comp.setBounds(BeginSizeX, BeginSizeY, width, height);
            BeginSizeX += width;
            BeginSizeY += height;
        }
    }

    public static void main(String[] args) {
                DiagonJFrame frame = new DiagonJFrame("DiagonLayout");

                frame.setResizable(false);
                frame.setVisible(true);
            }
    }