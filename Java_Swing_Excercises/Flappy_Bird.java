package Java_Swing_Excercises;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Flappy_Bird extends JPanel implements ActionListener, KeyListener {
    private boolean jumping = false;
    private boolean scored = false;

    private Timer timer;
    private int birdX = 50, birdY = 250, birdSpeed = 0;
    private int gapHeight = 150, pipeWidth = 80, pipeSpeed = 4;
    private int topPipeHeight, bottomPipeHeight, topPipeY, bottomPipeY;
    private int score = 0;
    private boolean gameOver = false;
    private Rectangle bird = new Rectangle(birdX, birdY, 20, 20);
    private Rectangle topPipe = new Rectangle(600, 0, pipeWidth, 0);
    private Rectangle bottomPipe = new Rectangle(600, 0, pipeWidth, 0);

    public Flappy_Bird() {
        timer = new Timer(20, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 600, 500);
        g.setColor(Color.GREEN);
        g.fillRect(birdX + 50, birdY, 20, 20);
        g.setColor(Color.RED);
        g.fillRect(topPipe.x + 50, topPipe.y, pipeWidth, topPipe.height);
        g.fillRect(bottomPipe.x + 50, bottomPipe.y, pipeWidth, bottomPipe.height);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
        if (gameOver) {
            g.drawString("Game Over!", 250, 250);
        }
    }

    public void update() {
        birdY += birdSpeed;
        topPipe.x -= pipeSpeed;
        bottomPipe.x -= pipeSpeed;
        if (topPipe.x <= -pipeWidth) {
            int randGap = (int) (Math.random() * 200 + 100);
            topPipeHeight = (int) (Math.random() * (500 - gapHeight - randGap));
            bottomPipeHeight = 500 - gapHeight - topPipeHeight;
            topPipeY = 0;
            bottomPipeY = topPipeHeight + gapHeight;
            topPipe = new Rectangle(600, topPipeY, pipeWidth, topPipeHeight);
            bottomPipe = new Rectangle(600, bottomPipeY, pipeWidth, bottomPipeHeight);
            scored = false;
        }
        if (birdY >= 480 || birdY <= 0 || bird.intersects(topPipe) || bird.intersects(bottomPipe)) {
            gameOver = true;
        }
        if (topPipe.x == birdX && !scored) {
            score++;
            scored = true;
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        Flappy_Bird game = new Flappy_Bird();
        frame.add(game);
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping) {
            jumping = true;
            birdSpeed = -10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jumping = false;
            birdSpeed = 5;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
