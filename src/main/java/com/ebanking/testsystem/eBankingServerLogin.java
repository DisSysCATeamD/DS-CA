package com.ebanking.testsystem;

import java.io.IOException;

import com.ebanking.testsystem.LoginGrpc.LoginImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class eBankingServerLogin {
	
	private Server server;
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		final eBankingServerLogin loginServer = new eBankingServerLogin();
		loginServer.start();
		
		//JmDNSRegistration reg = new JmDNSRegistration();
		//reg.run("_grpc1._tcp.local.", "LoginService", port, "running Login service");
	}
		
	private void start() throws IOException, InterruptedException{
		System.out.println("Starting Grpc Server");
			
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new LogonServerImpl()).build().start();
		System.out.println("Server runnning on port: "+port);
			
			server.awaitTermination();
		
	}
		
	static class LogonServerImpl extends LoginImplBase{
		
	
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

}
