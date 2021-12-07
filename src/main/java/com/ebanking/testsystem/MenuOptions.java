package com.ebanking.testsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOptions frameMenu = new MenuOptions();
					frameMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client - eBanking Menu");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton balanceButton = new JButton("Balance");
		balanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientGUI_Login client = new ClientGUI_Login();
			}
		});
		balanceButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		balanceButton.setBounds(159, 32, 117, 30);
		contentPane.add(balanceButton);
		
		JButton payButton = new JButton("Bill Payment");
		payButton = new JButton("Bill Payment");
		payButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		payButton.setBounds(159, 87, 117, 30);
		contentPane.add(payButton);
		
		JButton tradeButton = new JButton("Trade");
		tradeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		tradeButton.setBounds(159, 136, 117, 30);
		contentPane.add(tradeButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitButton.setBounds(180, 199, 72, 30);
		contentPane.add(exitButton);
		
		/*
	
			
			
			payButton = new JButton("Bill Payment");
			payButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			payButton.setBounds(159, 87, 117, 30);
			frame.getContentPane().add(payButton);
			//balanceButton.addActionListener(new ActionListener() {
				//public void actionPerformed(ActionEvent e) {
					//initialize2();
				//}
			//}
			tradeButton = new JButton("Trade");
			tradeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			tradeButton.setBounds(159, 136, 117, 30);
			frame.getContentPane().add(tradeButton);
			
			exitButton = new JButton("Exit");
			exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			exitButton.setBounds(180, 199, 72, 30);
			frame.getContentPane().add(exitButton);
		}
		*/
	}
}
