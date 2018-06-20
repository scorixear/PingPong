import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class GamePanel extends JPanel {
    private Ball ball;
    private Base base;
    private Base base2;
    private GameThread thread;
    private int point1, point2;
    private Font f;
    private int width1, width2;
    public GamePanel(int width, int height){
        base = new Base(height,this);
        base2 = new Base(100,this);
        ball = new Ball(width/2, height/2,50, base, base2);
        thread=new GameThread(ball,this, base, base2);
        point1 = 0;
        point2=0;
        width1= 0;
        width2= 0;
        f = new Font("LCD2",Font.PLAIN,48);
    }
    public void start(){
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        g.setColor(new Color(255,0,0,50));
        g.setFont(f);
        g.drawString(point1+"",getWidth()/2-width1/2,getHeight()/2-20);
        g.setColor(new Color(0,0,255,50));
        g.drawString(point2+"",getWidth()/2-width2/2,getHeight()/2+g.getFontMetrics().getHeight()+10);
        g.setColor(Color.BLACK);
        g.fillOval(ball.getLocation().x,ball.getLocation().y,ball.getRadius(),ball.getRadius());
        g.fillRect(base.x,base.y,base.width,base.height);
        g.fillRect(base2.x, base2.y, base2.width,base2.height);

    }

    public void point(Base base) {
        if(base.equals(this.base)){
            point2++;
            width2= (point2+"").chars().mapToObj(i -> (char) i).mapToInt(x ->this.getFontMetrics(f).charWidth(x)).sum();
        }
        else {
            point1++;
            width1= (point1+"").chars().mapToObj(i -> (char) i).mapToInt(x ->this.getFontMetrics(f).charWidth(x)).sum();
        }
    }
}
