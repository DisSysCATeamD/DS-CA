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
    comments = "Source: Trading.proto")
public final class TradingGrpc {

  private TradingGrpc() {}

  public static final String SERVICE_NAME = "testsystem.Trading";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ebanking.testsystem.purchase,
      com.ebanking.testsystem.stockListings> getBidirectStartTradingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bidirectStartTrading",
      requestType = com.ebanking.testsystem.purchase.class,
      responseType = com.ebanking.testsystem.stockListings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.ebanking.testsystem.purchase,
      com.ebanking.testsystem.stockListings> getBidirectStartTradingMethod() {
    io.grpc.MethodDescriptor<com.ebanking.testsystem.purchase, com.ebanking.testsystem.stockListings> getBidirectStartTradingMethod;
    if ((getBidirectStartTradingMethod = TradingGrpc.getBidirectStartTradingMethod) == null) {
      synchronized (TradingGrpc.class) {
        if ((getBidirectStartTradingMethod = TradingGrpc.getBidirectStartTradingMethod) == null) {
          TradingGrpc.getBidirectStartTradingMethod = getBidirectStartTradingMethod = 
              io.grpc.MethodDescriptor.<com.ebanking.testsystem.purchase, com.ebanking.testsystem.stockListings>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "testsystem.Trading", "bidirectStartTrading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.purchase.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ebanking.testsystem.stockListings.getDefaultInstance()))
                  .setSchemaDescriptor(new TradingMethodDescriptorSupplier("bidirectStartTrading"))
                  .build();
          }
        }
     }
     return getBidirectStartTradingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TradingStub newStub(io.grpc.Channel channel) {
    return new TradingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TradingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TradingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TradingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TradingFutureStub(channel);
  }

  /**
   */
  public static abstract class TradingImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.ebanking.testsystem.purchase> bidirectStartTrading(
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.stockListings> responseObserver) {
      return asyncUnimplementedStreamingCall(getBidirectStartTradingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBidirectStartTradingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.ebanking.testsystem.purchase,
                com.ebanking.testsystem.stockListings>(
                  this, METHODID_BIDIRECT_START_TRADING)))
          .build();
    }
  }

  /**
   */
  public static final class TradingStub extends io.grpc.stub.AbstractStub<TradingStub> {
    private TradingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TradingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TradingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TradingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ebanking.testsystem.purchase> bidirectStartTrading(
        io.grpc.stub.StreamObserver<com.ebanking.testsystem.stockListings> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBidirectStartTradingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TradingBlockingStub extends io.grpc.stub.AbstractStub<TradingBlockingStub> {
    private TradingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TradingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TradingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TradingBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class TradingFutureStub extends io.grpc.stub.AbstractStub<TradingFutureStub> {
    private TradingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TradingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TradingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TradingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_BIDIRECT_START_TRADING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TradingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TradingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BIDIRECT_START_TRADING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidirectStartTrading(
              (io.grpc.stub.StreamObserver<com.ebanking.testsystem.stockListings>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TradingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TradingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ebanking.testsystem.TradingSystemImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Trading");
    }
  }

  private static final class TradingFileDescriptorSupplier
      extends TradingBaseDescriptorSupplier {
    TradingFileDescriptorSupplier() {}
  }

  private static final class TradingMethodDescriptorSupplier
      extends TradingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TradingMethodDescriptorSupplier(String methodName) {
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
      synchronized (TradingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TradingFileDescriptorSupplier())
              .addMethod(getBidirectStartTradingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
