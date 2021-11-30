// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Payment.proto

package com.ebanking.testsystem;

/**
 * Protobuf type {@code testsystem.BillPayment}
 */
public  final class BillPayment extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:testsystem.BillPayment)
    BillPaymentOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BillPayment.newBuilder() to construct.
  private BillPayment(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BillPayment() {
    bic_ = "";
    iban_ = "";
    payee_ = "";
    description_ = "";
    amount_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BillPayment(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            bic_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            iban_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            payee_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            description_ = s;
            break;
          }
          case 41: {

            amount_ = input.readDouble();
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
    return com.ebanking.testsystem.PaymentSystemImpl.internal_static_testsystem_BillPayment_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ebanking.testsystem.PaymentSystemImpl.internal_static_testsystem_BillPayment_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ebanking.testsystem.BillPayment.class, com.ebanking.testsystem.BillPayment.Builder.class);
  }

  public static final int BIC_FIELD_NUMBER = 1;
  private volatile java.lang.Object bic_;
  /**
   * <code>string bic = 1;</code>
   */
  public java.lang.String getBic() {
    java.lang.Object ref = bic_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      bic_ = s;
      return s;
    }
  }
  /**
   * <code>string bic = 1;</code>
   */
  public com.google.protobuf.ByteString
      getBicBytes() {
    java.lang.Object ref = bic_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      bic_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int IBAN_FIELD_NUMBER = 2;
  private volatile java.lang.Object iban_;
  /**
   * <code>string iban = 2;</code>
   */
  public java.lang.String getIban() {
    java.lang.Object ref = iban_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      iban_ = s;
      return s;
    }
  }
  /**
   * <code>string iban = 2;</code>
   */
  public com.google.protobuf.ByteString
      getIbanBytes() {
    java.lang.Object ref = iban_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      iban_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PAYEE_FIELD_NUMBER = 3;
  private volatile java.lang.Object payee_;
  /**
   * <code>string payee = 3;</code>
   */
  public java.lang.String getPayee() {
    java.lang.Object ref = payee_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      payee_ = s;
      return s;
    }
  }
  /**
   * <code>string payee = 3;</code>
   */
  public com.google.protobuf.ByteString
      getPayeeBytes() {
    java.lang.Object ref = payee_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      payee_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  private volatile java.lang.Object description_;
  /**
   * <code>string description = 4;</code>
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>string description = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AMOUNT_FIELD_NUMBER = 5;
  private double amount_;
  /**
   * <code>double amount = 5;</code>
   */
  public double getAmount() {
    return amount_;
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
    if (!getBicBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, bic_);
    }
    if (!getIbanBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, iban_);
    }
    if (!getPayeeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, payee_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, description_);
    }
    if (amount_ != 0D) {
      output.writeDouble(5, amount_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getBicBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, bic_);
    }
    if (!getIbanBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, iban_);
    }
    if (!getPayeeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, payee_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, description_);
    }
    if (amount_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, amount_);
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
    if (!(obj instanceof com.ebanking.testsystem.BillPayment)) {
      return super.equals(obj);
    }
    com.ebanking.testsystem.BillPayment other = (com.ebanking.testsystem.BillPayment) obj;

    boolean result = true;
    result = result && getBic()
        .equals(other.getBic());
    result = result && getIban()
        .equals(other.getIban());
    result = result && getPayee()
        .equals(other.getPayee());
    result = result && getDescription()
        .equals(other.getDescription());
    result = result && (
        java.lang.Double.doubleToLongBits(getAmount())
        == java.lang.Double.doubleToLongBits(
            other.getAmount()));
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
    hash = (37 * hash) + BIC_FIELD_NUMBER;
    hash = (53 * hash) + getBic().hashCode();
    hash = (37 * hash) + IBAN_FIELD_NUMBER;
    hash = (53 * hash) + getIban().hashCode();
    hash = (37 * hash) + PAYEE_FIELD_NUMBER;
    hash = (53 * hash) + getPayee().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getAmount()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ebanking.testsystem.BillPayment parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ebanking.testsystem.BillPayment parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ebanking.testsystem.BillPayment parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ebanking.testsystem.BillPayment parseFrom(
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
  public static Builder newBuilder(com.ebanking.testsystem.BillPayment prototype) {
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
   * Protobuf type {@code testsystem.BillPayment}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:testsystem.BillPayment)
      com.ebanking.testsystem.BillPaymentOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ebanking.testsystem.PaymentSystemImpl.internal_static_testsystem_BillPayment_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ebanking.testsystem.PaymentSystemImpl.internal_static_testsystem_BillPayment_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ebanking.testsystem.BillPayment.class, com.ebanking.testsystem.BillPayment.Builder.class);
    }

    // Construct using com.ebanking.testsystem.BillPayment.newBuilder()
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
      bic_ = "";

      iban_ = "";

      payee_ = "";

      description_ = "";

      amount_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ebanking.testsystem.PaymentSystemImpl.internal_static_testsystem_BillPayment_descriptor;
    }

    @java.lang.Override
    public com.ebanking.testsystem.BillPayment getDefaultInstanceForType() {
      return com.ebanking.testsystem.BillPayment.getDefaultInstance();
    }

    @java.lang.Override
    public com.ebanking.testsystem.BillPayment build() {
      com.ebanking.testsystem.BillPayment result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ebanking.testsystem.BillPayment buildPartial() {
      com.ebanking.testsystem.BillPayment result = new com.ebanking.testsystem.BillPayment(this);
      result.bic_ = bic_;
      result.iban_ = iban_;
      result.payee_ = payee_;
      result.description_ = description_;
      result.amount_ = amount_;
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
      if (other instanceof com.ebanking.testsystem.BillPayment) {
        return mergeFrom((com.ebanking.testsystem.BillPayment)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ebanking.testsystem.BillPayment other) {
      if (other == com.ebanking.testsystem.BillPayment.getDefaultInstance()) return this;
      if (!other.getBic().isEmpty()) {
        bic_ = other.bic_;
        onChanged();
      }
      if (!other.getIban().isEmpty()) {
        iban_ = other.iban_;
        onChanged();
      }
      if (!other.getPayee().isEmpty()) {
        payee_ = other.payee_;
        onChanged();
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      if (other.getAmount() != 0D) {
        setAmount(other.getAmount());
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
      com.ebanking.testsystem.BillPayment parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ebanking.testsystem.BillPayment) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object bic_ = "";
    /**
     * <code>string bic = 1;</code>
     */
    public java.lang.String getBic() {
      java.lang.Object ref = bic_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        bic_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string bic = 1;</code>
     */
    public com.google.protobuf.ByteString
        getBicBytes() {
      java.lang.Object ref = bic_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        bic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string bic = 1;</code>
     */
    public Builder setBic(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      bic_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string bic = 1;</code>
     */
    public Builder clearBic() {
      
      bic_ = getDefaultInstance().getBic();
      onChanged();
      return this;
    }
    /**
     * <code>string bic = 1;</code>
     */
    public Builder setBicBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      bic_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object iban_ = "";
    /**
     * <code>string iban = 2;</code>
     */
    public java.lang.String getIban() {
      java.lang.Object ref = iban_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        iban_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string iban = 2;</code>
     */
    public com.google.protobuf.ByteString
        getIbanBytes() {
      java.lang.Object ref = iban_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        iban_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string iban = 2;</code>
     */
    public Builder setIban(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      iban_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string iban = 2;</code>
     */
    public Builder clearIban() {
      
      iban_ = getDefaultInstance().getIban();
      onChanged();
      return this;
    }
    /**
     * <code>string iban = 2;</code>
     */
    public Builder setIbanBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      iban_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object payee_ = "";
    /**
     * <code>string payee = 3;</code>
     */
    public java.lang.String getPayee() {
      java.lang.Object ref = payee_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        payee_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string payee = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPayeeBytes() {
      java.lang.Object ref = payee_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        payee_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string payee = 3;</code>
     */
    public Builder setPayee(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      payee_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string payee = 3;</code>
     */
    public Builder clearPayee() {
      
      payee_ = getDefaultInstance().getPayee();
      onChanged();
      return this;
    }
    /**
     * <code>string payee = 3;</code>
     */
    public Builder setPayeeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      payee_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <code>string description = 4;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string description = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string description = 4;</code>
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      description_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string description = 4;</code>
     */
    public Builder clearDescription() {
      
      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     * <code>string description = 4;</code>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      description_ = value;
      onChanged();
      return this;
    }

    private double amount_ ;
    /**
     * <code>double amount = 5;</code>
     */
    public double getAmount() {
      return amount_;
    }
    /**
     * <code>double amount = 5;</code>
     */
    public Builder setAmount(double value) {
      
      amount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double amount = 5;</code>
     */
    public Builder clearAmount() {
      
      amount_ = 0D;
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


    // @@protoc_insertion_point(builder_scope:testsystem.BillPayment)
  }

  // @@protoc_insertion_point(class_scope:testsystem.BillPayment)
  private static final com.ebanking.testsystem.BillPayment DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ebanking.testsystem.BillPayment();
  }

  public static com.ebanking.testsystem.BillPayment getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BillPayment>
      PARSER = new com.google.protobuf.AbstractParser<BillPayment>() {
    @java.lang.Override
    public BillPayment parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BillPayment(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BillPayment> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BillPayment> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ebanking.testsystem.BillPayment getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

