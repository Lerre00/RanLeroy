package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Graphics extends JFrame {

    Random r = new Random();
    JPanel basePanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JButton newGame = new JButton("Nytt Spel");
    JButton[] numButtons= new JButton[17];
    JButton emptyButton = new JButton("Empty");
        Graphics(){
            basePanel.setLayout(new BorderLayout());
            southPanel.setLayout(new GridLayout(4,4));
            northPanel.add(newGame);

            //int test = r.nextInt(10-1 + 1) + 1;

                for (int i = 1; i < 17; i++) {
                    if (i != 16) {
                        numButtons[i] = new JButton(""+i);
                        //numButtons[i].setBackground(Color.getHSBColor(r.nextFloat(),r.nextFloat(),r.nextFloat()));
                        southPanel.add(numButtons[i]);
                    } else {
                        emptyButton.setBackground(Color.WHITE);
                        southPanel.add(emptyButton);
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
