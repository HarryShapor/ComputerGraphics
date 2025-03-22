package Laboratory7;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ImageWithApplication extends JFrame
{
    private static final long serialVersionUID = 1L;
    Image img2;
    int h, w;
    public ImageWithApplication( )
    {
        super("����������e � ����");
//�������� ������� ������
        h = Toolkit.getDefaultToolkit().getScreenSize().height;
        w = Toolkit.getDefaultToolkit().getScreenSize().width;
//������������� ������� ���� ������� ������� ������
        setSize(w, h);
//��������� �������� ����������
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
//����������� �� �����
//������� ������
        JPanel p1 = new JPanel();
//���������� ��������� � ���� � ������ ������
        p1.setBounds(w/2, h/2, w, h);
//��������� ������ � ����
        this.add(p1);
//�������� ����������� �������� ������
        Graphics2D gp1 = (Graphics2D) p1.getGraphics();
//������� ����������� �� �����
        Image img = Toolkit.getDefaultToolkit().getImage("src/images/sa.jpg");
//���������� ������� �����������
        int imh = img.getHeight(this);
        int imw = img.getWidth(this);
//������������ ����������� ���, ����� ��� ���������� �� ������
        gp1.scale(0.01*(h/imh), 0.01*(w/imw));
//������� ����������� � ������
        gp1.drawImage(img, 0, 0, this);
    }
    public static void main( String args[])
    {
        new ImageWithApplication();
    }
}
