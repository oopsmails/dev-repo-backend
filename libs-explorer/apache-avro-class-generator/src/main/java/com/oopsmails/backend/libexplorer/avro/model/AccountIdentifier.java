/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.oopsmails.backend.libexplorer.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AccountIdentifier extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4848557295492551941L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AccountIdentifier\",\"namespace\":\"com.oopsmails.backend.libexplorer.avro.model\",\"fields\":[{\"name\":\"accountNumber\",\"type\":\"string\"},{\"name\":\"accountType\",\"type\":{\"type\":\"enum\",\"name\":\"AccountType\",\"symbols\":[\"SAVING\",\"CHECKING\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AccountIdentifier> ENCODER =
      new BinaryMessageEncoder<AccountIdentifier>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AccountIdentifier> DECODER =
      new BinaryMessageDecoder<AccountIdentifier>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AccountIdentifier> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AccountIdentifier> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AccountIdentifier> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AccountIdentifier>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AccountIdentifier to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AccountIdentifier from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AccountIdentifier instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AccountIdentifier fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence accountNumber;
   private com.oopsmails.backend.libexplorer.avro.model.AccountType accountType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AccountIdentifier() {}

  /**
   * All-args constructor.
   * @param accountNumber The new value for accountNumber
   * @param accountType The new value for accountType
   */
  public AccountIdentifier(java.lang.CharSequence accountNumber, com.oopsmails.backend.libexplorer.avro.model.AccountType accountType) {
    this.accountNumber = accountNumber;
    this.accountType = accountType;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return accountNumber;
    case 1: return accountType;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: accountNumber = (java.lang.CharSequence)value$; break;
    case 1: accountType = (com.oopsmails.backend.libexplorer.avro.model.AccountType)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'accountNumber' field.
   * @return The value of the 'accountNumber' field.
   */
  public java.lang.CharSequence getAccountNumber() {
    return accountNumber;
  }


  /**
   * Sets the value of the 'accountNumber' field.
   * @param value the value to set.
   */
  public void setAccountNumber(java.lang.CharSequence value) {
    this.accountNumber = value;
  }

  /**
   * Gets the value of the 'accountType' field.
   * @return The value of the 'accountType' field.
   */
  public com.oopsmails.backend.libexplorer.avro.model.AccountType getAccountType() {
    return accountType;
  }


  /**
   * Sets the value of the 'accountType' field.
   * @param value the value to set.
   */
  public void setAccountType(com.oopsmails.backend.libexplorer.avro.model.AccountType value) {
    this.accountType = value;
  }

  /**
   * Creates a new AccountIdentifier RecordBuilder.
   * @return A new AccountIdentifier RecordBuilder
   */
  public static com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder newBuilder() {
    return new com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder();
  }

  /**
   * Creates a new AccountIdentifier RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AccountIdentifier RecordBuilder
   */
  public static com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder newBuilder(com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder other) {
    if (other == null) {
      return new com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder();
    } else {
      return new com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder(other);
    }
  }

  /**
   * Creates a new AccountIdentifier RecordBuilder by copying an existing AccountIdentifier instance.
   * @param other The existing instance to copy.
   * @return A new AccountIdentifier RecordBuilder
   */
  public static com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder newBuilder(com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier other) {
    if (other == null) {
      return new com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder();
    } else {
      return new com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder(other);
    }
  }

  /**
   * RecordBuilder for AccountIdentifier instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AccountIdentifier>
    implements org.apache.avro.data.RecordBuilder<AccountIdentifier> {

    private java.lang.CharSequence accountNumber;
    private com.oopsmails.backend.libexplorer.avro.model.AccountType accountType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.accountNumber)) {
        this.accountNumber = data().deepCopy(fields()[0].schema(), other.accountNumber);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.accountType)) {
        this.accountType = data().deepCopy(fields()[1].schema(), other.accountType);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing AccountIdentifier instance
     * @param other The existing instance to copy.
     */
    private Builder(com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.accountNumber)) {
        this.accountNumber = data().deepCopy(fields()[0].schema(), other.accountNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accountType)) {
        this.accountType = data().deepCopy(fields()[1].schema(), other.accountType);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'accountNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getAccountNumber() {
      return accountNumber;
    }


    /**
      * Sets the value of the 'accountNumber' field.
      * @param value The value of 'accountNumber'.
      * @return This builder.
      */
    public com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder setAccountNumber(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.accountNumber = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'accountNumber' field has been set.
      * @return True if the 'accountNumber' field has been set, false otherwise.
      */
    public boolean hasAccountNumber() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'accountNumber' field.
      * @return This builder.
      */
    public com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder clearAccountNumber() {
      accountNumber = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountType' field.
      * @return The value.
      */
    public com.oopsmails.backend.libexplorer.avro.model.AccountType getAccountType() {
      return accountType;
    }


    /**
      * Sets the value of the 'accountType' field.
      * @param value The value of 'accountType'.
      * @return This builder.
      */
    public com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder setAccountType(com.oopsmails.backend.libexplorer.avro.model.AccountType value) {
      validate(fields()[1], value);
      this.accountType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'accountType' field has been set.
      * @return True if the 'accountType' field has been set, false otherwise.
      */
    public boolean hasAccountType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'accountType' field.
      * @return This builder.
      */
    public com.oopsmails.backend.libexplorer.avro.model.AccountIdentifier.Builder clearAccountType() {
      accountType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AccountIdentifier build() {
      try {
        AccountIdentifier record = new AccountIdentifier();
        record.accountNumber = fieldSetFlags()[0] ? this.accountNumber : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.accountType = fieldSetFlags()[1] ? this.accountType : (com.oopsmails.backend.libexplorer.avro.model.AccountType) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AccountIdentifier>
    WRITER$ = (org.apache.avro.io.DatumWriter<AccountIdentifier>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AccountIdentifier>
    READER$ = (org.apache.avro.io.DatumReader<AccountIdentifier>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.accountNumber);

    out.writeEnum(this.accountType.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.accountNumber = in.readString(this.accountNumber instanceof Utf8 ? (Utf8)this.accountNumber : null);

      this.accountType = com.oopsmails.backend.libexplorer.avro.model.AccountType.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.accountNumber = in.readString(this.accountNumber instanceof Utf8 ? (Utf8)this.accountNumber : null);
          break;

        case 1:
          this.accountType = com.oopsmails.backend.libexplorer.avro.model.AccountType.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









