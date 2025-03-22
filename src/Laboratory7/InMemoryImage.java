package Laboratory7;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import javax.swing.JFrame;
public class InMemoryImage extends JFrame {
    private static final long serialVersionUID = 1L;
    //������ ������������ �����������
    private int w =100;
    private int h =100;
    //������ ��� �������� �����������
    private int[] pix = new int[w*h];
    private Image img;
    InMemoryImage(String s) {
        super(s);
//�������� ������ ��� �����������
        int i = 0;
        for (int y = 0; y < h; y++) {
            int red = (y * 100) / (h - 1);
            for (int x = 0; x < w; x++) {
                int blue = (x * 0) / (w - 1);
                int green = (y * 203) / (w - 1);
                pix[i++] =  (189 << 24) | (red << 16) | (green << 8) | blue;
            }
        }
        this.setSize(200, 200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g) {
        if (img == null)
            img = this.createImage(new MemoryImageSource(w, h, pix, 0, w));
        g.drawImage(img, 50, 50, this);
    }
    public static void main(String[] args) {
        new InMemoryImage("�����������, ��������� � ������");
    }
}
