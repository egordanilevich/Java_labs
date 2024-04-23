import java.awt.*;
public class Test
{
	public static void main(String args[]) 
    {
        /*Rectangle r1 = new Rectangle(1,2,5,6); 
        Rectangle r2 = new Rectangle(3,4); 
        Rectangle r3 = new Rectangle(); 
        r1.rect_print();
        r2.rect_print();
        r3.rect_print();
        System.out.println("move:");
        r2.move(1,1);
        r2.rect_print();
        System.out.println("sum:");
        Rectangle r4 = new Rectangle();
        r4 = r1.Union(r2);
        r4.rect_print();*/
        //Graphics g;// = new Graphics();
        DrawableRect dr1 = new DrawableRect(1,2,3,4);
        dr1.draw(null);

    }
}