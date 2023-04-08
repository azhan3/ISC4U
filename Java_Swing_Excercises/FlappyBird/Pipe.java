package Java_Swing_Excercises.FlappyBird;

import java.awt.*;

public class Pipe {
    private final int BIRD_X = 50, GAP_HEIGHT = 175, PIPE_WIDTH = 80;
    private int topPipeHeight, bottomPipeHeight, topPipeY, bottomPipeY;

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
    public Rectangle getTop() {
        return topPipe;
    }
    public Rectangle getBottom() {
        return bottomPipe;
    }
    public int x() {
        return topPipe.x;
    }
    
    public void adjustPipe(double val) {
        pipe[0].x -= val;
        pipe[1].x -= val;

    }
    public Boolean intersects(int birdY, Rectangle bird) {
        if (Math.abs(topPipe.x - (BIRD_X + (PIPE_WIDTH/2))) - (PIPE_WIDTH/2) - 10 <= 0) {
            if (birdY <= topPipe.height || birdY + bird.height >= bottomPipe.y) {
                return true;
            }
        } 
        return false;
    }
}
