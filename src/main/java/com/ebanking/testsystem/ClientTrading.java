package com.ebanking.testsystem;

import java.util.concurrent.TimeUnit;

import com.ebanking.testsystem.TradingGrpc.TradingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ClientTrading {
	
	private static TradingStub asyncStub;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		int port = 50054;
		
		//ServiceInfo serviceInfo = JmDNSDiscovery.run("_grpc3._tcp.local.");
	
		//System.out.println("service running on port: " + serviceInfo.getPort());
		
		ManagedChannel channel4 = ManagedChannelBuilder
			.forAddress(host, port)
			.usePlaintext()
			.build();
		
		asyncStub = TradingGrpc.newStub(channel4);
	}
		
	public static void bidirectStartTrading() {
			
			//for incoming messages we need to implement a StreamObserver
			//then we pass it to the grpc library

		StreamObserver<stockListings> responseObserver = new StreamObserver<stockListings>() {

				@Override
				public void onNext(stockListings stocks) {
					System.out.println("Receiving stock listings "+stocks.getCompany()+", "+stocks.getIsin()+", "+stocks.getPrice()+", "+stocks.getTrend());
					
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

			StreamObserver<purchase> requestObserver = asyncStub.bidirectStartTrading(responseObserver);

			try {
				
				String trade = "Trade";
				String name = "AIB Group PLC";
				String number = "IE00BF013536";
				double price = 1.993;
				int amount = 50;
				
				
				requestObserver.onNext(purchase.newBuilder().setRequest(trade).build());
				
				requestObserver.onNext(purchase.newBuilder().setCompany(name).build());
				requestObserver.onNext(purchase.newBuilder().setIsin(number).build());
				requestObserver.onNext(purchase.newBuilder().setPrice(price).build());
				requestObserver.onNext(purchase.newBuilder().setAmount(amount).build());
				
				System.out.println("Please purchase these shares on my behalf and deduct the cost from my balance");
				requestObserver.onCompleted();
				Thread.sleep(8000);
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}



			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	



	}