package org.example;

import org.entity.CarModelEntity;
import org.repository.CarModelRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // URL для подключения к базе данных
        String url = "jdbc:sqlserver://DESKTOP-QSVFQH3;databaseName=CarDTO;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CarDTO_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CarModelRepository carModelRepository = new CarModelRepository(entityManager);


        // Переменные для хранения соединения и запроса
        Connection connection = null;
        Statement statement = null;

        try {
            // Регистрация драйвера для SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Установить соединение
            connection = DriverManager.getConnection(url);

            // Проверка соединения
            if (connection != null) {
                System.out.println("Подключение к базе данных CarDTO успешно установлено!");
            } else {
                System.out.println("Не удалось подключиться к базе данных.");
            }

            // Пример выполнения запроса
            CarModelEntity carModelEntity = new CarModelEntity();
            carModelEntity.setBrand("Tesla");
            carModelEntity.setModel("Model S");
            carModelEntity.setCountryOrigin("USA");
            carModelEntity.setCountryCode("US");

            // Создание записи
            carModelRepository.create(carModelEntity);

            // Получение записи
            CarModelEntity foundCarModel = carModelRepository.getById(5);
            System.out.println("Найдено: " + foundCarModel.toString());

            // Обновление записи
            carModelEntity.setModel("Model X");
            carModelRepository.update(carModelEntity);

            // Удаление записи
            carModelRepository.delete(5);

            entityManager.close();
            entityManagerFactory.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Закрытие ресурсов
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
