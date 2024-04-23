import java.awt.*;
import java.awt.Rectangle;

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
        
    }
    
}