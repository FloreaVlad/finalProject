package mvc.Model;

import mvc.Connection.ConnSQL;
import mvc.POJO.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    private Connection connection = new ConnSQL().getC();

    public List<Book> getBooks(String criteria){
        Statement statement = null;
        List<Book> books = new ArrayList<>();

        try{
            statement = connection.createStatement();
        } catch(Exception e){
            System.out.println("Create user - Connection failed");
        }

        String sqlStatement = "SELECT author, name, price, quantity FROM books WHERE author ILIKE '%" + criteria +"%'" +
                " OR name LIKE '%" + criteria + "%';";

        try{
            int i = 0;
            ResultSet rs = null;
            if (statement != null) {
                rs = statement.executeQuery(sqlStatement);
            }
            if (rs != null) {
                while(rs.next()){
                    Book book = new Book();
                    book.setAuthor(rs.getString("author"));
                    book.setName(rs.getString("name"));
                    book.setPrice(rs.getInt("price"));
                    book.setQuantity(rs.getInt("quantity"));
                    books.add(i, book);
                    i++;
                }
            }
        }catch (SQLException e){
            System.out.println("Create user - Connection failed");
            return null;
        }

        return books;
    }

    public void updateBook(Book book){
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Update book - Connection failed");
        }

        String sqlStatement = "UPDATE users SET name = '" + book.getName() + "', author = '" + book.getAuthor() + "'"
                + ", quantity = '" + book.getQuantity() + "', price = '" + book.getPrice() + "' WHERE id = " + book.getId() + ";";

        try{
            if(statement != null){
                statement.executeUpdate(sqlStatement);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteBook(Book book){
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Update book - Connection failed");
        }

        String sqlStatement = "DELETE FROM books WHERE ";

        try {
            if (statement != null) {
                statement.execute(sqlStatement);
            }
        } catch (SQLException e) {
            System.out.println("Create user - Connection failed");
        }
    }

    public void addBook(Book book){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Create user - Connection failed");
        }

        String sqlStatement = "INSERT INTO books(name , author, quantity, price) VALUES ('" + book.getName() + "','"
                + book.getAuthor() + "'," + book.getQuantity() + "," + book.getPrice() + ";";
    }
}
