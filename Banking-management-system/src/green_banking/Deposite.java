package green_banking;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Deposite extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private JButton btnDeposite;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("null")
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
	private JTextField textField_1;
	private JLabel lblAccountNo;
	private JLabel lblPleaseProvideThe;

	public Deposite() {
		conn = sqliteConnection.dbConnector();
		setTitle("Transection menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterAmountTo = new JLabel("Enter amount");
		lblEnterAmountTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterAmountTo.setBounds(12, 187, 109, 34);
		contentPane.add(lblEnterAmountTo);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(153, 255, 153));
		textField.setBounds(133, 106, 307, 33);
		contentPane.add(textField);

		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setForeground(new Color(255, 51, 0));
		button.setBounds(162, 281, 104, 46);
		contentPane.add(button);

		btnDeposite = new JButton("Deposite");
		btnDeposite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if ( textField.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Enter amount");

				else
				{
					try {
						String query = "SELECT Balance FROM acc WHERE Acc_No = '"+textField.getText()+"' ";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs = pst.executeQuery();

						int OldBalance = rs.getInt("Balance");
						int NewBalance = Integer.parseInt(textField_1.getText());
						int UpdatedBalance = OldBalance + NewBalance;

						String query2 = "UPDATE acc SET Balance = '"+UpdatedBalance+"' WHERE Acc_No = '"+textField.getText()+"' ";
						PreparedStatement pst2 = conn.prepareStatement(query2);

						pst2.execute();
						JOptionPane.showMessageDialog(null, "Amount is successfuly added! New balance is: " + UpdatedBalance);

						pst.close();
						rs.close();
						pst2.close();
						dispose();

					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnDeposite.setForeground(Color.BLUE);
		btnDeposite.setBounds(308, 281, 104, 46);
		contentPane.add(btnDeposite);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(153, 255, 153));
		textField_1.setBounds(133, 187, 307, 33);
		contentPane.add(textField_1);

		lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccountNo.setBounds(12, 104, 98, 34);
		contentPane.add(lblAccountNo);

		lblPleaseProvideThe = new JLabel("Please provide the correct information");
		lblPleaseProvideThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseProvideThe.setBounds(12, 13, 400, 46);
		contentPane.add(lblPleaseProvideThe);
	}

}
