package com.ebanking.testsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import com.ebanking.testsystem.BalanceGrpc.BalanceBlockingStub;

import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Client_BalanceGUI {
	
	private static BalanceBlockingStub blockingbStub;
	private static BalanceBlockingStub bstub;
	
	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_BalanceGUI bal = new Client_BalanceGUI();
					bal.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client_BalanceGUI() {
		
		int port = 50002;
		String host = "localhost";
		/*
		ServiceInfo serviceInfo;
		String service_Type = "_bal._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = JmDNSDiscovery.run(service_Type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		*/
		System.out.println("service running on port: " + port); //serviceInfo2.getPort());
		
		ManagedChannel channel2 = ManagedChannelBuilder
			.forAddress(host, port) //serviceInfo2.getPort())
			.usePlaintext()
			.build();

		//stubs -- generate from proto
		blockingbStub = BalanceGrpc.newBlockingStub(channel2);
		bstub = BalanceGrpc.newBlockingStub(channel2);
		
		
	
		
		initialize();
	}

	/**
	 * Client GUI for Balance
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
			// TODO Auto-generated method stub
			frame = new JFrame();
			//Jframe is a window with a title bar
			frame.setTitle("Client - Service Controller");
			//set bounds can be done for frames panels and buttons
			frame.setBounds(100, 100, 500, 300);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
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
			btnSend.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSend.setBounds(156, 189, 136, 70);
			//Add an action listener to our button
			btnSend.addActionListener(new ActionListener() {
				
				//implement action performed method
				//This will happen when the button is clicked
				public void actionPerformed(ActionEvent e) {
					
					// Creating a message that will be sent to the server
				try {	
					// 1. Creating a message that will be sent to the server and then sending a response back to let the user know that request was accepted

					balanceRequest cString =balanceRequest.newBuilder().setFirstString("Getting Balance").build(); 
					
					//BalanceBlockingStub bstub = BalanceGrpc.newBlockingStub(channel2);

					//we can use this now to call the rpc
					//balanceRequest response =	bstub.getFirstString(cString);
					
					// 2. This will fetch the balance from server and the server will send the total back. We then print the result onto the console
					balanceResponse response3 =	bstub.getBalanceResponseAmt(cString);
					JOptionPane.showMessageDialog(null, "Your Balance is:  "+ response3.getBalRes());
					
					
					//This returns the stream of the last transactions
					
					Iterator<balanceTransactions> transactions;
					 transactions =	bstub.getBalanceTransactions(cString);
					    for (int i = 1; transactions.hasNext(); i++) {
					    	balanceTransactions response1 = transactions.next();
					    	JOptionPane.showMessageDialog(null,"\n" +response1.getTransaction() +"€" +response1.getLastTrans());
					    	
					    }
					    Thread.sleep(2000);
						
				} catch(StatusRuntimeException el) {
					el.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
				}
				
			}}); //End of setup button
			
			//Add button to the panel
			panel_service_1.add(btnSend);
			
				
		}	//end of Client Balance GUI	


}
