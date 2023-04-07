package Java_Swing_Excercises;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Flappy_Bird extends JPanel implements ActionListener, KeyListener {
    private boolean jumping = false, started = false;
    private boolean scored = false;
    private Timer timer;
    private int birdX = 50, birdY = 250;
    private double birdSpeed = 1, pipeSpeed = 2;
    private int gapHeight = 200, pipeWidth = 80;
    private int topPipeHeight, bottomPipeHeight, topPipeY, bottomPipeY;
    private int score = 0;
    private ArrayList<Rectangle> pipes = new ArrayList<>();

    private boolean gameOver = false;
    private Rectangle bird = new Rectangle(birdX, birdY, 40, 40);
    private Rectangle topPipe = new Rectangle(600, 0, pipeWidth, 0);
    private Rectangle bottomPipe = new Rectangle(600, 0, pipeWidth, 0);
    private int groundY = 450;

    private int frameCount = 0;
    private static final int FPS = 60;
    private static final String FPS_TEXT = "FPS: ";
    private long startTime = System.currentTimeMillis();
    int jump_counter = 0;
    private static final int GROUND_SPEED = 3; // Define the ground speed as a constant value
    private int groundX = 0;

    public Flappy_Bird() {
        timer = new Timer(12, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private int getFPS() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return (int) (frameCount / (elapsedTime / 1000.0));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        // Draw the ground with diagonal bars
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 600, 500);
        g.setColor(Color.BLACK);
        g.fillRect(0, groundY + 1, 600, 50);
        g.setColor(Color.WHITE);
        for (int i = 0; i < 600; i += 40) {
            g.drawLine(i + groundX, groundY + 1, i + groundX + 20, groundY + 51);
            g.drawLine(i + groundX + 20, groundY + 51, i + groundX + 40, groundY + 1);
        }
    
        // Draw the bird, pipes, and score
        g.setColor(Color.YELLOW);
        g.fillRect(birdX + 50, birdY, 40, 40);
        g.setColor(Color.GREEN);
        g.fillRect(topPipe.x + 50, topPipe.y, pipeWidth, topPipe.height);
        g.fillRect(bottomPipe.x + 50, bottomPipe.y, pipeWidth, bottomPipe.height);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
        g.drawString(FPS_TEXT + getFPS(), 20, 40);
    
        // Draw game over message if necessary
        if (gameOver) {
            g.drawString("Game Over!", 250, 250);
        }
    
        // Move the ground to the left
        groundX -= GROUND_SPEED;
        if (groundX < -40) {
            groundX = 0;
        }
    }
    
    public void update() {
        if (gameOver) {
            return;
        }
        if (!started) {
            repaint();
            return;
        }
        frameCount++;
        topPipe.x -= pipeSpeed;
        bottomPipe.x -= pipeSpeed;
        if (jumping) {
            if (jump_counter++ == 10) {
                jump_counter = 0;
                jumping = false;
                birdSpeed = 1;
            }
            birdSpeed = -3.5;
            // birdSpeed -= 0.1;
        } else {
            birdSpeed += 0.2;
        }
        birdY += birdSpeed;
        if (topPipe.x <= -pipeWidth) {
            // System.out.println("DONE");
            int randGap = (int) (Math.random() * 200 + 100);
            topPipeHeight = (int) (Math.random() * (500 - gapHeight - randGap));
            bottomPipeHeight = 500 - gapHeight - topPipeHeight;
            topPipeY = 0;
            bottomPipeY = topPipeHeight + gapHeight;
            
            topPipe = new Rectangle(600, topPipeY, pipeWidth, topPipeHeight);
            bottomPipe = new Rectangle(600, bottomPipeY, pipeWidth, bottomPipeHeight);
            scored = false;
        }
        if (Math.abs(topPipe.x - birdX + bird.height) + 40 < pipeWidth) {
            if ((birdY <= topPipe.height || birdY + bird.height >= bottomPipe.y) && bottomPipe.height != 0) {
                gameOver = true;

            }
        } else if (birdY >= groundY - bird.height) {
            birdY = groundY - bird.height;
            gameOver = true;
        }
        // Check for scoring
        if (!scored && birdX > topPipe.x + pipeWidth) {
            pipeSpeed += 0.01;
            score++;
            scored = true;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        Flappy_Bird game = new Flappy_Bird();

        frame.add(game);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE && !gameOver && !jumping) {
            started = true;
            jumping = true;
        } else if (key == KeyEvent.VK_ENTER && gameOver) {
            started = false;
            gameOver = false;
            birdX = 50;
            birdY = 250;
            birdSpeed = 0;
            topPipe = new Rectangle(600, 0, pipeWidth, 0);
            bottomPipe = new Rectangle(600, 0, pipeWidth, 0);
            score = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }
    
    private void restartGame() {
        gameOver = false;
        birdX = 50;
        birdY = 250;
        birdSpeed = 0;
        topPipe = new Rectangle(600, 0, pipeWidth, 0);
        bottomPipe = new Rectangle(600, 0, pipeWidth, 0);
        score = 0;
    }
    
}
