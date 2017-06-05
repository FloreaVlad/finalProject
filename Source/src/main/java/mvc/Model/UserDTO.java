package mvc.Model;

import mvc.Connection.ConnSQL;
import mvc.POJO.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDTO {

    private static Connection connection = new ConnSQL().getC();

    public void registerUser(User user) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Create user - Connection failed");
        }

        String sqlStatement = "INSERT INTO users(username, password, name, usertype) " +
                "VALUES ('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getName() + "','" + user.getUserType() + "');";

        try {
            if (statement != null) {
                statement.execute(sqlStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Create user - Connection failed");
        }
    }

    public User getUserForLogin(String userUsername) {
        Statement statement = null;
        User usr = new User();

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Select user - Connection failed");
        }

        String sqlStatement = "SELECT username, password, name, usertype " +
                "FROM users WHERE username = '" + userUsername + "';";


        try {
            if (statement != null) {
                ResultSet rs = statement.executeQuery(sqlStatement);

                while (rs.next()) {
                    usr.setUsername(rs.getString("username"));
                    usr.setPassword(rs.getString("password"));
                    usr.setName(rs.getString("name"));
                    usr.setUserType(rs.getString("usertype"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Select user - Connection failed");
            return null;
        }

        return usr;
    }

    public List<User> getUsersWithCriteria(String userCriteria) {
        Statement statement = null;
        List<User> users = new ArrayList<>();

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Create user - Connection failed");
        }

        String sqlStatement = "SELECT id, username, password, name, usertype " +
                "FROM users WHERE username ILIKE '%" + userCriteria + "%' OR name ILIKE '%" + userCriteria + "%';";

        try {
            if (statement != null) {
                ResultSet rs = statement.executeQuery(sqlStatement);
                int i = 0;
                while (rs.next()) {
                    User usr = new User();

                    usr.setId(rs.getInt("id"));
                    usr.setUsername(rs.getString("username"));
                    usr.setPassword(rs.getString("password"));
                    usr.setName(rs.getString("name"));
                    usr.setUserType(rs.getString("usertype"));

                    users.add(i, usr);
                    i++;
                }
            }
        } catch (SQLException e) {
            System.out.println("Create user - Connection failed");
            return null;
        }

        return users;
    }

    public void updateUser(User user) {
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Create user - Connection failed");
        }
//        UPDATE COMPANY SET SALARY = 15000 WHERE ID = 3;
        String sqlStatement = "UPDATE users SET username = '" + user.getUsername() + "', password = '" + user.getPassword() + "'"
                + ", name = '" + user.getName() + "', usertype = '" + user.getUserType() + "' WHERE id = " + user.getId() + ";";

        try{
            if(statement != null){
                statement.executeUpdate(sqlStatement);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Delete user - Connection failed");
        }
//        UPDATE COMPANY SET SALARY = 15000 WHERE ID = 3;
        String sqlStatement = "DELETE FROM users WHERE id = " + user.getId() + ";";

        try{
            if(statement != null){
                statement.executeUpdate(sqlStatement);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
