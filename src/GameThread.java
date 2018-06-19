/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class GameThread extends Thread {
    private Ball ball;
    private Base base;
    private GamePanel panel;
    public GameThread(Ball b, GamePanel p, Base ba){
        ball =b;
        panel=p;
        base=ba;
    }

    @Override
    public void run() {
        while(true){

            double x = panel.getMousePosition()!=null?panel.getMousePosition().getLocation().getX():base.x+base.width/2;
            base.update(x);
            ball.tick(panel.getWidth(),panel.getHeight());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.repaint();
        }

    }
}
