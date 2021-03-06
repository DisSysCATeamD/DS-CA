// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Balance.proto

package com.ebanking.testsystem;

/**
 * <pre>
 *For our 3 Last Transactions
 * </pre>
 *
 * Protobuf type {@code testsystem.balanceTransactions}
 */
public  final class balanceTransactions extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:testsystem.balanceTransactions)
    balanceTransactionsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use balanceTransactions.newBuilder() to construct.
  private balanceTransactions(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private balanceTransactions() {
    transaction_ = "";
    lastTrans_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private balanceTransactions(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            transaction_ = s;
            break;
          }
          case 25: {

            lastTrans_ = input.readDouble();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ebanking.testsystem.BalanceImpl.internal_static_testsystem_balanceTransactions_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ebanking.testsystem.BalanceImpl.internal_static_testsystem_balanceTransactions_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ebanking.testsystem.balanceTransactions.class, com.ebanking.testsystem.balanceTransactions.Builder.class);
  }

  public static final int TRANSACTION_FIELD_NUMBER = 2;
  private volatile java.lang.Object transaction_;
  /**
   * <code>string transaction = 2;</code>
   */
  public java.lang.String getTransaction() {
    java.lang.Object ref = transaction_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      transaction_ = s;
      return s;
    }
  }
  /**
   * <code>string transaction = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTransactionBytes() {
    java.lang.Object ref = transaction_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      transaction_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LASTTRANS_FIELD_NUMBER = 3;
  private double lastTrans_;
  /**
   * <code>double lastTrans = 3;</code>
   */
  public double getLastTrans() {
    return lastTrans_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getTransactionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, transaction_);
    }
    if (lastTrans_ != 0D) {
      output.writeDouble(3, lastTrans_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTransactionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, transaction_);
    }
    if (lastTrans_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, lastTrans_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ebanking.testsystem.balanceTransactions)) {
      return super.equals(obj);
    }
    com.ebanking.testsystem.balanceTransactions other = (com.ebanking.testsystem.balanceTransactions) obj;

    boolean result = true;
    result = result && getTransaction()
        .equals(other.getTransaction());
    result = result && (
        java.lang.Double.doubleToLongBits(getLastTrans())
        == java.lang.Double.doubleToLongBits(
            other.getLastTrans()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TRANSACTION_FIELD_NUMBER;
    hash = (53 * hash) + getTransaction().hashCode();
    hash = (37 * hash) + LASTTRANS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getLastTrans()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ebanking.testsystem.balanceTransactions parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ebanking.testsystem.balanceTransactions parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ebanking.testsystem.balanceTransactions parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ebanking.testsystem.balanceTransactions prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *For our 3 Last Transactions
   * </pre>
   *
   * Protobuf type {@code testsystem.balanceTransactions}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:testsystem.balanceTransactions)
      com.ebanking.testsystem.balanceTransactionsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ebanking.testsystem.BalanceImpl.internal_static_testsystem_balanceTransactions_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ebanking.testsystem.BalanceImpl.internal_static_testsystem_balanceTransactions_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ebanking.testsystem.balanceTransactions.class, com.ebanking.testsystem.balanceTransactions.Builder.class);
    }

    // Construct using com.ebanking.testsystem.balanceTransactions.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      transaction_ = "";

      lastTrans_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ebanking.testsystem.BalanceImpl.internal_static_testsystem_balanceTransactions_descriptor;
    }

    @java.lang.Override
    public com.ebanking.testsystem.balanceTransactions getDefaultInstanceForType() {
      return com.ebanking.testsystem.balanceTransactions.getDefaultInstance();
    }

    @java.lang.Override
    public com.ebanking.testsystem.balanceTransactions build() {
      com.ebanking.testsystem.balanceTransactions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ebanking.testsystem.balanceTransactions buildPartial() {
      com.ebanking.testsystem.balanceTransactions result = new com.ebanking.testsystem.balanceTransactions(this);
      result.transaction_ = transaction_;
      result.lastTrans_ = lastTrans_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ebanking.testsystem.balanceTransactions) {
        return mergeFrom((com.ebanking.testsystem.balanceTransactions)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ebanking.testsystem.balanceTransactions other) {
      if (other == com.ebanking.testsystem.balanceTransactions.getDefaultInstance()) return this;
      if (!other.getTransaction().isEmpty()) {
        transaction_ = other.transaction_;
        onChanged();
      }
      if (other.getLastTrans() != 0D) {
        setLastTrans(other.getLastTrans());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.ebanking.testsystem.balanceTransactions parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ebanking.testsystem.balanceTransactions) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object transaction_ = "";
    /**
     * <code>string transaction = 2;</code>
     */
    public java.lang.String getTransaction() {
      java.lang.Object ref = transaction_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        transaction_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string transaction = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTransactionBytes() {
      java.lang.Object ref = transaction_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        transaction_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string transaction = 2;</code>
     */
    public Builder setTransaction(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      transaction_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string transaction = 2;</code>
     */
    public Builder clearTransaction() {
      
      transaction_ = getDefaultInstance().getTransaction();
      onChanged();
      return this;
    }
    /**
     * <code>string transaction = 2;</code>
     */
    public Builder setTransactionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      transaction_ = value;
      onChanged();
      return this;
    }

    private double lastTrans_ ;
    /**
     * <code>double lastTrans = 3;</code>
     */
    public double getLastTrans() {
      return lastTrans_;
    }
    /**
     * <code>double lastTrans = 3;</code>
     */
    public Builder setLastTrans(double value) {
      
      lastTrans_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double lastTrans = 3;</code>
     */
    public Builder clearLastTrans() {
      
      lastTrans_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:testsystem.balanceTransactions)
  }

  // @@protoc_insertion_point(class_scope:testsystem.balanceTransactions)
  private static final com.ebanking.testsystem.balanceTransactions DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ebanking.testsystem.balanceTransactions();
  }

  public static com.ebanking.testsystem.balanceTransactions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<balanceTransactions>
      PARSER = new com.google.protobuf.AbstractParser<balanceTransactions>() {
    @java.lang.Override
    public balanceTransactions parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new balanceTransactions(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<balanceTransactions> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<balanceTransactions> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ebanking.testsystem.balanceTransactions getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

