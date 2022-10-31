package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Logic {
    JFrame jfr = new JFrame();

    protected void startGame(JPanel southPanel,JButton[] buttons){

        addPieces(southPanel,buttons);

        for (int i = 0; i <= 15; i++) {
            final int finalI = i;
            int clickedButton;
            int left = i -1;
            int right = i +1;
            int up = i -4;
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

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(buttons[finalLeft].getText() == "" && clickedButton != 0 && clickedButton != 4 && clickedButton != 8 && clickedButton != 12){
                        buttons[finalLeft].setBackground(Color.CYAN);
                        buttons[clickedButton].setBackground(Color.WHITE);
                        buttons[finalLeft].setText(buttons[clickedButton].getText());
                        buttons[clickedButton].setText("");
                        //System.out.println("Inside left");
                    }
                    else if(buttons[finalRight].getText() == "" && clickedButton != 3 && clickedButton != 7 && clickedButton != 11){
                        buttons[finalRight].setBackground(Color.CYAN);
                        buttons[clickedButton].setBackground(Color.WHITE);
                        buttons[finalRight].setText(buttons[clickedButton].getText());
                        buttons[clickedButton].setText("");
                        //System.out.println("Inside right");
                    }
                    else if(buttons[finalUp].getText() == "" && clickedButton != 2 && clickedButton != 3){
                        buttons[finalUp].setBackground(Color.CYAN);
                        buttons[clickedButton].setBackground(Color.WHITE);
                        buttons[finalUp].setText(buttons[clickedButton].getText());
                        buttons[clickedButton].setText("");
                        //System.out.println("Inside up");
                    }
                    else if(buttons[finalDown].getText() == "" && clickedButton != 12 && clickedButton != 13){
                        buttons[finalDown].setBackground(Color.CYAN);
                        buttons[clickedButton].setBackground(Color.WHITE);
                        buttons[finalDown].setText(buttons[clickedButton].getText());
                        buttons[clickedButton].setText("");
                        //System.out.println("Inside down");
                    }
                    //System.out.println(clickedButton);

                    /*System.out.println(buttons[0].getText());
                    System.out.println(buttons[1].getText());

                    if(Objects.equals(buttons[0].getText(), "1") && Objects.equals(buttons[1].getText(), "2")){

                        System.out.println("you won");

                    }*/
                }
            });
        }
    }


    protected void restartGame(JButton button, JPanel panel, JButton[] buttons){

        button.addActionListener(e -> {
            panel.removeAll();
            startGame(panel, buttons);
            panel.updateUI();
        });

    }

    protected void addPieces(JPanel panel, JButton[] buttons){

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<JButton> buttonArr = new ArrayList<>();

        for (int i=1; i<=16; i++) { //Randomizes numbers from 1-15
            list.add(i);
        }

        Collections.shuffle(list);

        for (int i = 0; i <=15; i++) {
            if(list.get(i) != 16) {
                buttons[i] = new JButton("" + list.get(i));
                buttons[i].setBackground(Color.CYAN);
                panel.add(buttons[i]);
            }
            else{
                buttons[i] = new JButton("");
                buttons[i].setBackground(Color.WHITE);
                panel.add(buttons[i]);
            }
            buttonArr.add(buttons[i]);

        }

    }



}
