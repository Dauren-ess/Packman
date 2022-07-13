package sample;

import javafx.scene.input.KeyCode;

public interface Player {
    public void move(KeyCode keyCode);

    public void moveRight();

    public void moveLeft();

    public void moveUp();

    public void moveDown();

    public Position getPosition();
}

