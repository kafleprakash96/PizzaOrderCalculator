package com.company;

//import necessary class
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Create class for greeting panel
class GreetingPanel extends JPanel{

    public GreetingPanel(){
        JLabel greetingLabel = new JLabel("Welcome to Pizza Order Calculator");

        //add greetingLabel to Panel
        add(greetingLabel);
    }
}

// create panel for size, toppings and drinks

//Create size panel class
class SizePanel extends JPanel {

    //create JRadioButton object for each size
    private JRadioButton smallButton;
    private JRadioButton mediumButton;
    private JRadioButton largeButton;

    JButton seePriceButton; //this button is use te see the price

    //set price for each size
    public final double SMALL_SIZE = 9.99;
    public final double MEDIUM_SIZE = 12.99;
    public final double LARGE_SIZE = 14.99;

    //Create constructor
    public SizePanel() {
        //Create buttons
        smallButton = new JRadioButton("Small");
        mediumButton = new JRadioButton("Medium");
        largeButton = new JRadioButton("Large");
        seePriceButton = new JButton("See Price");

        seePriceButton.addActionListener(new SeePriceListener());

        //set layout for buttons
        setLayout(new GridLayout(4, 1));

        //set title for the panel
        setBorder(BorderFactory.createTitledBorder("Size"));

        //Group the radio buttons together
        ButtonGroup group = new ButtonGroup();
        group.add(smallButton);
        group.add(mediumButton);
        group.add(largeButton);

        //add buttons to the panel
        add(smallButton);
        add(mediumButton);
        add(largeButton);
        add(seePriceButton);

    }

    //create class SeePriceListener that execute when See Price button is clicked
    private class SeePriceListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,String.format("Small: $%.2f \n" +
                                                                              "Medium: $%.2f \n"+
                                                                                "Large: $%.2f ",SMALL_SIZE,MEDIUM_SIZE,LARGE_SIZE));
        }
    }

    //create method to get price of the selected pizza size
    public double getSizeCost(){
        double total = 0.0;
        if(smallButton.isSelected()){
            total += SMALL_SIZE;
        }
        else if(mediumButton.isSelected()){
            total += MEDIUM_SIZE;
        }
        else if(largeButton.isSelected()){
            total += LARGE_SIZE;
        }
        return total;
    }
}

//create toppings panel class
class ToppingPanel extends JPanel {

    //create check box buttons for each toppings
    private JCheckBox cheeseBox;
    private JCheckBox onionsBox;
    private JCheckBox pineappleBox;
    private JCheckBox mushroomBox;
    private JButton seePriceButton;

    //set price for toppings
    public final double CHEESE = 0.0;
    public final double ONIONS = 0.0;
    public final double PINEAPPLE = 0.25;
    public final double MUSHROOM = 0.25;

    //Create constructor
    public ToppingPanel() {

        //Create buttons
        cheeseBox = new JCheckBox("Cheese");
        onionsBox = new JCheckBox("Onions");
        pineappleBox = new JCheckBox("Pineapple");
        mushroomBox = new JCheckBox("Mushroom");
        seePriceButton = new JButton("See Price");

        seePriceButton.addActionListener(new SeePriceListener());

        setLayout(new GridLayout(5, 1)); //set layout for 5 buttons in 1 row

        setBorder(BorderFactory.createTitledBorder("Toppings")); //set title for to the panel

        //add all buttons to the panel
        add(cheeseBox);
        add(onionsBox);
        add(pineappleBox);
        add(mushroomBox);
        add(seePriceButton);

    }

    //create class to handle See Price button when clicked
    private class SeePriceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, String.format("Cheese and Onions for free. \n" +
                    "Adding pineapple and mushroom costs %.2f each", PINEAPPLE));
        }
    }

    //Create method to get price of selected toppings.
    public double getToppingPrice() {
        double total = 0.0;

        if (cheeseBox.isSelected()) {
            total += CHEESE;
        }
        if (onionsBox.isSelected()) {
            total += ONIONS;
        }
        if (mushroomBox.isSelected()) {
            total += MUSHROOM;
        }
        if (pineappleBox.isSelected()) {
            total += PINEAPPLE;
        }
        return total;
    }
}


class DrinksPanel extends JPanel{

    //declare required buttons objects
    private JRadioButton noSodaButton;
    private JRadioButton fantaButton;
    private JRadioButton cokeButton;
    private JRadioButton spriteButton;
    private JButton seePriceButton;

    private ButtonGroup group;

    //set price of drinks
    public final double NO_SODA_PRICE = 0.0;
    public final double FANTA_PRICE = 2.09;
    public final double COKE_PRICE = 2.09;
    public final double SPRITE_PRICE = 2.09;

    public DrinksPanel(){

        //create buttons
        noSodaButton = new JRadioButton("No Soda");
        fantaButton = new JRadioButton("Fanta");
        cokeButton = new JRadioButton("Coke");
        spriteButton = new JRadioButton("Sprite");
        seePriceButton = new JButton("See Price");

        seePriceButton.addActionListener(new SeePriceListener());

        setLayout(new GridLayout(5,1)); //set layout for 5 buttons in 1 row

        setBorder(BorderFactory.createTitledBorder("Drinks")); //set panel title

        //group the buttons together
        group = new ButtonGroup();

        group.add(noSodaButton);
        group.add(fantaButton);
        group.add(cokeButton);
        group.add(spriteButton);

        //add buttons to the panel
        add(noSodaButton);
        add(fantaButton);
        add(cokeButton);
        add(spriteButton);
        add(seePriceButton);

    }

    //create private class SeePriceListener to handle See Price button when clicked
    private class SeePriceListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,String.format("All soda are of same price $%.2f ", FANTA_PRICE));
        }
    }

    //Create method to get selected drink price
    public double getDrinksPrice(){

        double total = 0.0;

        if(noSodaButton.isSelected()){
            total += NO_SODA_PRICE;
        }
        else if(fantaButton.isSelected()){
            total += FANTA_PRICE;
        }
        else if(cokeButton.isSelected()){
            total += COKE_PRICE;
        }
        else if(spriteButton.isSelected()){
            total += SPRITE_PRICE;
        }

        return total;
    }
}



public class OrderCalculatorGUI extends JFrame {

    //Create object for each created class
    private SizePanel sizePanel;
    private GreetingPanel greetingPanel;
    private ToppingPanel toppingPanel;
    private DrinksPanel drinksPanel;

    //Create button objects for calculate and exit buttons
    private JButton calculateButton;
    private JButton exitButton;

    private JPanel panel; //panel needed for calculate and exit button

    private final double TAX_RATE = 0.0825; //set tax rate

    public OrderCalculatorGUI(){

        //instantiate the objects of created class
        sizePanel = new SizePanel();
        greetingPanel = new GreetingPanel();
        toppingPanel = new ToppingPanel();
        drinksPanel = new DrinksPanel();


        setTitle("Pizza Order Calculator"); //Set title on frame
        setLayout(new BorderLayout()); //To add panels to desired direction
        setSize(500,500); //Set size pf frame
        setLocation(500,20); //Set location to be displayed on the screen

        //add all panels to the frame
        add(greetingPanel,BorderLayout.NORTH);
        add(sizePanel,BorderLayout.WEST);
        add(toppingPanel,BorderLayout.CENTER);
        add(drinksPanel,BorderLayout.EAST);
        buildPanel();
        add(panel,BorderLayout.SOUTH);
        pack();

        setVisible(true); //Makes the frame visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit when close button (x) is clicked

    }

    //Create buildPanel() method to make panel for calculate and exit buttons

    public void buildPanel(){

        panel = new JPanel(); //Create panel

        //Create buttons
        calculateButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        calculateButton.addActionListener(new CalculateButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        panel.add(calculateButton);
        panel.add(exitButton);

    }

    //Create private class to handle calculate and exit button on clicked
    private class CalculateButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double subTotal , total;

            //get sub total and total price
            subTotal = sizePanel.getSizeCost() + toppingPanel.getToppingPrice() + drinksPanel.getDrinksPrice();
            total = (subTotal * TAX_RATE) + subTotal;

            JOptionPane.showMessageDialog(null,String.format("Sub total: $%.2f\n" +
                                                                            "Tax: %.4f \n" +
                                                                            "Total: $%.2f \n",subTotal,TAX_RATE,total));
        }
    }

    private class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0); //exits the system
        }
    }

    //main method
    public static void main(String[] args) {
        new OrderCalculatorGUI();
    }
}
