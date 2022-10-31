package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Graphics extends JFrame {

    Logic logic = new Logic();
    Random r = new Random();
    JPanel basePanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JButton newGame = new JButton("Nytt Spel");
    JButton[] numButtons= new JButton[16];
    //JButton emptyButton = new JButton("Empty");

        Graphics(){
            basePanel.setLayout(new BorderLayout());
            southPanel.setLayout(new GridLayout(4,4));
            northPanel.add(newGame);

            logic.startGame(southPanel,numButtons);
            add(basePanel);

            basePanel.add(northPanel, BorderLayout.NORTH);
            basePanel.add(southPanel);

            logic.restartGame(newGame, southPanel, numButtons);

            setSize(500,500);
            setLocation(100,100);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);


        }






}
