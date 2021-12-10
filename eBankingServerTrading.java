package com.ebanking.testsystem;

import javax.swing.JOptionPane;


//server for bidirectional streaming RPC
//extend abstract base class for our implementation, based on our proto	
//this TradingImplBase comes from the proto and is found in the TradingGrpc

import com.ebanking.testsystem.TradingGrpc.TradingImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class eBankingServerTrading extends TradingImplBase{
	
	public static void main(String[] args){		//main method
		
		System.out.println("Starting Trading Grpc Server");
		int port = 50004;

		eBankingServerTrading tradingServer = new eBankingServerTrading();	
		//for jmDNS - not working on client GUI currently commented out
		JmDNSRegistration reg = new JmDNSRegistration();
		reg.run("_trade._tcp.local.", "TradingService", port, "running Trading service");
		
		try {	//to build our particular service
			Server server4 = ServerBuilder.forPort(port)
					.addService(tradingServer)
					.build()
					.start();
			System.out.println("Server running on port: "+port);
			server4.awaitTermination();
			
		} catch(Exception e) {
			System.out.println(e);
		}}
	
	//setting up the bidirectional messaging
	//for incoming message to the server implements the Stream observer
	//and passes it back to the grpc library for receiving
	//with ResponseObserver to pass the response back to the client
	
	public StreamObserver<purchase> bidirectStartTrading(StreamObserver<stockListings> responseObserver) {
		
		//creating the message from the client to the server
		return new StreamObserver<purchase> () {
			double balance =  1195.86;
			String message = "";
			@Override
			public void onNext(purchase buy) {
				System.out.println("Requesting information from Server: ");
				
				if(buy.getRequest().equals("Trade") && balance >= 1000) {
					System.out.println("I would like to purchase " +buy.getCompany()+", " +buy.getIsin()+", " +buy.getPrice()+", " +buy.getAmount());
					double cost = buy.getPrice()*buy.getAmount();
					balance = balance - cost;
					message = "Total Cost is: "+cost+ "\nYour Balance is: "+balance;
				}
				else {
					System.out.println("Thank you");
				}
				
				//data for the server streaming of stocklistings
				String name1 = "AIB Group PLC";
				String number1 = "IE00BF013536";
				double price1 = 1.993;
				double trend1 = 0.68;
			
				String name2 = "Bank of Ireland GP";
				String number2 = "IE00BF013536";
				double price2 = 4.956;
				double trend2 = 0.38;
				
				String name3 = "Ryanair Hold PLC";
				String number3 = "IE00BYTBXV33";
				double price3 = 15.065;
				double trend3 = 1.04;

				//passing the response back ie the stocklistings to the client
				stockListings reply1 = stockListings.newBuilder()
					.setCompany(name1).setIsin(number1).setPrice(price1).setTrend(trend1)
					.build();
				stockListings reply2 = stockListings.newBuilder()
					.setCompany(name2).setIsin(number2).setPrice(price2).setTrend(trend2)
					.build();
				stockListings reply3 = stockListings.newBuilder()
						.setCompany(name3).setIsin(number3).setPrice(price3).setTrend(trend3)
						.build();
				responseObserver.onNext(reply1);
				responseObserver.onNext(reply2);
				responseObserver.onNext(reply3);
				
			}

			@Override		//in case an error occurs
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override	//when the server has streamed all its message, advising that its finished
			public void onCompleted() {
				System.out.println("All Stocks Available sent");
				//completed too
				responseObserver.onCompleted();
			}	//closing onCompleted
			
		};	// closing new StreamObserver purchase
	
	}	//closing StreamObserver purchase
		
}	//closing class
				


