import java.sql.*;

public class InsertDataStudent {
    public static void main(String[] args) {

        // Updated database name to 'jdbcc' as per your URL
        String url = "jdbc:mysql://localhost:3306/jdbcc?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "tanjilsql";

        // Fixed: Removed 'age' and changed table name to 'student' (singular)
        String sql = "INSERT INTO student(name) VALUES (?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            // We only need to set one parameter (name)
            ps.setString(1, "Tanjil");

            ps.executeUpdate();
            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}