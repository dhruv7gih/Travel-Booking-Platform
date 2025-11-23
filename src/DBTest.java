import dao.DBConnection;
import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("✅ Database Connected Successfully!");
        } catch (Exception e) {
            System.out.println("❌ Connection Failed");
            e.printStackTrace();
        }
    }
}