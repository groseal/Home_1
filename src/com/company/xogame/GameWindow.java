package com.company.xogame;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_POS_X = 350;
    private static final int WINDOW_POS_Y = 100;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;

    StartNewGameWindow startNewGameWindow;
    BattleMap field;

    public GameWindow() {
        setTitle("Tic Tac Toe");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton btnNewGame = new JButton("NewGame");
        JButton btnExit = new JButton("Exit");
        panel.add(btnNewGame);
        panel.add(btnExit);
        add(panel,BorderLayout.SOUTH);

        startNewGameWindow = new StartNewGameWindow(this);
        field = new BattleMap();
        add(field,BorderLayout.CENTER);


        btnExit.addActionListener(event->{
            System.exit(0);
        });

        btnNewGame.addActionListener(event->{
            startNewGameWindow.setVisible(true);
        });




        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
//        System.out.printf("mode %d fieldSizeX %d fieldSizeY %d winLength %d \n"
//                ,mode, fieldSizeX, fieldSizeY, winLength);
        field.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}
