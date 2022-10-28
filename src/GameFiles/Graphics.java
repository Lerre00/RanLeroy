package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Graphics extends JFrame {

    Random r = new Random();
    JPanel basePanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JButton newGame = new JButton("Nytt Spel");
    JButton[][] button = new JButton[4][4];
    JButton emptyButton = new JButton("Empty");

        Graphics(){
            basePanel.setLayout(new BorderLayout());
            southPanel.setLayout(new GridLayout(4,4));
            northPanel.add(newGame);

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i!=3 || j!=3) {
                        button[i][j] = new JButton();
                        button[i][j].setBackground(Color.getHSBColor(r.nextFloat(),r.nextFloat(),r.nextFloat()));
                        southPanel.add(button[i][j]);
                    }
                    else {
                        emptyButton.setBackground(Color.WHITE);
                        southPanel.add(emptyButton);
                    }
                }
            }
            add(basePanel);
            basePanel.add(northPanel, BorderLayout.NORTH);
            basePanel.add(southPanel);
            setSize(500,500);
            setLocation(100,100);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }


}
