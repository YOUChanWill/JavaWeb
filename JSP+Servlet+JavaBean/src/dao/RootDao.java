package dao;

import models.Note;
import tools.DBTool;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RootDao {

    public void updateRoot(Note note){
        try {
            DBTool.initConnect();
            PreparedStatement preparedStatement = DBTool.connection.prepareStatement("update Object.note set purview = ? where username = ? and title = ?");

            preparedStatement.setInt(1, Integer.parseInt(String.valueOf(note.getPurview())));
            preparedStatement.setString(2, note.getUsername());
            preparedStatement.setString(3, note.getTitle());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
