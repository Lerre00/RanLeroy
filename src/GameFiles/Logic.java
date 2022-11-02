package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Logic {

    protected void movePieces(JButton[] buttonArr){

        for (int i = 0; i <= 15; i++) {
            int clickedButton;
            int left = i-1;
            int right = i+1;
            int up = i-4;
            int down = i+4;
            final int finalLeft;
            final int finalRight;
            final int finalUp;
            final int finalDown;

            if (left < 0){
                left = 0;
            }
            if (right > 15){
                right = 15;
            }
            if (up < 0){
                up = 0;
            }
            if (down > 15){
                down = 15;
            }

            finalLeft = left;
            finalRight = right;
            finalUp = up;
            finalDown = down;

            clickedButton = i;

            buttonArr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(buttonArr[finalLeft].getText() == "" && clickedButton != 0 && clickedButton != 4 && clickedButton != 8 && clickedButton != 12){
                        buttonArr[finalLeft].setBackground(Color.CYAN);
                        buttonArr[clickedButton].setBackground(Color.WHITE);
                        buttonArr[finalLeft].setText(buttonArr[clickedButton].getText());
                        buttonArr[clickedButton].setText("");
                    }
                    else if(buttonArr[finalRight].getText() == "" && clickedButton != 3 && clickedButton != 7 && clickedButton != 11){
                        buttonArr[finalRight].setBackground(Color.CYAN);
                        buttonArr[clickedButton].setBackground(Color.WHITE);
                        buttonArr[finalRight].setText(buttonArr[clickedButton].getText());
                        buttonArr[clickedButton].setText("");
                    }
                    else if(buttonArr[finalUp].getText() == "" && clickedButton != 2 && clickedButton != 3){
                        buttonArr[finalUp].setBackground(Color.CYAN);
                        buttonArr[clickedButton].setBackground(Color.WHITE);
                        buttonArr[finalUp].setText(buttonArr[clickedButton].getText());
                        buttonArr[clickedButton].setText("");
                    }
                    else if(buttonArr[finalDown].getText() == "" && clickedButton != 12 && clickedButton != 13){
                        buttonArr[finalDown].setBackground(Color.CYAN);
                        buttonArr[clickedButton].setBackground(Color.WHITE);
                        buttonArr[finalDown].setText(buttonArr[clickedButton].getText());
                        buttonArr[clickedButton].setText("");
                    }
                }
            });
        }
    }

    protected void winGame(JButton[] buttonArr, JPanel southPanel, JLabel winLabel) {

        ArrayList<String> numOnButtonsList = new ArrayList<>();
        ArrayList<String> sortedNumList = new ArrayList<>(Arrays.asList("1", "2", "3", "4",
                "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", ""));

        for (int i = 0; i <= 15; i++) {
            buttonArr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for (JButton test : buttonArr) {
                        String numOnButtons = test.getText();
                        numOnButtonsList.add(numOnButtons);
                    }
                    if(numOnButtonsList.equals(sortedNumList)){
                        southPanel.removeAll();
                        southPanel.add(winLabel);
                        southPanel.updateUI();
                    }
                    else{
                        numOnButtonsList.clear();
                    }
                }
            });
        }
    }


    protected void restartGame(JButton restartButton, JPanel southPanel, JButton[] buttonArr, JLabel winLabel){

        restartButton.addActionListener(e -> {
            southPanel.removeAll();
            startGame(southPanel, buttonArr);
            winGame(buttonArr, southPanel, winLabel);
            movePieces(buttonArr);
            southPanel.updateUI();
        });

    }

    protected void startGame(JPanel southPanel, JButton[] buttonArr){

        ArrayList<Integer> randomNumList = new ArrayList<>();

        for (int i=1; i<=16; i++) {
            randomNumList.add(i);
        }

        //Collections.shuffle(randomNumList);

        for (int i = 0; i <=15; i++) {
            if(randomNumList.get(i) != randomNumList.get(15)) {
                buttonArr[i] = new JButton("" + randomNumList.get(i));
                buttonArr[i].setBackground(Color.CYAN);
                southPanel.add(buttonArr[i]);
            }
            else{
                buttonArr[i] = new JButton("");
                buttonArr[i].setBackground(Color.WHITE);
                southPanel.add(buttonArr[i]);
            }
        }
    }
}
