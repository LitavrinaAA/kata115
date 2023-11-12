package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


import static jm.task.core.jdbc.util.Util.connection;
import static jm.task.core.jdbc.util.Util.statement;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable()  {
        String sql = "CREATE TABLE IF NOT EXISTS user(" +
                "id int auto_increment primary key," +
                "name varchar(30) not null ," +
                "lastName varchar(30) not null ," +
                "age int not null )";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            statement.executeUpdate("DROP TABLE IF  EXISTS user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user (name ,lastName, age) values (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setByte(3, age);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {
        try {
            statement.executeUpdate("DELETE FROM user WHERE Id =" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {

    List<User> users = new ArrayList<>();
    try {
        ResultSet res = statement.executeQuery("SELECT * FROM user");
        while (res.next()) {
            users.add(new User(res.getString(2)
                    , res.getString(3)
                    , Byte.parseByte(res.getString(4))));
        }
    } catch (SQLException e){
        throw new RuntimeException(e);
    }
        return users;
    }

    public void cleanUsersTable() {
        try {
            statement.executeUpdate("DELETE FROM user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
