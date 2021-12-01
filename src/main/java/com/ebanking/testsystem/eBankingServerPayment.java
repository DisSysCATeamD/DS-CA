package com.ebanking.testsystem;

import com.ebanking.testsystem.PaymentServiceGrpc.PaymentServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class eBankingServerPayment extends PaymentServiceImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting gRPC Server");
		int port = 50053;
		
		eBankingServerPayment paymentServer = new eBankingServerPayment();
		JmDNSRegistration reg3 = new JmDNSRegistration();
		reg3.run("_grpc3._tcp.local.", "PaymentService", port, "running Payment service");
		
		try {
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
		//for incoming message in application implements tthe Stream observer
		//and passes it back to the grpc library for receiving
		
		
		public class InputStreamObserver implements StreamObserver<BillPayment>{
			
			String message = "";
			double balance = 1195.86;
			private final StreamObserver<Status> outputStreamObserver;
			
			public InputStreamObserver(StreamObserver<Status> outputStreamObserver) {
		        this.outputStreamObserver = outputStreamObserver;
			}

			@Override
			public void onNext(BillPayment value) {
				if(balance >= value.getAmount()) {
					if(value.getBic().matches("BOFIIE2D") || value.getBic().matches("AIBKIE2D") || value.getBic().matches("IPBSIE2D")){
						balance = balance - value.getAmount();
						message = "Transaction Successful, your new balance is €"+balance;
					}
					else {
						message = "The information provided is not correct. Please check and Try Again";
					}
				}
				else {
					message = "Transaction Failed, please add more funds to complete this transaction";
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				Status response = Status.newBuilder().setConfirmation(message).build();
				outputStreamObserver.onNext(response);
				outputStreamObserver.onCompleted();
				
			}
			
		}
		
		@Override 
		public StreamObserver<BillPayment> sentPayment(StreamObserver<Status> ResponseObserver){
			System.out.println("On server, inside streaming method");
			return new InputStreamObserver(ResponseObserver);
			
		}

	

}
