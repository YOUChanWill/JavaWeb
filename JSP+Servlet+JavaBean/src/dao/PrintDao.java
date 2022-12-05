package dao;

import models.Note;
import models.User;
import servlet.Login;
import tools.DBTool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintDao {

    public List<User> searchUser(){

        List UserList = new ArrayList();

        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("select username from Object.user");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                UserList.add(user);
            }
            return UserList;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    public List<Note> searchNote(Note note1){

        List NoteList = new ArrayList();


        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("select * from Object.note where username = ? or purview = 1");

            preparedStatement.setString(1, Login.note.getUsername());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Note note = new Note();
                note.setUsername(resultSet.getString("username"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                NoteList.add(note);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        return NoteList;
    }

    public List<Note> searchAllNote(){

        List AllNoteList = new ArrayList();


        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("select * from Object.note");

            Note note1 = new Note();

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Note note = new Note();
                note.setUsername(resultSet.getString("username"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                AllNoteList.add(note);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        return AllNoteList;
    }

}