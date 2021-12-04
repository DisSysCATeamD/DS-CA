package com.ebanking.testsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ebanking.testsystem.LoginGrpc.LoginBlockingStub;
import com.ebanking.testsystem.PaymentServiceGrpc.PaymentServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class ClientGUI_Login {
	
	private static LoginBlockingStub blockingStub;
	private static PaymentServiceStub asyncStub;
	
	//instance variables, accessible to all the methods
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton balanceButton;
	private JButton payButton;
	private JButton tradeButton;
	private JButton exitButton;
	private JTextField textField_bic;
	private JTextField textField_iban;
	private JTextField textField_payee;
	private JTextField textField_desc;
	private JTextField textField_amt;
	private JButton btnNewButton_pay;

	/**
	 * Launch the application. Need below to run the code
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
	/*
		try {
			String host = "localhost";
			int port = 50051;
		
			//ServiceInfo serviceInfo = JmDNSDiscovery.run("_grpc1._tcp.local.");
	
			//System.out.println("service running on port: " + serviceInfo.getPort());
		
			ManagedChannel channel1 = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
			blockingStub = LoginGrpc.newBlockingStub(channel1);
		
			initialize1();
		}
		catch(Exception el) {
			el.printStackTrace();
		}
		finally {
			channel1.shutdown().awaitTermination(60, TimeUnit.SECONDS);	
		}
		
		//initializeMenu();
		*/
		String host3 = "localhost";
		int port3 = 50053;
		
		//ServiceInfo serviceInfo = JmDNSDiscovery.run("_grpc3._tcp.local.");
	
		//System.out.println("service running on port: " + serviceInfo.getPort());
		
		ManagedChannel channel3 = ManagedChannelBuilder
				.forAddress(host3, port3)
				.usePlaintext()
				.build();
		
		asyncStub = PaymentServiceGrpc.newStub(channel3);
		
		initialize2();
		
	}
	/*
	/**
	 * Initialize the contents of the frame.
	 
	private void initialize1() {
		frame = new JFrame();		//the outer window
		//Jframe is a window with a title bar
		frame.setTitle("Client - eBanking Logon");
		//set bounds can be done for frames panels and buttons
		frame.setBounds(100, 100, 450, 300);	//size of box and where it appears on the window
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
			try{
				
				String username = textField.getText();
				String password = textField_1.getText();
				LoginRequest login = LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
				
				LoginValidation reply = blockingStub.sayLogin(login);
								
				JOptionPane.showMessageDialog(null, "Validating, please wait");
				
				JOptionPane.showMessageDialog(null, "Response" +reply.getValid());	
				Thread.sleep(8000);
				
			} catch(StatusRuntimeException el) {
					ep.printStackTrace();
			} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				//initializeMenu();
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
	/*
	private void initializeMenu() {
		frame = new JFrame();
		frame.setTitle("Client - eBanking Menu");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		balanceButton = new JButton("Balance");
		balanceButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		balanceButton.setBounds(159, 32, 117, 30);
		frame.getContentPane().add(balanceButton);
		
		
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

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize2() {
		frame = new JFrame();
		//Jframe is a window with a title bar
		frame.setTitle("Client - eBanking Payment");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JLabel bicLabel = new JLabel("BIC:");
		bicLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		bicLabel.setBounds(38, 29, 45, 13);
		frame.getContentPane().add(bicLabel);
		
		textField_bic = new JTextField();
		textField_bic.setBounds(126, 27, 199, 19);
		frame.getContentPane().add(textField_bic);
		textField_bic.setColumns(10);
		
		JLabel ibanLabel = new JLabel("IBAN:");
		ibanLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		ibanLabel.setBounds(38, 59, 45, 13);
		frame.getContentPane().add(ibanLabel);
		
		textField_iban = new JTextField();
		textField_iban.setBounds(126, 56, 199, 19);
		frame.getContentPane().add(textField_iban);
		textField_iban.setColumns(10);
		
		JLabel payeeLabel = new JLabel("Payee:");
		payeeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		payeeLabel.setBounds(38, 90, 45, 13);
		frame.getContentPane().add(payeeLabel );
		
		textField_payee = new JTextField();
		textField_payee.setBounds(126, 88, 199, 19);
		frame.getContentPane().add(textField_payee);
		textField_payee.setColumns(10);
		
		JLabel descLabel = new JLabel("Description:");
		descLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		descLabel.setBounds(38, 125, 78, 13);
		frame.getContentPane().add(descLabel);
		
		textField_desc = new JTextField();
		textField_desc.setBounds(126, 123, 199, 19);
		frame.getContentPane().add(textField_desc);
		textField_desc.setColumns(10);
		
		JLabel amtLabel = new JLabel("Amount \u20AC:");
		descLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		amtLabel.setBounds(38, 155, 68, 13);
		frame.getContentPane().add(amtLabel);
	
		
		textField_amt= new JTextField();
		textField_amt.setBounds(126, 152, 103, 19);
		frame.getContentPane().add(textField_amt);
		textField_amt.setColumns(10);
		
		btnNewButton_pay = new JButton("Submit");		
		btnNewButton_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//for incoming messages we need to implement a StreamObserver
				//then we pass it to the grpc library
						
				StreamObserver<Status> responseObserver = new StreamObserver<Status>() {

				@Override
				public void onNext(Status value) {
				// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null,"Response from server: \n" + value.getConfirmation());
				}

				@Override
				public void onError(Throwable t) {
				// TODO Auto-generated method stub
								
				}

				@Override
				public void onCompleted() {
				// TODO Auto-generated method stub
								
				}};
				
				try {
				
					String bic = textField_bic.getText();
					String iban = textField_iban.getText();
					String payee = textField_payee.getText();
					String description = textField_desc.getText();
					double amount =  Double.parseDouble(textField_amt.getText());
			
					//grpc library returns a streamObserver to use requestObserver
					//we use this to send our outgoing messages
					StreamObserver<BillPayment> requestObserver = asyncStub.sentPayment(responseObserver);
				
					requestObserver.onNext(BillPayment.newBuilder().setBic(bic).build());
					requestObserver.onNext(BillPayment.newBuilder().setIban(iban).build());
					requestObserver.onNext(BillPayment.newBuilder().setPayee(payee).build());
					requestObserver.onNext(BillPayment.newBuilder().setDescription(description).build());
					requestObserver.onNext(BillPayment.newBuilder().setAmount(amount).build());
				
					System.out.println("Client has sent full payment details");
					requestObserver.onCompleted();
					Thread.sleep(8000);
				
				}
				catch(StatusRuntimeException ep) {
					ep.printStackTrace();
				} catch (InterruptedException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				//finally {
					//channel3.shutdown().awaitTermination(60, TimeUnit.SECONDS);	
			//}
			}
		});
		btnNewButton_pay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_pay.setBounds(156, 189, 136, 37);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_pay);
	}
	
	
}
