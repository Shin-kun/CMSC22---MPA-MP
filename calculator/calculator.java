/**
 * Created by Loewe on 10/28/2016.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;

public class Calculator extends JFrame{
    //operations
    private JButton plus;
    private JButton minus;
    private JButton times;
    private JButton divide;
    private JButton clear;
    private JButton equals;
    private JButton conv;
    private JButton dott;
    //to know what the user inputted on the operation buttons
    public static final int ADD = 1;
    public static final int SUBTRACT = 2;
    public static final int MULTIPLY = 3;
    public static final int DVD = 4;
    public static final int EQUALS = 0;
    //....
    private String disp = "";
    //numbers
    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    //...
    //input
    private JTextField input; //input from user
    private boolean decimal;
    private boolean num; //decides the first or second number being inputted
    private BigDecimal b1;   //big decimal a
    private int pressoper;
    //constructor
    public Calculator(){
        num = true;
        decimal = false;
        JPanel pan = new JPanel();
        pan.add(input = new JTextField(disp,25));
        input.setEditable(false);

        JPanel pan2 = new JPanel();
        pan2.setLayout(new GridLayout(6,4));    //setting layout
        pan2.add(clear = new JButton("A/C"));   //clearing the last character
        pan2.add(conv = new JButton("+/-"));     //converting positive to negative and vice versa button

        pan2.add(divide = new JButton("/"));    //divdie
        pan2.add(nine = new JButton("9"));
        pan2.add(eight = new JButton("8"));
        pan2.add(times = new JButton("*")); //times
        pan2.add(seven = new JButton("7"));
        pan2.add(six = new JButton("6"));
        pan2.add(plus = new JButton("+"));  //plus
        pan2.add(five = new JButton("5"));
        pan2.add(four = new JButton("4"));
        pan2.add(minus = new JButton("-")); //minus
        pan2.add(three = new JButton("3"));
        pan2.add(two = new JButton("2"));
        pan2.add(equals = new JButton("="));    //equals
        pan2.add(one = new JButton("1"));
        pan2.add(zero = new JButton("0"));
        pan2.add(dott = new JButton("."));  //point

        //numbers..
        zero.addActionListener(new MyActionListener());
        one.addActionListener(new MyActionListener());
        two.addActionListener(new MyActionListener());
        three.addActionListener(new MyActionListener());
        four.addActionListener(new MyActionListener());
        five.addActionListener(new MyActionListener());
        six.addActionListener(new MyActionListener());
        seven.addActionListener(new MyActionListener());
        eight.addActionListener(new MyActionListener());
        nine.addActionListener(new MyActionListener());
        //operations
        plus.addActionListener(new MyActionListener());
        minus.addActionListener(new MyActionListener());
        times.addActionListener(new MyActionListener());
        divide.addActionListener(new MyActionListener());
        conv.addActionListener(new MyActionListener());
        clear.addActionListener(new MyActionListener());
        equals.addActionListener(new MyActionListener());
        dott.addActionListener(new MyActionListener());
        //....
        divide.setBackground(Color.ORANGE);
        times.setBackground(Color.ORANGE);
        plus.setBackground(Color.ORANGE);
        minus.setBackground(Color.ORANGE);
        equals.setBackground(Color.ORANGE);
        one.setBackground(Color.LIGHT_GRAY);
        two.setBackground(Color.LIGHT_GRAY);
        three.setBackground(Color.LIGHT_GRAY);
        four.setBackground(Color.LIGHT_GRAY);
        five.setBackground(Color.LIGHT_GRAY);
        six.setBackground(Color.LIGHT_GRAY);
        seven.setBackground(Color.LIGHT_GRAY);
        eight.setBackground(Color.LIGHT_GRAY);
        nine.setBackground(Color.LIGHT_GRAY);
        zero.setBackground(Color.LIGHT_GRAY);
        clear.setBackground(Color.WHITE);
        conv.setBackground(Color.WHITE);
        dott.setBackground(Color.WHITE);
        add(pan,BorderLayout.NORTH);
        add(pan2,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Simple Calculator"); // "super" JFrame sets title
        setSize(300, 320);         // "super" JFrame sets initial size
        setVisible(true);
    }

    public class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == zero){
                resetNum();
                if(disp.compareTo("0") != 0) {  //adding zero only once if text field is only 0
                    disp += "0";
                    input.setText(disp);
                }
                //adding zero
            } else if(e.getSource() == one){
                resetNum();
                disp += "1";
                input.setText(disp);
                //one
            } else if(e.getSource() == two){
                resetNum();
                disp += "2";
                input.setText(disp);
                //two
            } else if(e.getSource() == three){
                resetNum();
                disp += "3";
                input.setText(disp);
                //three
            } else if(e.getSource() == four){
                resetNum();
                disp += "4";
                input.setText(disp);
                //four
            } else if(e.getSource() == five){
                resetNum();
                disp += "5";
                input.setText(disp);
                //five
            } else if(e.getSource() == six){
                resetNum();
                disp += "6";
                input.setText(disp);
                //six
            } else if(e.getSource() == seven){
                resetNum();
                disp += "7";
                input.setText(disp);
                //7
            } else if(e.getSource() == eight){
                resetNum();
                disp += "8";
                input.setText(disp);
                //eight
            } else if(e.getSource() == nine){
                resetNum();
                disp += "9";
                input.setText(disp);
                //nine
            } else if(e.getSource() == dott){
                disp += ".";
                input.setText(disp);
                decimal = true;
                //adding decimals
            } else if(e.getSource() == clear){
                //if it sees error reset everything
                if(disp.compareTo("ERROR") == 0){
                    resetNum();
                } else if(disp.compareTo("") != 0){ //erases the last character
                    disp = disp.replace(disp.substring(disp.length()-1), "");
                }
                input.setText(disp);

            } else if(e.getSource() == conv) {
                //converting
                if(disp.compareTo("") != 0) {
                    b1 = new BigDecimal(disp);
                    b1 = b1.negate();
                    disp = b1.toString();
                    input.setText(disp);
                }
            } else if(e.getSource() == plus){

                if(num){    //if adding only once
                    b1 = new BigDecimal(disp);
                    num = false;

                } else {    //if adding more than once
                    b1 = b1.add(new BigDecimal(disp));
                }
                disp = "";
                input.setText(disp);
                pressoper = ADD;

            } else if(e.getSource() == minus){

                if(num){    //if subtracting only once
                    b1 = new BigDecimal(disp);
                    num = false;
                } else {    //subtracting more than once
                    b1 = b1.subtract(new BigDecimal(disp));
                }
                disp = "";
                input.setText(disp);
                pressoper = SUBTRACT;

            } else if(e.getSource() == times){

                if(num){    //multiplying once
                    b1 = new BigDecimal(disp);
                    num = false;
                } else {    //multiplying more than once
                    b1 = b1.multiply(new BigDecimal(disp));
                }

                disp = "";
                input.setText(disp);
                pressoper = MULTIPLY;

            } else if(e.getSource() == divide){
                //if divisor is zero print error
                if(b1 != null && disp.compareTo("0") == 0){
                    disp = "ERROR";
                    input.setText(disp);
                    pressoper = -1;

                } else {
                    if (num) {  //dividing only once
                        b1 = new BigDecimal(disp);
                        num = false;

                    } else {    //dividing twice

                        b1 = b1.divide(new BigDecimal(disp), 5, RoundingMode.HALF_UP);
                    }
                    pressoper = DVD;
                    disp = "";
                    input.setText(disp);
                }

            }  else if(e.getSource() == equals){
                if(pressoper != EQUALS && pressoper != -1) {
                    boolean err = false;
                    if (pressoper == ADD) { //adding once
                        b1 = b1.add(new BigDecimal(disp));

                    } else if (pressoper == SUBTRACT) { //subtracting once
                        b1 = b1.subtract(new BigDecimal(disp));

                    } else if (pressoper == MULTIPLY) { //multiplying once
                        b1 = b1.multiply(new BigDecimal(disp));

                    } else if (pressoper == DVD) {

                        if(b1 != null && disp.compareTo("0") == 0){
                            err = true; //if divisor is zero

                        } else {    //dividing once
                            b1 = b1.divide(new BigDecimal(disp), 5, RoundingMode.HALF_UP);
                        }
                    }
                    if(!err) {
                        if (!decimal) { //if not decimal then converting to integer
                            BigInteger i1;
                            i1 = b1.toBigInteger();
                            disp = i1.toString();
                            input.setText(i1.toString());

                        } else {    //if decimal
                            disp = b1.toString();
                            input.setText(b1.toString());
                        }
                        pressoper = EQUALS; //to know that the previous operation is equals
                    } else {    //dividing errors
                        pressoper = -1;
                        disp = "ERROR"; //display error
                        input.setText(disp);
                    }
                    num = true;
                    decimal = false;
                } else {    //if the user didn't inputted any operations simply display
                    input.setText(disp);
                }
            }
        }
    }

    private void resetNum(){    //resetting the numbers;
        if(pressoper == EQUALS){
            disp = "";
            input.setText(disp);
            pressoper = -1;
        }
    }

    public static void main(String[] args){
        new Calculator();

    }
}
