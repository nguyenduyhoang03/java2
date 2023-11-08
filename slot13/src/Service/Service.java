package Service;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    //connect to database
    private static final String url = "jdbc:mysql://localhost:3306/aptechlibrary";
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,"root","");
        }catch (SQLException e){
                e.printStackTrace();
        }
        return connection;
    }
    //disconnect
    public static void close(Connection connection) throws SQLException {
        if (connection != null){
            connection.close();
        }
    }
    public static void close(PreparedStatement preparedStatement)throws SQLException{
        if (preparedStatement != null){
            preparedStatement.close();
        }
    }
    public static void close(ResultSet resultSet)throws SQLException{
        if (resultSet != null){
            resultSet.close();
        }
    }
    public void addBook(Book book)throws SQLException{
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "insert into book(id,name,quantity,borrow) values(?,?,?)"
        );
        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2, book.getName());
        preparedStatement.setInt(3,book.getQuantity());
        int check = preparedStatement.executeUpdate();
        close(connection);
        close(preparedStatement);
    }
    public Book searchById(int id)throws SQLException{
        Book book = new Book();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id = ?");
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            book.setId(rs.getInt(1));
            book.setName(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setQuantity(rs.getInt(4));
            book.setBorrowed(rs.getBoolean(5));
        }
        close(rs);
        close(preparedStatement);
        close(connection);
        return book;
    }
    public Book searchByName(String name)throws SQLException{
        Book book = new Book();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id = ?");
        preparedStatement.setString(1,name);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            book.setId(rs.getInt(1));
            book.setName(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setQuantity(rs.getInt(4));
            book.setBorrowed(rs.getBoolean(5));
        }
        close(rs);
        close(preparedStatement);
        close(connection);
        return book;
    }

    public List<Book> getAllbBook() throws SQLException {
       List<Book> books = new ArrayList<>();
       Connection connection = getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement("select * from book");
       ResultSet rs = preparedStatement.executeQuery();
       while (rs.next()){
           Book book = new Book();
           book.setId(rs.getInt("id"));
           book.setName(rs.getString("name"));
           book.setAuthor(rs.getString("author"));
           book.setQuantity(rs.getInt("quantity"));
           book.setBorrowed(rs.getBoolean("Borrowed"));
           books.add(book);
       }
       return books;
    }
    public void updateStatusBorrow(int ticketId,boolean isReturned) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update ticket set is_returned = ? where ticket_id like = ?  ");
        preparedStatement.setBoolean(1,isReturned);
        preparedStatement.setInt(2,ticketId);
    }
}
