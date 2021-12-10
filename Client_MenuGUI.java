package com.ebanking.testsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//central Client GUI opens once user has logged on
public class Client_MenuGUI {
	
	JFrame frame;	//not private so that it can be called from the Client_LoginGUI
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_MenuGUI window = new Client_MenuGUI();
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
	public Client_MenuGUI() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//when the Balance button is pressed it calls up the Client Balance GUI
		JButton balanceButton = new JButton("Balance");
		balanceButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		balanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//creating an instance of the Client_BalanceGUI and setting it to visible
							Client_BalanceGUI bal = new Client_BalanceGUI();
							bal.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		balanceButton.setBounds(206, 122, 205, 63);
		frame.getContentPane().add(balanceButton);
		
		//when the Bill Payment button is pressed it calls up the Client Payment GUI
		JButton payButton = new JButton("Bill Payment");
		payButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//creating an instance of the Client_PaymentGUI and setting it to visible
							Client_PaymentGUI pay = new Client_PaymentGUI();
							pay.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		payButton.setBounds(206, 230, 205, 63);
		frame.getContentPane().add(payButton);
		
		//when the Trading button is pressed it calls up the Client Trading GUI
		JButton tradeButton = new JButton("Trading");
		tradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	//creating an instance of the Client_TradingGUI and setting it to visible
							Client_TradingGUI trade = new Client_TradingGUI();
							trade.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		tradeButton.setBounds(206, 345, 205, 63);
		tradeButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(tradeButton);

		//when the Exit button is clicked the Client Menu GUI closes
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
						
			}
		});
		exitButton.setBounds(248, 485, 134, 63);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(exitButton);
		
		//Welcome label
		JLabel titlewLabel = new JLabel("Welcome to Mafi Online Banking");
		titlewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		titlewLabel.setBounds(164, 37, 277, 41);
		frame.getContentPane().add(titlewLabel);
		
	
	} //closing initialization
} //closing Client_MenuGUI

