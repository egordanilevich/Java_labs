import java.applet.*;
import java.awt.*;
//Создаем собственный класс,который наследуется от класса Applet
//Данный класс реализует методы интерфейса Runnable
public class BouncingCircle extends Applet implements Runnable {
int x = 150, y = 50, r = 50; // Центр и радиус круга
int dx = 11, dy = 7;
// Движение круга по горизонт и вертик
Thread animator;
// Нить, которая осуществляет анимацию
volatile boolean pleaseStop; // Флаг остановки движения
//Метод для рисования окружности красным цветом
public void paint(Graphics g) {
g.setColor(Color.red);
//установка цвета для g
g.fillOval(x-r, y-r, r*2, r*2); //прорисовка круга
}
//Метод двигает круг и "отражает" его при ударе круга о стенку,
//затем вызывает перерисовку.
//Данный метод вызывается многократно анимационным потоком
public void animate() {
Rectangle bounds = getBounds(); //Получение размера окна программы
if ((x - r + dx < 0) || (x + r + dx > bounds.width)) dx = -dx;
if ((y - r + dy < 0) || (y + r + dy > bounds.height)) dy = -dy;
// Изменение координат круга, по сути - движение.
x += dx; y += dy;
//"Просим" браузер вызвать метод paint() для отрисовки
// круга в новой позиции
repaint();
}/*Это метод из интерфейса Runnable. Это тело потока исполнения,
осуществляющего анимацию. Сам поток создается и
запускается методом start()
*/
public void run() {
while(!pleaseStop) {
// Цикл до тех пор, пока не будет
//команды остановиться.
animate();
// Обновляем положение и перерисовываем
try { Thread.sleep(100); }
// Ждем 100 миллисекунд
catch(InterruptedException e) {} // Игнорируем прерывания
}
}
//Запускаем анимацию при запуске апплета браузером
public void start() {
animator = new Thread(this); // Создаем поток исполнения
pleaseStop = false;
// Пока не просим его остановиться
animator.start();
// Запускаем поток
}
//Останавливаем анимацию, когда браузер останавливает апплет
public void stop() { pleaseStop = true; }
}