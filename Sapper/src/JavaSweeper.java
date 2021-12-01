import javax.swing.*;
import java.awt.*;
public class JavaSweeper extends JFrame
{
    private JPanel panel;
    private final int COLS = 15; // Длина
    private final int ROWS = 1; // Ширина
    private final int IMAGE_SIZE = 50; // размер картинок
    public static void main(String[] args)
    {
        new JavaSweeper();
    }
    // инициализация методов
    private JavaSweeper()
    {
        initPanel();
        initFrame();
    }
    // описание панели приложения
    private void initPanel()
    {
        panel = new JPanel()
        {
            @Override
            protected void printComponent(Graphics g)
            {
                super.paintComponents(g);
                g.drawImage(getImage("bomb"), 0, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS*IMAGE_SIZE));
        add (panel);
    }
    // метод отвечающий за функкционал панели
    private void initFrame()
    {
        pack ();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // по умолчанию закрытие окна
        setTitle("Java Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    // функция получения картинок
    private Image getImage(String name)
    {
        String filename = "img/"+name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon (getClass().getResource(filename));
        return icon.getImage();
    }
}
