package com.ebanking.testsystem;

import java.io.IOException;

import com.ebanking.testsystem.BalanceGrpc.BalanceImplBase;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class eBankingServerBalance {
	
	private Server server;


	public static void main(String[] args) throws IOException, InterruptedException {
		final eBankingServerBalance ourServer = new eBankingServerBalance();
		
		ourServer.start();
	}
	
	private void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		
		int port = 50052;
		JmDNSRegistration reg = new JmDNSRegistration();
		reg.run("_grpc2._tcp.local.", "BalanceService", port, "running Balance service");
		
		server =ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		System.out.println("SERVER RUNNING ON PORT:" +port);
		
		server.awaitTermination(); // server closes and the client wont be able to communicate so we need to tell it to wait around until its told to terminate
}

	//Extend abstract base class for our implementation
	
	static class NewServerImpl extends BalanceImplBase{
		
		//wrioting methods that satisfies our grpc
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
		
		@Override // Class of 28th Oct.  this is #2 task after adding server stream
		public void getSecondString(balanceRequest request, StreamObserver<balanceRequest> responseObserver) {
			
		// find out waht was sent by the client
			
			String firstString =  request.getFirstString();
			
			System.out.println("First String is: "+ firstString);
			
			// Now build our response 
			//1. we must build the message
			// 2. send the message back to the client server
			
			balanceRequest.Builder response =  balanceRequest.newBuilder();
			
			response.setFirstString("Our first response string:" +firstString);
			//this corresponds to one message
			responseObserver.onNext(response.build());  // as we are unary only we only want to get 1 message back so only need only one "onNext". Will be changeing the default "request" as we are wanting a response. 
			// response is a builder so we need to put .build
			//class of 28th Oct. lets send a new string back...
			response.setFirstString("Now streaming!");
			//this corresponds to a second message 
			responseObserver.onNext(response.build());
			//need to clean and tidy this up and while the server keeps on runing we need to tell that this transaction(stream of messages) is complete . If we had a number of onNexts would still use responseObserver.onCompleted
			responseObserver.onCompleted();
		}
		
		
				
		
		//changing it from unary to server streaming - nov 4th class. Method must always match the rpc for its name for it to work. Sending only one message back
		// to send more than one message back. we can reuse our builder
		//This was to show that we can send more than one message back with an int value
		@Override
		public void getBalanceResponseAmt(balanceRequest request, StreamObserver<balanceResponse> responseObserver) {
			
		// find out waht was sent by the client
			
			String firstString =  request.getFirstString();
			
			System.out.println("First String is: "+ firstString);
			
			// Now build our response 
			//1. we must build the message
			// 2. send the message back to the client server
			
			balanceResponse.Builder response =  balanceResponse.newBuilder();
			
			double firstInt =500.56;
			
			response.setBalRes(firstInt);
			responseObserver.onNext(response.build());  // as we are unary only we only want to get 1 message back so only need only one "onNext". Will be changeing the default "request" as we are wanting a response. 
			// response is a builder so we need to put .build
			
			responseObserver.onCompleted();
			

		

	}
		
		public void getBalanceTransactions(balanceRequest request, StreamObserver<balanceTransactions> responseObserver) {
			
			// find out waht was sent by the client
				
				String firstString =  request.getFirstString();
				
				System.out.println("First String is: "+ firstString);
				
				// Now build our response 
				//1. we must build the message
				// 2. send the message back to the client server
				
				balanceTransactions.Builder response =  balanceTransactions.newBuilder();
				
			//	double firstInt =500.56;
				String trans = "Nike.com  ";
				String trans2= "Adidas.com ";
				double transval1 = 345.34;
				double transval2 = 123.45;
			//	response.setFirstInt( firstInt);
				
			//	responseObserver.onNext(response.build());  // as we are unary only we only want to get 1 message back so only need only one "onNext". Will be changeing the default "request" as we are wanting a response. 
				// response is a builder so we need to put .build
				
				response.setTransaction(trans).setLastTrans(transval1);
				responseObserver.onNext(response.build());
				
				response.setTransaction(trans2).setLastTrans(transval2);
				responseObserver.onNext(response.build());

		
	}
}
}