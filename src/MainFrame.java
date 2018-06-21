import javax.swing.*;
import java.awt.*;

/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class MainFrame extends JFrame {
    private GamePanel panel;
    public MainFrame(){
        panel=new GamePanel(400,800);
        setSize(400,800);
        setLayout(new BorderLayout());
        add(panel,BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        panel.start();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}