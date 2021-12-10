package com.ebanking.testsystem;

import java.io.IOException;

import com.ebanking.testsystem.LoginGrpc.LoginImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

//Server for unary RPC - Login
//server implements the methods declared by the service and runs a gRPC server to handle client requests
public class eBankingServerLogin {
	
	private Server server;
	
	//main method with exception handing
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		final eBankingServerLogin loginServer = new eBankingServerLogin();
		loginServer.start();		//instantiating a method of this class
		
	}
		
	private void start() throws IOException, InterruptedException{
		System.out.println("Starting Login Grpc Server");
		try {
			int port = 50001;
			//for jmDNS - not working on client GUI currently commented out
		
			JmDNSRegistration reg = new JmDNSRegistration();
			reg.run("_grpc._tcp.local.", "LoginService", port , "running Login service");
		
			//setting up a generic port, but have to build our particular service
			server = ServerBuilder.forPort(port).addService(new LogonServerImpl()).build().start();
			System.out.println("Server runnning on port: "+port);
			
			server.awaitTermination();
		}catch(Exception e) {
			System.out.println("Error, Server unable to start");
		}
		
	}
	//extend abstract base class for our implementation, based on our proto	
	//this LoginImplBase comes from the proto and is found in the LoginGrpc
	static class LogonServerImpl extends LoginImplBase{
		
	//this message will be sent by the client to the server
	public void sayLogin(LoginRequest request, StreamObserver<LoginValidation> responseObserver) {
		System.out.println("You are Logging on to eBanking");			
			//requesting the user to enter their username and password and checking using the logon method below
			responseObserver.onNext(checkLoginCredentials(request.getUsername(), request.getPassword()));
						
			responseObserver.onCompleted();

	}
	//method to validate the username and password entered by the customer
	private LoginValidation checkLoginCredentials(String username, String password) {
		//send response back to the client
		//first build a message and send that message back to the client, need to use a builder
		LoginValidation.Builder responseBuilder = LoginValidation.newBuilder();
		if(username.equals("Maria") && password.equals("password")) {      
			responseBuilder.setValid("Login Success. Welcome " +username);
		}
		else {
			responseBuilder.setValid("Login Failed, please check your Credentials and try again");
			
		}
		return responseBuilder.build();	//returning the response valid or failed to the client
	}	//closing LoginValidation
	} //closing LogonServerImpl

} //closing class
