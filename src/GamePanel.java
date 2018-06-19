import javax.swing.*;
import java.awt.*;

/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class GamePanel extends JPanel {
    private Ball ball;
    private Base base;
    private GameThread thread;
    public GamePanel(int width, int height){
        base = new Base(height,this);
        ball = new Ball(width/2, height/2,50, base);
        thread=new GameThread(ball,this, base);

    }
    public void start(){
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(ball.getLocation().x,ball.getLocation().y,ball.getRadius(),ball.getRadius());
        g.fillRect(base.x,base.y,base.width,base.height);
    }
}
