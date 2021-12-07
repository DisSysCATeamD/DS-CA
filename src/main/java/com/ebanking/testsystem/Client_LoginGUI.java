package com.ebanking.testsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ebanking.testsystem.LoginGrpc.LoginBlockingStub;

import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Client_LoginGUI {
	
	private static LoginBlockingStub blockingStub;
	
	private JFrame frame;
	private JTextField textField_usr;
	private JTextField textField_pwd;
	private JButton btnNewButton_log;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_LoginGUI window = new Client_LoginGUI();
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
	
	public Client_LoginGUI() {
		
			String host = "localhost";
			int port = 50001;
			/*
			ServiceInfo serviceInfo;
			String service_Type = "_grpc._tcp.local.";
			//Now retrieve the service info - all we are supplying is the service type
			serviceInfo = JmDNSDiscovery.run(service_Type);
			//Use the serviceInfo to retrieve the port
			int port = serviceInfo.getPort();
			String host = "localhost";
		
			*/
	
			System.out.println("service running on port: " +port);
		
			ManagedChannel channel1 = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
			blockingStub = LoginGrpc.newBlockingStub(channel1);
			
			initialize();

	}
	
	//Initialize the contents of the frame.
		//Client GUI for Logging on
		private void initialize() {
			frame = new JFrame();		//the outer window
			//Jframe is a window with a title bar
			frame.setTitle("Client - eBanking Logon");
			//set bounds can be done for frames panels and buttons
			frame.setBounds(100, 100, 450, 300);	//size of box and where it appears on the window
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			textField_usr = new JTextField();
			textField_usr.setBounds(156, 71, 136, 32);
			frame.getContentPane().add(textField_usr);
			textField_usr.setColumns(10);
			
			JLabel Ursnmlabel = new JLabel("Username:");
			Ursnmlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			Ursnmlabel.setBounds(76, 71, 70, 29);
			frame.getContentPane().add(Ursnmlabel);
			
			JLabel Psswrdlabel = new JLabel("Password:");
			Psswrdlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			Psswrdlabel.setBounds(76, 110, 70, 29);
			frame.getContentPane().add(Psswrdlabel);
			
			textField_pwd = new JTextField();
			textField_pwd.setBounds(156, 113, 136, 32);
			frame.getContentPane().add(textField_pwd);
			textField_pwd.setColumns(10);
			
			btnNewButton_log = new JButton("Login");
			btnNewButton_log.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try{
					
					String username = textField_usr.getText();
					String password = textField_pwd.getText();
					LoginRequest login = LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
					
					LoginValidation reply = blockingStub.sayLogin(login);
									
					JOptionPane.showMessageDialog(null, "Validating, please wait");
					
					JOptionPane.showMessageDialog(null, "Response" +reply.getValid());	
						frame.dispose();
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
					
					Thread.sleep(5000);
					
				} catch(StatusRuntimeException el) {
						el.printStackTrace();
				} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
					//initializeMenu();
				}
			});
			btnNewButton_log.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_log.setBounds(156, 189, 136, 37);
			frame.getContentPane().add(btnNewButton_log);
			
			JLabel LoginLabel = new JLabel("Welcome to Mafi Bank");
			LoginLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			LoginLabel.setBounds(108, 10, 219, 32);
			frame.getContentPane().add(LoginLabel);	
			
		}	//end of gui for Login

}
