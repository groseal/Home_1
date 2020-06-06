package com.company.hw2_7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;

    public Server() throws SQLException {
        AuthService.connect();//подключение к БД

        clients = new Vector<>();//список подлкюченных клиентов
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);//новый сервер сокет
            System.out.println("server start");

            while (true) {
                socket = server.accept();//сервер ожидатет подкдючения клиента
                System.out.println("client connect");
                new ClientHandler(this, socket);//создаем клиента
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();//закрыли поток сервера
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();//отключение от БД
        }
    }

    //отправляет сообщения всем подключенным клиентам (находящимся в Vector<ClientHandler> clients)
    public void broadcastMsg(String msg) {
        for (ClientHandler c : clients) {
            c.sendMSG(msg);
        }
    }

    //добавляет подключившегося клиента в Vector
    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    //удаляет отключившегося клиента из Vector
    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }


}
