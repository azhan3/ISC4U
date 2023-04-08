package Java_Swing_Excercises.FlappyBird;

import java.awt.*;

public class Pipe {
    private final int BIRD_X = 50, GAP_HEIGHT = 175, PIPE_WIDTH = 80, GROUND_Y = 450;
    private int topPipeHeight, bottomPipeHeight, topPipeY, bottomPipeY, groundX;

    Rectangle[] pipe;
    Rectangle topPipe, bottomPipe;
    
    public Pipe(int pos) {
        int randGap = (int) (Math.random() * 200 + 100);
        topPipeHeight = (int) (Math.random() * (500 - GAP_HEIGHT - randGap));
        bottomPipeHeight = 500 - GAP_HEIGHT - topPipeHeight;
        topPipeY = 0;
        bottomPipeY = topPipeHeight + GAP_HEIGHT;
        topPipe = new Rectangle(pos, topPipeY, PIPE_WIDTH, topPipeHeight);
        bottomPipe = new Rectangle(pos, bottomPipeY, PIPE_WIDTH, bottomPipeHeight);
        pipe = new Rectangle[] { topPipe, bottomPipe };
    }

    public Boolean intersects(int birdY, Rectangle bird) {
        if (Math.abs(topPipe.x - BIRD_X + bird.height) - PIPE_WIDTH < 0) {
            if (birdY <= topPipe.height || birdY + bird.height >= bottomPipe.y) {
                return true;
            }
        }
        return false;
    }
}
