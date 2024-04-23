import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ex1 extends JApplet 
{
    private JButton b1 = new JButton("Button 1"), b2 = new JButton("Button 2");
    private JTextField txt = new JTextField(10);
    //класс обработчик событий, реализующий интерфейс ActionListener
    public class ButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    }
    //создание экземпляра класса-обработчика
    private ButtonListener bl = new ButtonListener();
    public void init() 
    {
        b1.addActionListener(bl); //регистрация слушателя события
        b2.addActionListener(bl); // экземпляра bl класса ButtonListener
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }
}