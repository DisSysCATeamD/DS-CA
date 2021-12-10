package com.ebanking.testsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import the stub from Grpc, which will give us the interface
import com.ebanking.testsystem.LoginGrpc.LoginBlockingStub;

import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Client_LoginGUI {
	//declaring the stub variable
	private static LoginBlockingStub blockingStub;
	
	private JFrame frame;
	private JTextField textField_usr;
	private JPasswordField textField_pwd;
	private JButton btnNewButton_log;

	public static void main(String[] args) {	//main method
		EventQueue.invokeLater(new Runnable() {	//starting the gui
			public void run() {
				try {	//creating an instance of the LoginGUI and setting it to visible
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
			//have to specify the server, which is currently the same (if on a different server, would have to use DNS or IP of that server)
			String host = "localhost";
			int port = 50001;
			/*
			 * Unfortunately jmDNS on the clients does not work! It runs fine on the server but does not connect on the client, or the code does not run at all!
			 * jmDNS commented out so the client will function, it connects via specified host and port instead.
			
			ServiceInfo serviceInfo;
			String service_Type = "_grpc._tcp.local.";
			//Now retrieve the service info - all we are supplying is the service type
			serviceInfo = JmDNSDiscovery.run(service_Type);
			//Use the serviceInfo to retrieve the port
			int port = serviceInfo.getPort();
			String host = "localhost";
		
			*/
	
			System.out.println("service running on port: " +port);
			//creating a channel on this host in order to communicate with the server
			ManagedChannel channel1 = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
			//creating an instance of the stub gives the interface to the server
			//use blocking stub as call waits for the server to respond.
			blockingStub = LoginGrpc.newBlockingStub(channel1);
			
			initialize();

	}
	
	//Initialize the contents of the frame.
	//Initializing the Client GUI for Logging on
		private void initialize() {
			frame = new JFrame();		//the outer window
			//Jframe is a window with a title bar
			frame.setTitle("Client - eBanking Logon");
			//set bounds can be done for frames and buttons
			frame.setBounds(100, 100, 450, 300);	//size of box and where it appears on the window
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			//this is the field where the user enters their username
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
			
			//field for the password to be entered, the type is hidden
			textField_pwd = new JPasswordField();
			textField_pwd.setBounds(156, 113, 136, 32);
			frame.getContentPane().add(textField_pwd);
			textField_pwd.setColumns(10);
			
			//press the login button in order to pass the username and password to the server
			btnNewButton_log = new JButton("Login");
			btnNewButton_log.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try{	//try/catch for exception handing if data is inputted incorrectly, the code won't terminate
					
					String username = textField_usr.getText();
					String password = textField_pwd.getText();
					//creating the message with the username and password being sent by the client to the server
					LoginRequest login = LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
					//requesting reply to the login details sent
					LoginValidation reply = blockingStub.sayLogin(login);
									
					JOptionPane.showMessageDialog(null, "Validating, please wait");
					//reply will either be valid or failed, sent by the server after validation
					JOptionPane.showMessageDialog(null, "Response" +reply.getValid());	
						frame.dispose();	//closes the login dialog box, opens the Client_MenuGUI
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
			
		}	//closing initialize

} //end of Client_LoginGUI
