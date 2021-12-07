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
	
	private static PaymentServiceStub asyncStub;
	
	//instance variables, accessible to all the methods
		JFrame frame;
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
				try {
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
		
		//client Payment - channel
		
		String host = "localhost";
		int port = 50003;
		/*
		ServiceInfo serviceInfo;
		String service_Type = "_pay._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = JmDNSDiscovery.run(service_Type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
	*/
		System.out.println("service running on port: " + port); //serviceInfo3.getPort());
	
		ManagedChannel channel = ManagedChannelBuilder
			.forAddress(host, port)
			.usePlaintext()
			.build();
	
		asyncStub = PaymentServiceGrpc.newStub(channel);
	
		initialize();	
	
	}
	
	 //Initialize the contents of the frame.
		//Client GUI for Payment
		
		private void initialize() {
			frame = new JFrame();
			//Jframe is a window with a title bar
			frame.setTitle("Client - eBanking Payment");
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			
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

}
