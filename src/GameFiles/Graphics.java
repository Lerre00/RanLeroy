package GameFiles;

import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame {

    Logic logic = new Logic();
    JPanel basePanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JButton restartButton = new JButton("Nytt Spel");
    JButton[] buttonArr = new JButton[16];
    JLabel winLabel = new JLabel("You Won!");


    Graphics(){
        basePanel.setLayout(new BorderLayout());
        southPanel.setLayout(new GridLayout(4,4));
        northPanel.add(restartButton);
        winLabel.setFont(new Font("Arial", Font.BOLD, 32));
        winLabel.setHorizontalAlignment(JLabel.CENTER);

        logic.startGame(southPanel, buttonArr);
        logic.winGame(buttonArr, southPanel, winLabel);
        logic.movePieces(buttonArr);
        logic.restartGame(restartButton, southPanel, buttonArr, winLabel);
        add(basePanel);

        basePanel.add(northPanel, BorderLayout.NORTH);
        basePanel.add(southPanel);

        setSize(500,500);
        setLocation(100,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
