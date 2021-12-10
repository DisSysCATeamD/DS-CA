package com.ebanking.testsystem;

import com.ebanking.testsystem.PaymentServiceGrpc.PaymentServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

//server for client streaming RPC
//extend abstract base class for our implementation, based on our proto	
//this PaymentServiceImplBase comes from the proto and is found in the PaymentServiceGrpc

public class eBankingServerPayment extends PaymentServiceImplBase{

	public static void main(String[] args) {	//main method
		// TODO Auto-generated method stub
		System.out.println("Starting Payment gRPC Server");
		int port = 50003;
		
		eBankingServerPayment paymentServer = new eBankingServerPayment();
		//for jmDNS - not working on client GUI currently commented out
		JmDNSRegistration reg = new JmDNSRegistration();
		reg.run("_pay._tcp.local.", "PaymentService", 50003, "running Payment service");
		
		try {	//to build our particular service
			Server server3 = ServerBuilder.forPort(port)
					.addService(paymentServer)
					.build()
					.start();
			System.out.println("Server running on port: "+port);
			server3.awaitTermination();
			
		} catch(Exception e) {
			System.out.println(e);
		}}
		
		//method for client streaming
		//for incoming message in application implements the Stream observer
		//and passes it back to the grpc library for receiving
			
		public class InputStreamObserver implements StreamObserver<BillPayment>{
			
			String message = "";
			double balance = 1195.86;
			private final StreamObserver<Status> outputStreamObserver;
			
			//creating the response from the server
			public InputStreamObserver(StreamObserver<Status> outputStreamObserver) {
		        this.outputStreamObserver = outputStreamObserver;
			}

			@Override	//validating the received message, and checking that the amount being paid is not greater than the balance and creating response
			public void onNext(BillPayment value) {
				if(balance >= value.getAmount()) {
					balance = balance - value.getAmount();
					message = "Transaction Successful, your new balance is €"+balance;	
				}
				else {
					message = "Transaction Failed, please add more funds to complete this transaction";
				}
			}

			@Override		//incase an error occurs
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {		//when the client streaming has completed, the server, builds the reply based on if the transaction failed or succeeded
				Status response = Status.newBuilder().setConfirmation(message).build();
				outputStreamObserver.onNext(response);	//the response is the message returned
				outputStreamObserver.onCompleted();
				
			}
			
		}
		
		@Override //
		public StreamObserver<BillPayment> sentPayment(StreamObserver<Status> ResponseObserver){
			System.out.println("On server, inside streaming method");
			return new InputStreamObserver(ResponseObserver);
			
		}	//closing StreamObserver Billpayment

	

}	//closing class
