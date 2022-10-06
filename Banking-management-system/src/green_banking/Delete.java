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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Delete extends JFrame {

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
	private JTable table;

	public Delete() {
		setTitle("Delete Record");
		conn = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 68, 700, 200);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		fetch();

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if ( textField.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Enter Account No.");

				else
				{
					try {
						String query = "SELECT Acc_No FROM acc WHERE Acc_No = '"+textField.getText()+"' ";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						if (!rs.next()){
							JOptionPane.showMessageDialog(null, "Account No: " + textField.getText() + " not found!");
						}
						else {
						
						String query2 = "DELETE FROM acc WHERE Acc_No = '"+textField.getText()+"' ";
						PreparedStatement pst2 = conn.prepareStatement(query2);
						pst2.execute();
						JOptionPane.showMessageDialog(null, "Record deleted!");

						pst.close();
						pst2.close();
						rs.close();
						dispose();
						}
						

					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}

			}
		});
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setBounds(388, 378, 104, 46);
		contentPane.add(btnDelete);

		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setForeground(new Color(255, 51, 0));
		button_1.setBounds(241, 378, 104, 46);
		contentPane.add(button_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(153, 255, 153));
		textField.setBounds(173, 285, 369, 33);
		contentPane.add(textField);

		JLabel lblEnterAccountNumber = new JLabel("Enter account Number");
		lblEnterAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterAccountNumber.setBounds(209, 188, 181, 34);
		contentPane.add(lblEnterAccountNumber);

		JLabel lblNewLabel = new JLabel("Please provide the correct account number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 3, 314, 33);
		contentPane.add(lblNewLabel);
	}
	public void fetch()
	{
		try {

			String query = "SELECT * FROM acc";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
