package com.example.mavenproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private ComboBox<String> languageCombo;

    @FXML
    private ComboBox<String> categoryCombo;

    @FXML
    private Button continueButton;

    @FXML
    public void initialize() {
        languageCombo.getItems().addAll("English", "Italian", "Greek");
        categoryCombo.getItems().addAll("Greetings", "Travel", "Food", "Emergency");
    }

    @FXML
    private void handleContinue(ActionEvent event) {
              Alert alert = new Alert(AlertType.WARNING);
     if (languageCombo.getValue() == null || categoryCombo.getValue() == null) {
     alert.setTitle("Η Γλώσσα και η Κατηγορία δεν μπορούν να είναι κενές");
     alert.setHeaderText(null);
     alert.setContentText("Επέλεξε Γλώσσα και Κατηγορία ");
     alert.showAndWait();} else {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mavenproject1/secondary.fxml"));
            Parent root = loader.load();

            // Pass selections to secondary controller
            SecondaryController controller = loader.getController();
            controller.setLanguage(languageCombo.getValue());
            controller.setCategory(categoryCombo.getValue());

            Stage stage = (Stage) continueButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }
    @FXML
    private void handleQuiz(ActionEvent event) {
       Alert alert = new Alert(AlertType.WARNING);
     if (languageCombo.getValue() == null || categoryCombo.getValue() == null) {
     alert.setTitle("Η Γλώσσα και η Κατηγορία δεν μπορούν να είναι κενές");
     alert.setHeaderText(null);
     alert.setContentText("Επέλεξε Γλώσσα και Κατηγορία ");
     alert.showAndWait();} else {
     
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mavenproject1/quiz.fxml"));
            Parent root = loader.load();

            // Pass selections to quiz controller
            QuizController controller = loader.getController();
            controller.setLanguage(languageCombo.getValue());
            controller.setCategory(categoryCombo.getValue());

            Stage stage = (Stage) continueButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }
}