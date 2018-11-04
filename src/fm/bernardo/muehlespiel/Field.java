package fm.bernardo.muehlespiel;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

final class Field extends Button {

    String owner = null;
    int id;

    final void changeColor(final String color) {
        this.setStyle("-fx-background-color: " + color);
    }

    Field(final int id) {
        this.id = id;
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Double.MAX_VALUE);
        this.setShape(new Circle(1));
    }

}
