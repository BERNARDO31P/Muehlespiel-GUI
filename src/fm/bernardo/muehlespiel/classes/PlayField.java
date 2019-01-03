package fm.bernardo.muehlespiel.classes;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public final class PlayField {

    // Array welches Definitiert, welche Felder spielbar sind
    private final int[] playable = {0, 3, 6, 8, 10, 12, 16, 17, 18, 21, 22, 23, 25, 26, 27, 30, 31, 32, 36, 38, 40, 42, 45, 48};

    // Eigenschaften vom Spielfeld sowie Generation von nötigen Instanzvariablen
    public Scene scene;
    private final GridPane playField = new GridPane();
    private final ArrayList<Player> players = new ArrayList<>();
    private int playing;
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final Map<Integer, Field> fields = new HashMap<>();

    // Globale Variabeln als Information für die "fieldValidation" Funktion
    private final Map<Integer, Map<String, Object>> possibilities = new HashMap<Integer, Map<String, Object>>() {
        {
            put(0, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{3, 21});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{3, 6});
                            add(new int[]{21, 42});
                        }
                    });
                }
            });
            put(3, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{0, 6, 10});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{0, 6});
                            add(new int[]{10, 17});
                        }
                    });
                }
            });
            put(6, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{3, 27});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{0, 3});
                            add(new int[]{27, 48});
                        }
                    });
                }
            });
            put(8, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{10, 22});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{10, 12});
                            add(new int[]{22, 36});
                        }
                    });
                }
            });
            put(10, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{3, 8, 12, 17});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{8, 12});
                            add(new int[]{3, 17});
                        }
                    });
                }
            });
            put(12, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{10, 26});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{8, 10});
                            add(new int[]{26, 40});
                        }
                    });
                }
            });
            put(16, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{17, 23});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{17, 18});
                            add(new int[]{23, 30});
                        }
                    });
                }
            });
            put(17, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{10, 16, 18});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{16, 18});
                            add(new int[]{3, 10});
                        }
                    });
                }
            });
            put(18, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{17, 25});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{16, 17});
                            add(new int[]{25, 32});
                        }
                    });
                }
            });
            put(21, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{0, 22, 42});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{0, 42});
                            add(new int[]{22, 23});
                        }
                    });
                }
            });
            put(22, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{8, 21, 23, 36});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{21, 23});
                            add(new int[]{8, 36});
                        }
                    });
                }
            });
            put(23, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{16, 22, 30});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{16, 30});
                            add(new int[]{21, 22});
                        }
                    });
                }
            });
            put(25, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{18, 26, 32});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{18, 32});
                            add(new int[]{26, 27});
                        }
                    });
                }
            });
            put(26, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{12, 25, 27, 40});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{25, 27});
                            add(new int[]{12, 40});
                        }
                    });
                }
            });
            put(27, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{6, 26, 48});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{25, 26});
                            add(new int[]{6, 48});
                        }
                    });
                }
            });
            put(30, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{23, 31});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{16, 23});
                            add(new int[]{31, 32});
                        }
                    });
                }
            });
            put(31, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{30, 32, 38});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{30, 32});
                            add(new int[]{38, 45});
                        }
                    });
                }
            });
            put(32, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{25, 31});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{30, 31});
                            add(new int[]{18, 25});
                        }
                    });
                }
            });
            put(36, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{22, 38});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{8, 22});
                            add(new int[]{38, 40});
                        }
                    });
                }
            });
            put(38, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{31, 36, 40, 45});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{36, 40});
                            add(new int[]{31, 45});
                        }
                    });
                }
            });
            put(40, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{26, 38});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{12, 26});
                            add(new int[]{36, 38});
                        }
                    });
                }
            });
            put(42, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{21, 45});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{0, 21});
                            add(new int[]{45, 48});
                        }
                    });
                }
            });
            put(45, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{38, 42, 48});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{42, 48});
                            add(new int[]{31, 36});
                        }
                    });
                }
            });
            put(48, new HashMap<String, Object>() {
                {
                    put("neighbours", new int[]{27, 45});
                    put("mills", new ArrayList<int[]>() {
                        {
                            add(new int[]{6, 27});
                            add(new int[]{42, 45});
                        }
                    });
                }
            });
        }
    };
    private boolean wantToMove = false, wasMill = false;
    private Field toChange;

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

    // Konstrukteur vom Spielfeld
    public PlayField() {

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
        this.scene = new Scene(this.playField, 700, 700);

        // Setzung von der CSS Stylesheet
        this.scene.getStylesheets().add(this.getClass().getResource("../css/main.css").toExternalForm());

        // Aufruf von der Nächsten Klassenmethode, nachdem alles beendet ist
        generatePlayField();
    }

    // Onclick Event Methodendefinition
    private void fieldValidation(final ActionEvent actionEvent) {

        // Geklicktes Objekt abfangen
        final Field field = (Field) actionEvent.getSource();

        // Abfrage ob das Feld bereits belegt ist
        if (field.owner == null) {

            if (this.wantToMove) {
                this.wantToMove = false;

                if (IntStream.of((int[]) this.possibilities.get(this.toChange.id).get("neighbours")).anyMatch(x -> x == field.id)) {
                    this.toChange.changeInfo("none", null);
                    this.fields.put(this.toChange.id, this.toChange);
                    field.changeInfo(players.get(playing).color, players.get(playing).name);
                } else {
                    alert.setContentText("Sie können das Feld nicht hierhin verschieben.");
                    alert.showAndWait();
                    return;
                }

                // Abfrage ob der spielende Spieler bereits alle Felder aufgebraucht hat
            } else if (players.get(playing).toPlace != 0) {

                // Änderung der Feldeigenschaften
                field.changeInfo(players.get(playing).color, players.get(playing).name);
                final Player player = players.get(playing);
                player.toPlace--;
                players.set(playing, player);
            } else {
                alert.setContentText("Sie haben bereits alle neun Felder verbraucht. Sie müssen Felder verschieben.");
                alert.showAndWait();
                return;
            }

            this.fields.put(field.id, field);

            boolean isMill = false;
            for (int[] mill : (ArrayList<int[]>) this.possibilities.get(field.id).get("mills")) {
                for (int checkField : mill) {
                    try {
                        if (!this.fields.get(checkField).owner.equals(field.owner)) {
                            throw new Exception();
                        }
                        isMill = true;
                    } catch (Exception e) {
                        isMill = false;
                        break;
                    }
                }
                if (isMill) {
                    alert.setContentText("Sie dürfen nun ein Feld von Ihrem Gegner entfernen.");
                    alert.showAndWait();
                    this.wasMill = true;
                    return;
                }
            }

        } else if (field.owner.equals(players.get(playing).name) && players.get(playing).toPlace == 0 && !this.wantToMove) {
            this.wantToMove = true;
            this.toChange = field;
            return;
        } else {
            if (this.wasMill) {
                this.wasMill = false;
                field.changeInfo("none", null);
            } else {
                alert.setContentText("Dieses Feld ist von " + field.owner + " besetzt.");
                alert.showAndWait();
                return;
            }
        }

        // Setzung vom spielender Spieler
        if (playing == 0) playing = 1;
        else playing = 0;

    }

    // Generierung von den Spielfeldern
    private void generateFields() {

        // Schleife zum Generieren von den Feldern
        for (int length = 0; length < 7; length++)
            for (int width = 0; width < 7; width++) {

                // Formel zum Berrechnen von den Feld IDs
                final int id = 7 * length + width;

                // Abfrage ob die generierte ID zu den spielbaren Feldern gehört
                if (Arrays.stream(this.playable).anyMatch(i -> i == id)) {

                    // Kreation von einem Feld
                    final Field field = new Field(id);

                    // Definition vom onclick Event
                    field.setOnAction(this::fieldValidation);

                    // Hinzufügen vom Feld zum Spielfeld
                    this.playField.add(field, width, length);

                    this.fields.put(id, field);
                }
            }

    }

}
