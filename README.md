# AppGiaGlwsses – JavaFX Educational Application

## Περιγραφή
Η εφαρμογή αναπτύχθηκε στο μάθημα
«Προγραμματισμός Διεπαφή Χρήστη» (Εαρινό 2024–2025).

Στόχος:
Εκμάθηση βασικών φράσεων μέσω επιλογής:
- Γλώσσας
- Κατηγορίας
- Quiz αξιολόγησης

## Τεχνολογίες
- Java 21
- JavaFX
- Maven
- FXML
- VS Code

## Λειτουργίες
✔ Επιλογή γλώσσας  
✔ Επιλογή κατηγορίας  
✔ Προβολή περιεχομένου  
✔ Quiz γνώσεων  

AppGiaGlwsses/
│
├── README.md
├── Report.docx
├── pom.xml
├── .gitignore
├── screenshots/
│   ├── home.png
│   ├── quiz.png
│   └── results.png
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/mavenproject1/
│   │   │       ├── App.java
│   │   │       ├── PrimaryController.java
│   │   │       ├── SecondaryController.java
│   │   │       └── QuizController.java
│   │   │
│   │   └── resources/
│   │       └── com/example/mavenproject1/
│   │           ├── primary.fxml
│   │           ├── secondary.fxml
│   │           └── quiz.fxml
│
└── src/test/

## Εκτέλεση

```bash
mvn clean javafx:run
