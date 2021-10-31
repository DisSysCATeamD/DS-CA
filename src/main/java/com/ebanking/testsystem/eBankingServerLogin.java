package com.ebanking.testsystem;

import java.io.IOException;

import javax.xml.validation.Validator;

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
			
			responseObserver.onNext(checkLoginCredentials(request.getUsername(), request.getPassword()));
						
			responseObserver.onCompleted();

	}
	
	private LoginValidation checkLoginCredentials(String username, String password) {
		
		LoginValidation.Builder responseBuilder = LoginValidation.newBuilder();
		if(username.equals("Customer2") && password.equals("ThisIsThePassword")) {      
			responseBuilder.setValid("Login Success. Welcome " +username);
		}
		else {
			responseBuilder.setValid("Login Failed, please check your Credentials and try again");
			
		}
		return responseBuilder.build();
	}

}
