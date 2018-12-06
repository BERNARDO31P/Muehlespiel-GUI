package fm.bernardo.muehlespiel;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.Arrays;

final class PlayField {

    // Eigenschaften vom Spielfeld sowie Generation von nötigen Instanzvariablen
    Scene scene;
    private final GridPane playField = new GridPane();
    private final ArrayList<Player> players = new ArrayList<>();
    private int playing;
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);


    // Methode zum Generieren vom Spielfeld (Reihen und Spalten)
    private void generatePlayField() {

        // For Schleife zum Generieren von Spalten
        for (int width = 0; width < 7; width++) {
            final ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.CENTER);
            column.setPercentWidth(100);
            this.playField.getColumnConstraints().add(column);
        }

        // For Schleife zum Generieren von Reihen
        for (int length = 0; length < 7; length++) {
            final RowConstraints row = new RowConstraints();
            row.setPercentHeight(100);
            this.playField.getRowConstraints().add(row);
        }

        // Aufruf von der Nächsten Klassenmethode, nachdem alles beendet ist
        this.generateFields();

    }

    // Onclick Event Methodendefinition
    private void fieldValidation(final ActionEvent actionEvent) {

        // Geklicktes Objekt abfangen
        final Field field = (Field) actionEvent.getSource();

        // Abfrage ob das Feld bereits belegt ist
        if (field.owner == null) {

            // Abfrage ob der spielende Spieler bereits alle Felder aufgebraucht hat
            if (players.get(playing).occupied.size() < 9) {

                // Änderung der Feldeigenschaften
                field.owner = players.get(playing).name;
                field.changeColor(players.get(playing).color);
                final Player player = players.get(playing);
                player.occupied.add(field);
                players.set(playing, player);
            } else {
                alert.setContentText("Sie haben bereits alle neun Felder verbraucht.");
                alert.showAndWait();
            }

            // Setzung vom spielender Spieler
            if (playing == 0) playing = 1;
            else playing = 0;
        } else {
            alert.setContentText("Dieses Feld ist von " + field.owner + " besetzt.");
            alert.showAndWait();
        }

    }

    // Generierung von den Spielfeldern
    private void generateFields() {

        // Array welches Definitiert, welche Felder spielbar sind
        final int[] playable = {0, 3, 6, 8, 10, 12, 16, 17, 18, 21, 22, 23, 25, 26, 27, 30, 31, 32, 36, 38, 40, 42, 45, 48};

        // Schleife zum Generieren von den Feldern
        for (int length = 0; length < 7; length++)
            for (int width = 0; width < 7; width++) {

                // Formel zum Berrechnen von den Feld IDs (Später nötig für KN03
                final int id = 7 * length + width;

                // Abfrage ob die generierte ID zu den spielbaren Feldern gehört
                if (Arrays.stream(playable).anyMatch(i -> i == id)) {

                    // Kreation von einem Feld
                    final Field field = new Field(id);

                    // Definition vom onclick Event
                    field.setOnAction(this::fieldValidation);

                    // Hinzufügen vom Feld zum Spielfeld
                    this.playField.add(field, width, length);
                }
            }

    }

    // Konstrukteur vom Spielfeld
    PlayField() {

        // Definition von
        this.playField.setId("mainWindow");
        this.alert.setTitle("Informations Dialog");
        this.alert.setHeaderText(null);

        // Kreation von zwei Spielern
        final Player player1 = new Player("black");
        player1.setName("Spieler1");
        final Player player2 = new Player("gray");
        player2.setName("Spieler2");

        // Hinzufügen von den Spielern zum Array
        this.players.addAll(Arrays.asList(player1, player2));

        // Definition vom Abstand zwischen den Feldern
        this.playField.setHgap(15);
        this.playField.setVgap(15);

        // Kreation von einer Fläche in der Objekte hinzugefügt werden können
        this.scene = new Scene(this.playField, 300, 300);

        // Setzung von der CSS Stylesheet
        this.scene.getStylesheets().add(this.getClass().getResource("css/main.css").toExternalForm());

        // Aufruf von der Nächsten Klassenmethode, nachdem alles beendet ist
        generatePlayField();
    }

}
