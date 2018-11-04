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

    Scene scene;
    private final GridPane playField = new GridPane();
    private final ArrayList<Player> players = new ArrayList<>();
    private int playing;

    private void generatePlayField() {

        for (int width = 0; width < 7; width++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setHalignment(HPos.CENTER);
            column.setPercentWidth(100);
            this.playField.getColumnConstraints().add(column);
        }
        for (int length = 0; length < 7; length++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100);
            this.playField.getRowConstraints().add(row);
        }
        this.generateFields();

    }

    private void fieldValidation(ActionEvent actionEvent) {

        Field field = (Field) actionEvent.getSource();
        if (field.owner == null) {
            field.owner = players.get(playing).name;
            field.changeColor(players.get(playing).color);
            Player player = players.get(playing);
            player.occupied.add(field);
            players.set(playing, player);

            if (playing == 0) playing = 1;
            else playing = 0;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informations Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Dieses Feld ist von " + field.owner + " besetzt.");
            alert.showAndWait();
        }

    }

    private void generateFields() {

        final int[] playable = {0, 3, 6, 8, 10, 12, 16, 17, 18, 21, 22, 23, 25, 26, 27, 30, 31, 32, 36, 38, 40, 42, 45, 48};
        for (int length = 0; length < 7; length++)
            for (int width = 0; width < 7; width++) {
                final int id = 7 * length + width;

                if (Arrays.stream(playable).anyMatch(i -> i == id)) {
                    Field field = new Field(id);
                    field.setOnAction(this::fieldValidation);
                    this.playField.add(field, width, length);
                }
            }

    }

    PlayField() {

        this.playField.setId("mainWindow");

        Player player1 = new Player("red");
        player1.setName("Spieler1");
        Player player2 = new Player("blue");
        player2.setName("Spieler2");

        players.addAll(Arrays.asList(player1, player2));

        this.playField.setHgap(15);
        this.playField.setVgap(15);

        this.scene = new Scene(this.playField, 275, 300);
        this.scene.getStylesheets().add(this.getClass().getResource("./css/main.css").toExternalForm());
        generatePlayField();
    }

}
