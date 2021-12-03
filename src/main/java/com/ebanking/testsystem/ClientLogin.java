package com.ebanking.testsystem;

import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import com.ebanking.testsystem.LoginGrpc.LoginBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class ClientLogin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		int port = 50051;
		
		//ServiceInfo serviceInfo = JmDNSDiscovery.run("_grpc1._tcp.local.");
	
		//System.out.println("service running on port: " + serviceInfo.getPort());
		
		ManagedChannel channel1 = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		LoginBlockingStub blockingStub = LoginGrpc.newBlockingStub(channel1);
		
		try {
			String username = "Customer2";
			String password = "ThisIsThePassword";
			LoginRequest login = LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
			
			LoginValidation reply = blockingStub.sayLogin(login);
			
			System.out.println("Response" +reply.getValid());	
		}
		catch(StatusRuntimeException e) {
			e.printStackTrace();
		}
		finally {
			channel1.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			
		}
		

	}

}
