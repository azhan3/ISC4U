package Java_Swing_Excercises.FlappyBird;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class FlappyBirdInstructions {
    private JButton instructionsButton;

    public FlappyBirdInstructions() {
        instructionsButton = new JButton("Instructions");
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Instructions for Flappy Bird:\n\n1. Press the space bar to make the bird fly.\n2. Avoid the pipes.\n3. Score points by passing through gaps in the pipes.\n4. Good luck!");
                
            }
        });
    }

    public JButton getInstructionsButton() {
        return instructionsButton;
    }
    public void setVisible(boolean visible) {
        instructionsButton.setVisible(visible);
    }
}

