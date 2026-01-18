import java.sql.*;

public class InsertData {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbcc?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "tanjilsql";

        String sql = "INSERT INTO students(name, age) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "Rahim");
            ps.setInt(2, 22);

            ps.executeUpdate();
            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
