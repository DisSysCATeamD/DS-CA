package com.ebanking.testsystem;

import com.ebanking.testsystem.TradingGrpc.TradingImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class eBankingServerTrading extends TradingImplBase{
	
	public static void main(String[] args){
		
		System.out.println("Starting Trading Grpc Server");
		int port = 50054;

		eBankingServerTrading tradingServer = new eBankingServerTrading();	
		//JmDNSRegistration reg = new JmDNSRegistration();
		//reg.run("_grpc4._tcp.local.", "TradingService", port, "running Trading service");
		try {
			Server server4 = ServerBuilder.forPort(port)
					.addService(tradingServer)
					.build()
					.start();
			System.out.println("Server running on port: "+port);
			server4.awaitTermination();
			
		} catch(Exception e) {
			System.out.println(e);
		}}
	
public StreamObserver<purchase> bidirectStartTrading(StreamObserver<stockListings> responseObserver) {
		
		return new StreamObserver<purchase> () {

			@Override
			public void onNext(purchase buy) {
				System.out.println("Requesting information from Server: ");
				double balance =  1196.25;
				if(buy.getRequest().equals("Trade") && balance >= 1000) {
					System.out.println("I would like to purchase " +buy.getCompany()+", " +buy.getIsin()+", " +buy.getPrice()+", " +buy.getAmount());
					double cost = buy.getPrice()*buy.getAmount();
					balance = balance - cost;
					System.out.println("Total Cost is: "+cost+ "\nYour Balance is: "+balance);
				}
				else {
					System.out.println("Thank you");
				}
				
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

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("All Stocks Available sent");
				//completed too
				responseObserver.onCompleted();
			}
		};
	}
		
}
				


