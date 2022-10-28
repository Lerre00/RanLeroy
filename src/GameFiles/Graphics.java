package GameFiles;

import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame {

    JPanel basePanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JButton newGame = new JButton("Nytt Spel");
    JButton[][] button = new JButton[4][4];
    JButton emptyButton = new JButton();

        Graphics(){
            basePanel.setLayout(new BorderLayout());
            //northPanel.add(newGame);
            southPanel.setLayout(new GridLayout(4,4));
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    button[i][j] = new JButton();
                    southPanel.add(button[i][j]);
                }
            }
            //pack();
            setSize(500,500);
            setLocation(600, 300);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }


}
