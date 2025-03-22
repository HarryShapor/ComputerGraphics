package Laboratory3;

// Класс EntryLayout
import java.awt.*;
// Простой менеджер компоновки для форм типа
// Имя: ______________ _
// Пароль: ______________ _
// ...
public class EntryLayout implements LayoutManager {
    // Массив для ширины столбцо, как дробных чиссел (0.4 - это 40%, и т.д.)
    protected final double[] widthPercentages;
    // Количество столбцов
    protected final int COLUMNS;
    // Вертикальной и горизонтальное расстояние между элементами по умолчанию
    protected final static int HPAD = 5, VPAD = 5;
    //Текущие расстояния
    protected final int hpad, vpad;
    // True если список для ширины столбцов правильный
    protected boolean validWidths = false;
    //Конструктор EntryLayout с массивом ширины и отступами между элементами
    //widths - массив, определяющий ширину столбцов.
    // h - горизонтальное расстояние между элементами
    // v - вертикальное расстояние между элементами
    public EntryLayout(double[] widths, int h, int v) {
        COLUMNS = widths.length;
        widthPercentages = new double[COLUMNS];
        for (int i=0; i<widths.length; i++) {
            if (widths[i] >= 1.0)
                throw new IllegalArgumentException(
                        "EntryLayout: ширина должна быть дробной и < 1");
            widthPercentages[i] = widths[i];
        }
        validWidths = true;
        hpad = h;
        vpad = v;
    }
    // Конструктор EntryLayout с массивом ширины элементов и отступами по умолчанию
// Массив widths определяет ширину столбцов.
    public EntryLayout(double[] widths) {
        this(widths, HPAD, VPAD);
    }
    public void addLayoutComponent(String name, Component comp) {
// Не используется
    }
    public void removeLayoutComponent(Component comp) {
// Не используется
    }
    // Вычисляет предпочтительные размеры для родительской панели
    public Dimension preferredLayoutSize(Container parent) {
// System.out.println("preferredLayoutSize");
        return computelayoutSize(parent, hpad, vpad);
    }
    /** Find the minimum Dimension for the
     * specified container given the components therein.
     */
// Определяет минимальные размеры для контейнера
// для размещения в нем компонентов
    public Dimension minimumLayoutSize(Container parent) {
// System.out.println("minimumLayoutSize");
        return computelayoutSize(parent, 0, 0);
    }
    // Ширина каждого столбца вычисляется computLayoutSize( )
    int[] widths;
    // Высота каждой строки вычисляется computLayoutSize( )
    int[] heights;
    // вычисление размера
    protected Dimension computelayoutSize(Container parent, int hpad,
                                          int vpad) {
        if (!validWidths)
            return null;
        Component[] components = parent.getComponents( );
        Dimension contSize = parent.getSize( );
        int preferredWidth = 0, preferredHeight = 0;
        widths = new int[COLUMNS];
        heights = new int[components.length / COLUMNS];
// System.out.println("Grid: " + widths.length + ", " +heights.length);
        int i;
// Проход 1: Вычисление наибольшей длины и ширины.
        for (i=0; i<components.length; i++) {
            int row = i / widthPercentages.length;
            int col = i % widthPercentages.length;
            Component c = components[i];
            Dimension d = c.getPreferredSize( );
            widths[col] = Math.max(widths[col], d.width);
            heights[row] = Math.max(heights[row], d.height);
        }
// Проход 2: Собираем вместе.
        for (i=0; i<widths.length; i++)
            preferredWidth += widths[i] + hpad;
        for (i=0; i<heights.length; i++)
            preferredHeight += heights[i] + vpad;
        return new Dimension(preferredWidth, preferredHeight);
    }
    //Разметка контейнера
    public void layoutContainer(Container parent) {
// System.out.println("layoutContainer:");
        if (!validWidths)
            return;
        Component[] components = parent.getComponents( );
        Dimension contSize = parent.getSize( );
        for (int i=0; i<components.length; i++) {
            int row = i / COLUMNS;
            int col = i % COLUMNS;
            Component c = components[i];
            Dimension d = c.getPreferredSize( );
            int colWidth = (int)(contSize.width *
                    widthPercentages[col]);
            Rectangle r = new Rectangle(
                    col == 0 ? 0 :
                            hpad * (col-1) + (int)(contSize.width *widthPercentages[col-1]),
                    vpad * (row) + (row * heights[row]) + (heights[row]-d.height),
                    colWidth,
                    d.height);
// System.out.println(c.getClass( ) + "-->" + r);
            c.setBounds(r);
        }
    }
}
