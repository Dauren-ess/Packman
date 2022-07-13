package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyCode;


public class MyPlayer implements Player {

    private Circle ball;
    private Map map;
    private Position position;

    public MyPlayer(Map map) {
        this.map = map;
        position = map.getStartPosition();

        ball = new Circle(25);
        ball.setFill(Color.RED);

        map.getChildren().add(ball);
        move(KeyCode.T);
    }

    public void move(KeyCode code) {
        switch (code) {
            case RIGHT: moveRight(); break;
            case LEFT: moveLeft(); break;
            case UP: moveUp(); break;
            case DOWN: moveDown(); break;
            default:
        }

        ball.setCenterX(position.getX() * map.getUnit() + map.getUnit() / 2);
        ball.setCenterY(position.getY() * map.getUnit() + map.getUnit() / 2);
    }

    @Override
    public void moveLeft() {
        int x = position.getX();
        if (x - 1 >= 0 && map.getValueAt()[position.getY()][x - 1] != 1) {
            position.setX(x - 1);
        }
    }

    @Override
    public void moveRight() {
        int x = position.getX();
        if (x + 1 < map.getSize() && map.getValueAt()[position.getY()][x + 1] != 1) {
            position.setX(x + 1);
        }
    }

    public void moveUp() {
        int y = position.getY();
        if (y - 1 >= 0 && map.getValueAt()[y - 1][position.getX()] != 1) {
            position.setY(y - 1);
        }
    }

    @Override
    public void moveDown() {
        int y = position.getY();
        if (y + 1 < map.getSize() && map.getValueAt()[y + 1][position.getX()] != 1) {
            position.setY(y + 1);
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

}