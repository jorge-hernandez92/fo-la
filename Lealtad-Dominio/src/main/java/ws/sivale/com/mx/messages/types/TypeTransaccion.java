/**
 * TypeTransaccion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.sivale.com.mx.messages.types;

public class TypeTransaccion  implements java.io.Serializable {
    private java.lang.String authorizationNumber;

    private java.lang.String numberCard;

    private java.lang.String transactionDate;

    private java.lang.Double amount;

    private java.lang.String acceptorName;

    private java.lang.Integer messageType;

    private java.lang.Double responseCode;

    private java.lang.String transactionType;

    private java.lang.String transactionOrder;

    public TypeTransaccion() {
    }

    public TypeTransaccion(
           java.lang.String authorizationNumber,
           java.lang.String numberCard,
           java.lang.String transactionDate,
           java.lang.Double amount,
           java.lang.String acceptorName,
           java.lang.Integer messageType,
           java.lang.Double responseCode,
           java.lang.String transactionType,
           java.lang.String transactionOrder) {
           this.authorizationNumber = authorizationNumber;
           this.numberCard = numberCard;
           this.transactionDate = transactionDate;
           this.amount = amount;
           this.acceptorName = acceptorName;
           this.messageType = messageType;
           this.responseCode = responseCode;
           this.transactionType = transactionType;
           this.transactionOrder = transactionOrder;
    }


    /**
     * Gets the authorizationNumber value for this TypeTransaccion.
     * 
     * @return authorizationNumber
     */
    public java.lang.String getAuthorizationNumber() {
        return authorizationNumber;
    }


    /**
     * Sets the authorizationNumber value for this TypeTransaccion.
     * 
     * @param authorizationNumber
     */
    public void setAuthorizationNumber(java.lang.String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }


    /**
     * Gets the numberCard value for this TypeTransaccion.
     * 
     * @return numberCard
     */
    public java.lang.String getNumberCard() {
        return numberCard;
    }


    /**
     * Sets the numberCard value for this TypeTransaccion.
     * 
     * @param numberCard
     */
    public void setNumberCard(java.lang.String numberCard) {
        this.numberCard = numberCard;
    }


    /**
     * Gets the transactionDate value for this TypeTransaccion.
     * 
     * @return transactionDate
     */
    public java.lang.String getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this TypeTransaccion.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(java.lang.String transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the amount value for this TypeTransaccion.
     * 
     * @return amount
     */
    public java.lang.Double getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this TypeTransaccion.
     * 
     * @param amount
     */
    public void setAmount(java.lang.Double amount) {
        this.amount = amount;
    }


    /**
     * Gets the acceptorName value for this TypeTransaccion.
     * 
     * @return acceptorName
     */
    public java.lang.String getAcceptorName() {
        return acceptorName;
    }


    /**
     * Sets the acceptorName value for this TypeTransaccion.
     * 
     * @param acceptorName
     */
    public void setAcceptorName(java.lang.String acceptorName) {
        this.acceptorName = acceptorName;
    }


    /**
     * Gets the messageType value for this TypeTransaccion.
     * 
     * @return messageType
     */
    public java.lang.Integer getMessageType() {
        return messageType;
    }


    /**
     * Sets the messageType value for this TypeTransaccion.
     * 
     * @param messageType
     */
    public void setMessageType(java.lang.Integer messageType) {
        this.messageType = messageType;
    }


    /**
     * Gets the responseCode value for this TypeTransaccion.
     * 
     * @return responseCode
     */
    public java.lang.Double getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this TypeTransaccion.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.Double responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the transactionType value for this TypeTransaccion.
     * 
     * @return transactionType
     */
    public java.lang.String getTransactionType() {
        return transactionType;
    }


    /**
     * Sets the transactionType value for this TypeTransaccion.
     * 
     * @param transactionType
     */
    public void setTransactionType(java.lang.String transactionType) {
        this.transactionType = transactionType;
    }


    /**
     * Gets the transactionOrder value for this TypeTransaccion.
     * 
     * @return transactionOrder
     */
    public java.lang.String getTransactionOrder() {
        return transactionOrder;
    }


    /**
     * Sets the transactionOrder value for this TypeTransaccion.
     * 
     * @param transactionOrder
     */
    public void setTransactionOrder(java.lang.String transactionOrder) {
        this.transactionOrder = transactionOrder;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TypeTransaccion)) return false;
        TypeTransaccion other = (TypeTransaccion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authorizationNumber==null && other.getAuthorizationNumber()==null) || 
             (this.authorizationNumber!=null &&
              this.authorizationNumber.equals(other.getAuthorizationNumber()))) &&
            ((this.numberCard==null && other.getNumberCard()==null) || 
             (this.numberCard!=null &&
              this.numberCard.equals(other.getNumberCard()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.acceptorName==null && other.getAcceptorName()==null) || 
             (this.acceptorName!=null &&
              this.acceptorName.equals(other.getAcceptorName()))) &&
            ((this.messageType==null && other.getMessageType()==null) || 
             (this.messageType!=null &&
              this.messageType.equals(other.getMessageType()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.transactionType==null && other.getTransactionType()==null) || 
             (this.transactionType!=null &&
              this.transactionType.equals(other.getTransactionType()))) &&
            ((this.transactionOrder==null && other.getTransactionOrder()==null) || 
             (this.transactionOrder!=null &&
              this.transactionOrder.equals(other.getTransactionOrder())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAuthorizationNumber() != null) {
            _hashCode += getAuthorizationNumber().hashCode();
        }
        if (getNumberCard() != null) {
            _hashCode += getNumberCard().hashCode();
        }
        if (getTransactionDate() != null) {
            _hashCode += getTransactionDate().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getAcceptorName() != null) {
            _hashCode += getAcceptorName().hashCode();
        }
        if (getMessageType() != null) {
            _hashCode += getMessageType().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getTransactionType() != null) {
            _hashCode += getTransactionType().hashCode();
        }
        if (getTransactionOrder() != null) {
            _hashCode += getTransactionOrder().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TypeTransaccion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeTransaccion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorizationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberCard");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acceptorName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acceptorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
