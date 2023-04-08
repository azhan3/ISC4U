package Java_Swing_Excercises.FlappyBird;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.swing.border.Border;

public class Flappy_Bird extends JPanel implements ActionListener, KeyListener, MouseListener {
    JButton exitButton, retryButton;
    FlappyBirdInstructions instructions;
    private final Font ARIAL_ITALIC = new Font("Arial", Font.ITALIC, 25), ARIAL_BOLD = new Font("Arial", Font.BOLD, 50),
            FONT = Font.createFont(Font.TRUETYPE_FONT, new File("./Java_Swing_Excercises/font.ttf")).deriveFont(50f);;
    private int frames;
    private boolean jumping = false, started = false, gameOver = false;
    private Timer timer;
    private final int BIRD_X = 50, GAP_HEIGHT = 175, PIPE_WIDTH = 80, GROUND_Y = 450;
    private int birdY, score, topPipeHeight, bottomPipeHeight, topPipeY, bottomPipeY, groundX, jump_counter;
    private double birdSpeed, pipeSpeed;
    private ArrayList<Rectangle[]> pipes;
    Rectangle[] ContinueAnimation = {};
    private Rectangle bird;

    public Flappy_Bird() throws IOException, FontFormatException {
        frames = 0;
        birdSpeed = 1;
        pipeSpeed = 2;
        birdY = 250;
        score = 0;
        groundX = 0;
        jump_counter = 0;
        pipes = new ArrayList<Rectangle[]>();
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
        setLayout(new BorderLayout());
        instructions = new FlappyBirdInstructions();
        add(instructions.getInstructionsButton(), BorderLayout.PAGE_START);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 175, 0);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(emptyBorder);
        buttonPanel.setOpaque(false);
        add(buttonPanel, BorderLayout.SOUTH);
        exitButton = new JButton("Exit");
        retryButton = new JButton("Restart");
        exitButton.setPreferredSize(new Dimension(100, 50));
        retryButton.setPreferredSize(new Dimension(100, 50));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        retryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        buttonPanel.add(retryButton);
        buttonPanel.add(exitButton);
        
        exitButton.setVisible(false);
        retryButton.setVisible(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, 600, 500);

        for (Rectangle[] pipe : pipes) {
            Rectangle topPipe = pipe[0], bottomPipe = pipe[1];
            g2.setColor(Color.GREEN);
            g2.fillRect(topPipe.x + 50, topPipe.y, PIPE_WIDTH, topPipe.height);
            g2.fillRect(bottomPipe.x + 50, bottomPipe.y, PIPE_WIDTH, bottomPipe.height);
            g2.setColor(Color.BLACK);
            g2.drawRect(topPipe.x + 50, topPipe.y - 1, PIPE_WIDTH, topPipe.height);
            g2.drawRect(bottomPipe.x + 50, bottomPipe.y, PIPE_WIDTH, bottomPipe.height);
        }
        for (Rectangle pipe : ContinueAnimation) {
            g2.setColor(Color.GREEN);
            g2.fillRect(pipe.x + 50, pipe.y, PIPE_WIDTH, pipe.height);
            g2.setColor(Color.BLACK);
            g2.drawRect(pipe.x + 50, pipe.y - 1, PIPE_WIDTH, pipe.height);
        }
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
        g2.setColor(Color.YELLOW);
        g2.fillRect(BIRD_X + 50, birdY, 40, 40);
        g2.setColor(Color.BLACK);

        if (started) {
            g2.setFont(FONT);
            g2.drawString("" + score, 250, 100);
        } else {
            g2.setFont(ARIAL_ITALIC);
            g2.drawString("Press SPACE or LEFT CLICK to start", 50, 250);
        }
        if (gameOver) {
            g2.setFont(ARIAL_BOLD);
            g2.drawString("Game Over!", 100, 225);
            g2.setFont(ARIAL_ITALIC);
            g2.drawString("Press ENTER to play again", 100, 250);

        }

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
            int randGap = (int) (Math.random() * 200 + 100);
            topPipeHeight = (int) (Math.random() * (500 - GAP_HEIGHT - randGap));
            bottomPipeHeight = 500 - GAP_HEIGHT - topPipeHeight;
            topPipeY = 0;
            bottomPipeY = topPipeHeight + GAP_HEIGHT;
            pipes.add(new Rectangle[] { new Rectangle(600, topPipeY, PIPE_WIDTH, topPipeHeight),
                    new Rectangle(600, bottomPipeY, PIPE_WIDTH, bottomPipeHeight) });
        }
        for (Rectangle[] pipe : pipes) {
            pipe[0].x -= pipeSpeed;
            pipe[1].x -= pipeSpeed;
        }
        for (Rectangle pipe : ContinueAnimation) {
            pipe.x -= pipeSpeed;
        }
        if (jumping) {
            if (jump_counter++ == 10) {
                jump_counter = 0;
                jumping = false;
                birdSpeed = 1;
            }
            birdSpeed = -3.5;
        } else {
            birdSpeed += 0.2;
        }
        birdY += birdSpeed;
        if (pipes.size() != 0) {
            Rectangle topPipe = pipes.get(0)[0], bottomPipe = pipes.get(0)[1];
            if (topPipe.x == 400 || topPipe.x == 200 || topPipe.x == 0) {
                int randGap = (int) (Math.random() * 200 + 100);
                topPipeHeight = (int) (Math.random() * (500 - GAP_HEIGHT - randGap));
                bottomPipeHeight = 500 - GAP_HEIGHT - topPipeHeight;
                topPipeY = 0;
                bottomPipeY = topPipeHeight + GAP_HEIGHT;
                pipes.add(new Rectangle[] { new Rectangle(600, topPipeY, PIPE_WIDTH, topPipeHeight),
                        new Rectangle(600, bottomPipeY, PIPE_WIDTH, bottomPipeHeight) });
            }
            if (topPipe.x <= 0) {
                ContinueAnimation = pipes.get(0);
                score++;
                pipes.remove(0);
            }
            if (Math.abs(topPipe.x - BIRD_X + bird.height) - PIPE_WIDTH < 0) {
                if (birdY <= topPipe.height || birdY + bird.height >= bottomPipe.y) {
                    gameOver = true;
                    exitButton.setVisible(true);
                    retryButton.setVisible(true);
                }
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

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE && !gameOver && !jumping) {
            instructions.setVisible(false);
            started = true;
            jumping = true;
        } else if (key == KeyEvent.VK_ENTER && gameOver) {
            restart();
        }
    }

    private void restart() {
        started = false;
        gameOver = false;
        birdY = 250;
        birdSpeed = 0;
        score = 0;
        pipeSpeed = 2;
        frames = 0;
        pipes.clear();
        ContinueAnimation = new Rectangle[0];
        exitButton.setVisible(false);
        retryButton.setVisible(false);
        instructions.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        instructions.setVisible(false);
        started = true;
        jumping = true;
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
