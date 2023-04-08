package Java_Swing_Excercises.FlappyBird;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    Graphics2D g2;
    private ArrayList<Pipe> pipes;
    private Pipe ContinueAnimation;
    private int birdY;
    private int score;
    private boolean started;
    private boolean gameOver;

    private final int PIPE_WIDTH = 80;
    private final int GROUND_Y = 450;
    private final int BIRD_X = 100;
    private Font FONT;
    private final Font ARIAL_BOLD = new Font("Arial", Font.BOLD, 50);
    private final Font ARIAL_ITALIC = new Font("Arial", Font.ITALIC, 25);
    private int groundX;

    public GamePanel(ArrayList<Pipe> pipes, Pipe ContinueAnimation, int birdY, int score, boolean started, boolean gameOver, int groundX, Font FONT) {
        this.FONT = FONT;
        refresh(pipes, ContinueAnimation, birdY, score, started, gameOver, groundX);
    }
    public void Component(Graphics2D g2) {
        
        drawBackground(g2);
        drawPipes(g2);
        drawGround(g2);
        drawBird(g2);
        drawScore(g2);
        drawGameStatus(g2);
    }

    public void refresh(ArrayList<Pipe> pipes, Pipe ContinueAnimation, int birdY, int score, boolean started, boolean gameOver, int groundX) {
        this.pipes = pipes;
        this.ContinueAnimation = ContinueAnimation;
        this.birdY = birdY;
        this.score = score;
        this.started = started;
        this.gameOver = gameOver;
        this.groundX = groundX;
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, 600, 500);
    }

    private void drawPipes(Graphics2D g2) {
        for (Pipe pipe : pipes) {
            Rectangle topPipe = pipe.getTop();
            Rectangle bottomPipe = pipe.getBottom();
            int x = pipe.x() + 50;
            g2.setColor(Color.GREEN);
            g2.fillRect(x, topPipe.y, PIPE_WIDTH, topPipe.height);
            g2.fillRect(x, bottomPipe.y, PIPE_WIDTH, bottomPipe.height);
    
            g2.setColor(Color.BLACK);
            g2.drawRect(x, topPipe.y - 1, PIPE_WIDTH, topPipe.height);
            g2.drawRect(x, bottomPipe.y, PIPE_WIDTH, bottomPipe.height);
        }
    
        // Draw continue animation pipe
        if (ContinueAnimation != null) {
            Rectangle topPipe = ContinueAnimation.getTop();
            Rectangle bottomPipe = ContinueAnimation.getBottom();
            int x = ContinueAnimation.x() + 50;
    
            g2.setColor(Color.GREEN);
            g2.fillRect(x, topPipe.y, PIPE_WIDTH, topPipe.height);
            g2.fillRect(x, bottomPipe.y, PIPE_WIDTH, bottomPipe.height);
    
            g2.setColor(Color.BLACK);
            g2.drawRect(x, topPipe.y - 1, PIPE_WIDTH, topPipe.height);
            g2.drawRect(x, bottomPipe.y, PIPE_WIDTH, bottomPipe.height);
        }
    }

    private void drawGround(Graphics2D g2) {
        g2.setColor(new Color(255, 238, 153));
        g2.fillRect(0, GROUND_Y + 1, 600, 50);
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.GREEN);
        g2.fillRect(0, GROUND_Y, 600, 15);
    
        g2.setColor(new Color(17, 102, 0));
        for (int i = 0; i < 600; i += 20) {
            g2.drawLine(i + groundX, GROUND_Y + 12, i + groundX + 10, GROUND_Y + 1);
        }
    
        g2.fillRect(0, GROUND_Y + 13, 600, 5);
        g2.setColor(Color.BLACK);
        g2.fillRect(0, GROUND_Y - 5, 600, 7);
    }

    private void drawBird(Graphics2D g2) {
        g2.setColor(Color.YELLOW);
        g2.fillRect(BIRD_X + 50, birdY, 40, 40);
    
        g2.setColor(Color.BLACK);
    }
    private void drawScore(Graphics2D g2) {
        if (started) {
            g2.setFont(FONT);
            g2.drawString("" + score, 250, 100);
        } else {
            g2.setFont(ARIAL_ITALIC);
            g2.drawString("Press SPACE or LEFT CLICK to start", 50, 250);
        }
    }
    private void drawGameStatus(Graphics2D g2) {
        if (gameOver) {
            g2.setFont(ARIAL_BOLD);
            g2.drawString("Game Over!", 100, 225);
            g2.setFont(ARIAL_ITALIC);
            g2.drawString("Press ENTER to play again", 100, 250);
        }
    }
}

