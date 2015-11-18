/**
 * RequestMovimientos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.sivale.com.mx.messages.request.tarjeta;

public class RequestMovimientos  extends ws.sivale.com.mx.messages.request.tarjeta.RequestBase  implements java.io.Serializable {
    private java.lang.String saldo;

    private java.lang.Integer cargos;

    private java.lang.Integer abonos;

    public RequestMovimientos() {
    }

    public RequestMovimientos(
           java.lang.String tarjeta,
           java.lang.String saldo,
           java.lang.Integer cargos,
           java.lang.Integer abonos) {
        super(
            tarjeta);
        this.saldo = saldo;
        this.cargos = cargos;
        this.abonos = abonos;
    }


    /**
     * Gets the saldo value for this RequestMovimientos.
     * 
     * @return saldo
     */
    public java.lang.String getSaldo() {
        return saldo;
    }


    /**
     * Sets the saldo value for this RequestMovimientos.
     * 
     * @param saldo
     */
    public void setSaldo(java.lang.String saldo) {
        this.saldo = saldo;
    }


    /**
     * Gets the cargos value for this RequestMovimientos.
     * 
     * @return cargos
     */
    public java.lang.Integer getCargos() {
        return cargos;
    }


    /**
     * Sets the cargos value for this RequestMovimientos.
     * 
     * @param cargos
     */
    public void setCargos(java.lang.Integer cargos) {
        this.cargos = cargos;
    }


    /**
     * Gets the abonos value for this RequestMovimientos.
     * 
     * @return abonos
     */
    public java.lang.Integer getAbonos() {
        return abonos;
    }


    /**
     * Sets the abonos value for this RequestMovimientos.
     * 
     * @param abonos
     */
    public void setAbonos(java.lang.Integer abonos) {
        this.abonos = abonos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestMovimientos)) return false;
        RequestMovimientos other = (RequestMovimientos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.saldo==null && other.getSaldo()==null) || 
             (this.saldo!=null &&
              this.saldo.equals(other.getSaldo()))) &&
            ((this.cargos==null && other.getCargos()==null) || 
             (this.cargos!=null &&
              this.cargos.equals(other.getCargos()))) &&
            ((this.abonos==null && other.getAbonos()==null) || 
             (this.abonos!=null &&
              this.abonos.equals(other.getAbonos())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getSaldo() != null) {
            _hashCode += getSaldo().hashCode();
        }
        if (getCargos() != null) {
            _hashCode += getCargos().hashCode();
        }
        if (getAbonos() != null) {
            _hashCode += getAbonos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestMovimientos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestMovimientos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cargos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abonos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "abonos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
