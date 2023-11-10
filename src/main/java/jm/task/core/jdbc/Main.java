package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;



public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();
        User user1 = new User("Ivan", "Petrov", (byte) 30);
        User user2 = new User("Petr", "Ivanov", (byte) 18);
        User user3 = new User("Yuri", "Sidorov", (byte) 100);
        User user4 = new User("Masha", "Ivanova", (byte) 15);
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        System.out.println("Все пользователи: ");
        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
