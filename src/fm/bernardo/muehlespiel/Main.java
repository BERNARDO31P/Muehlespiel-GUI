package fm.bernardo.muehlespiel;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public final class Main extends Application {

    @Override
    public final void start(final Stage mainWindow) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Informations Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Dieses Spiel wurde mit viel Liebe programmiert.\n© 2018 BERNARDO.FM - Alle Rechte vorbehalten.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() != ButtonType.OK) {
            System.exit(0);
        }

        mainWindow.setTitle("Mühlespiel");

        PlayField playField = new PlayField();

        mainWindow.setScene(playField.scene);
        mainWindow.setMinWidth(275);
        mainWindow.setMinHeight(300);
        mainWindow.setMaxWidth(450);
        mainWindow.setMaxHeight(475);
        mainWindow.show();

        mainWindow.widthProperty().addListener((obs, oldVal, newVal) -> {
            mainWindow.setHeight(newVal.doubleValue() + 25);
        });

        mainWindow.heightProperty().addListener((obs, oldVal, newVal) -> {
            mainWindow.setWidth(newVal.doubleValue() - 25);
        });

        mainWindow.setOnCloseRequest(e -> System.exit(0));

    }

    public static void main(String[] args) {
        launch(args);
    }

}
