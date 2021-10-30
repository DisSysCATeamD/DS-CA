package com.ebanking.testsystem;

import java.io.IOException;

import com.ebanking.testsystem.LoginGrpc.LoginImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class eBankingServerLogin  extends LoginImplBase {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		int port = 50051;
		
		eBankingServerLogin loginServer = new eBankingServerLogin();
		JmDNSRegistration reg = new JmDNSRegistration();
		reg.run("_grpc._tcp.local.", "LoginService", 50051, "running Login service");
		
		try {
			Server server1 = ServerBuilder.forPort(port)
					.addService(loginServer)
					.build()
					.start();
			
			server1.awaitTermination();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
		
	@Override
	public void sayLogin(LoginRequest request, StreamObserver<LoginValidation> responseObserver) {
		System.out.println("You are Logging on to eBanking");
			
		LoginValidation reply = LoginValidation.newBuilder()
				.setValid("Welcome " +request.getUsername()).build();
			/*
			public void check{
				if(username == "Customer2" && password == "ThisIsMyPassword") {
					System.out.println();
				}
				else {
					System.out.println("Please try again, your credentials are incorrect");	
			}
			*/
			responseObserver.onNext(reply);
			responseObserver.onCompleted();

		
		


	}

}
