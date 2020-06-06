package com.company.hw2_7.server;

import java.sql.*;

//Отвечает за авторизацию и работу с БД
public class AuthService {
    private static Connection connection;//подключение к БД
    private static Statement stmt;//обращение к БД

    //подключение к БД
    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");//указываем место расположения драйвера БД
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");//подключение к БД
            stmt = connection.createStatement();//запросы в БД
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //отключение от БД
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //проверка логина и пароля в БД
    public static String getNickByLoginAndPass(String login, String password) {
        String sql = String.format("SELECT nickname FROM main\n" +//запрос в БД
                "WHERE login='%s'\n" +
                "AND password='%s'", login, password);
        try {
            ResultSet rs = stmt.executeQuery(sql);//обработка ответа БД
            if (rs.next()) {
                return rs.getString(1);//вернется если есть запись в БД
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;//вернется если нет записи в БД
    }


}