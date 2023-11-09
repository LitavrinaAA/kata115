package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;



public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 100);
//        userService.saveUser("Petr", "Petrov", (byte) 25);
//        userService.saveUser("Yuri", "Sidorov", (byte) 30);
//        userService.saveUser("Masha", "Ivanova", (byte) 38);
//
//        userService.removeUserById(1);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

    }
}
