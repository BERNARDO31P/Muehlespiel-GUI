package fm.bernardo.muehlespiel;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

final class Player {

    // Eigenschaften vom Spieler
    String color;
    String name;
    int toPlace = 9;

    // Konstrukteur vom Spieler, welcher die Farbe setzt
    Player(final String color) {
        this.color = color;
    }

    // Methode zur Setzung vom Spielername
    final void setName(final String spieler) {

        // Kreation von einem Eingabedialog
        final TextInputDialog dialog = new TextInputDialog();

        // Setzung der Dialogeigenschaften
        dialog.setTitle("Namensdefinition");
        dialog.setHeaderText(spieler);
        dialog.setContentText("Bitte geben Sie einen Namen ein:");

        // Abfangen der Benutzereingabe
        final Optional<String> result = dialog.showAndWait();

        // Überprüfung der Eingabe
        if (result.isPresent()) {
            if (result.get().equals("")) {
                setName(spieler);
                return;
            }
            this.name = result.get();
        } else
            System.exit(0);
    }

}
