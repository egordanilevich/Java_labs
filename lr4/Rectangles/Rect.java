import java.awt.*;
import java.awt.Rectangle;

public class Rect
{
    private int x1,x2,y1,y2;
    protected Color outColor = new Color(10, 10, 255);
    private boolean grab = false;
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

    boolean get_grab() 
    {
        return grab;
    }

    void set_grab(boolean in) 
    {
        grab = in;
    }
}