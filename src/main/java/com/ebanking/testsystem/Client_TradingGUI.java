package com.ebanking.testsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ebanking.testsystem.TradingGrpc.TradingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client_TradingGUI {
	
	private static TradingStub asynctStub;
	
	JFrame frame;
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
		
		//channel4 for Client Trading
		
		String host = "localhost";
		int port = 50004;
		/*
		ServiceInfo serviceInfo;
		String service_Type = "_trade._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = JmDNSDiscovery.run(service_Type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		*/
		System.out.println("service running on port: " + port); //serviceInfo3.getPort());
	
		ManagedChannel channel = ManagedChannelBuilder
			.forAddress(host, port) //serviceInfo4.getPort())
			.usePlaintext()
			.build();
	
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

		



}
