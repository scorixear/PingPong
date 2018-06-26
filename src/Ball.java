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

    Ball(int x, int y, int r, Base b, Base b2){
        this.r=r;
        this.lastx=x;
        this.lasty=y;
        this.x=x;
        this.y=y;
        base=b;
        base2=b2;
        velo=new Vector<>();
        velo.add(Math.random());
        velo.add(0.5+Math.random()*0.5);
        normalize();
    }

    private void normalize() {
        double divisor = Math.sqrt(velo.get(0)*velo.get(0)+velo.get(1)*velo.get(1));
        velo.set(0,(velo.get(0)*2)/divisor);
        velo.set(1,(velo.get(1)*2)/divisor);
    }

    void tick(int width, int height){
        this.lastx=x;
        this.lasty=y;
        x+=velo.get(0);
        y+=velo.get(1);
        if(x<0&&this.lastx-velo.get(0)>=0){
            if(lasty<y)
                rotate(-90,width);
            else
                rotate(90,width);

            //velo.set(0,velo.get(0)*-1);
            enlarge();
        } else if(x+r>width&&this.lastx+velo.get(0)<=width){
            if(lasty<y)
                rotate(90,width);
            else
                rotate(-90,width);
            //velo.set(0,velo.get(0)*-1);
            enlarge();
        }
        if(x>base.x-r/2&&x<base.x+base.width&&y+r>=base.y&&y+r<=base.y+base.height&&this.lasty+velo.get(1)<=base.y){
            if(lastx<x)
                rotate(-90,width);
            else
                rotate(90,width);
            //velo.set(1,velo.get(1)*-1);
            enlarge();

        } else if(x>base2.x-r/2&&x<base2.x+base2.width&&y<=base2.y+base2.height&&y>=base2.y&&this.lasty-velo.get(1)<base.y){
            if(lastx<x)
                rotate(90,width);
            else
                rotate(-90,width);
            //velo.set(1,velo.get(1)*-1);
            enlarge();
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

    Point getLocation(){
        return new Point((int)Math.round(x),(int)Math.round(y));
    }

    int getRadius(){
        return r;
    }
    private void rotate (double degree, int width){
        if((this.x-velo.get(0)<0||this.x+velo.get(0)>width||this.y-velo.get(1)<base.y||this.y+velo.get(1)>base.y)) {
            double x = velo.get(0);
            double y = velo.get(1);
            velo.set(0, x * Math.cos(Math.toRadians(degree))-y * Math.sin(Math.toRadians(degree)));
            velo.set(1, x * Math.sin(Math.toRadians(degree))+y * Math.cos(Math.toRadians(degree)));
        }
    }
    private void enlarge(){
        velo.set(0,(velo.get(0)<5.0&&velo.get(0)>-5.0)?velo.get(0)* 1.05 :velo.get(0));
        velo.set(1,(velo.get(1)<5.0&&velo.get(1)>-5.0)?velo.get(1)*1.05:velo.get(1));
    }

}
