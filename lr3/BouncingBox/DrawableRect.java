import java.awt.*;
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