package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game extends Application {
    private Map map;
    private Player player;
    private Food food;
    private Group group = new Group();

    public void start(Stage stage) throws Exception {

        stage.setScene(new Scene(group));
        game();
        stage.setTitle("Pacman");
        stage.show();
    }

    private void game() {
        try {
            map = new Map("map1.txt");
            player = new MyPlayer(map);
            food = new Food(map, player);
            group.getScene().addEventHandler(KeyEvent.KEY_RELEASED, key -> {
                player.move(key.getCode());
            });
            group.getScene().getWindow().setWidth(400);
            group.getScene().getWindow().setHeight(421);
            group.getChildren().add(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        launch(args);
    }
}
