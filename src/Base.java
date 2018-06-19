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
        if(x-width/2<0)
            this.x=0;
        else if(x+width/2> panel.getWidth())
            this.x=panel.getWidth()-width;
        else
            this.x=((int)x-width/2);
    }
}
