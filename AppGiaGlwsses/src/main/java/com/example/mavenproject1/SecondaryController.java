package com.example.mavenproject1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondaryController {
    private String language;
    private String category;

    @FXML
    private Button backButton;
    @FXML
    private Label selectedLanguageLabel;
    @FXML
    private Label selectedCategoryLabel;
    @FXML
    private Label phrasesLabel;

    public void setLanguage(String language) {
        this.language = language;
        if (selectedLanguageLabel != null) {
            selectedLanguageLabel.setText("Selected Language: " + language);
        }
    }

    public void setCategory(String category) {
        this.category = category;
        if (selectedCategoryLabel != null) {
            selectedCategoryLabel.setText("Selected Category: " + category);
            loadPhrases();
        }
    }

    private void loadPhrases() {
        // Example phrases for demonstration with translations
        String[][] phrases = {
            {"Hello", "Goodbye", "Thank you", "Please", "How are you?", "Nice to meet you", "Good morning", "Good night", "Excuse me", "I'm sorry", "Can you help me?", "Where is the bathroom?", "I'm lost", "Call a doctor", "I need water"},
            {"Ciao", "Arrivederci", "Grazie", "Per favore", "Come stai?", "Piacere di conoscerti", "Buongiorno", "Buonanotte", "Mi scusi", "Mi dispiace", "Può aiutarmi?", "Dov'è il bagno?", "Mi sono perso", "Chiami un dottore", "Ho bisogno di acqua"},
            {"Γεια σας", "Αντίο", "Ευχαριστώ", "Παρακαλώ", "Πώς είσαι;", "Χαίρομαι που σε γνώρισα", "Καλημέρα", "Καληνύχτα", "Συγγνώμη", "Λυπάμαι", "Μπορείτε να με βοηθήσετε;", "Πού είναι η τουαλέτα;", "Έχω χαθεί", "Καλέστε έναν γιατρό", "Χρειάζομαι νερό"}
        };

        int languageIndex;
        switch (language) {
            case "English":
                languageIndex = 0;
                break;
            case "Italian":
                languageIndex = 1;
                break;
            case "Greek":
                languageIndex = 2;
                break;
            default:
                languageIndex = 0;
        }

        String[] selectedPhrases = phrases[languageIndex];
        String[] greekPhrases = phrases[2]; // Always use Greek translations

        // Display phrases based on category
        switch (category) {
            case "Greetings":
                phrasesLabel.setText("Phrases: " + selectedPhrases[0] + " (" + greekPhrases[0] + "), " + selectedPhrases[1] + " (" + greekPhrases[1] + "), " + selectedPhrases[4] + " (" + greekPhrases[4] + "), " + selectedPhrases[5] + " (" + greekPhrases[5] + "), " + selectedPhrases[6] + " (" + greekPhrases[6] + ")");
                break;
            case "Travel":
                phrasesLabel.setText("Phrases: " + selectedPhrases[2] + " (" + greekPhrases[2] + "), " + selectedPhrases[3] + " (" + greekPhrases[3] + "), " + selectedPhrases[8] + " (" + greekPhrases[8] + "), " + selectedPhrases[9] + " (" + greekPhrases[9] + "), " + selectedPhrases[10] + " (" + greekPhrases[10] + ")");
                break;
            case "Food":
                phrasesLabel.setText("Phrases: " + selectedPhrases[0] + " (" + greekPhrases[0] + "), " + selectedPhrases[2] + " (" + greekPhrases[2] + "), " + selectedPhrases[4] + " (" + greekPhrases[4] + "), " + selectedPhrases[5] + " (" + greekPhrases[5] + "), " + selectedPhrases[6] + " (" + greekPhrases[6] + ")");
                break;
            case "Emergency":
                phrasesLabel.setText("Phrases: " + selectedPhrases[1] + " (" + greekPhrases[1] + "), " + selectedPhrases[3] + " (" + greekPhrases[3] + "), " + selectedPhrases[11] + " (" + greekPhrases[11] + "), " + selectedPhrases[12] + " (" + greekPhrases[12] + "), " + selectedPhrases[13] + " (" + greekPhrases[13] + ")");
                break;
            default:
                phrasesLabel.setText("No phrases available for this category.");
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mavenproject1/primary.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}