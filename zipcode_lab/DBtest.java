import java.sql.Connection;
import java.sql.DriverManager;

public class DBtest {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
