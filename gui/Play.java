package gui;

/**
 * Created by Loewe on 10/25/2016.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
    the gameplay is stored in the Play class... every time the user clicks the button
    rockpaperscissorslizardspock.. the gameplay will be automatically called
    I separate the two classes in order to segregate their functionality.
    The main class is for creating the game mechanics
 */

public class Play {
    private GameRPSPLS game;
    private boolean mesbox = true;  // to know if the user enters the button, the message box will only appear once
    // to know what the player and the computer chose
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS  = 3;
    private static final int LIZARD = 4;
    private static final int SPOCK = 5;
    //...
    int comchoice;  //computer choice
    int playchoice; //player choice
    int comscore;   //computer score
    int playscore;  //player score
    String cmptr;
    String plyr;

    Play(GameRPSPLS game){ // in order to access some of the game functions I instantiate this.game from its argument
        this.game = game;
        comscore = 0;
        playscore = 0;
    }

    public void gameOver(){
        if(mesbox){
            String disp = "";
            if (playscore > comscore) {   //to display the winner
                disp += "PLAYER WINS!";
            } else {
                disp += "COMPUTER WINS!";
            }
            //creating the dialog box
            Dialog msg = new Dialog(new Frame(), "Game Over");
            msg.setSize(220, 110);
            msg.setLayout(new FlowLayout());
            Label lbl1 = new Label(disp + " Play Again?");
            Button yes = new Button("YES");
            Button no = new Button("NO");
            msg.add(lbl1);
            msg.add(yes);
            msg.add(no);

            no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.exit(0); // exit if no
                }
            });

            yes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    playscore = 0;  //resetting everything
                    comscore = 0;
                    msg.setVisible(false);
                    game.txtfld1.setText(Integer.toString(playscore));
                    game.txtfld2.setText(Integer.toString(comscore));
                    mesbox = true;
                }
            });
            mesbox = false;
            msg.setVisible(true);
        }
    }

    public String gamePlay(){   //this is the gameplay....
        String display = "";
        if(playchoice == ROCK && (comchoice == SCISSORS || comchoice == LIZARD)){
            playscore++;
            display += "YOU WIN THIS ROUND";
        } else if(playchoice == PAPER && (comchoice == SPOCK || comchoice == ROCK)){
            playscore++;
            display += "YOU WIN THIS ROUND";
        } else if(playchoice == SCISSORS && (comchoice == LIZARD || comchoice == PAPER)){
            playscore++;
            display += "YOU WIN THIS ROUND";
        } else if(playchoice == LIZARD && (comchoice == PAPER || comchoice == SPOCK)){
            playscore++;
            display += "YOU WIN THIS ROUND";

        } else if(playchoice == SPOCK && (comchoice == ROCK || comchoice == SCISSORS)){
            playscore++;
            display += "YOU WIN THIS ROUND";

        } else if(playchoice == ROCK && comchoice == ROCK){
            display += "THERE ARE NO WINNERS IN THIS ROUND";

        } else if(playchoice == PAPER && comchoice == PAPER){
            display += "THERE ARE NO WINNERS IN THIS ROUND";

        } else if(playchoice == SCISSORS && comchoice == SCISSORS){
            display += "THERE ARE NO WINNERS IN THIS ROUND";

        } else if(playchoice == LIZARD && comchoice == LIZARD){
            display += "THERE ARE NO WINNERS IN THIS ROUND";

        } else if(playchoice == SPOCK && comchoice == SPOCK){
            display += "THERE ARE NO WINNERS IN THIS ROUND";

        } else{
            comscore++;
            display += "YOU LOSE THIS ROUND";
        }
        return display;
    }

    public void addText(){  //adds text into the text area to know what the user inputted
        if(game.chckbg.getSelectedCheckbox().equals(game.rock)){
            plyr = "ROCK";
            playchoice = ROCK;
        } else if(game.chckbg.getSelectedCheckbox().equals(game.paper)){
            plyr = "PAPER";
            playchoice = PAPER;
        } else if(game.chckbg.getSelectedCheckbox().equals(game.scissors)){
            plyr = "SCISSORS";
            playchoice = SCISSORS;
        } else if(game.chckbg.getSelectedCheckbox().equals(game.lizard)){
            plyr = "LIZARD";
            playchoice = LIZARD;
        } else if(game.chckbg.getSelectedCheckbox().equals(game.spock)){
            plyr = "SPOCK";
            playchoice = SPOCK;
        }
        comchoice = (int)(Math.random() * 5  + 1);
        if(comchoice == ROCK){
            cmptr = "ROCK";
        } else if(comchoice == PAPER){
            cmptr = "PAPER";
        } else if(comchoice == SCISSORS){
            cmptr = "SCISSORS";
        } else if(comchoice == LIZARD){
            cmptr = "LIZARD";
        } else if(comchoice == SPOCK){
            cmptr = "SPOCK";
        }
    }
}
