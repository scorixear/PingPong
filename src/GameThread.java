/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class GameThread extends Thread {
    private Ball ball;
    private Base base, base2;
    private GamePanel panel;
    GameThread(Ball b, GamePanel p, Base ba, Base ba2){
        ball =b;
        panel=p;
        base=ba;
        base2=ba2;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while(true){

            double x = 0;
            double y;
            try{
                y = panel.getMousePosition().getLocation().getY();
            }catch (NullPointerException ex){
                y=0;
            }
            try{
                x = panel.getMousePosition().getLocation().getX();

            }catch (NullPointerException ex){
                if(y<panel.getHeight()/2)
                    x=base2.x+base2.width/2;
            }
            if(y<panel.getHeight()/2)
                base2.update(x);
            else
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
