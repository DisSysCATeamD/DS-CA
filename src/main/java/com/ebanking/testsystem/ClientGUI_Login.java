package com.ebanking.testsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI_Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI_Login window = new ClientGUI_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(156, 71, 136, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel Ursnmlabel = new JLabel("Username:");
		Ursnmlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Ursnmlabel.setBounds(76, 71, 70, 29);
		frame.getContentPane().add(Ursnmlabel);
		
		JLabel Psswrdlabel = new JLabel("Password:");
		Psswrdlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Psswrdlabel.setBounds(76, 110, 70, 29);
		frame.getContentPane().add(Psswrdlabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 113, 136, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//when button is clicked the username and password messages need to be sent to the server for response
				//not sure how to do this yet
				JOptionPane.showMessageDialog(null, "Validating, please wait");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(156, 189, 136, 37);
		frame.getContentPane().add(btnNewButton);
		
		JLabel LoginLabel = new JLabel("Welcome to Mafi Bank");
		LoginLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		LoginLabel.setBounds(108, 10, 219, 32);
		frame.getContentPane().add(LoginLabel);
	}
}
