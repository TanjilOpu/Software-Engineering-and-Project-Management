import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/quizdb";
        String user = "root";
        String pass = "tanjilsql";   // if password set, write here

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected Successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
