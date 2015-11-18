/**
 * ResponseUsuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.sivale.com.mx.messages.response.sivalemx;

public class ResponseUsuario  extends ws.sivale.com.mx.messages.response.sivalemx.ResponseBase  implements java.io.Serializable {
    private java.lang.String nombre;

    private java.lang.String apellidoPaterno;

    private java.lang.String apellidoMaterno;

    private java.lang.String correoElectronico;

    private java.lang.String preguntaSecreta;

    private ws.sivale.com.mx.messages.response.ResponseEstadisticas estadisticas;

    public ResponseUsuario() {
    }

    public ResponseUsuario(
           ws.sivale.com.mx.messages.response.ResponseError responseError,
           java.lang.String nombre,
           java.lang.String apellidoPaterno,
           java.lang.String apellidoMaterno,
           java.lang.String correoElectronico,
           java.lang.String preguntaSecreta,
           ws.sivale.com.mx.messages.response.ResponseEstadisticas estadisticas) {
        super(
            responseError);
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.preguntaSecreta = preguntaSecreta;
        this.estadisticas = estadisticas;
    }


    /**
     * Gets the nombre value for this ResponseUsuario.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this ResponseUsuario.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the apellidoPaterno value for this ResponseUsuario.
     * 
     * @return apellidoPaterno
     */
    public java.lang.String getApellidoPaterno() {
        return apellidoPaterno;
    }


    /**
     * Sets the apellidoPaterno value for this ResponseUsuario.
     * 
     * @param apellidoPaterno
     */
    public void setApellidoPaterno(java.lang.String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }


    /**
     * Gets the apellidoMaterno value for this ResponseUsuario.
     * 
     * @return apellidoMaterno
     */
    public java.lang.String getApellidoMaterno() {
        return apellidoMaterno;
    }


    /**
     * Sets the apellidoMaterno value for this ResponseUsuario.
     * 
     * @param apellidoMaterno
     */
    public void setApellidoMaterno(java.lang.String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }


    /**
     * Gets the correoElectronico value for this ResponseUsuario.
     * 
     * @return correoElectronico
     */
    public java.lang.String getCorreoElectronico() {
        return correoElectronico;
    }


    /**
     * Sets the correoElectronico value for this ResponseUsuario.
     * 
     * @param correoElectronico
     */
    public void setCorreoElectronico(java.lang.String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


    /**
     * Gets the preguntaSecreta value for this ResponseUsuario.
     * 
     * @return preguntaSecreta
     */
    public java.lang.String getPreguntaSecreta() {
        return preguntaSecreta;
    }


    /**
     * Sets the preguntaSecreta value for this ResponseUsuario.
     * 
     * @param preguntaSecreta
     */
    public void setPreguntaSecreta(java.lang.String preguntaSecreta) {
        this.preguntaSecreta = preguntaSecreta;
    }


    /**
     * Gets the estadisticas value for this ResponseUsuario.
     * 
     * @return estadisticas
     */
    public ws.sivale.com.mx.messages.response.ResponseEstadisticas getEstadisticas() {
        return estadisticas;
    }


    /**
     * Sets the estadisticas value for this ResponseUsuario.
     * 
     * @param estadisticas
     */
    public void setEstadisticas(ws.sivale.com.mx.messages.response.ResponseEstadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseUsuario)) return false;
        ResponseUsuario other = (ResponseUsuario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.apellidoPaterno==null && other.getApellidoPaterno()==null) || 
             (this.apellidoPaterno!=null &&
              this.apellidoPaterno.equals(other.getApellidoPaterno()))) &&
            ((this.apellidoMaterno==null && other.getApellidoMaterno()==null) || 
             (this.apellidoMaterno!=null &&
              this.apellidoMaterno.equals(other.getApellidoMaterno()))) &&
            ((this.correoElectronico==null && other.getCorreoElectronico()==null) || 
             (this.correoElectronico!=null &&
              this.correoElectronico.equals(other.getCorreoElectronico()))) &&
            ((this.preguntaSecreta==null && other.getPreguntaSecreta()==null) || 
             (this.preguntaSecreta!=null &&
              this.preguntaSecreta.equals(other.getPreguntaSecreta()))) &&
            ((this.estadisticas==null && other.getEstadisticas()==null) || 
             (this.estadisticas!=null &&
              this.estadisticas.equals(other.getEstadisticas())));
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
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getApellidoPaterno() != null) {
            _hashCode += getApellidoPaterno().hashCode();
        }
        if (getApellidoMaterno() != null) {
            _hashCode += getApellidoMaterno().hashCode();
        }
        if (getCorreoElectronico() != null) {
            _hashCode += getCorreoElectronico().hashCode();
        }
        if (getPreguntaSecreta() != null) {
            _hashCode += getPreguntaSecreta().hashCode();
        }
        if (getEstadisticas() != null) {
            _hashCode += getEstadisticas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseUsuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/sivalemx", "ResponseUsuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellidoPaterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellidoPaterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellidoMaterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellidoMaterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoElectronico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correoElectronico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preguntaSecreta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preguntaSecreta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadisticas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estadisticas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response", "ResponseEstadisticas"));
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
