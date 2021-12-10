package com.ebanking.testsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ebanking.testsystem.PaymentServiceGrpc.PaymentServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class Client_PaymentGUI {
	//declaring the variable
	private static PaymentServiceStub asyncStub;
	
	//instance variables, accessible to all the methods
		JFrame frame;	//not private so that it can be called from the Client_MenuGUI
		private JTextField textField_bic;
		private JTextField textField_iban;
		private JTextField textField_payee;
		private JTextField textField_desc;
		private JTextField textField_amt;
		private JButton btnNewButton_pay;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

	/**
	 * Create the application.
	 */
	
	public Client_PaymentGUI() throws InterruptedException {
		
		//client Payment - channel: Client Streaming
		//have to specify the server, which is currently the same host(if on a different server, would have to use DNS or IP of that server)
		String host = "localhost";
		int port = 50003;
		
		/*
		 * Unfortunately jmDNS on the clients does not work! It runs fine on the server but does not connect on the client, or the code does not run at all!
		 * jmDNS commented out so the client will function, it connects via specified host and port.
		 * 
		ServiceInfo serviceInfo;
		String service_Type = "_pay._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = JmDNSDiscovery.run(service_Type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
	*/
		System.out.println("service running on port: " + port); //serviceInfo3.getPort());
		
		//creating a channel on this host in order to communicate with the server
		ManagedChannel channel = ManagedChannelBuilder
			.forAddress(host, port)
			.usePlaintext()
			.build();
		
		//use an asynchronous stub so that the client can stream, and one is not waiting on the server to respond
		//creating an instance of the asyncstub for streaming, gives the interface to the server
		asyncStub = PaymentServiceGrpc.newStub(channel);
	
		initialize();	
	
	}
	
	//Initialize the contents of the frame.
	//Client GUI for Payment
		
		private void initialize() {
			frame = new JFrame();	//the outer window
			//Jframe is a window with a title bar
			frame.setTitle("Client - eBanking Payment");
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//set to close when the x is pressed but not close the client_menuGUI
			
			JLabel bicLabel = new JLabel("BIC:");
			bicLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			bicLabel.setBounds(38, 29, 45, 13);
			frame.getContentPane().add(bicLabel);
			
			//field for the bic information to be entered
			textField_bic = new JTextField();
			textField_bic.setBounds(126, 27, 199, 19);
			frame.getContentPane().add(textField_bic);
			textField_bic.setColumns(10);
			
			JLabel ibanLabel = new JLabel("IBAN:");
			ibanLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			ibanLabel.setBounds(38, 59, 45, 13);
			frame.getContentPane().add(ibanLabel);
			
			//field for the iban information to be entered
			textField_iban = new JTextField();
			textField_iban.setBounds(126, 56, 199, 19);
			frame.getContentPane().add(textField_iban);
			textField_iban.setColumns(10);
			
			JLabel payeeLabel = new JLabel("Payee:");
			payeeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			payeeLabel.setBounds(38, 90, 45, 13);
			frame.getContentPane().add(payeeLabel );
			
			//field for the person to be paid is entered
			textField_payee = new JTextField();
			textField_payee.setBounds(126, 88, 199, 19);
			frame.getContentPane().add(textField_payee);
			textField_payee.setColumns(10);
			
			JLabel descLabel = new JLabel("Description:");
			descLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			descLabel.setBounds(38, 125, 78, 13);
			frame.getContentPane().add(descLabel);
			
			//field for the description is entered
			textField_desc = new JTextField();
			textField_desc.setBounds(126, 123, 199, 19);
			frame.getContentPane().add(textField_desc);
			textField_desc.setColumns(10);
			
			JLabel amtLabel = new JLabel("Amount \u20AC:");
			descLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			amtLabel.setBounds(38, 155, 68, 13);
			frame.getContentPane().add(amtLabel);
		
			//field for the amount to be paid is entered
			textField_amt= new JTextField();
			textField_amt.setBounds(126, 152, 103, 19);
			frame.getContentPane().add(textField_amt);
			textField_amt.setColumns(10);
			
			//when submit is clicked the information is then sent below to the server and reponse received
			btnNewButton_pay = new JButton("Submit");		
			btnNewButton_pay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//for incoming messages we need to implement a StreamObserver
					//then we pass it to the grpc library				
					StreamObserver<Status> responseObserver = new StreamObserver<Status>() {

					//this is the reply from the server, if the client has enough funds it will be valid if not it will fail
					@Override
					public void onNext(Status value) {
					// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null,"Response from server: \n" + value.getConfirmation());
					}

					@Override	//should an error be generated
					public void onError(Throwable t) {
					// TODO Auto-generated method stub
									
					}

					@Override
					public void onCompleted() {		//the message has been sent by the server, the message exchange has finished
					// TODO Auto-generated method stub
									
					}};
					
					try {	//try/catch for exception handing if data is inputed incorrectly, the code won't terminate
						
						//enter the bic, it must adhere to the validation or a message will be displayed to the customer
						String bic = "";
						if(textField_bic.getText().startsWith("BOFIIE") || textField_bic.getText().startsWith("AIBKIE") || textField_bic.getText().startsWith("IPBSIE")){
							textField_bic.getText();
						}else {
							JOptionPane.showMessageDialog(null, "Make sure enter the correct BIC code, for BOI, AIB or IP TSB");
						}
						
						//the iban field cannot be left empty or an error will be displayed
						String iban = "";
						if(!textField_iban.getText().isEmpty()) {
							textField_iban.getText();			
						}else {
							JOptionPane.showMessageDialog(null, "IBAN connot be empty, please enter the 15 digit code beginning with IE");
						}
						
						//the payee cannot be left empty or an error will be displayed
						String payee = "";
						if(!textField_iban.getText().isEmpty()) {
							textField_payee.getText();							
						}else {
							JOptionPane.showMessageDialog(null, "Make sure you enter the correct Payees name in order to process your request correctly");
						}
						String description = textField_desc.getText();
						double amount =  Double.parseDouble(textField_amt.getText());
				
						//grpc library returns a streamObserver to use requestObserver
						//we use this to send our outgoing messages
						//use an asynchronous stub so that the client can stream, and one is not waiting on the server to respond	
						StreamObserver<BillPayment> requestObserver = asyncStub.sentPayment(responseObserver);
						
						//the information above entered by the customer builds the message to be sent to the server and each message is then sent to the server
						requestObserver.onNext(BillPayment.newBuilder().setBic(bic).build());
						requestObserver.onNext(BillPayment.newBuilder().setIban(iban).build());
						requestObserver.onNext(BillPayment.newBuilder().setPayee(payee).build());
						requestObserver.onNext(BillPayment.newBuilder().setDescription(description).build());
						requestObserver.onNext(BillPayment.newBuilder().setAmount(amount).build());
						
						//when all messages are sent by the client this is sent to say messages are finished
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
				
				}	//closing ActionPerformed
			}); 	//closing ActionListener
			
			btnNewButton_pay.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_pay.setBounds(156, 189, 136, 37);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(btnNewButton_pay);
		
		} //end of initialization

}	//closing class Client_PaymentGUI
