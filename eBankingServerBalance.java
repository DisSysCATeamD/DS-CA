package com.ebanking.testsystem;

import java.io.IOException;

import com.ebanking.testsystem.BalanceGrpc.BalanceImplBase;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class eBankingServerBalance {
	
	private Server server;


	public static void main(String[] args) throws IOException, InterruptedException {
		final eBankingServerBalance ourServer = new eBankingServerBalance();	// creating an instance of the EBanking Balance Server
		
		ourServer.start();
	}
	
	private void start() throws IOException, InterruptedException {		
		System.out.println("Starting gRPC Server");
		try {
			int port = 50002;	// using port 50002 as 50001 is being used by another service
			JmDNSRegistration reg = new JmDNSRegistration();
			reg.run("_bal._tcp.local.", "BalanceService", port, "running Balance service");
		
			server =ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
			System.out.println("SERVER RUNNING ON PORT:" +port);
		
			server.awaitTermination(); // server closes and the client wont be able to communicate so we need to tell it to wait around until its told to terminate
		}catch(Exception e) {
			System.out.println("Error, Server unable to start");
		}
		
	}

	//Extend abstract base class for our implementation
	
	static class NewServerImpl extends BalanceImplBase{
		
		//writing methods that satisfies our grpc
		@Override
		public void getFirstString(balanceRequest request, StreamObserver<balanceRequest> responseObserver) {
			
		// find out waht was sent by the client
			
			String firstString =  request.getFirstString(); 
			
			System.out.println("First String is: "+ firstString);
			
			// Now build our response 
			//1. we must build the message
			// 2. send the message back to the client server
			
			balanceRequest.Builder response =  balanceRequest.newBuilder();
			
			response.setFirstString("Our first response string:" +firstString);
			
			responseObserver.onNext(response.build());  // as we are unary only we only want to get 1 message back so only need only one "onNext". Will be changeing the default "request" as we are wanting a response. 
			// response is a builder so we need to put .build
			
			//need to clean and tidy this up and while the server keeps on runing we need to tell that this transaction(stream of messages) is complete . If we had a number of onNexts would still use responseObserver.onCompleted
			responseObserver.onCompleted();
		}
		
		//This method was put in here to test. I don't want to remove it unless Im absolutely sure it wont break my coded
		@Override 
		public void getSecondString(balanceRequest request, StreamObserver<balanceRequest> responseObserver) {
			
		// find out what was sent by the client
			
			String firstString =  request.getFirstString();
			
			System.out.println("First String is: "+ firstString);
			
			// Now build our response 
			//1. we must build the message
			// 2. send the message back to the client server
			
			balanceRequest.Builder response =  balanceRequest.newBuilder();
			
			response.setFirstString("Our first response string:" +firstString);
			//this corresponds to one message
			responseObserver.onNext(response.build());  
			
			response.setFirstString("Now streaming!");
			
			//this corresponds to a second message 
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
		}
		
		
		// This Method returns the user balance once a request to the server is made. Here we are setting a value that represents an example balance
		// We then set the value as the response which then gets sent back to client
		// Treating as unary as only sending one back			
		@Override
		public void getBalanceResponseAmt(balanceRequest request, StreamObserver<balanceResponse> responseObserver) {
			
		// find out what was sent by the client
			
			String firstString =  request.getFirstString();
			
			System.out.println("First String is: "+ firstString);
			
			// Now build our response 
			//1. we must build the message
			// 2. send the message back to the client server
			
			balanceResponse.Builder response =  balanceResponse.newBuilder();
			
			double firstInt =1195.86;		// setting a value here that represents an example balance
			
			response.setBalRes(firstInt);
			responseObserver.onNext(response.build());  // as we are unary only we only want to get 1 message back so only need only one "onNext". Will be changeing the default "request" as we are wanting a response. 
			// response is a builder so we need to put .build
			
			responseObserver.onCompleted();	

	}
		
		// This method sends back a stream of the last transactions of the user. We are setting values here for last transactions - The transaction description and the
		// transaction value which are then sent back to the client
		// Treated as Server Stream 
		
		public void getBalanceTransactions(balanceRequest request, StreamObserver<balanceTransactions> responseObserver) {
			
			// find out what was sent by the client
				
				String firstString =  request.getFirstString();
				
				System.out.println("First String is: "+ firstString);
				
				// Now build our response 
				//1. we must build the message
				// 2. send the message back to the client server
				
				balanceTransactions.Builder response =  balanceTransactions.newBuilder();
				
				String trans = "Nike.com  ";
				String trans2= "Adidas.com ";
				String trans3 = "Schuh.com ";
				double transval1 = 345.34;
				double transval2 = 123.45;
				double transval3 = 54.23;
	
				
				response.setTransaction(trans).setLastTrans(transval1);
				responseObserver.onNext(response.build());
				
				response.setTransaction(trans2).setLastTrans(transval2);	// need to set to values to our response, the string of the name of the transaction and then the value
				responseObserver.onNext(response.build());
				
				response.setTransaction(trans3).setLastTrans(transval3); // need to set to values to our response, the string of the name of the transaction and then the value
				responseObserver.onNext(response.build());
				
				responseObserver.onCompleted();

		
	}
}
}