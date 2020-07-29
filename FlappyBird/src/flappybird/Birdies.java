package flappybird;

import java.awt.*;

abstract public class Birdies {

    private Color birdColor;
    private Rectangle bird;


    public void createBirds(Rectangle bird, Color birdColor) {
        this.bird = bird;
        this.birdColor = birdColor;

    }

    public void setBirdColor(Color newBirdColor) {
        birdColor = newBirdColor;

    }

    public void setBirdSize(Rectangle newBirdSize) {
        Rectangle birdSize = newBirdSize;
    }
}
