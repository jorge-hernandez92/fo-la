/**
 * ResponseBase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.sivale.com.mx.messages.response.sivalemx;

public class ResponseBase  implements java.io.Serializable {
    private ws.sivale.com.mx.messages.response.ResponseError responseError;

    public ResponseBase() {
    }

    public ResponseBase(
           ws.sivale.com.mx.messages.response.ResponseError responseError) {
           this.responseError = responseError;
    }


    /**
     * Gets the responseError value for this ResponseBase.
     * 
     * @return responseError
     */
    public ws.sivale.com.mx.messages.response.ResponseError getResponseError() {
        return responseError;
    }


    /**
     * Sets the responseError value for this ResponseBase.
     * 
     * @param responseError
     */
    public void setResponseError(ws.sivale.com.mx.messages.response.ResponseError responseError) {
        this.responseError = responseError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseBase)) return false;
        ResponseBase other = (ResponseBase) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.responseError==null && other.getResponseError()==null) || 
             (this.responseError!=null &&
              this.responseError.equals(other.getResponseError())));
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
        if (getResponseError() != null) {
            _hashCode += getResponseError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseBase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/sivalemx", "ResponseBase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response", "ResponseError"));
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
