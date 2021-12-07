package com.ebanking.testsystem;

import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import com.ebanking.testsystem.PaymentServiceGrpc.PaymentServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ClientPayment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		//int port = 50003;
		
		ServiceInfo serviceInfo3 = JmDNSDiscovery.run("_pay._tcp.local.");
	
		System.out.println("service running on port: " + serviceInfo3.getPort());
		
		ManagedChannel channel3 = ManagedChannelBuilder
				.forAddress(host, serviceInfo3.getPort())
				.usePlaintext()
				.build();
		System.out.println("service running on port: " + serviceInfo3.getPort());
		
		PaymentServiceStub asyncStub = PaymentServiceGrpc.newStub(channel3);
		
		//for incoming messages we need to implement a StreamObserver
		//then we pass it to the grpc library
				
		StreamObserver<Status> responseObserver = new StreamObserver<Status>() {

		@Override
		public void onNext(Status value) {
		// TODO Auto-generated method stub
			System.out.println("Response from server: \n" + value.getConfirmation());
		}

		@Override
		public void onError(Throwable t) {
		// TODO Auto-generated method stub
						
		}

		@Override
		public void onCompleted() {
		// TODO Auto-generated method stub
						
		}};
		
		try {
			
			
			String bic = "BOFIIE2D";
			String iban = "IE94AIBK000123456789";
			String payee = "Betty Doyle";
			String description = "For flowers";
			double amount = 22.50;
		
			//grpc library returns a streamObserver to use requestObserver
			//we use this to send our outgoing messages
			StreamObserver<BillPayment> requestObserver = asyncStub.sentPayment(responseObserver);
			
			requestObserver.onNext(BillPayment.newBuilder().setBic(bic).build());
			requestObserver.onNext(BillPayment.newBuilder().setIban(iban).build());
			requestObserver.onNext(BillPayment.newBuilder().setPayee(payee).build());
			requestObserver.onNext(BillPayment.newBuilder().setDescription(description).build());
			requestObserver.onNext(BillPayment.newBuilder().setAmount(amount).build());
			
			System.out.println("Client has sent full payment details");
			requestObserver.onCompleted();
			Thread.sleep(8000);
			
		}
			catch(StatusRuntimeException e) {
				e.printStackTrace();
			}
			finally {
				channel3.shutdown().awaitTermination(60, TimeUnit.SECONDS);

		
		}

	}

}
