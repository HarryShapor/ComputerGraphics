package Laboratory4;

import javax.swing.*;
import java.awt.*;

public class DiagonJFrame extends JFrame {

    public DiagonJFrame(String name){
        setTitle(name);
        setLayout(new BorderLayout());
        JPanel contents = new JPanel();
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("Добавить");
        contents.setLayout(new Diagonlayout());
        jPanel.add(jButton);
        TextField textField = new TextField();
        textField.setColumns(50);
        jPanel.add(textField);
        TextField textFieldColor1 = new TextField();
        textFieldColor1.setColumns(20);
        jPanel.add(textFieldColor1);

        TextField textFieldColor2 = new TextField();
        textFieldColor2.setColumns(20);
        jPanel.add(textFieldColor2);

        TextField textFieldColor3 = new TextField();
        textFieldColor3.setColumns(20);
        jPanel.add(textFieldColor3);


        jPanel.setBackground(new Color(4, 74, 204));
        jButton.addActionListener(new ActionListenerDiagon(this, contents, textField,
                    textFieldColor1, textFieldColor2, textFieldColor3));
        add(jPanel, BorderLayout.NORTH);

        contents.add(new JButton("Один"));
        contents.add(new JButton("Два"));
        contents.add(new JTextField(30));

        add(contents);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        }
}
