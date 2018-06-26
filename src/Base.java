/**
 * @author Paul Keller
 * @date 19.06.2018
 */
public class Base {
    public int x, y, width, height;
    private GamePanel panel;
    public Base(int height, GamePanel p)
    {
        x =0;
        width=70;
        this.height=20;
        y=height-this.height*4;
        panel=p;
    }
    public void update(double x){
        x-=width/2;
        this.x += x>this.x+3?3:x<this.x-3?-3:x-this.x;
        if(this.x<0)
            this.x=0;
        else if(this.x>panel.getWidth()-width)
            this.x=panel.getWidth()-width;
    }

    public void point() {
        panel.point(this);
    }
}
