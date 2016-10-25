package gui;

/**
 * Created by Loewe on 10/25/2016.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRPSPLS extends Frame{
    Play play = new Play(this);

    Label lbl;
    CheckboxGroup chckbg;
    TextArea txta;
    Button button;
    TextField txtfld1;
    TextField txtfld2;

    Checkbox rock;
    Checkbox paper;
    Checkbox scissors;
    Checkbox lizard;
    Checkbox spock;

    GameRPSPLS(){
        setLayout(new FlowLayout());
        lbl = new Label("Your Choice");
        add(lbl);
        //adding checkbox group
        chckbg = new CheckboxGroup();
        rock = new Checkbox("Rock",chckbg,true);
        paper = new Checkbox("Paper",chckbg,false);
        scissors = new Checkbox("Scissors",chckbg,false);
        lizard = new Checkbox("Lizard",chckbg,false);
        spock = new Checkbox("Spock",chckbg,false);

        add(rock);
        add(paper);
        add(scissors);
        add(lizard);
        add(spock);
        add(txta = new TextArea("Result:\nPlayer Choose: \nComputer choose: "));

        add(button = new Button("RockPaperScissorsLizardSpock!"));
        button.addActionListener(new ActionListener() {     //clicking on button RockPaperScissorsLizardSpock
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(play.playscore < 5 && play.comscore < 5){        //if both scores are below 5 then gameplay will continue
                    play.addText();
                    String disp = "Result:\nPlayer Choose: " + play.plyr + "\nComputer choose: " + play.cmptr +
                            "\n\n" + play.gamePlay();
                    txta.setText(disp);
                    txtfld1.setText(Integer.toString(play.playscore));
                    txtfld2.setText(Integer.toString(play.comscore));
                }
                if(play.playscore == 5 || play.comscore == 5){  //if either of the two are equal two 5 then gameover
                    play.gameOver();
                }
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {  //press x if the user wants to exit
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });

        add(lbl = new Label("Player's Score: "));   //recording player's score
        add(txtfld1 = new TextField("0", 5));
        add(lbl = new Label("Computer's Score: ")); //recording computer's score
        add(txtfld2 = new TextField("0", 5));

        setTitle("RockPaperScissorsLizardSpock");   //title
        setSize(450,300);                           //setting size
        setVisible(true);                           //setting the frame visible to the user
    }

    public static void main(String[] args){
        new GameRPSPLS();
    }
}
