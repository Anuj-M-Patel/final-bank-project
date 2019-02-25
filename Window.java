import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame {

	ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	
	public Window() {
		setTitle("Bank");
		setLayout(null);
		setBounds(100, 100, 400, 350);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(20, 20, 50, 50);
		add(nameLabel);
		
		JTextField nameField = new JTextField("");
		nameField.setBounds(120, 20, 100, 50);
		add(nameField);
		
		JLabel accountTypeField = new JLabel("Account Type: ");
		accountTypeField.setBounds(20, 80, 100, 50);
		add(accountTypeField);
		
		String[] accountTypes = {"Checkings", "Savings"};
		JComboBox accountTypeBox = new JComboBox(accountTypes);
		accountTypeBox.setBounds(120, 80, 100, 50);
		add(accountTypeBox);
		
		JLabel balanceLabel = new JLabel("Initial Balance: ");
		balanceLabel.setBounds(20, 140, 100, 50);
		add(balanceLabel);
		
		JTextField balanceField = new JTextField("");
		balanceField.setBounds(120, 140, 100, 50);
		add(balanceField);
		
		JLabel notificationLabel = new JLabel("");
		notificationLabel.setBounds(40, 190, 100, 50);
		add(notificationLabel);
		
		JButton makeAccountButton = new JButton("Make Account");
		makeAccountButton.setBounds(20, 240, 150, 50);
		makeAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (accountTypeBox.getSelectedItem().equals("Checkings")) {
					bankAccounts.add(new CheckingAccount(nameField.getText(), Integer.parseInt(balanceField.getText()), 0, 0, 0));
					notificationLabel.setText("Account Created");
					repaint();
				}
				else if (accountTypeBox.getSelectedItem().equals("Savings")) {
					bankAccounts.add(new SavingsAccount(nameField.getText(), Integer.parseInt(balanceField.getText()), 0, 0, 0));
					notificationLabel.setText("Account Created");
					repaint();
				}
			}
		});
		add(makeAccountButton);
		
		//accountsLabel.setBounds(260, 20, 100, 100);
		//add(accountsLabel);
		
		JButton showAccountsButton = new JButton("Show Accounts");
		showAccountsButton.setBounds(220, 240, 150, 50);
		showAccountsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<JLabel> accountLabels = new ArrayList<JLabel>();
				for (BankAccount bankAccount : bankAccounts) {
					accountLabels.add(new JLabel(bankAccount.toString()));
					System.out.println(bankAccount.toString());
				}
				for (int i = 0; i < accountLabels.size(); i++) {
					accountLabels.get(i).setBounds(260, 20 * (i+1), 100, 100);
					add(accountLabels.get(i));
				}
				repaint();
			}
		});
		add(showAccountsButton);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		new Window();
	}
	
	
}
