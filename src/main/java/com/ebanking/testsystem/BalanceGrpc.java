package com.ebanking.testsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Balance.proto")
public final class BalanceGrpc {

  private BalanceGrpc() {}

  public static final String SERVICE_NAME = "testsystem.Balance";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceRequest> getGetFirstStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFirstString",
      requestType = com.ebanking.testsystem.balanceRequest.class,
      responseType = com.ebanking.testsystem.balanceRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceRequest> getGetFirstStringMethod() {
    io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceRequest> getGetFirstStringMethod;
    if ((getGetFirstStringMethod = BalanceGrpc.getGetFirstStringMethod) == null) {
      synchronized (BalanceGrpc.class) {
        if ((getGetFirstStringMethod = BalanceGrpc.getGetFirstStringMethod) == null) {
          BalanceGrpc.getGetFirstStringMethod = getGetFirstStringMethod = 
              io.grpc.MethodDescriptor.<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "testsystem.Balance", "GetFirstString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceMethodDescriptorSupplier("GetFirstString"))
                  .build();
          }
        }
     }
     return getGetFirstStringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceRequest> getGetSecondStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSecondString",
      requestType = com.ebanking.testsystem.balanceRequest.class,
      responseType = com.ebanking.testsystem.balanceRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceRequest> getGetSecondStringMethod() {
    io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceRequest> getGetSecondStringMethod;
    if ((getGetSecondStringMethod = BalanceGrpc.getGetSecondStringMethod) == null) {
      synchronized (BalanceGrpc.class) {
        if ((getGetSecondStringMethod = BalanceGrpc.getGetSecondStringMethod) == null) {
          BalanceGrpc.getGetSecondStringMethod = getGetSecondStringMethod = 
              io.grpc.MethodDescriptor.<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "testsystem.Balance", "GetSecondString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceMethodDescriptorSupplier("GetSecondString"))
                  .build();
          }
        }
     }
     return getGetSecondStringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceResponse> getGetBalanceResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBalanceResponse",
      requestType = com.ebanking.testsystem.balanceRequest.class,
      responseType = com.ebanking.testsystem.balanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceResponse> getGetBalanceResponseMethod() {
    io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceResponse> getGetBalanceResponseMethod;
    if ((getGetBalanceResponseMethod = BalanceGrpc.getGetBalanceResponseMethod) == null) {
      synchronized (BalanceGrpc.class) {
        if ((getGetBalanceResponseMethod = BalanceGrpc.getGetBalanceResponseMethod) == null) {
          BalanceGrpc.getGetBalanceResponseMethod = getGetBalanceResponseMethod = 
              io.grpc.MethodDescriptor.<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "testsystem.Balance", "GetBalanceResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceMethodDescriptorSupplier("GetBalanceResponse"))
                  .build();
          }
        }
     }
     return getGetBalanceResponseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceResponse> getGetBalanceResponseAmtMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBalanceResponseAmt",
      requestType = com.ebanking.testsystem.balanceRequest.class,
      responseType = com.ebanking.testsystem.balanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceResponse> getGetBalanceResponseAmtMethod() {
    io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceResponse> getGetBalanceResponseAmtMethod;
    if ((getGetBalanceResponseAmtMethod = BalanceGrpc.getGetBalanceResponseAmtMethod) == null) {
      synchronized (BalanceGrpc.class) {
        if ((getGetBalanceResponseAmtMethod = BalanceGrpc.getGetBalanceResponseAmtMethod) == null) {
          BalanceGrpc.getGetBalanceResponseAmtMethod = getGetBalanceResponseAmtMethod = 
              io.grpc.MethodDescriptor.<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "testsystem.Balance", "GetBalanceResponseAmt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceMethodDescriptorSupplier("GetBalanceResponseAmt"))
                  .build();
          }
        }
     }
     return getGetBalanceResponseAmtMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceTransactions> getGetBalanceTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBalanceTransactions",
      requestType = com.ebanking.testsystem.balanceRequest.class,
      responseType = com.ebanking.testsystem.balanceTransactions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest,
      com.ebanking.testsystem.balanceTransactions> getGetBalanceTransactionsMethod() {
    io.grpc.MethodDescriptor<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceTransactions> getGetBalanceTransactionsMethod;
    if ((getGetBalanceTransactionsMethod = BalanceGrpc.getGetBalanceTransactionsMethod) == null) {
      synchronized (BalanceGrpc.class) {
        if ((getGetBalanceTransactionsMethod = BalanceGrpc.getGetBalanceTransactionsMethod) == null) {
          BalanceGrpc.getGetBalanceTransactionsMethod = getGetBalanceTransactionsMethod = 
              io.grpc.MethodDescriptor.<com.ebanking.testsystem.balanceRequest, com.ebanking.testsystem.balanceTransactions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "testsystem.Balance", "GetBalanceTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.balanceTransactions.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceMethodDescriptorSupplier("GetBalanceTransactions"))
                  .build();
          }
        }
     }
     return getGetBalanceTransactionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BalanceStub newStub(io.grpc.Channel channel) {
    return new BalanceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BalanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BalanceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BalanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BalanceFutureStub(channel);
  }

  /**
   */
  public static abstract class BalanceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFirstString(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFirstStringMethod(), responseObserver);
    }

    /**
     */
    public void getSecondString(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSecondStringMethod(), responseObserver);
    }

    /**
     */
    public void getBalanceResponse(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceResponseMethod(), responseObserver);
    }

    /**
     * <pre>
     *server streaming for Balance
     * </pre>
     */
    public void getBalanceResponseAmt(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceResponseAmtMethod(), responseObserver);
    }

    /**
     * <pre>
     * server side streaming for last 3 transactions
     * </pre>
     */
    public void getBalanceTransactions(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceTransactions> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceTransactionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFirstStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ebanking.testsystem.balanceRequest,
                com.ebanking.testsystem.balanceRequest>(
                  this, METHODID_GET_FIRST_STRING)))
          .addMethod(
            getGetSecondStringMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ebanking.testsystem.balanceRequest,
                com.ebanking.testsystem.balanceRequest>(
                  this, METHODID_GET_SECOND_STRING)))
          .addMethod(
            getGetBalanceResponseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ebanking.testsystem.balanceRequest,
                com.ebanking.testsystem.balanceResponse>(
                  this, METHODID_GET_BALANCE_RESPONSE)))
          .addMethod(
            getGetBalanceResponseAmtMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ebanking.testsystem.balanceRequest,
                com.ebanking.testsystem.balanceResponse>(
                  this, METHODID_GET_BALANCE_RESPONSE_AMT)))
          .addMethod(
            getGetBalanceTransactionsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ebanking.testsystem.balanceRequest,
                com.ebanking.testsystem.balanceTransactions>(
                  this, METHODID_GET_BALANCE_TRANSACTIONS)))
          .build();
    }
  }

  /**
   */
  public static final class BalanceStub extends io.grpc.stub.AbstractStub<BalanceStub> {
    private BalanceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceStub(channel, callOptions);
    }

    /**
     */
    public void getFirstString(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceRequest> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFirstStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSecondString(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceRequest> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetSecondStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBalanceResponse(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceResponseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server streaming for Balance
     * </pre>
     */
    public void getBalanceResponseAmt(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceResponseAmtMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server side streaming for last 3 transactions
     * </pre>
     */
    public void getBalanceTransactions(com.ebanking.testsystem.balanceRequest request,
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceTransactions> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetBalanceTransactionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BalanceBlockingStub extends io.grpc.stub.AbstractStub<BalanceBlockingStub> {
    private BalanceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ebanking.testsystem.balanceRequest getFirstString(com.ebanking.testsystem.balanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFirstStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.ebanking.testsystem.balanceRequest> getSecondString(
        com.ebanking.testsystem.balanceRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetSecondStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ebanking.testsystem.balanceResponse getBalanceResponse(com.ebanking.testsystem.balanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceResponseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server streaming for Balance
     * </pre>
     */
    public com.ebanking.testsystem.balanceResponse getBalanceResponseAmt(com.ebanking.testsystem.balanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceResponseAmtMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server side streaming for last 3 transactions
     * </pre>
     */
    public java.util.Iterator<com.ebanking.testsystem.balanceTransactions> getBalanceTransactions(
        com.ebanking.testsystem.balanceRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetBalanceTransactionsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BalanceFutureStub extends io.grpc.stub.AbstractStub<BalanceFutureStub> {
    private BalanceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ebanking.testsystem.balanceRequest> getFirstString(
        com.ebanking.testsystem.balanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFirstStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ebanking.testsystem.balanceResponse> getBalanceResponse(
        com.ebanking.testsystem.balanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceResponseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *server streaming for Balance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ebanking.testsystem.balanceResponse> getBalanceResponseAmt(
        com.ebanking.testsystem.balanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceResponseAmtMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FIRST_STRING = 0;
  private static final int METHODID_GET_SECOND_STRING = 1;
  private static final int METHODID_GET_BALANCE_RESPONSE = 2;
  private static final int METHODID_GET_BALANCE_RESPONSE_AMT = 3;
  private static final int METHODID_GET_BALANCE_TRANSACTIONS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BalanceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BalanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FIRST_STRING:
          serviceImpl.getFirstString((com.ebanking.testsystem.balanceRequest) request,
              (io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceRequest>) responseObserver);
          break;
        case METHODID_GET_SECOND_STRING:
          serviceImpl.getSecondString((com.ebanking.testsystem.balanceRequest) request,
              (io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceRequest>) responseObserver);
          break;
        case METHODID_GET_BALANCE_RESPONSE:
          serviceImpl.getBalanceResponse((com.ebanking.testsystem.balanceRequest) request,
              (io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceResponse>) responseObserver);
          break;
        case METHODID_GET_BALANCE_RESPONSE_AMT:
          serviceImpl.getBalanceResponseAmt((com.ebanking.testsystem.balanceRequest) request,
              (io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceResponse>) responseObserver);
          break;
        case METHODID_GET_BALANCE_TRANSACTIONS:
          serviceImpl.getBalanceTransactions((com.ebanking.testsystem.balanceRequest) request,
              (io.grpc.stub.StreamObserver<com.ebanking.testsystem.balanceTransactions>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BalanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BalanceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ebanking.testsystem.BalanceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Balance");
    }
  }

  private static final class BalanceFileDescriptorSupplier
      extends BalanceBaseDescriptorSupplier {
    BalanceFileDescriptorSupplier() {}
  }

  private static final class BalanceMethodDescriptorSupplier
      extends BalanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BalanceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BalanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BalanceFileDescriptorSupplier())
              .addMethod(getGetFirstStringMethod())
              .addMethod(getGetSecondStringMethod())
              .addMethod(getGetBalanceResponseMethod())
              .addMethod(getGetBalanceResponseAmtMethod())
              .addMethod(getGetBalanceTransactionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
