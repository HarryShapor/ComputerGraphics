package Laboratory4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerDiagon implements ActionListener {

    private JPanel container;
    private DiagonJFrame jFrame;
    private TextField textField;
    private TextField textFieldColor1;
    private TextField textFieldColor2;
    private TextField textFieldColor3;
    public ActionListenerDiagon(DiagonJFrame jFrame, JPanel container, TextField textField,
                                TextField textFieldColor1,TextField textFieldColor2,TextField textFieldColor3){
        this.container = container;
        this.jFrame = jFrame;
        this.textField = textField;
        this.textFieldColor1 = textFieldColor1;
        this.textFieldColor2 = textFieldColor2;
        this.textFieldColor3 = textFieldColor3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object btn2 = e.getActionCommand();
        if (btn2 == "Добавить") {
            if (!textField.getText().isEmpty()){
                Component obj = null;
                switch (textField.getText()) {
                    case "Кнопка": {
                        obj = new JButton("Кнопка");
                        break;
                    }
                    case "Текстовое поле": {
                        obj = new TextField();
                        break;
                    }
                    case "Радиокнопка": {
                        obj = new JRadioButton();
                        break;
                    }
                    case "Checkbox": {
                        obj = new JCheckBox();
                        break;
                    }
                    case "Панель": {
                        obj = new JPanel();
                    }
                }
                Integer red = 255, green = 255, blue = 255;
                if (!textFieldColor1.getText().isEmpty() || !textFieldColor2.getText().isEmpty() || !textFieldColor3.getText().isEmpty()) {

                    if (!textFieldColor1.getText().isEmpty()) {
                        red = Integer.parseInt(textFieldColor1.getText());
                        if (red < 0){
                            red = 0;
                        } else if (red > 255){
                            red = 255;
                        }
                        textFieldColor1.setText("");
                    }
                    if (!textFieldColor2.getText().isEmpty()) {
                        green = Integer.parseInt(textFieldColor2.getText());
                        if (green < 0){
                            green = 0;
                        } else if (green > 255){
                            green = 255;
                        }
                        textFieldColor2.setText("");
                    }
                    if (!textFieldColor3.getText().isEmpty()) {
                        blue = Integer.parseInt(textFieldColor3.getText());
                        if (blue < 0){
                            blue = 0;
                        } else if (blue > 255){
                            blue = 255;
                        }
                        textFieldColor3.setText("");
                    }

                }
                obj.setBackground(new Color(red, green, blue));
                container.add(obj);
                textField.setText("");
            }
            else {
                JButton btn = new JButton("Кнопка");
                container.add(btn);
            }
            container.revalidate();
            container.setLayout(new Diagonlayout());
//            container.repaint();
            jFrame.revalidate();
//            jFrame.remove(container);
//            jFrame.add(container);
//            container.setBackground(new Color(255,37,92));
            jFrame.repaint();
        }
    }
}
