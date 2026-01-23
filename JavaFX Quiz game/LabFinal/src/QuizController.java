import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class QuizController {

    private String[][] questions;
    private int currentQuestion = 0;
    private int score = 0;

    public QuizController(String[][] questions) {
        this.questions = questions;
    }

    // Load current question into UI
    public void loadQuestion(Label questionLabel, RadioButton[] options, ToggleGroup group) {
        questionLabel.setText(questions[currentQuestion][0]);
        for (int i = 0; i < 4; i++) {
            options[i].setText(questions[currentQuestion][i + 1]);
            options[i].setToggleGroup(group);
            options[i].setSelected(false);
        }
    }

    // Check answer and move to next question
    public boolean checkAnswer(RadioButton[] options) {
        int correctIndex = Integer.parseInt(questions[currentQuestion][5]);
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected() && i == correctIndex) {
                score++;
                break;
            }
        }
        currentQuestion++;
        return currentQuestion < questions.length;
    }

    public int getScore() {
        return score;
    }
}
