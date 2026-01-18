import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDataStudent {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbcc"
                + "?useSSL=false"
                + "&serverTimezone=UTC"
                + "&allowPublicKeyRetrieval=true";

        String user = "root";
        String password = "tanjilsql";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student")) {

            System.out.println("ID  AGE");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "   " +
                                rs.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
