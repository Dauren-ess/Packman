package sample;

import java.awt.Toolkit;
import java.io.*;
import java.util.Scanner;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class Map extends Pane {

    private int unit;
    private int size;
    private int[][] map;
    private Position start;

    public Map(String fileMap) throws Exception {
        File file = new File(fileMap);
        setPrefSize(400,400);

        try (Scanner in = new Scanner(file)) {
            double height = 400;
            size = in.nextInt();
            unit = 50;
            map = new int[size][size];
            for (int i = 0; i < size; i++) {
                in.nextLine();
                for (int j = 0; j < size; j++) {
                    map[i][j] = in.nextInt();
                    Rectangle rectangle = new Rectangle(j * unit, i * unit, 50, 50);
                    if (map[i][j] == 1) {
                        rectangle.setFill(Color.BLACK);
                        rectangle.setStroke(Color.BLACK);
                    }
                    if (map[i][j] == 0) {
                        rectangle.setFill(Color.WHITE);
                        rectangle.setStroke(Color.BLACK);
                    }
                    if (map[i][j] == 2){
                        rectangle.setFill(Color.WHITE);
                        rectangle.setStroke(Color.BLACK);
                    }
                    if (map[i][j] == 2) {
                        start = new Position(j, i);
                    }

                    getChildren().add(rectangle);
                }
            }
        }
    }

    public int getUnit() {
        return unit;
    }

    public int getSize() {
        return size;
    }

    public int[][] getValueAt() {
        return map;
    }

    public Position getStartPosition() {
        return start;
    }
}
