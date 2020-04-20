package com.company.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private static final int POS_X = 1000;
    private static final int POS_Y = 550;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 100;

    private final ChatServer server;
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");

    public static void main(String[] args) {
        //Создание потока для выполнения Server GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServerGUI();
            }
        });
//        throw new RuntimeException("Main died!");
        System.out.println("Main finished");
    }

    ServerGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);//установка обработчика непойманных
                                                        // исключений по умолчанию для потока
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true); //окно всегда поверх других окон
        setLayout(new GridLayout(1, 2));
        btnStart.addActionListener(this);//Выполнение действия по кнопке Старт
        btnStop.addActionListener(this);//Выполнение действия по кнопке Стоп

        add(btnStart);
        add(btnStop);
        server = new ChatServer();//новое окно чатсервера
        setVisible(true);
    }

    @Override
    //Слушатель  нажатий кнопок Старт и Стоп
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnStart) {
            server.start(8189);//Действие по кнопке Старт
        } else if (src == btnStop) {
//            server.stop();//Действие по кнопке Стоп
            throw new RuntimeException("Hello from EDT!");
        } else {
            throw new RuntimeException("Unknown source:" + src);
        }
    }

    @Override
    //Обрабатывает исключения пойманные setDefaultUncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = String.format("Exception in \"%s\" %s: %s\n\tat %s",
                t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);//окно с сообщением об ошибке
        System.exit(1);
    }
}
