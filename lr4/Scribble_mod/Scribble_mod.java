import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Scribble_mod extends Applet implements MouseListener, MouseMotionListener
{
    boolean L_key_pressed = false;
    private int last_x, last_y, 
    private int d = 20;
    private Graphics g;

    public void init() 
    {
        addMouseListener(this) ;
        addMouseMotionListener(this);
        g = getGraphics();
    }

    public void mouseReleased(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1) L_key_pressed = false;
    }

    public void mousePressed(MouseEvent e) 
    {
        if(e.getButton() == MouseEvent.BUTTON1) //ЛКМ
        {
            L_key_pressed = true;
            last_x = e.getX();
            last_y = e.getY();
        }
        if(e.getButton() == MouseEvent.BUTTON3) //ПКМ
        {
            Random randomGenerator = new Random();
            int red = randomGenerator.nextInt(256);
            int green = randomGenerator.nextInt(256);
            int blue = randomGenerator.nextInt(256);
            Color randomColour = new Color(red,green,blue);
            g.setColor(randomColour);
        }
    }

    public void mouseDragged(MouseEvent e) 
    {
        if (L_key_pressed) 
        {
            int x = e.getX(), y = e.getY();
            g.drawRect(x - d, y - d, d * 2, d * 2);
            last_x = x;
            last_y = y;
        }
    }
    public void mouseClicked(MouseEvent e) {;}
    public void mouseEntered(MouseEvent e) {;}
    public void mouseExited(MouseEvent e) {;}
    public void mouseMoved(MouseEvent e) {;}
}
