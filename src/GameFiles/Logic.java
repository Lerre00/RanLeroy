package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Logic {
    JFrame jfr = new JFrame();

    protected void startGame(JPanel southPanel,JButton[] buttons){
        addPieces(southPanel,buttons);
        int clickNr = 1;

        for (int i = 0; i < 16; i++) {
                final int finalI = i;
                int clickedButton;
                int left = i -1;
                int right = i +1;
                int up = i -4;
                int down = i+4;
                if(buttons[i].getText() == ""){
                }

                else {
                     clickedButton = i;
                    if (clickedButton == 0){

                    }
                    buttons[clickedButton].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(buttons[left].getText() == ""){
                                buttons[left].setBackground(Color.CYAN);
                                buttons[clickedButton].setBackground(Color.WHITE);
                                buttons[left].setText(buttons[clickedButton].getText());
                                buttons[clickedButton].setText("");
                            }
                            else if(buttons[right].getText() == ""){
                                buttons[right].setBackground(Color.CYAN);
                                buttons[clickedButton].setBackground(Color.WHITE);
                                buttons[right].setText(buttons[clickedButton].getText());
                                buttons[clickedButton].setText("");
                            }
                            else if(buttons[up].getText() == ""){
                                buttons[up].setBackground(Color.CYAN);
                                buttons[clickedButton].setBackground(Color.WHITE);
                                buttons[up].setText(buttons[clickedButton].getText());
                                buttons[clickedButton].setText("");
                            }
                            else if(buttons[down].getText() == ""){
                                buttons[down].setBackground(Color.CYAN);
                                buttons[clickedButton].setBackground(Color.WHITE);
                                buttons[down].setText(buttons[clickedButton].getText());
                                buttons[clickedButton].setText("");
                            }
                            else{}



                        }
                    });
                }
            }
        }





    protected void restartGame(JButton button, JPanel panel, JButton[] buttons){

        button.addActionListener(e -> {
            panel.removeAll();
            addPieces(panel, buttons);
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
