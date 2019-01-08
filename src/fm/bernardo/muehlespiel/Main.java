package fm.bernardo.muehlespiel;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public final class Main extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    // Überschreiben der standard Methode von Java
    @Override
    public final void start(final Stage mainWindow) {

        // Erstellung von einem Dialog
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Informations Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Dieses Spiel wurde mit viel Liebe programmiert.\n© 2018 BERNARDO.FM - Alle Rechte vorbehalten.");

        // Abfangen von der Benutzerantwort
        final Optional<ButtonType> result = alert.showAndWait();

        // Prüfung von der Benutzerantwort
        if (result.isPresent() && result.get() != ButtonType.OK)
            System.exit(0);

        // Erstellung von einem Spielfeld
        final PlayField playField = new PlayField();

        // Definition der Fenstereigenschaften
        mainWindow.setTitle("Mühlespiel");
        mainWindow.setScene(playField.scene);
        mainWindow.setOnCloseRequest(e -> System.exit(0));
        mainWindow.setMinWidth(475);
        mainWindow.setMinHeight(500);
        mainWindow.setMaxWidth(1050);
        mainWindow.setMaxHeight(1075);
        mainWindow.show();

        // Berrechnung und Setzung der Fenstergrösse, damit die Proportionen beibehalten bleiben
        mainWindow.widthProperty().addListener((obs, oldVal, newVal) -> mainWindow.setHeight(newVal.doubleValue() + 25));
        mainWindow.heightProperty().addListener((obs, oldVal, newVal) -> mainWindow.setWidth(newVal.doubleValue() - 25));

    }

}
