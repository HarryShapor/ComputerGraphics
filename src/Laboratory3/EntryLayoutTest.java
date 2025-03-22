package Laboratory3;

// Класс EntryLayoutTest
import java.awt.*;
import javax.swing.*;
// Тестирование менеджера компоновки EntryLayout.
public class EntryLayoutTest {
    public static void main(String[] av) {
        final JFrame f = new JFrame("Тестирование EntryLayout");
        Container cp = f.getContentPane( );
        double widths[] = { 0.95, .05 };
        cp.setLayout(new EntryLayout(widths));
        cp.add(new JLabel("Логин:", SwingConstants.RIGHT));
        cp.add(new JTextField(10));
        cp.add(new JLabel("Пароль:", SwingConstants.RIGHT));
        cp.add(new JPasswordField(20));
        cp.add(new JLabel("Домен безопасности:", SwingConstants.RIGHT));
        cp.add(new JTextField(20));
        cp.add(new JLabel("Год рождения", SwingConstants.RIGHT));
        cp.add(new JTextField(50));
        f.pack( );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(200, 200);
        f.setResizable(false);
        f.setVisible(true);
    }
}


