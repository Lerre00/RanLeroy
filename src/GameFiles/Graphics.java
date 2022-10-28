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
    JButton[] numButtons= new JButton[16];
    JButton emptyButton = new JButton("Empty");
        Graphics(){
            basePanel.setLayout(new BorderLayout());
            southPanel.setLayout(new GridLayout(4,4));
            northPanel.add(newGame);

            ArrayList<Integer> list = new ArrayList<>();

            for (int i=1; i<=16; i++) { //Randomizes numbers from 1-15
                    list.add(i);
            }

            Collections.shuffle(list);

            for (int i = 0; i <=15; i++) {
                if(list.get(i) != 16) {
                    numButtons[i] = new JButton("" + list.get(i));
                    southPanel.add(numButtons[i]);
                }
                else{
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
