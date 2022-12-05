
package tools;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DBTool {

    public static Connection connection = null;

    public static void initConnect() throws SQLException, ClassNotFoundException {
        Class.forName("org.gjt.mm.mysql.Driver");
        String url = "jdbc:mysql://192.168.122.132:3307/Object?characterEncoding=UTF-8";
        connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, "root", "123456");
    }

}