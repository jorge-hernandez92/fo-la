/**
 * ResponseEstadisticas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.sivale.com.mx.messages.response;

public class ResponseEstadisticas  implements java.io.Serializable {
    private ws.sivale.com.mx.messages.types.TypeEstadistica interceptor;

    private ws.sivale.com.mx.messages.types.TypeEstadistica tierExposition;

    public ResponseEstadisticas() {
    }

    public ResponseEstadisticas(
           ws.sivale.com.mx.messages.types.TypeEstadistica interceptor,
           ws.sivale.com.mx.messages.types.TypeEstadistica tierExposition) {
           this.interceptor = interceptor;
           this.tierExposition = tierExposition;
    }


    /**
     * Gets the interceptor value for this ResponseEstadisticas.
     * 
     * @return interceptor
     */
    public ws.sivale.com.mx.messages.types.TypeEstadistica getInterceptor() {
        return interceptor;
    }


    /**
     * Sets the interceptor value for this ResponseEstadisticas.
     * 
     * @param interceptor
     */
    public void setInterceptor(ws.sivale.com.mx.messages.types.TypeEstadistica interceptor) {
        this.interceptor = interceptor;
    }


    /**
     * Gets the tierExposition value for this ResponseEstadisticas.
     * 
     * @return tierExposition
     */
    public ws.sivale.com.mx.messages.types.TypeEstadistica getTierExposition() {
        return tierExposition;
    }


    /**
     * Sets the tierExposition value for this ResponseEstadisticas.
     * 
     * @param tierExposition
     */
    public void setTierExposition(ws.sivale.com.mx.messages.types.TypeEstadistica tierExposition) {
        this.tierExposition = tierExposition;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseEstadisticas)) return false;
        ResponseEstadisticas other = (ResponseEstadisticas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interceptor==null && other.getInterceptor()==null) || 
             (this.interceptor!=null &&
              this.interceptor.equals(other.getInterceptor()))) &&
            ((this.tierExposition==null && other.getTierExposition()==null) || 
             (this.tierExposition!=null &&
              this.tierExposition.equals(other.getTierExposition())));
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
        if (getInterceptor() != null) {
            _hashCode += getInterceptor().hashCode();
        }
        if (getTierExposition() != null) {
            _hashCode += getTierExposition().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseEstadisticas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response", "ResponseEstadisticas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tierExposition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tierExposition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica"));
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
