import java.applet.*;
import java.awt.*;
import java.awt.Rectangle;



public class BouncingBox2 extends Applet implements Runnable 
{
    public class Rect
{
    private int x1,x2,y1,y2;
    protected Color outColor = new Color(10, 10, 255);
    public Rect(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Rect(int x2, int y2)
    {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Rect()
    {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }
        //сеттеры
    public void set_x1(int x1) { this.x1 = x1; }
    public void set_y1(int y1) { this.y1 = y1; }
    public void set_x2(int x2) { this.x2 = x2; }
    public void set_y2(int y2) { this.y2 = y2; }
    //геттеры
    public int get_x1() {return x1;}
    public int get_y1() {return y1;}
    public int get_x2() {return x2;}
    public int get_y2() {return y2;}
    public void rect_print()
    {
        System.out.println("("+x1+" ; "+y1+") ("+x2+" ; "+y2+")");
    }

    public void move (int dx, int dy)
    {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }
    public void draw(Graphics g) 
    {
        g.setColor(outColor);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y1, x1, y2);
    }
    /*public Rectangle Union(Rectangle in)
    {
        Rectangle out = new Rectangle();

        if(this.x1 < in.get_x1()) out.x1 =this.x1;
        else out.set_x1(in.get_x1());

        if(this.y1 < in.get_y1()) out.set_y1(this.y1);
        else out.set_y1(in.get_y1());

        if(this.x2 > in.get_x2()) out.set_x2(this.x2);
        else out.set_x2(in.get_x2());

        if(this.y2 > in.get_y2()) out.set_y2(this.y2);
        else out.set_y2(in.get_y2());

        return out;
    }*/
}



class DrawableRect extends Rect
{
    private Color outColor = new Color(0,0,0);
    public DrawableRect(int x1, int y1, int x2, int y2)
    {
        super(x1,y1,x2,y2);
    }
    public DrawableRect(int x2, int y2)
    {
        super(x2,y2);
    }
    public DrawableRect()
    {
        super();
    }
    public void draw(Graphics g)
    {
        
        g.setColor(outColor);
        g.drawRect(this.get_x1(), this.get_y1(), this.get_y2()-this.get_y1(), this.get_x2()-this.get_x1());
    }
}


class ColoredRect extends DrawableRect
{
    private Color inColor = new Color(10,255,10); 

    public ColoredRect(int x1, int y1, int x2, int y2)
    {
        super(x1,y1,x2,y2);
    }
    public ColoredRect(int x2, int y2)
    {
        super(x2,y2);
    }
    public ColoredRect()
    {
        super();
    }

    public void draw(Graphics g)
    {
        g.setColor(inColor);
        g.fillRect(this.get_x1(), this.get_y1(), this.get_y2()-this.get_y1(), this.get_x2()-this.get_x1());
        super.draw(g);
        //g.setColor(outColor);
        //g.drawRect(this.get_x1(), this.get_y1(), this.get_y2()-this.get_y1(), this.get_x2()-this.get_x1());
    }
    
}

    protected int dx = (int) ( Math.random() * 50 ), dy = (int) ( Math.random() * 50 ); 
    //protected int dx = 40, dy = 7; 
    Thread animator; 
    volatile boolean pleaseStop;
    Rect [] rect_mas = new Rect[30];

    public void paint(Graphics g) 
    {
        for (int i = 0; i < 30; i++)
        {    
            rect_mas[i].draw(g);
        }
    }

    public void animate() 
    {
        Rectangle bounds = getBounds();
        for (int i = 0; i < 30; i++)
        {
         
                if ((rect_mas[i].get_x1() + dx <0) || (rect_mas[i].get_x2() + dx >bounds.width)) dx =-dx;
                if ((rect_mas[i].get_y1() + dy <0) || (rect_mas[i].get_y2() + dy >bounds.width)) dy =-dy;
                rect_mas[i].move(dx,dy);
                repaint();
        }
    }

    public void run() 
    {
        while (!pleaseStop) 
        {
            animate();
            try {Thread.sleep(200);}
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
        for (int i = 0; i < 30; i++)
        {
            int randX = 0, randY = 0;
            if (i < 10){ rect_mas [i] = new Rect(randX =  (int)(Math.random() * (getBounds().width - 150)),randY = (int)(Math.random() * (getBounds().height - 150)),randX + (int)(Math.random() * 100) + 50,randY +  (int)(Math.random() * 100) + 50); }
            else if (i < 20){ rect_mas [i] = new DrawableRect(randX =  (int)(Math.random() * (getBounds().width - 150)),randY = (int)(Math.random() * (getBounds().height - 150)),randX + (int)(Math.random() * 100) + 50,randY +  (int)(Math.random() * 100) + 50);}
            else if (i < 30){ rect_mas [i] = new ColoredRect(randX =  (int)(Math.random() * (getBounds().width - 150)),randY = (int)(Math.random() * (getBounds().height - 150)),randX + (int)(Math.random() * 100) + 50,randY +  (int)(Math.random() * 100) + 50);}
        }
    }
}
