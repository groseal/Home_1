package com.company.hw2_7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//Класс для подключения каждого клиента
public class ClientHandler {
    private Server server;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String nick;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());//поток вывода сокета клиента
            out = new DataOutputStream(socket.getOutputStream());//поток ввода сокета клиента

            new Thread(() -> {
                try {
                    //цикл авторизации
                    while (true) {
                        String str = in.readUTF();//построчно считывает входящий поток сокета
                        if (str.startsWith("/auth ")) {//СООБЩЕНИЕ АВТОРИЗАЦИИ если сообщение начинаестся с "/auth "
                            String[] token = str.split(" ");//разделяем сообщение по пробелу и записывает в массив
                            String newNick = AuthService.getNickByLoginAndPass(token[1], token[2]);//передаем выделенные из сообщения логин и пароль на проверку в БД
                            if (newNick != null) {//
                                sendMSG("/authok");//сообщаем клиенту сто авторизация прошла успешно
                                nick = newNick;
                                server.subscribe(this);//добавляем подключившегося клиента в список авторизованных (Vector)
                                System.out.println("client "+nick+ " autorized");
                                break;
                            } else {
                                sendMSG("Неверный логин или пароль.");
                            }
                        }
                    }

                    //цикл работы
                    while (true) {
                        String str = in.readUTF();//построчно считывает входящий поток сокета
                        if (str.equals("/end")) {//если клиент прислал /end происходит отключение и разрыв соединения
                            break;
                        }
                        server.broadcastMsg(nick + " : " + str);//добавляем ник в посланное сообщение
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();//закрыли поток сокета
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);//удаляем клиента из списка клиентов (Vector)
                    System.out.println("client "+nick+ " disconnect");
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //отправляет сообщения серверу
    public void sendMSG(String msg) {
        try {
            out.writeUTF(msg);//передает в исходящий поток сокета введенное сообщение
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
