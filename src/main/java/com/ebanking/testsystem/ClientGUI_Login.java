package com.ebanking.testsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.Iterator;

import com.ebanking.testsystem.BalanceGrpc.BalanceBlockingStub;
import com.ebanking.testsystem.LoginGrpc.LoginBlockingStub;
import com.ebanking.testsystem.PaymentServiceGrpc.PaymentServiceStub;
import com.ebanking.testsystem.TradingGrpc.TradingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class ClientGUI_Login {
	
	private static LoginBlockingStub blockingStub;
	private static BalanceBlockingStub blockingbStub;
	private static BalanceBlockingStub bstub;
	private static PaymentServiceStub asyncStub;
	private static TradingStub asynctStub;
	
	//instance variables, accessible to all the methods
	private JFrame frame;
	private JTextField textField_usr;
	private JTextField textField_pwd;
	private JButton btnNewButton_log;
	private JButton balanceButton;
	private JButton payButton;
	private JButton tradeButton;
	private JButton exitButton;
	private JTextField textName1;
	private JTextField textName2;
	private JTextArea textResponse;
	private JTextField textField_bic;
	private JTextField textField_iban;
	private JTextField textField_payee;
	private JTextField textField_desc;
	private JTextField textField_amt;
	private JButton btnNewButton_pay;
	private JTextField textField_trd;
	private JTextField textField_co;
	private JTextField textField_isin;
	private JTextField textField_price;
	private JTextField textField_stk;
	private JButton btnNewButton_trade;

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
		
			String host = "localhost";
			int port = 50001;
		
			//ServiceInfo serviceInfo1 = JmDNSDiscovery.run("_grpc._tcp.local.");
	
			System.out.println("service running on port: " + port);//serviceInfo1.getPort());
		
			ManagedChannel channel1 = ManagedChannelBuilder
				.forAddress(host, port) //serviceInfo1.getPort())
				.usePlaintext()
				.build();
		
			blockingStub = LoginGrpc.newBlockingStub(channel1);
		
			initialize1();
		

		//Client Balance, server streaming - channel 2

		int port2 = 50002;
		String host2 = "localhost";
			
		//ServiceInfo serviceInfo2 = JmDNSDiscovery.run("_bal._tcp.local.");
		
		System.out.println("service running on port: " + port2); //serviceInfo2.getPort());
		
		ManagedChannel channel2 = ManagedChannelBuilder
			.forAddress(host, port2) //serviceInfo2.getPort())
			.usePlaintext()
			.build();

		//stubs -- generate from proto
		blockingbStub = BalanceGrpc.newBlockingStub(channel2);
		bstub = BalanceGrpc.newBlockingStub(channel2);
		
		initialize2();
			

		
		//client Payment - channel 3
	
			String host3 = "localhost";
			int port3 = 50003;
		
			//ServiceInfo serviceInfo3 = JmDNSDiscovery.run("_pay._tcp.local.");
	
			System.out.println("service running on port: " + port); //serviceInfo3.getPort());
		
			ManagedChannel channel3 = ManagedChannelBuilder
				.forAddress(host3, port3)	// serviceInfo3.getPort())
				.usePlaintext()
				.build();
		
			asyncStub = PaymentServiceGrpc.newStub(channel3);
		
			initialize3();
		
		
		
		
		//channel4 for Client Trading
		
			String host4 = "localhost";
			int port4 = 50054;
		
			//ServiceInfo serviceInfo4 = JmDNSDiscovery.run("_trade._tcp.local.");
	
			System.out.println("service running on port: " +port); //+ serviceInfo4.getPort());
		
			ManagedChannel channel4 = ManagedChannelBuilder
				.forAddress(host4, port4) //serviceInfo4.getPort())
				.usePlaintext()
				.build();
		
			asynctStub = TradingGrpc.newStub(channel4);
			initialize4();
		

	}
	
	//Initialize the contents of the frame.
	//Client GUI for Logging on
	private void initialize1() {
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
					MenuOptions menu = new MenuOptions();
					menu.setVisible(true);
				
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
	

	//Client GUI for Balance
	private void initialize2() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		//Jframe is a window with a title bar
		frame.setTitle("Client - Service Controller");
		//set bounds can be done for frames panels and buttons
		frame.setBounds(100, 100, 500, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Box layout determines how components are laid out in the panel
		//Layout vertically in a col - box layout doesn't wrap
		//See: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		//Create JPanel
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		//Flow layout - items retain their size, are laid out horizontally and wrap

		//panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		//Set Up Button ....
		JButton btnSend = new JButton("Click here to view your balance");
		
		//Add an action listener to our button
		btnSend.addActionListener(new ActionListener() {
			
			//implement action performed method
			//This will happen when the button is clicked
			public void actionPerformed(ActionEvent e) {
				
				//int port = 50052;
				//String host = "localhost";
				
				
				// build the channel
				//ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host,port).usePlaintext().build();
						
				// Creating a message that will be sent to the server
			try {	
				balanceRequest cString =balanceRequest.newBuilder().setFirstString("Getting Balance").build(); 
				
				//create a stub .object that the client has that is a representation of the remote service. and is specific to the service
				//can have 2 types of stub - blocking and async. async is send off the request and this will allow you to carry on with your code while you wait for response
				
				//BalanceBlockingStub bstub = BalanceGrpc.newBlockingStub(channel2);

				//we can use this now to call the rpc
				
				balanceRequest response =	bstub.getFirstString(cString);
				// this returns the Balance
				balanceResponse response3 =	bstub.getBalanceResponseAmt(cString);
				JOptionPane.showMessageDialog(null, "Your Balance is:  "+ response3.getBalRes());
				
				//System.out.println(response.getFirstString());
				
				//This returns the stream of the last transactions
				
				Iterator<balanceTransactions> transactions;
				 transactions =	bstub.getBalanceTransactions(cString);
				    for (int i = 1; transactions.hasNext(); i++) {
				    	balanceTransactions response1 = transactions.next();
				    	JOptionPane.showMessageDialog(null,"\n" +response1.getTransaction() +"€" +response1.getLastTrans());
				    	
				    }
				    Thread.sleep(5000);
					
			
	/*	   
			try {
				newChannel.shutdown().awaitTermination(5,TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error closing down channel");
				e1.printStackTrace();
			}
			*/
			} catch(StatusRuntimeException el) {
				el.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			
		}}); //End of setup button
		
		//Add button to the panel
		panel_service_1.add(btnSend);
		
		/*
		textResponse = new JTextArea();
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		

		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		*/
			
	}	//end of Client Balance GUI	

	
	 //Initialize the contents of the frame.
	//Client GUI for Payment
	
	private void initialize3() {
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
			
			}
		});
		btnNewButton_pay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_pay.setBounds(156, 189, 136, 37);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_pay);
	
	} //end of gui for payment
	//client GUI for Trading
	
	// Initialize the contents of the frame.
 
	private void initialize4() {
		frame = new JFrame();
		//Jframe is a window with a title bar
		frame.setTitle("Client - eBanking Trading");
		frame.setBounds(100, 100, 500, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textResponse = new JTextArea();
		textResponse.setBounds(160, 22, 310, 70);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		frame.getContentPane().add(textResponse);
		
		JLabel stklsLabel = new JLabel("Stock Listings:");
		stklsLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		stklsLabel.setBounds(28, 28, 125, 13);
		frame.getContentPane().add(stklsLabel);
		
		JLabel tradeLabel = new JLabel("To buy type 'Trade':");
		tradeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tradeLabel.setBounds(28, 108, 125, 13);
		frame.getContentPane().add(tradeLabel);
		
		textField_trd = new JTextField();
		textField_trd.setBounds(160, 105, 165, 19);
		frame.getContentPane().add(textField_trd);
		textField_trd.setColumns(10);
		
		textField_co = new JTextField();
		textField_co.setBounds(160, 134, 165, 19);
		frame.getContentPane().add(textField_co);
		textField_co.setColumns(10);
		
		JLabel coLabel = new JLabel("Company:");
		coLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		coLabel.setBounds(28, 137, 76, 13);
		frame.getContentPane().add(coLabel);
		
		textField_isin = new JTextField();
		textField_isin.setBounds(160, 164, 165, 19);
		frame.getContentPane().add(textField_isin);
		textField_isin.setColumns(10);
		
		JLabel isinLabel = new JLabel("ISIN:");
		isinLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		isinLabel.setBounds(28, 166, 76, 13);
		frame.getContentPane().add(isinLabel);
		
		textField_price = new JTextField();
		textField_price.setBounds(160, 193, 165, 19);
		frame.getContentPane().add(textField_price);
		textField_price.setColumns(10);
		
		JLabel priceLabel = new JLabel("Price \u20AC:");
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		priceLabel.setBounds(28, 195, 76, 13);
		frame.getContentPane().add(priceLabel);
		
		textField_stk = new JTextField();
		textField_stk.setBounds(160, 222, 165, 19);
		frame.getContentPane().add(textField_stk);
		textField_stk.setColumns(10);
		
		JLabel stkLabel = new JLabel("Amount:");
		stkLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		stkLabel.setBounds(28, 224, 76, 13);
		frame.getContentPane().add(stkLabel);
		
		//JButton subLabel = new JButton("Submit");
		//subLabel.setBounds(333, 207, 76, 34);
		//frame.getContentPane().add(subLabel);
		
		btnNewButton_trade = new JButton("Trade");	
		btnNewButton_trade.setBounds(360, 207, 76, 34);
		frame.getContentPane().add(btnNewButton_trade);
		btnNewButton_trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//for incoming messages we need to implement a StreamObserver
				//then we pass it to the grpc library
				StreamObserver<stockListings> responseObserver = new StreamObserver<stockListings>() {

					@Override
					public void onNext(stockListings stocks) {
						textResponse.append("\nStock: "+stocks.getCompany()+", "+stocks.getIsin()+", "+stocks.getPrice()+", "+stocks.getTrend());
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}

					@Override
					public void onCompleted() {
						System.out.println("Stream Completed, StockListings received");
					}			

				};

				StreamObserver<purchase> requestObserver = asynctStub.bidirectStartTrading(responseObserver);

				try {
					
					String trade = textField_trd.getText();
					String name = textField_co.getText();
					String number = textField_isin.getText();
					double price = Double.parseDouble(textField_price.getText());
					int amount = Integer.parseInt(textField_stk.getText());
								
					requestObserver.onNext(purchase.newBuilder().setRequest(trade).build());	
					requestObserver.onNext(purchase.newBuilder().setCompany(name).build());
					requestObserver.onNext(purchase.newBuilder().setIsin(number).build());
					requestObserver.onNext(purchase.newBuilder().setPrice(price).build());
					requestObserver.onNext(purchase.newBuilder().setAmount(amount).build());
					
					System.out.println("Please purchase these shares on my behalf and deduct the cost from my balance");
					requestObserver.onCompleted();
					Thread.sleep(8000);
				} catch (RuntimeException et) {
					et.printStackTrace();
				} catch (InterruptedException e4) {			
					e4.printStackTrace();
				}
				try {
					Thread.sleep(8000);
				} catch (InterruptedException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
			}
					
		});
		
	} //closing Client Trading GUI

}	//closing class ClientGUI


