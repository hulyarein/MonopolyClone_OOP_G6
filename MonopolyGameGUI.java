import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonopolyGameGUI extends JFrame {
    private JButton rollButton;
    private JLabel playerLabel;
    private JLabel positionLabel;

    private Dice dice;
    private Player player;

    public MonopolyGameGUI() {
        super("Monopoly Game");

        dice = new Dice();
        player = new Player("Player1");

        rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRollDice();
            }
        });

        playerLabel = new JLabel("Player: " + player.getName());
        positionLabel = new JLabel("Position: " + player.getPosition());

        setLayout(new FlowLayout());
        add(rollButton);
        add(playerLabel);
        add(positionLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void handleRollDice() {
        int steps = dice.rollTwoDice();
        player.move(steps);
        updateLabels();
        handleBoardPosition();
    }

    private void handleBoardPosition() {
        int position = player.getPosition();

        // Implement logic for different board positions
        switch (position) {
            case 0:
                // Implement logic for position 0 (e.g., passing Go)
                break;
            case 10:
                // Implement logic for Jail position
                break;
            // Add more cases for other special positions
            default:
                // Implement logic for regular property spaces, chance cards, etc.
                break;
        }
    }

    private void updateLabels() {
        playerLabel.setText("Player: " + player.getName());
        positionLabel.setText("Position: " + player.getPosition());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MonopolyGameGUI();
            }
        });
    }
}
