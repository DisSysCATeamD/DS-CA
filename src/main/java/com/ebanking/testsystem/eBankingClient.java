package com.ebanking.testsystem;

import java.util.concurrent.TimeUnit;
import javax.jmdns.ServiceInfo;
import com.ebanking.testsystem.LoginGrpc.LoginBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class eBankingClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "localhost";
		int port = 50051;
		
		ServiceInfo serviceInfo = JmDNSDiscovery.run("_grpc._tcp.local.");
		System.out.println("");
		
		//setup channel on the host and port above and it is going to communicate on the channel we setup
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//instance of our stub which has the login method on it which we can call
		LoginBlockingStub stub = LoginGrpc.newBlockingStub(channel);
		
		//try catch, to try connect to the server
		//the output from the proto file, so pass message from the client to the server, want to create a request using the LoginRequest object

		

	}

}
