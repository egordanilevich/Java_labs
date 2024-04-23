import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MovedRect extends Applet implements Runnable 
{
    Thread animator;
    volatile boolean pleaseStop,flag=false;
    ArrayList<Rect> rect_list = new ArrayList<Rect>();
    int last_x = 0, last_y = 0, dx=0, dy=0, imX=0, imY=0;

    public void init() 
    {
        Button Rect_button = new Button("Rect");
        Rect_button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                rect_list.add(new Rect(200,100));
            }
        });
       add(Rect_button);

        Button Drawable_button = new Button("DrawableRect");
        Drawable_button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                rect_list.add(new DrawableRect(200,150));
            }
        });
        add(Drawable_button);

        Button Colored_button = new Button("ColoredRect");
        Colored_button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                rect_list.add(new ColoredRect(200,200));
            }
        });
        add(Colored_button);

        

        this.addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e) 
            {//кнопка мыши нажата
                flag=true;
                for (int i = 0; i < rect_list.size(); i++)
                {
                    if(e.getX() > rect_list.get(i).get_x1() && e.getX() < rect_list.get(i).get_x2()&& e.getY() > rect_list.get(i).get_y1() && e.getY() < rect_list.get(i).get_y2()) 
                    {
                        rect_list.get(i).set_grab(true);
                        last_x = e.getX();
                        last_y = e.getY();
                    }
                }
            }
        });

        addMouseListener(new MouseAdapter() 
        {
            public void mouseReleased(MouseEvent e) 
            {//кнопка мыши отпущена
                flag=false;
                for (int i = 0; i < rect_list.size(); i++)
                    if (rect_list.get(i).get_grab()) rect_list.get(i).set_grab(false);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {//наведена на компонент
            public void mouseDragged(MouseEvent e) {
                if (flag)
                {
                    for (int i = 0; i < rect_list.size(); i++)
                    {
                        if(rect_list.get(i).get_grab()) {
                            rect_list.get(i).move(e.getX() - last_x, e.getY() - last_y);
                            last_x = e.getX();
                            last_y = e.getY();
                        }
                    }
                }
            }
        });
    }


    public void start() 
    {
        animator = new Thread(this);// Создаем поток исполнения
        pleaseStop = false;// Пока не просим его остановиться
        animator.start();// Запускаем поток
    }

    public void stop() {pleaseStop = true;}

    public void paint(Graphics g) 
    {
        for (int i = 0; i < rect_list.size(); i++)
        {
            rect_list.get(i).draw(g);
        }
    }

    public void animate() {repaint();}

    public void run() 
    {
        while (!pleaseStop) 
        {
            animate();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {} 
        }
    }

}

