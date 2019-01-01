package fm.bernardo.muehlespiel.classes;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

// Übernahme alle Methoden und Eigenschaften von einem Knopf
final class Field extends Button {

    // Eigenschaften vom Feld
    String owner;
    int id;

    // Methode zur Anpassung der Farbe
    final void changeInfo(final String color, final String owner) {
        this.setStyle("-fx-background-color: " + color);
        this.owner = owner;
    }

    // Konstrukteur der Feldes
    Field(final int id) {
        this.id = id;

        // Setzung auf die maximale Grösse, welche möglich ist
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Double.MAX_VALUE);

        this.setStyle("-fx-background-color: none");

        // Setzung der Form zu einem Kreis
        this.setShape(new Circle(1));
    }

}
