package fm.bernardo.muehlespiel;

import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.Optional;

final class Player {

    String color;
    String name;
    final ArrayList<Field> occupied = new ArrayList<>();

    final void setName(final String spieler) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Namensdefinition");
        dialog.setHeaderText(spieler);
        dialog.setContentText("Bitte geben Sie einen Namen ein:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if (result.get().equals("")) {
                setName(spieler);
                return;
            }
            this.name = result.get();
        } else {
            System.exit(0);
        }

    }

    Player (final String color) {

        this.color = color;

    }

}
