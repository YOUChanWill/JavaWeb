package dao;

import com.mysql.jdbc.Connection;
import models.Note;
import models.User;
import tools.DBTool;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public static boolean Login(String username,String password){

        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("select * from Object.user where username = ? and password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return true;
            }
            return false;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void addNote(Note note){
        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("insert into Object.note(username, title,content,purview) values (?, ?, ?, ?)");
            preparedStatement.setString(1, note.getUsername());
            preparedStatement.setString(2, note.getTitle());
            preparedStatement.setString(3, note.getContent());
            preparedStatement.setInt(4, Integer.parseInt(String.valueOf(note.getPurview())));

            preparedStatement.executeUpdate();
            System.out.println(note.getContent());

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deleteNote(Note note){
        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("delete from Object.note where title = ? and username = ?");

            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getUsername());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }



    public void addUser(User user){
        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("insert into Object.user(username, password) values (?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void deleteUser(User user){
        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("delete from Object.user where username = ?");
            preparedStatement.setString(1, user.getUsername());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }



}
