package Laboratory6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//�����, ����������� JPanel � ����������� ����������
//ActionListener - ��������� ������� ��������
//MouseListener - ��������� ������� ����
//MouseMotionListener - ��������� ������� ����������� ����
public class PaintPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener {
    private static final long serialVersionUID = 1L;
    private float wl = 1.0F;
    protected int lastX, lastY, w, h;
    protected Color curColor = Color.BLACK;
    protected JFrame f;
    protected JColorChooser jColorChooser;
    protected JLabel jLabel;
    //�����������. ��������� � �������� ���������� �����, �� ������� ����� ���������
//������ � ������� ������
    public PaintPanel(JFrame frame, int width, int height, JColorChooser jColorChooser, JLabel jLabel) {
        super();
        f = frame;
        w = width;
        h = height;
        this.jColorChooser = jColorChooser;
        this.jLabel = jLabel;
    }
    //���������� ������� ����������� ���� � ������� �������
    @Override
    public void mouseDragged(MouseEvent me) {
//���� ��� ����������� ������ ����� ������ ����
        if ((me.getModifiers() & MouseEvent.BUTTON1_MASK) == MouseEvent.BUTTON1_MASK) {
//� �������� ������ ������ this.getGraphics() �������� ����������� �������� ����� ������
//� �������� ��� � Graphics2D
            Graphics2D g2 = (Graphics2D)this.getGraphics();
//������������� ������� ������ ������ (Stroke) � 5 ��������
            g2.setStroke(new BasicStroke(wl, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//������������� ������� ���� ���������
            g2.setColor(curColor);
//������ ������� ������� � ������ ������ ����� �� �����������
//��������� ���� �� ��������
            g2.drawLine(lastX, lastY, me.getX(), me.getY());
//������ ������� ��������� ���� ����������
            lastX = me.getX();
            lastY = me.getY();
        }
    }
    //��� ������� �� ����������
    @Override
    public void mouseMoved(MouseEvent e) {
        curColor = jColorChooser.getColor();
    }
    //��� ������� �� ����������
    @Override
    public void mouseClicked(MouseEvent arg0) {
    }
    //��� ������� �� ����������
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    //��� ������� �� ����������
    @Override
    public void mouseExited(MouseEvent arg0) {}
    //���������� ������� ������� ����
    @Override
    public void mousePressed(MouseEvent me) {
//���� ������ ����� ������ ����
        if ((me.getModifiers() & MouseEvent.BUTTON1_MASK) == MouseEvent.BUTTON1_MASK) {
//������������� ���������� ���������� ���� � �������
            lastX = me.getX();
            lastY = me.getY();
        }
    }
//��� ������� �� ����������
    @Override
    public void mouseReleased(MouseEvent arg0) {}
    //���������� ������� ��������. ����������� ����� ���
//��������� ������� �� ������
    @Override
    public void actionPerformed(ActionEvent event) {
        String s = event.getActionCommand();
//���� ������ ������ "��������", �� �������� ������ ���������
        if (s.equals("��������")) this.repaint();
//���� ������ ������ "�������", �� ���������� ������� ���� ��������� � �������
//��������� ������ ����������
        else if (s.equals("�������")) curColor = Color.RED;
        else if (s.equals("�������")) curColor = Color.GREEN;
        else if (s.equals("�����")) curColor = Color.BLUE;
        else if (s.equals("������")) curColor = Color.BLACK;
        curColor = jColorChooser.getColor();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() > 0 && wl < 50)
        {
            wl++;
        }
        if (e.getWheelRotation() < 0 && wl > 0)
        {
            wl--;
        }
        this.jLabel.setText("������ ���� "+wl);
    }
}
