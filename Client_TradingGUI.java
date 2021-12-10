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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ebanking.testsystem.TradingGrpc.TradingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client_TradingGUI {
	//declaring the variable
	private static TradingStub asynctStub;
	
	JFrame frame;	//not private so that it can be called from the Client_MenuGUI
	private JTextField textField_trd;
	private JTextField textField_co;
	private JTextField textField_isin;
	private JTextField textField_price;
	private JTextField textField_stk;
	private JButton btnNewButton_trade;

	/**
	 * Launch the application. Need below to run the code
	 */
	public static void main(String[] args) {	//main method
		EventQueue.invokeLater(new Runnable() {		//starting the gui
			public void run() {
				try {		//creating an instance of the Client_TradingGUI and setting it to visible
					Client_TradingGUI trade = new Client_TradingGUI();
					trade.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Client_TradingGUI() {
		
		//client Trading - channel: bidirectional streaming
		//have to specify the server, which is currently the same host(if on a different server, would have to use DNS or IP of that server)
		
		String host = "localhost";
		int port = 50004;
		/*
		 * Unfortunately jmDNS on the clients does not work! It runs fine on the server but does not connect on the client, or the code does not run at all!
		 * jmDNS commented out so the client will function, it connects via specified host and port.
		 * 
		ServiceInfo serviceInfo;
		String service_Type = "_trade._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = JmDNSDiscovery.run(service_Type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		*/
		
		System.out.println("service running on port: " + port); //serviceInfo3.getPort());
		
		//creating a channel on this host in order to communicate with the server
		ManagedChannel channel = ManagedChannelBuilder
			.forAddress(host, port) //serviceInfo4.getPort())
			.usePlaintext()
			.build();
		
		//creating an instance of the asynctstub for streaming, gives the interface to the server
		//use an asynchronous stub so that both client and server can stream at the same time, and one is not waiting on the other to responds
		asynctStub = TradingGrpc.newStub(channel);
		
		initialize();	

	}
	
	//client GUI for Trading
	
		// Initialize the contents of the frame.
	 
		private void initialize() {
			frame = new JFrame();
			//Jframe is a window with a title bar
			frame.setTitle("Client - eBanking Trading");
			frame.setBounds(100, 100, 500, 310);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				public void actionPerformed(ActionEvent e) throws NullPointerException, NumberFormatException  {
					
					//for incoming messages we need to implement a StreamObserver
					//then we pass it to the grpc library
					StreamObserver<stockListings> responseObserver = new StreamObserver<stockListings>() {
						
						//incoming message from the server with the stocklistings
						@Override
						public void onNext(stockListings stocks) {
							textResponse.append("\nStock: "+stocks.getCompany()+", "+stocks.getIsin()+", "+stocks.getPrice()+", "+stocks.getTrend());
						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();

						}

						@Override
						public void onCompleted() {		//when the sever has finished sending its message stream
							System.out.println("Stream Completed, StockListings received");
						}			

					};
					
					//passing back to the libraries using StreamObserver
					//use an asynchronous stub so that both client and server can stream at the same time, and one is not waiting on the other to responds
					StreamObserver<purchase> requestObserver = asynctStub.bidirectStartTrading(responseObserver);
					//sending the share details that the customer wishes to purchase
					
					try { 	//try/catch for exception handing if data is inputed incorrectly, the code won't terminate
						
						//required to type Trade in order to complete the trading form
						String trade = "";
						if(!textField_trd.getText().equals("Trade")){
							JOptionPane.showMessageDialog(null, "To Start Trading, please type in the word 'Trade'");
						}else{
							textField_trd.getText();
						}
						//must enter one of the companies that are on the portfolio
						String name = "";
						if(textField_co.getText().equals("AIB") || textField_co.getText().equals("Bank of Ireland") || textField_co.getText().equals("Ryanair")) {
							textField_co.getText(); 		
						}else{
							JOptionPane.showMessageDialog(null, "You must enter one of the stocks listed");
						}
						//customer enters the number of the isin they are interested in
						String number = textField_isin.getText();
						
						//the price per share that they want to buy
						double price = Double.parseDouble(textField_price.getText());
						
						//must trade 10 or more shares or it is not valid and an message will be displayed
						int amount = 0;
						if(Integer.parseInt(textField_stk.getText())>= 10) {
							Integer.parseInt(textField_stk.getText());
							JOptionPane.showMessageDialog(null, "Please Note: All stock purchase requests will be processed, and confirmation and cost will be on your account within 1 hour");
						}else {
							JOptionPane.showMessageDialog(null, "You must trade with 10 or more shares");
						}
							
						//building the clients message with information enter by the customer, that will be sent to the server when the 'Trade' button is clicked			
						requestObserver.onNext(purchase.newBuilder().setRequest(trade).build());	
						requestObserver.onNext(purchase.newBuilder().setCompany(name).build());
						requestObserver.onNext(purchase.newBuilder().setIsin(number).build());
						requestObserver.onNext(purchase.newBuilder().setPrice(price).build());
						requestObserver.onNext(purchase.newBuilder().setAmount(amount).build());
						
						System.out.println("Please purchase these shares on my behalf and deduct the cost from my balance");
						
						requestObserver.onCompleted();	//telling the server that the message stream from the client has finished
						
						Thread.sleep(1000);
						
					} catch (RuntimeException et) {
						et.printStackTrace();
					} catch (InterruptedException e4) {		
						e4.printStackTrace();
					}	//closing catch
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}	//closing catch
				}	//closing ActionPerformed
						
			}); 	//closing ActionListener
			
		} //closing Client Trading GUI

		



}
