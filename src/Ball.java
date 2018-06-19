import java.awt.*;
import java.util.Vector;

/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class Ball {
    private double x,y;
    private Vector<Double> velo;
    private int r;
    private Base base;

    public Ball(int x, int y,int r, Base b){
        this.r=r;
        this.x=x;
        this.y=y;
        base=b;
        velo=new Vector<>();
        velo.add(Math.random());
        velo.add(Math.random());
        normalize();
    }

    private void normalize() {
        double divisor = Math.sqrt(velo.get(0)*velo.get(0)+velo.get(1)*velo.get(1));
        velo.set(0,velo.get(0)/divisor);
        velo.set(1,velo.get(1)/divisor);
    }

    public void tick(int width, int height){
        x+=velo.get(0);
        y+=velo.get(1);
        if(x<0||x+r>width){
            velo.set(0,(velo.get(0)<5.0&&velo.get(0)>-5.0)?velo.get(0)*-1.05:velo.get(0)*-1.0);
            velo.set(1,(velo.get(1)<5.0&&velo.get(1)>-5.0)?velo.get(1)*1.05:velo.get(1));
        }
        System.out.println(x>base.x-r/2);
        System.out.println((x<base.x+base.width));
        System.out.println(y+r>=base.y);
        if(y<0||y+r>height||(x>base.x-r/2&&x<base.x+base.width&&y+r>=base.y)){
            velo.set(0,(velo.get(0)<5.0&&velo.get(0)>-5.0)?velo.get(0)*1.05:velo.get(0));
            velo.set(1,(velo.get(1)<5.0&&velo.get(1)>-5.0)?velo.get(1)*-1.05:velo.get(1)*-1.0);
        }

    }

    public Point getLocation(){
        return new Point((int)Math.round(x),(int)Math.round(y));
    }

    public Vector<Double> getVelo(){
        return velo;
    }

    public int getRadius(){
        return r;
    }

}
