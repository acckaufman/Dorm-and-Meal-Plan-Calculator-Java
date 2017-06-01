package chapter12;

//imports
import java.awt.*;
import javax.swing.*;		//Needed for Swing classes
import java.awt.event.*;	//Needed for event listener interface

/**
 * Amanda Kaufman
 * Chapter 12 
 * Programming Challenge 3, 
 * Dorm and Meal Plan Calculator
 */

public class DormAndMealPlanCalc extends JFrame {
	//Window size variables
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 300;
	
	// Array with dorm names
	private String [] dormNames = { "Allen Hall", "Pike Hall", "Farthing Hall", "University Suites" };

	// Array with meal plan descriptions
	private String [] mealPlans = { "7 meals per week", "14 meals per week", "Unlimited meals" };

    // Combo box to display dorms
	private JComboBox dormBox;
	
	// Combo box to display meal plans
	private JComboBox mealBox;

	// To calculate prices
	private JButton calcPrices;
	
	// To exit the application
	private JButton exitApp;

    // Panel for dorm combo box
	private JPanel dormPanel;
	
	// Panel for meal combo box
	private JPanel mealPanel;
	
	// Panel for the buttons
	private JPanel buttonPanel;

	/**
	 * Constructor
	 */

	public DormAndMealPlanCalc() {
		// Display a title.
		super("Dorm and Meal Plan Calculator");
		
		//Set the size of the window.
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		//Create a border layout manager for the content pane.
		setLayout(new BorderLayout());
		
		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the dorm panel.
		buildDormPanel();
		
		// Build the meal plan panel.
		buildMealPanel();

		// Build the button panel.
		buildButtonPanel();

		// Add the panels to the content pane.
		add(dormPanel, BorderLayout.NORTH);
		add(mealPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		// Pack and display the window.
		pack();
		setVisible(true);
	}

	/**
	 * buildDormPanel method
	 */

	private void buildDormPanel() {
		//Create a JPanel object and let the dormPanel field reference it.
		dormPanel = new JPanel();
		
		// Create a label prompting the user to select a dorm.
		JLabel dormLabel = new JLabel("Select a Dorm: ");

		// Create the dorm combo box.
		dormBox = new JComboBox(dormNames);

		// Put the components in a panel.
		dormPanel.add(dormLabel);
		dormPanel.add(dormBox);
	}

	/**
	 * buildMealPanel method
	 */

	private void buildMealPanel() {
		//Create a JPanel object and let the dormPanel field reference it.
		mealPanel = new JPanel();
		
		// Create a label prompting the user to select a meal plan.
		JLabel mealLabel = new JLabel("Select a Meal Plan: ");

		// Create the meal plan combo box.
		mealBox = new JComboBox(mealPlans);

		// Put the components in a panel.
		mealPanel.add(mealLabel);
		mealPanel.add(mealBox);
	}

	/**
	 * buildButtonPanel method
	 */

	private void buildButtonPanel() {
		//Create a JPanel object and let the dormPanel field reference it.
		buttonPanel = new JPanel();
		
		// Create a button to calculate the charges.
		calcPrices = new JButton("Calculate Prices");

		// Add an action listener to the button.
		calcPrices.addActionListener(new CalcButtonListener());

		// Create a button to exit the application.
		exitApp = new JButton("Exit");

		// Add an action listener to the button.
		exitApp.addActionListener(new ExitButtonListener());

		// Put the buttons in their own panel.
		buttonPanel.add(calcPrices);
		buttonPanel.add(exitApp);
	}

	
	/**
	 * CalcButtonListener is an action listener class for the calcbutton
	 * component.
	 */

	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Variables for calculations
			int dormCost = 0;
			int mealCost = 0;
			int totalCost = 0;
			
			//Get the values selected by the user.
			String dormSelection = (String) dormBox.getSelectedItem();
			String mealPlanSelection = (String) mealBox.getSelectedItem();
			
			//Set the value of dormCost based on the dorm selected by the user.
			if (dormSelection == "Allen Hall")
				dormCost = 1500;
			else if (dormSelection == "Pike Hall")
				dormCost = 1600;
			else if (dormSelection == "Farthing Hall")
				dormCost = 1200;
			else if (dormSelection == "University Suites")
				dormCost = 1800;
			
			//Set the value of mealCost based on the meal plan selected by the user.
			if (mealPlanSelection == "7 meals per week")
				mealCost = 560;
			else if (mealPlanSelection == "14 meals per week")
				mealCost = 1095;
			else if (mealPlanSelection == "Unlimited meals")
				mealCost = 1500;
			
			//Calculate the total cost.
			totalCost = dormCost + mealCost;
			
			//Create a popup message box that tells the user the total cost.
			JOptionPane.showMessageDialog(null,  "Total Charges per Semester: $" + totalCost);
		}
	}
	
	/**
	 * ExitButtonListener is an action listener class for the exitButton
	 * component.
	 */

	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	/**
	 * The main method creates an instance of the DormAndMealPlanCalc class.
	 */
	public static void main(String[] args) {
		DormAndMealPlanCalc dmpc = new DormAndMealPlanCalc();
	}
}
