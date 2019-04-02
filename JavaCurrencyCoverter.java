import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//ChevonieDanielProgramV extends JFrame to use it's properties
public class ChevonieDanielProgramV extends JFrame {
	
	//declares instance variables
	private JButton convButton;
	private JLabel convLabel;
	private JLabel initCurrLabel;
	private JLabel convCurrLabel;
	private JLabel headerLabel;
	
	private JTextField initCurrField;
	
	private JPanel convPanel;
	
	private JComboBox<String> initCurrCombo;
	private JComboBox<String> convCurrCombo;
	
	private double initAmnt;
	private double convAmnt;
	
	private static final int CONVFRAME_WIDTH = 370;
	private static final int CONVFRAME_HEIGHT = 190;

	private static final double EUR_TO_USD = 1.42;
	private static final double GBP_TO_USD = 1.64;
	private static final double GBP_TO_EUR = 1.13;
	
	private final int CURR_FIELD_WIDTH = 9;
	
	//Constructor calls createComponents & setSize function
	public ChevonieDanielProgramV() {
		
		createComponents();
		setSize(CONVFRAME_WIDTH, CONVFRAME_HEIGHT);
	}
	
	//Main function sets main attributes of frame
	public static void main(String[] args) {
		
		JFrame convFrame = new ChevonieDanielProgramV();
	
		convFrame.setTitle("Chevonie's Currency Converter");
		convFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		convFrame.setVisible(true);
	}
	
	//Determines properties of the gui
	public void createComponents() {
		
		headerLabel = new JLabel("CHEVONIE'S CURRENCY CONVERTER");
		
		initCurrLabel = new JLabel("Initial Currency Amount: ");
		convCurrLabel = new JLabel("Convert to: ");
		
		initCurrField = new JTextField(CURR_FIELD_WIDTH);
		
		initCurrCombo = new JComboBox<String>();
		initCurrCombo.addItem("USD");
		initCurrCombo.addItem("GBP");
		initCurrCombo.addItem("EUR");
		
		convCurrCombo = new JComboBox<String>();
		convCurrCombo.addItem("USD");
		convCurrCombo.addItem("GBP");
		convCurrCombo.addItem("EUR");
		
		convButton = new JButton("CONVERT");
		convLabel = new JLabel();	
		
		convPanel = new JPanel();
		
		convPanel.add(headerLabel);
		convPanel.add(initCurrLabel);
		convPanel.add(initCurrCombo);
		convPanel.add(initCurrField);
		convPanel.add(convCurrLabel);
		convPanel.add(convCurrCombo);
		convPanel.add(convButton);
		convPanel.add(convLabel);

		add(convPanel);
		
		ActionListener convButtonlistener = new convertListener();
		convButton.addActionListener(convButtonlistener);
	}
	
	//Implements ActionListener in another class for convenience
	public class convertListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			//Casts combo selection as string
			String initCurrStr = (String) initCurrCombo.getSelectedItem();
			String convCurrStr = (String) convCurrCombo.getSelectedItem();
			
			//Try block contains conditions that determine what will be converted
			try {
			
				if (initCurrStr == "EUR" && convCurrStr == "USD") {
					
					initAmnt = Double.parseDouble(initCurrField.getText());
					convAmnt = initAmnt * EUR_TO_USD;
					double roundedConvAmnt = Math.round(convAmnt * 100.0) / 100.0;
					
					if (initAmnt >= 0 && initAmnt < 99999999999.0) {
						convLabel.setText("$" + roundedConvAmnt);
					}
					else {
						convLabel.setText("Your number must be between 0 and 99999999999");
					}
				}
				
				else if (initCurrStr == "GBP" && convCurrStr == "USD") {
					
					initAmnt = Double.parseDouble(initCurrField.getText());
					convAmnt = initAmnt * GBP_TO_USD;
					double roundedConvAmnt = Math.round(convAmnt * 100.0) / 100.0;
					
					if (initAmnt >= 0 && initAmnt < 99999999999.0) {
						convLabel.setText("$" + roundedConvAmnt);
					}
					else {
						convLabel.setText("Your number must be between 0 and 99999999999");
					}
				}
				
				else if (initCurrStr == "GBP" && convCurrStr == "EUR") {
					
					initAmnt = Double.parseDouble(initCurrField.getText());
					convAmnt = initAmnt * GBP_TO_EUR;
					double roundedConvAmnt = Math.round(convAmnt * 100.0) / 100.0;
					
					if (initAmnt >= 0 && initAmnt < 99999999999.0) {
						convLabel.setText("€" + roundedConvAmnt);
					}
					else {
						convLabel.setText("Your number must be between 0 and 99999999999");
					}
				}
				
				else if (initCurrStr == "USD" && convCurrStr == "EUR") {
					
					initAmnt = Double.parseDouble(initCurrField.getText());
					convAmnt = initAmnt / EUR_TO_USD;
					double roundedConvAmnt = Math.round(convAmnt * 100.0) / 100.0;
					
					if (initAmnt >= 0 && initAmnt < 99999999999.0) {
						convLabel.setText("€" + roundedConvAmnt);
					}
					else {
						convLabel.setText("Your number must be between 0 and 99999999999");
					}
				}
				
				else if (initCurrStr == "USD" && convCurrStr == "GBP") {
					
					initAmnt = Double.parseDouble(initCurrField.getText());
					convAmnt = initAmnt / GBP_TO_USD;
					double roundedConvAmnt = Math.round(convAmnt * 100.0) / 100.0;
					
					if (initAmnt >= 0 && initAmnt < 99999999999.0) {
						convLabel.setText("£" + roundedConvAmnt);
					}
					else {
						convLabel.setText("Your number must be between 0 and 99999999999");
					}
				}
				
				else if (initCurrStr == "EUR" && convCurrStr == "GBP") {
					
					initAmnt = Double.parseDouble(initCurrField.getText());
					convAmnt = initAmnt / GBP_TO_EUR;
					double roundedConvAmnt = Math.round(convAmnt * 100.0) / 100.0;
					
					if (initAmnt >= 0 && initAmnt < 99999999999.0) {
						convLabel.setText("£" + roundedConvAmnt);
					}
					else {
						convLabel.setText("Your number must be between 0 and 99999999999");
					}
				}
				
				//Warns that two currencies were not selected
				else {
					
					convLabel.setText("Please choose two different currencies");
				}
			}
			
			//Catches invalid input and prompts for valid input
			catch (NumberFormatException exp1) {
				
				convLabel.setText("Invalid Number! Please enter a valid number");
			}
		}
	}
	
}