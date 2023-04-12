package Java_Swing_Excercises.FlappyBird;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class Flappy_Bird extends JPanel implements ActionListener, KeyListener, MouseListener {
    GamePanel gamePanel;
    JButton exitButton, retryButton;
    FlappyBirdInstructions instructions;
    private final Font FONT = Font.createFont(Font.TRUETYPE_FONT, new File("./Java_Swing_Excercises/FlappyBird/font.ttf")).deriveFont(50f);
    private int frames;
    private boolean jumping = false, started = false, gameOver = false;
    private Timer timer;
    private final int BIRD_X = 50, GROUND_Y = 450;
    private int birdY, score, groundX, jump_counter;
    private double birdSpeed, pipeSpeed, resetPipe, resetBird;
    private final double GRAVITY = 0.25;
    private ArrayList<Pipe> pipes;
    Pipe ContinueAnimation;
    private Rectangle bird;

    public Flappy_Bird(double pipeSpeed, double birdSpeed) throws IOException, FontFormatException {
        frames = score = groundX = jump_counter = 0;
        this.resetPipe = pipeSpeed;
        this.resetBird = birdSpeed;
        pipes = new ArrayList<Pipe>();
        bird = new Rectangle(BIRD_X, birdY, 40, 40);
        createMenu();
        restart();
        gamePanel = new GamePanel(pipes, ContinueAnimation, birdY, score, started, gameOver, groundX, FONT);
        timer = new Timer(12, this);
        timer.start();
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }
    private void createMenu() {
        setLayout(new BorderLayout());
        
        instructions = new FlappyBirdInstructions();
        add(instructions.getInstructionsButton(), BorderLayout.PAGE_START);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 175, 0));
        buttonPanel.setOpaque(false);
        
        exitButton = new JButton("Exit");
        retryButton = new JButton("Restart");
        exitButton.setPreferredSize(new Dimension(100, 50));
        retryButton.setPreferredSize(new Dimension(100, 50));
        exitButton.addActionListener(e -> System.exit(0));
        retryButton.addActionListener(e -> restart());
        buttonPanel.add(retryButton);
        buttonPanel.add(exitButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        exitButton.setVisible(false);
        retryButton.setVisible(false);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    
        gamePanel.refresh(pipes, ContinueAnimation, birdY, score, started, gameOver, groundX);

        gamePanel.Component(g2);

        groundX -= pipeSpeed;
        if (groundX < -20) {
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
        if (frames <= 200) {
            frames++;
        }
        if (frames == 20) {
            pipes.add(new Pipe(600));
        }
        for (Pipe pipe : pipes) {
            pipe.adjustPipe(pipeSpeed);
        }
        if (ContinueAnimation != null) ContinueAnimation.adjustPipe(pipeSpeed);
        if (jumping) {
            if (jump_counter++ == 10) {
                jump_counter = 0;
                jumping = false;
                birdSpeed = 1;
            }
            birdSpeed = -3.5;
        } else {
            birdSpeed += GRAVITY;
        }
        birdY += birdSpeed;
        if (pipes.size() != 0) {
            int PipeX = pipes.get(0).x();
            if (PipeX % 200 == 0) {
                pipes.add(new Pipe(600));
            }
            if (PipeX <= 0) {
                ContinueAnimation = pipes.get(0);
                score++;
                pipes.remove(0);
            }
            if (pipes.get(0).intersects(birdY, bird)) {
                gameOver = true;
                exitButton.setVisible(true);
                retryButton.setVisible(true);
            }
        }
        if (birdY >= GROUND_Y - bird.height) {
            birdY = GROUND_Y - bird.height;
            gameOver = true;
            exitButton.setVisible(true);
            retryButton.setVisible(true);
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
    private void jump() {
        instructions.setVisible(false);
        started = true;
        jumping = true;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE && !gameOver && !jumping) {
            jump();
        } else if (key == KeyEvent.VK_ENTER && gameOver) {
            restart();
        }
    }

    private void restart() {
        frames = score = groundX = jump_counter = 0;
        started = false;
        gameOver = false;
        birdY = 250;
        pipeSpeed = resetPipe;
        birdSpeed = resetBird;
        pipes.clear();
        ContinueAnimation = null;
        exitButton.setVisible(false);
        retryButton.setVisible(false);
        instructions.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        jump();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
    public static void main(String[] args) throws IOException, FontFormatException {
        JFrame frame = new JFrame("Flappy Bird");
        Flappy_Bird game = new Flappy_Bird(2, 2.5);
        frame.add(game);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}