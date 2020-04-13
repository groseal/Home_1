package com.company.gameball;

import java.awt.*;

public class Background extends GameCanvas {
    public Background(MainCircles listener) {
        super(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {//рисует GameCanvas (рисует последовательно кадры игры)
        super.paintComponent(g);//перерисовывает игровое поле
        //60 frames per second
        long currentTime = System.nanoTime();//системное время
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        listener.onCanvasRepainted(this, g, deltaTime);

    setBackground(new Color (
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)));

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();//выпоняет метод paintComponent повторно (зацикливает выполнение метода, отрисовку кадров игры)
    }
}


