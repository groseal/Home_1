package com.company.gameball;

import javax.swing.*;
import java.awt.*;
//Игровое поле
public class GameCanvas extends JPanel {//игровое поле

    MainCircles listener;//

    long lastFrameTime;//переменная для игрового времени

    GameCanvas(MainCircles listener) {//игровое поле
        this.listener = listener;
        lastFrameTime = System.nanoTime();
    }

//Штука считающая время между итерациями отрисовки экрана
    @Override
    protected void paintComponent(Graphics g) {//рисует GameCanvas (рисует последовательно кадры игры)
        super.paintComponent(g);//перерисовывает игровое поле
        //60 frames per second
        long currentTime = System.nanoTime();//системное время
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        listener.onCanvasRepainted(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();//выпоняет метод paintComponent повторно (зацикливает выполнение метода, отрисовку кадров игры)
    }

    //методы возвращающие границы панели
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
