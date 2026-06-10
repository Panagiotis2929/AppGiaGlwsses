package com.example.mavenproject1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuizController {
    private String language;
    private String category;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Question> questions = new ArrayList<>();

    @FXML
    private Label questionLabel;
    @FXML
    private TextField answerField;
    @FXML
    private Label feedbackLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button backButton;

    public void setLanguage(String language) {
        this.language = language;
        initializeQuestions();
    }

    public void setCategory(String category) {
        this.category = category;
        initializeQuestions();
    }

    private void initializeQuestions() {
        if (language == null || category == null) return;

        questions.clear();
        String[][] phrases = {
            {"Hello", "Goodbye", "Thank you", "Please", "How are you?", "Nice to meet you", "Good morning", "Good night", "Excuse me", "I'm sorry", "Can you help me?", "Where is the bathroom?", "I'm lost", "Call a doctor", "I need water"},
            {"Ciao", "Arrivederci", "Grazie", "Per favore", "Come stai?", "Piacere di conoscerti", "Buongiorno", "Buonanotte", "Mi scusi", "Mi dispiace", "Può aiutarmi?", "Dov'è il bagno?", "Mi sono perso", "Chiami un dottore", "Ho bisogno di acqua"},
            {"Γεια σας", "Αντίο", "Ευχαριστώ", "Παρακαλώ", "Πώς είσαι;", "Χαίρομαι που σε γνώρισα", "Καλημέρα", "Καληνύχτα", "Συγγνώμη", "Λυπάμαι", "Μπορείτε να με βοηθήσετε;", "Πού είναι η τουαλέτα;", "Έχω χαθεί", "Καλέστε έναν γιατρό", "Χρειάζομαι νερό"}
        };

        switch (category) {
            case "Greetings":
                addQuestions(phrases, new int[]{0, 1, 4, 5, 6});
                break;
            case "Travel":
                addQuestions(phrases, new int[]{2, 3, 8, 9, 10});
                break;
            case "Food":
                addQuestions(phrases, new int[]{0, 2, 4, 5, 6});
                break;
            case "Emergency":
                addQuestions(phrases, new int[]{1, 3, 11, 12, 13});
                break;
        }

        Collections.shuffle(questions);
        if (questions.size() > 10) {
            questions = questions.subList(0, 10);
        }

        currentQuestionIndex = 0;
        score = 0;
        displayQuestion();
    }

    private void addQuestions(String[][] phrases, int[] indices) {
        for (int index : indices) {
            int sourceLangIndex = (Math.random() < 0.5) ? 0 : 1;
            String sourcePhrase = phrases[sourceLangIndex][index];
            String greekTranslation = phrases[2][index];
            String sourceLanguage = (sourceLangIndex == 0) ? "English" : "Italian";

            questions.add(new Question(sourcePhrase, greekTranslation, sourceLanguage));
        }
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            questionLabel.setText("Μετάφρασε στα Ελληνικά:\n" + question.getQuestion() + "\n(Από " + question.getSourceLanguage() + ")");
            answerField.clear();
            answerField.setDisable(false);
            answerField.setVisible(true);
            feedbackLabel.setText("");
            scoreLabel.setText("Βαθμολογία: " + score + "/" + questions.size());

        } else {
            questionLabel.setText("Ολοκληρώθηκε το κουίζ!");
            answerField.setVisible(false);
            feedbackLabel.setText("Τελική βαθμολογία: " + score + "/10");
        }
    }

    @FXML
    private void handleCheckAnswer() {
        if (currentQuestionIndex >= questions.size()) return;

        String userAnswer = answerField.getText().trim();
        Question question = questions.get(currentQuestionIndex);

        if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
            feedbackLabel.setText("Σωστά! +1 πόντος\nΗ απάντησή σου: " + userAnswer);
            score++;
            scoreLabel.setText("Βαθμολογία: " + score + "/" + questions.size());
            answerField.setDisable(true); // Δεν επιτρέπει άλλη αλλαγή
        } else {
            feedbackLabel.setText("Λάθος απάντηση. Προσπάθησε ξανά!");
            answerField.clear();
        }
    }

    @FXML
    private void handleNextQuestion() {
        if (answerField.isDisabled()) {
            currentQuestionIndex++;
            displayQuestion();
        } else {
            feedbackLabel.setText("Απάντησε σωστά για να συνεχίσεις!");
        }
    }

    @FXML
    private void switchToPrimary() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mavenproject1/primary.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) questionLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Question {
        private final String question;
        private final String answer;
        private final String sourceLanguage;

        public Question(String question, String answer, String sourceLanguage) {
            this.question = question;
            this.answer = answer;
            this.sourceLanguage = sourceLanguage;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }

        public String getSourceLanguage() {
            return sourceLanguage;
        }
    }
}