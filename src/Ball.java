import java.awt.*;
import java.util.Vector;

/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class Ball {
    private double x,y,lastx, lasty;
    private Vector<Double> velo;
    private int r;
    private Base base;
    private Base base2;

    public Ball(int x, int y,int r, Base b, Base b2){
        this.r=r;
        this.lastx=x;
        this.lasty=y;
        this.x=x;
        this.y=y;
        base=b;
        base2=b2;
        velo=new Vector<>();
        velo.add(Math.random());
        velo.add(Math.random());
        normalize();
    }

    private void normalize() {
        double divisor = Math.sqrt(velo.get(0)*velo.get(0)+velo.get(1)*velo.get(1));
        velo.set(0,(velo.get(0)*2)/divisor);
        velo.set(1,(velo.get(1)*2)/divisor);
    }

    public void tick(int width, int height){
        this.lastx=x;
        this.lasty=y;
        x+=velo.get(0);
        y+=velo.get(1);
        if(x<0){
            if(lasty<y)
                rotate(-90);
            else
                rotate(90);
            enlarge(1.05);
        } else if(x+r>width){
            if(lasty<y)
                rotate(90);
            else
                rotate(-90);
            enlarge(1.05);
        }
        if(x>base.x-r/2&&x<base.x+base.width&&y+r>=base.y&&y+r<=base.y+base.height){
            if(lastx<x)
                rotate(-90);
            else
                rotate(90);
            enlarge(1.05);

        } else if(x>base2.x-r/2&&x<base2.x+base2.width&&y<=base2.y+base2.height&&y>=base2.y){
            if(lastx<x)
                rotate(90);
            else
                rotate(-90);
            enlarge(1.05);
        }else if(y<0)
            reset(width, height, true);
        else if(y+r>height)
            reset(width,height,false);
    }

    private void reset(int width, int height, boolean team) {
        x = width/2;
        y = height/2;
        if(team)
            base.point();
        else
            base2.point();

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
    private void rotate (double degree){

        double x = velo.get(0);
        double y = velo.get(1);
        velo.set(0,x*Math.cos(Math.toRadians(degree))-y*Math.sin(Math.toRadians(degree)));
        velo.set(1, x*Math.sin(Math.toRadians(degree))+y*Math.cos(Math.toRadians(degree)));
    }
    private void enlarge(double multiplicator){
        velo.set(0,(velo.get(0)<5.0&&velo.get(0)>-5.0)?velo.get(0)*multiplicator:velo.get(0));
        velo.set(1,(velo.get(1)<5.0&&velo.get(1)>-5.0)?velo.get(1)*1.05:velo.get(1));
    }

}
