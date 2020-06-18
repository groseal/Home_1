package com.company.hw2_7.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    @FXML public TextArea textArea;
    @FXML public TextField textField;
    @FXML public PasswordField passwordField;
    @FXML public TextField loginField;
    @FXML public HBox upperPanel;
    @FXML public Button sendMSG;
    @FXML public HBox bottomPanel;

    private boolean isAuthorized;//говорит авторизован клиент или нет

    Socket socket;//клиентский сокет
    DataInputStream in;//исходящий поток
    DataOutputStream out;//входящий поток

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    //поведение окна чата
    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
        if (isAuthorized){
            upperPanel.setVisible(false);//верхняя панель окна скрыта если клиент авторизовался
            bottomPanel.setVisible(true);//нижняя панель окна видна если клиент авторизовался
        }else {
            upperPanel.setVisible(true);//верхняя панель окна видна если клиент не авторизовался
            bottomPanel.setVisible(false);//нижняя панель окна скрыта если клиент не авторизовался
        }
    }

    //вызывается после ввода логина и пароля
    public void connect() {
        try {
            socket = new Socket(IP_ADRESS, PORT);//новый сокет клиента
            in = new DataInputStream(socket.getInputStream());//поток вывода сокета клиента
            out = new DataOutputStream(socket.getOutputStream());//поток ввода сокета клиента

            new Thread(() -> {//поток в котором клиент считывает входящий поток
                try {
                    //цикл авторизации
                    while (true) {
                        String str = in.readUTF();//читаем данные с входящего потока
                        if (str.equals("/authok")) {//если с сервера пришло сообщение с токеном "/authok" (успешная авторизация)
                            setAuthorized(true);//авторизация прошла успешно
                            break;
                        }
                        textArea.appendText(str + "\n");//выводим их на экран в поле textArea
                    }

                    //цикл работы
                    while (true) {
                        String str = in.readUTF();//читаем данные с входящего потока
                        textArea.appendText(str + "\n");//выводим их на экран в поле textArea
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();//закрываем сокет клиента
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setAuthorized(false);//что бы при не успешной авторизации панели окна были как надо
                }
            }).start();//запуск потока
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMSG(ActionEvent actionEvent) {
        try {
            out.writeUTF(textField.getText());//отправляет в исходящий поток сокета введенный текст
            textField.setText("");
            textField.requestFocus();//вернуть фокус на поле ввода
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //собирает сообщение авторизации
    public void tryToAuth(ActionEvent actionEvent) {
        if (socket==null||socket.isClosed()) {//если сокен не создан или закрылся
            connect();
        }
        try {
            out.writeUTF("/auth "+loginField.getText()+" "
                    +passwordField.getText());//собирает сообщение авторизации
            loginField.clear();//очистить поле ввода логина
            passwordField.clear();//очистить поле ввода пароля
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
