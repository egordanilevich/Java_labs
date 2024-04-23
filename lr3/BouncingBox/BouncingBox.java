import java.applet.*;
import java.awt.*;
import java.awt.Rectangle;

public class BouncingBox extends Applet implements Runnable 
{
    protected int dx = 40, dy = 7;
    protected int x1=0, y1=0, x2=100, y2=150;
    Thread animator;
    volatile boolean pleaseStop;
    ColoredRect cbox;

    public void paint(Graphics g) {cbox.draw(g);}

    public void animate() 
    {
        Rectangle bounds = getBounds();
        if ((cbox.get_x1() + dx < 0) || (cbox.get_x2() + dx > bounds.width)) dx = -dx;
        if ((cbox.get_y1() + dy < 0) || (cbox.get_y2() + dy > bounds.height)) dy = -dy;
        cbox.move(dx,dy);
        repaint();
    }

    public void run() 
    {
        while (!pleaseStop) 
        {
            animate();
            try {Thread.sleep(100);}
            catch (InterruptedException e) {}
        }
    }

    public void start() 
    {
        animator = new Thread(this);
        pleaseStop = false;
        animator.start();
    }

    public void stop() {pleaseStop = true;}

    public void init() 
    {
        cbox = new ColoredRect( this.x1, this.y1, this.x2, this.y2);
    }
}
