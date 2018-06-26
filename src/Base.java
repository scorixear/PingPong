/**
 * @author Paul Keller
 * @date 19.06.2018
 */
class Base {
    int x, y, width, height;
    private GamePanel panel;
    Base(int height, GamePanel p)
    {
        x =0;
        width=70;
        this.height=20;
        y=height-this.height*4;
        panel=p;
    }
    void update(double x){
        x-=width/2;
        this.x += x>this.x+3?3:x<this.x-3?-3:x-this.x;
        if(this.x<0)
            this.x=0;
        else if(this.x>panel.getWidth()-width)
            this.x=panel.getWidth()-width;
    }

    void point() {
        panel.point(this);
    }
}
