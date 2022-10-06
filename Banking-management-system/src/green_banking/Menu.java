package green_banking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Menu;

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

	public Menu() {
		setTitle("Green banking management menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 662);
		Menu = new JPanel();
		Menu.setBackground(new Color(102, 255, 153));
		Menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Menu);

		JButton btnOpenNew = new JButton("OPEN NEW ACCOUNT IN BANK");
		btnOpenNew.setForeground(Color.GRAY);
		btnOpenNew.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOpenNew.setBounds(200, 108, 307, 52);
		btnOpenNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Create_Account ca = new Create_Account();
				ca.setVisible(true);
			}
		});
		Menu.setLayout(null);
		Menu.add(btnOpenNew);

		JLabel lblWelcome = new JLabel("GREEN BANK MANAGEMENT SOFTWARE");
		lblWelcome.setBackground(Color.WHITE);
		lblWelcome.setForeground(new Color(0, 102, 51));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcome.setBounds(200, -5, 338, 36);
		Menu.add(lblWelcome);

		JButton btnDepositAmountTo = new JButton("DEPOSIT AMOUNT");
		btnDepositAmountTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Deposite o = new Deposite();
				o.setVisible(true);
			}
		});
		btnDepositAmountTo.setForeground(Color.GRAY);
		btnDepositAmountTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDepositAmountTo.setBounds(200, 189, 307, 52);
		Menu.add(btnDepositAmountTo);

		JButton btnWithdrawAmount = new JButton("WITHDRAW AMOUNT");
		btnWithdrawAmount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Withdraw o = new Withdraw();
				o.setVisible(true);
			}
		});
		btnWithdrawAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWithdrawAmount.setForeground(Color.GRAY);
		btnWithdrawAmount.setBounds(200, 269, 307, 52);
		Menu.add(btnWithdrawAmount);

		JButton btnAllAccounts = new JButton("ALL ACCOUNTS LIST");
		btnAllAccounts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Accounts o = new Accounts();
				o.setVisible(true);
			}
		});
		btnAllAccounts.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAllAccounts.setForeground(Color.GRAY);
		btnAllAccounts.setBounds(200, 359, 307, 52);
		Menu.add(btnAllAccounts);

		JButton btnModify = new JButton("MODIFY ACCOUNT");
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Modify o = new Modify();
				o.setVisible(true);

			}
		});
		btnModify.setForeground(Color.GRAY);
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModify.setBounds(200, 439, 307, 52);
		Menu.add(btnModify);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Start o = new Start();
				o.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(625, 10, 86, 34);
		Menu.add(btnLogout);

		JButton buttonDelete = new JButton("DELETE ACCOUNT");
		buttonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Delete o = new Delete();
				o.setVisible(true);
			}
		});
		buttonDelete.setForeground(Color.GRAY);
		buttonDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonDelete.setBounds(200, 519, 307, 52);
		Menu.add(buttonDelete);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 79, 838, 2);
		Menu.add(separator_1);

	}
}
