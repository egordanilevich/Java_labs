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
    private void draw(Graphics g) 
    {
        g.setColor(outColor);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y1, x1, y2);
    };
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