package Java_Swing_Excercises.FlappyBird;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class Flappy_Bird extends JPanel implements ActionListener, KeyListener, MouseListener {
    JButton exitButton, retryButton;
    FlappyBirdInstructions instructions;
    private final Font ARIAL_ITALIC = new Font("Arial", Font.ITALIC, 25), ARIAL_BOLD = new Font("Arial", Font.BOLD, 50),
            FONT = Font.createFont(Font.TRUETYPE_FONT, new File("./Java_Swing_Excercises/FlappyBird/font.ttf")).deriveFont(50f);;
    private int frames;
    private boolean jumping = false, started = false, gameOver = false;
    private Timer timer;
    private final int BIRD_X = 50, PIPE_WIDTH = 80, GROUND_Y = 450;
    private int birdY, score, groundX, jump_counter;
    private double birdSpeed, pipeSpeed;
    private final double GRAVITY = 0.2;
    private ArrayList<Pipe> pipes;
    Pipe ContinueAnimation;
    private Rectangle bird;

    public Flappy_Bird() throws IOException, FontFormatException {
        frames = score = groundX = jump_counter = 0;
        birdSpeed = 1;
        pipeSpeed = 2;
        birdY = 250;
        pipes = new ArrayList<Pipe>();
        bird = new Rectangle(BIRD_X, birdY, 40, 40);
        createMenu();
        timer = new Timer(12, this);
        timer.start();
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }
    private void createMenu() {
        // Set layout
        setLayout(new BorderLayout());
        
        // Add instructions button
        instructions = new FlappyBirdInstructions();
        add(instructions.getInstructionsButton(), BorderLayout.PAGE_START);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 175, 0));
        buttonPanel.setOpaque(false);
        
        // Add exit and retry buttons to button panel
        exitButton = new JButton("Exit");
        retryButton = new JButton("Restart");
        exitButton.setPreferredSize(new Dimension(100, 50));
        retryButton.setPreferredSize(new Dimension(100, 50));
        exitButton.addActionListener(e -> System.exit(0));
        retryButton.addActionListener(e -> restart());
        buttonPanel.add(retryButton);
        buttonPanel.add(exitButton);
        
        // Add button panel to frame and set visibility of buttons
        add(buttonPanel, BorderLayout.SOUTH);
        exitButton.setVisible(false);
        retryButton.setVisible(false);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    
        // Draw sky background
        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, 600, 500);
    
        // Draw pipes
        
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
    
        // Draw ground
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
    
        // Draw bird
        g2.setColor(Color.YELLOW);
        g2.fillRect(BIRD_X + 50, birdY, 40, 40);
    
        g2.setColor(Color.BLACK);
    
        // Draw score or start message
        if (started) {
            g2.setFont(FONT);
            g2.drawString("" + score, 250, 100);
        } else {
            g2.setFont(ARIAL_ITALIC);
            g2.drawString("Press SPACE or LEFT CLICK to start", 50, 250);
        }
    
        // Draw game over message
        if (gameOver) {
            g2.setFont(ARIAL_BOLD);
            g2.drawString("Game Over!", 100, 225);
            g2.setFont(ARIAL_ITALIC);
            g2.drawString("Press ENTER to play again", 100, 250);
        }
    
        // Update ground position
        groundX -= pipeSpeed;
        if (groundX < -20) {
            groundX = 0;
        }
    }
    

    public void update() {
        System.out.println(bird.y);
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
        if (frames == 100) {
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

    public static void main(String[] args) throws IOException, FontFormatException {
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
        pipeSpeed = 2;
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

}
