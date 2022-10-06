package green_banking;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Create_Account extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Account;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox<String> comboType;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JOptionPane.showMessageDialog(null,"You are not allowed to enter directly! please go to Start.java and then click run...");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;

	public Create_Account() {
		conn = sqliteConnection.dbConnector();
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Account application menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 646);
		Account = new JPanel();
		Account.setBackground(new Color(102, 255, 153));
		Account.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Account);
		Account.setLayout(null);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(12, 170, 89, 33);
		Account.add(lblName);

		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBalance.setBounds(12, 310, 104, 33);
		Account.add(lblBalance);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(153, 255, 153));
		textField_1.setColumns(10);
		textField_1.setBounds(144, 170, 330, 33);
		Account.add(textField_1);

		textField_3 = new JTextField();
		textField_3.setBackground(new Color(153, 255, 153));
		textField_3.setColumns(10);
		textField_3.setBounds(144, 310, 330, 33);
		Account.add(textField_3);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (textField_1.getText().isEmpty() || comboType.getSelectedItem() == "Select" || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please fill all the fields and then click Submit");

				else {

					try {

						String query = "INSERT INTO acc (Name,Acc_Type,Balance,Contacts) VALUES (?,?,?,?)";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,textField_1.getText());
						pst.setString(2,comboType.getSelectedItem().toString());
						pst.setString(3,textField_3.getText());
						pst.setString(4,textField_4.getText());

						pst.execute();

						JOptionPane.showMessageDialog(null, "Account has been succesfuly created!");

						pst.close();
						dispose();

					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}

				}
			}
		});
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(329, 500, 104, 46);
		Account.add(btnSubmit);

		JLabel lblApplicationFormFor = new JLabel("Application form for creating new account in Green bank");
		lblApplicationFormFor.setForeground(new Color(0, 102, 51));
		lblApplicationFormFor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApplicationFormFor.setBackground(Color.WHITE);
		lblApplicationFormFor.setBounds(12, 0, 534, 46);
		Account.add(lblApplicationFormFor);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 46, 590, 8);
		Account.add(separator);

		JLabel lblNewLabel = new JLabel("Please fill the following data carefully");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 61, 534, 33);
		Account.add(lblNewLabel);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(45, 226, 56, 16);
		Account.add(label_1);

		JLabel lblType = new JLabel("TYPE");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(12, 240, 89, 25);
		Account.add(lblType);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(153, 255, 153));
		textField_4.setBounds(142, 380, 332, 33);
		Account.add(textField_4);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContact.setBounds(12, 380, 104, 33);
		Account.add(lblContact);

		String type[] = { "Select", "Term Deposit", "Saving", "Current", "Foreign Currency" };
		comboType = new JComboBox<>(type);
		comboType.setBackground(new Color(153, 255, 153));
		comboType.setBounds(142, 240, 332, 35);
		Account.add(comboType);

		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setForeground(new Color(255, 51, 0));
		button.setBounds(191, 500, 104, 46);
		Account.add(button);
	}
}