import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizController {

    @FXML
    private TextField nameField;

    @FXML
    private Label questionLabel;

    @FXML
    private Button optionA, optionB, optionC, optionD;

    private List<Question> questions = new ArrayList<>();
    private int currentIndex = 0;
    private int score = 0;
    private String playerName;

    // ================= START QUIZ =================
    @FXML
    private void startQuiz(ActionEvent event) {


        playerName = nameField.getText().trim();

        if (playerName.isEmpty()) {
            showAlert("Name Required", "Please enter your name first.");
            return;
        }

        loadQuestions();

        if (questions.isEmpty()) {
            showAlert("Error", "No questions found in database!");
            return;
        }

        Collections.shuffle(questions);        // randomize
        questions = questions.subList(0, Math.min(5, questions.size())); // take up to 5 questions

        score = 0;
        currentIndex = 0;

        nameField.setDisable(true);

        // Enable buttons
        optionA.setDisable(false);
        optionB.setDisable(false);
        optionC.setDisable(false);
        optionD.setDisable(false);

        displayQuestion();
    }

    // ================= LOAD QUESTIONS FROM DB =================
    private void loadQuestions() {
        questions.clear();

        String sql = "SELECT * FROM questions";


        try (Connection con = DBConnect.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {


            while (rs.next()) {
                Question q = new Question(
                        rs.getString("question"),
                        rs.getString("option_a"),
                        rs.getString("option_b"),
                        rs.getString("option_c"),
                        rs.getString("option_d"),
                        rs.getString("correct_option").charAt(0)
                );
                questions.add(q);
            }

            System.out.println("Loaded questions: " + questions.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= DISPLAY QUESTION =================
    private void displayQuestion() {
        if (currentIndex >= questions.size()) {
            endQuiz();
            return;
        }

        Question q = questions.get(currentIndex);

        questionLabel.setText((currentIndex + 1) + ". " + q.getQuestion());
        optionA.setText("A. " + q.getOptionA());
        optionB.setText("B. " + q.getOptionB());
        optionC.setText("C. " + q.getOptionC());
        optionD.setText("D. " + q.getOptionD());

        // Dynamically set actions
        optionA.setOnAction(e -> checkAnswer('A'));
        optionB.setOnAction(e -> checkAnswer('B'));
        optionC.setOnAction(e -> checkAnswer('C'));
        optionD.setOnAction(e -> checkAnswer('D'));
    }

    // ================= HANDLE ANSWER =================
    @FXML
    private void handleAnswer(ActionEvent event) {
        // This method is required because FXML references it.
        // Actual answer handling happens in displayQuestion() via lambda
    }

    // ================= CHECK ANSWER =================
    private void checkAnswer(char selected) {
        Question q = questions.get(currentIndex);

        if (selected == q.getCorrectOption()) {
            score++;
        }

        currentIndex++;
        displayQuestion();
    }

    // ================= END QUIZ =================
    private void endQuiz() {
        saveScore();

        questionLabel.setText(
                "Quiz Finished!\n\n" +
                        "Name: " + playerName + "\n" +
                        "Score: " + score + " / 5"
        );

        optionA.setDisable(true);
        optionB.setDisable(true);
        optionC.setDisable(true);
        optionD.setDisable(true);
    }

    // ================= SAVE SCORE TO DB =================
    private void saveScore() {
        String sql = "INSERT INTO results (name, score) VALUES (?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, playerName);
            ps.setInt(2, score);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= RESTART QUIZ =================
    @FXML
    private void restartQuiz(ActionEvent event) {
        nameField.clear();
        nameField.setDisable(false);

        optionA.setDisable(true);
        optionB.setDisable(true);
        optionC.setDisable(true);
        optionD.setDisable(true);

        questionLabel.setText("");
        questions.clear();
        score = 0;
        currentIndex = 0;
    }

    // ================= EXIT =================
    @FXML
    private void exitApp(ActionEvent event) {
        Stage stage = (Stage) questionLabel.getScene().getWindow();
        stage.close();
    }

    // ================= ALERT =================
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
