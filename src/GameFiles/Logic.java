package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Logic{
    JFrame jfr = new JFrame();

    protected void restartGame(JButton button, JPanel panel, JButton[] buttons, JButton emptyButton, JPanel base){

        button.addActionListener(e -> {
            addPieces(panel, buttons, emptyButton);
            panel.remove(buttons[15]);
            panel.updateUI();
        });

    }

    protected void addPieces(JPanel panel, JButton[] buttons, JButton emptyButton){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=1; i<=16; i++) { //Randomizes numbers from 1-15
            list.add(i);
        }

        Collections.shuffle(list);

        for (int i = 0; i <=15; i++) {
            if(list.get(i) != 16) {
                buttons[i] = new JButton("" + list.get(i));
                panel.add(buttons[i]);
            }
            else{
                emptyButton.setBackground(Color.WHITE);
                panel.add(emptyButton);
            }

        }


    }



}
