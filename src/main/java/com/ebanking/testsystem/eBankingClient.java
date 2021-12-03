package com.ebanking.testsystem;

import java.util.concurrent.TimeUnit;
import javax.jmdns.ServiceInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Scanner;

import com.ebanking.testsystem.BalanceGrpc.BalanceBlockingStub;
import com.ebanking.testsystem.LoginGrpc.LoginBlockingStub;
import com.ebanking.testsystem.PaymentServiceGrpc.PaymentServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


public class eBankingClient {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String host = "localhost";
		
		int port;
		
		ServiceInfo serviceInfo = JmDNSDiscovery.run("_grpc1._tcp.local.");
		ServiceInfo serviceInfo2 = JmDNSDiscovery.run("_grpc2._tcp.local.");
		ServiceInfo serviceInfo3 = JmDNSDiscovery.run("_grpc3._tcp.local.");
		ServiceInfo serviceInfo4 = JmDNSDiscovery.run("_grpc4._tcp.local.");

		System.out.println("service running on port: " + serviceInfo.getPort());
	
		
		//setup channel on the host and port above and it is going to communicate on the channel we setup
		ManagedChannel channel1 = ManagedChannelBuilder
				.forAddress(host, serviceInfo.getPort())
				.usePlaintext()
				.build();
		
		ManagedChannel channel3 = ManagedChannelBuilder
				.forAddress(host, serviceInfo3.getPort())
				.usePlaintext()
				.build();
		ManagedChannel channel4 = ManagedChannelBuilder
				.forAddress(host, serviceInfo4.getPort())
				.usePlaintext()
				.build();
		
		//unary rpc, client sends username and password, server replies if it is valid
		//instance of our stub which has the login method on it which we can call
		
		LoginBlockingStub stub = LoginGrpc.newBlockingStub(channel1);
		PaymentServiceStub asyncStub =  PaymentServiceGrpc.newStub(channel3);
		
		//try catch, to try connect to the server
		//the output from the proto file, so pass message from the client to the server, want to create a request using the LoginRequest object
		try {
			LoginRequest login = LoginRequest.newBuilder().setUsername("Customer2").setPassword("ThisIsThePassword").build();
			LoginValidation reply = stub.sayLogin(login);
			
			System.out.println(reply.getValid());	
		}
		catch(StatusRuntimeException e) {
			e.printStackTrace();
		}
		finally {
			channel1.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			
		}
		
		// Build a channel 
		//int port = 50052;
				
				
		// build the channel
		ManagedChannel channel2 = ManagedChannelBuilder
				.forAddress(host, serviceInfo2.getPort())
				.usePlaintext()
				.build();
						
		// Creating a message that will be sent to the server
				
		balanceRequest cString =balanceRequest.newBuilder().setFirstString("Getting Balance").build(); 
				
		//create a stub .object that the client has that is a representation of the remote service. and is specific to the service
		//can have 2 types of stub - blocking and async. async is send off the request and this will allow you to carry on with your code while you wait for response
				
		BalanceBlockingStub bstub = BalanceGrpc.newBlockingStub(channel2);

		//we can use this now to call the rpc
				
		balanceRequest response =	bstub.getFirstString(cString);
		// this returns the Balance
		balanceResponse response3 =	bstub.getBalanceResponseAmt(cString);
		System.out.println("Your Balance is:  "+ response3.getBalRes());
				
		System.out.println(response.getFirstString());
				
		//This returns the stream of the last transactions
				
		Iterator<balanceTransactions> transactions;
			transactions =	bstub.getBalanceTransactions(cString);
			for (int i = 1; transactions.hasNext(); i++) {
				    balanceTransactions response1 = transactions.next();
				    System.out.println("\n" +response1.getTransaction() +"€" +response1.getLastTrans());
			}		
			try {
				channel2.shutdown().awaitTermination(5,TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Error closing down channel");
				e.printStackTrace();
			}
		
		//client streaming - Paying a bill. Client sends Bill details, Server validates and returns if successful or not
		

	}

}
