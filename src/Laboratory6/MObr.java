package Laboratory6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
public class MObr implements MouseListener, MouseMotionListener, MouseWheelListener {
    String st = new String("");

    private JFrame jFrame;
    public MObr(){}

    public MObr(JFrame jFrame){
        this.jFrame = jFrame;
    }
    @Override
//Обработка вращения колесика мыши
    public void mouseWheelMoved(MouseWheelEvent mwe) {
// Метод возвращает положительное значение, если колесико мыши вращается на себя
// и отрицательное, если вращение происходит от себя
        if (mwe.getWheelRotation() > 0)
            st = new String (" на себя" );
        if (mwe.getWheelRotation() < 0)
            st = new String (" от себя" );
        System.out.println("Колесико мыши повернуто" + st);
    }
    @Override
//Обработка перемещения мыши с нажатой кнопкой мыши
    public void mouseDragged(MouseEvent me) {
        if ((me.getModifiers() & MouseEvent.BUTTON1_MASK) == MouseEvent.BUTTON1_MASK) {
            System.out.println("Мышь движется с нажатой кнопкой - 1 (Левая)");
            if (jFrame != null){
                jFrame.setBackground(new Color(244,234,123));
            }
        }
        if ((me.getModifiers() & MouseEvent.BUTTON3_MASK)==MouseEvent.BUTTON3_MASK)
            System.out.println("Мышь движется с нажатой кнопкой - 3 (Правая)");
    }
    @Override
//Обработка перемещения мыши
    public void mouseMoved(MouseEvent me) {
        System.out.println("Перемешение мыши "+ "x= "+me.getX()+" y= "+me.getY());
    }
    @Override
//Обработка клика и двойного клика
    public void mouseClicked(MouseEvent me) {
        System.out.println("Клик");
        if (me.getClickCount()==2) System.out.println("Двойной клик");
    }
    @Override
//Обработка вхождения курсора мыши в область компонента,
//в данном случае фрейма
    public void mouseEntered(MouseEvent me) {
        System.out.println("Мышь вошла в окно");
    }
    @Override
//Лбработка выхода из пределов компонента
    public void mouseExited(MouseEvent me) {
        System.out.println("Мышь вышла из окна");
    }
    @Override
//Обработка нажатия кнопки мыши
    public void mousePressed(MouseEvent me) {
        //System.out.println(me.getButton());
        System.out.println("Мышь нажата. Номер кнопки - " + me.getButton());
    }
    @Override
//Обработка отпускания кнопки мыши
    public void mouseReleased(MouseEvent me) {
        System.out.println("Мышь отпущена");
    }
}
