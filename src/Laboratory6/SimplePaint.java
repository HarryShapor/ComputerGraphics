package Laboratory6;

import java.awt.BorderLayout;
import javax.swing.*;

public class SimplePaint extends JFrame {
    private static final long serialVersionUID = 1L;
    //����������� ������
    public SimplePaint(String s) {
//�������� ����������� �����������, �� ���� ������ JFrame
//� �������� � ���� ������ ��������� ����
        super(s);
//��������� ������ ������� ����
//        this.setResizable(false);
//������������� ������� ����
        this.setSize(500, 500);
//������� ������ ������ PaintPanel, ������� ������ ����


        JPanel p = new JPanel();
//��������� ��� ������ � ������ ����� ������ (�����) ����
        this.add(p, BorderLayout.SOUTH);
        JColorChooser jColorChooser = new JColorChooser();
        p.add(jColorChooser);
        JLabel jLabel = new JLabel();
        p.add(jLabel);

        JPanel jPanel2 = new JPanel();

        PaintPanel panel = new PaintPanel(this, 800, 800, jColorChooser, jLabel);
//��������� � ���������� ������� ����������� �������
//� ����� ������ ���� ������ ��� ����� ������������ ���� �������
        panel.addMouseListener(panel);
        panel.addMouseMotionListener(panel);
        panel.addMouseWheelListener(panel);
//������� ������������� �����, ����� ����������, ��� ��� ��������
//������������� ��� ������ ����� ������ ��� ��������� panel, � � //�������� � ����������� JScrollPane
        JScrollPane pane = new JScrollPane(panel);
//����������, ����� ������������ � �������������� ������ ���������
// ������ ������������ ������
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//��������� ������ ��� ��������� � ����������� ������� ������ ����
//this - ������ �� ������ ����, �� ���� � ����� ������ ������ //������ SimplePaint
        JSplitPane jSplitPane = new JSplitPane(SwingConstants.VERTICAL, jPanel2, pane);
        this.add(jSplitPane, BorderLayout.NORTH);
//        jSplitPane.add(pane);
//������� ����� ������

//������� ��������� ������, ������ �� ������� ��������� �� ������
//���������� ����������� ������� ��� ������ ������
//        JButton b1 = new JButton("�������");
//        p.add(b1);
//        b1.addActionListener(panel);
//        JButton b2 = new JButton("�������");
//        p.add(b2);
//        b2.addActionListener(panel);
//        JButton b3 = new JButton("�����");
//        p.add(b3);
//        b3.addActionListener(panel);
//        JButton b4 = new JButton("������");
//        p.add(b4);
//        b4.addActionListener(panel);
//        JButton b5 = new JButton("��������");
//        p.add(b5);
//        b5.addActionListener(panel);


//���������� �������� ��� �������� ����
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//������ ���� �������
        this.setVisible(true);
    }

    public static void main(String[] args) {
//������� ���� ��� ���������� ������, ������ ��� ��� ��� ��� �� �����
        new SimplePaint("����� ������� ��������");
    }
}
