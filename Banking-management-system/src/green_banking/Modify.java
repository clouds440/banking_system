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

public class Modify extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	private JTextField textField;
	private JComboBox<String> comboType;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	public Modify() {
		setTitle("Modification menu");
		conn = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 707);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("ACCOUNT NO");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(12, 69, 118, 33);
		contentPane.add(label);

		JLabel label_1 = new JLabel("NAME");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(12, 189, 89, 33);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("TYPE");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(12, 264, 89, 25);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("BALANCE");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(12, 332, 104, 33);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Contact");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(12, 400, 104, 33);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(153, 255, 153));
		textField.setBounds(190, 70, 400, 33);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(153, 255, 153));
		textField_1.setBounds(190, 190, 400, 33);
		contentPane.add(textField_1);

		String type[] = { "Select", "Term Deposit", "Saving", "Current", "Foreign Currency" };
		comboType = new JComboBox<>(type);
		comboType.setBackground(new Color(153, 255, 153));
		comboType.setBounds(188, 261, 402, 35);
		contentPane.add(comboType);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(153, 255, 153));
		textField_3.setBounds(190, 333, 402, 33);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(153, 255, 153));
		textField_4.setBounds(188, 401, 402, 33);
		contentPane.add(textField_4);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 127, 780, 2);
		contentPane.add(separator);

		JLabel lblPleaseEnterThe = new JLabel("Please enter the account number whose data is to be modified");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterThe.setBounds(12, 13, 578, 33);
		contentPane.add(lblPleaseEnterThe);

		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setForeground(new Color(255, 51, 0));
		button.setBounds(263, 497, 104, 46);
		contentPane.add(button);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if ( textField.getText().isEmpty() || textField_1.getText().isEmpty() || comboType.getSelectedItem() == "Select" || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Please fill all the fields and then click Update");

				else {

					try {

						String query = "UPDATE acc SET Name ='"+textField_1.getText()+"', Acc_Type ='"+comboType.getSelectedItem().toString()+"', Balance = '"+textField_3.getText()+"', Contacts = '"+textField_4.getText()+"' where Acc_No ='"+textField.getText()+"'  ";
						PreparedStatement pst = conn.prepareStatement(query);

						pst.execute();

						JOptionPane.showMessageDialog(null, "Account has been succesfuly Updated...");

						pst.close();
						dispose();

					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBounds(409, 497, 104, 46);
		contentPane.add(btnUpdate);

		JLabel lblEnterNewRecord = new JLabel("Enter new record here");
		lblEnterNewRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterNewRecord.setBounds(10, 143, 180, 33);
		contentPane.add(lblEnterNewRecord);
	}

}
