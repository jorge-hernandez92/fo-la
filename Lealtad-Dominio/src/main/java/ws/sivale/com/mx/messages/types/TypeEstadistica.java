/**
 * TypeEstadistica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.sivale.com.mx.messages.types;

public class TypeEstadistica  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.lang.String peticion;

    private java.lang.String respuesta;

    private java.lang.String proceso;

    private ws.sivale.com.mx.messages.types.TypeEstadistica verificarAutorizador;

    private ws.sivale.com.mx.messages.types.TypeEstadistica tierService;

    private ws.sivale.com.mx.messages.types.TypeEstadistica beanService;

    private ws.sivale.com.mx.messages.types.TypeEstadistica[] actividades;

    public TypeEstadistica() {
    }

    public TypeEstadistica(
           java.lang.String descripcion,
           java.lang.String peticion,
           java.lang.String respuesta,
           java.lang.String proceso,
           ws.sivale.com.mx.messages.types.TypeEstadistica verificarAutorizador,
           ws.sivale.com.mx.messages.types.TypeEstadistica tierService,
           ws.sivale.com.mx.messages.types.TypeEstadistica beanService,
           ws.sivale.com.mx.messages.types.TypeEstadistica[] actividades) {
           this.descripcion = descripcion;
           this.peticion = peticion;
           this.respuesta = respuesta;
           this.proceso = proceso;
           this.verificarAutorizador = verificarAutorizador;
           this.tierService = tierService;
           this.beanService = beanService;
           this.actividades = actividades;
    }


    /**
     * Gets the descripcion value for this TypeEstadistica.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this TypeEstadistica.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the peticion value for this TypeEstadistica.
     * 
     * @return peticion
     */
    public java.lang.String getPeticion() {
        return peticion;
    }


    /**
     * Sets the peticion value for this TypeEstadistica.
     * 
     * @param peticion
     */
    public void setPeticion(java.lang.String peticion) {
        this.peticion = peticion;
    }


    /**
     * Gets the respuesta value for this TypeEstadistica.
     * 
     * @return respuesta
     */
    public java.lang.String getRespuesta() {
        return respuesta;
    }


    /**
     * Sets the respuesta value for this TypeEstadistica.
     * 
     * @param respuesta
     */
    public void setRespuesta(java.lang.String respuesta) {
        this.respuesta = respuesta;
    }


    /**
     * Gets the proceso value for this TypeEstadistica.
     * 
     * @return proceso
     */
    public java.lang.String getProceso() {
        return proceso;
    }


    /**
     * Sets the proceso value for this TypeEstadistica.
     * 
     * @param proceso
     */
    public void setProceso(java.lang.String proceso) {
        this.proceso = proceso;
    }


    /**
     * Gets the verificarAutorizador value for this TypeEstadistica.
     * 
     * @return verificarAutorizador
     */
    public ws.sivale.com.mx.messages.types.TypeEstadistica getVerificarAutorizador() {
        return verificarAutorizador;
    }


    /**
     * Sets the verificarAutorizador value for this TypeEstadistica.
     * 
     * @param verificarAutorizador
     */
    public void setVerificarAutorizador(ws.sivale.com.mx.messages.types.TypeEstadistica verificarAutorizador) {
        this.verificarAutorizador = verificarAutorizador;
    }


    /**
     * Gets the tierService value for this TypeEstadistica.
     * 
     * @return tierService
     */
    public ws.sivale.com.mx.messages.types.TypeEstadistica getTierService() {
        return tierService;
    }


    /**
     * Sets the tierService value for this TypeEstadistica.
     * 
     * @param tierService
     */
    public void setTierService(ws.sivale.com.mx.messages.types.TypeEstadistica tierService) {
        this.tierService = tierService;
    }


    /**
     * Gets the beanService value for this TypeEstadistica.
     * 
     * @return beanService
     */
    public ws.sivale.com.mx.messages.types.TypeEstadistica getBeanService() {
        return beanService;
    }


    /**
     * Sets the beanService value for this TypeEstadistica.
     * 
     * @param beanService
     */
    public void setBeanService(ws.sivale.com.mx.messages.types.TypeEstadistica beanService) {
        this.beanService = beanService;
    }


    /**
     * Gets the actividades value for this TypeEstadistica.
     * 
     * @return actividades
     */
    public ws.sivale.com.mx.messages.types.TypeEstadistica[] getActividades() {
        return actividades;
    }


    /**
     * Sets the actividades value for this TypeEstadistica.
     * 
     * @param actividades
     */
    public void setActividades(ws.sivale.com.mx.messages.types.TypeEstadistica[] actividades) {
        this.actividades = actividades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TypeEstadistica)) return false;
        TypeEstadistica other = (TypeEstadistica) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.peticion==null && other.getPeticion()==null) || 
             (this.peticion!=null &&
              this.peticion.equals(other.getPeticion()))) &&
            ((this.respuesta==null && other.getRespuesta()==null) || 
             (this.respuesta!=null &&
              this.respuesta.equals(other.getRespuesta()))) &&
            ((this.proceso==null && other.getProceso()==null) || 
             (this.proceso!=null &&
              this.proceso.equals(other.getProceso()))) &&
            ((this.verificarAutorizador==null && other.getVerificarAutorizador()==null) || 
             (this.verificarAutorizador!=null &&
              this.verificarAutorizador.equals(other.getVerificarAutorizador()))) &&
            ((this.tierService==null && other.getTierService()==null) || 
             (this.tierService!=null &&
              this.tierService.equals(other.getTierService()))) &&
            ((this.beanService==null && other.getBeanService()==null) || 
             (this.beanService!=null &&
              this.beanService.equals(other.getBeanService()))) &&
            ((this.actividades==null && other.getActividades()==null) || 
             (this.actividades!=null &&
              java.util.Arrays.equals(this.actividades, other.getActividades())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getPeticion() != null) {
            _hashCode += getPeticion().hashCode();
        }
        if (getRespuesta() != null) {
            _hashCode += getRespuesta().hashCode();
        }
        if (getProceso() != null) {
            _hashCode += getProceso().hashCode();
        }
        if (getVerificarAutorizador() != null) {
            _hashCode += getVerificarAutorizador().hashCode();
        }
        if (getTierService() != null) {
            _hashCode += getTierService().hashCode();
        }
        if (getBeanService() != null) {
            _hashCode += getBeanService().hashCode();
        }
        if (getActividades() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getActividades());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getActividades(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TypeEstadistica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peticion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peticion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proceso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proceso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verificarAutorizador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "verificarAutorizador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tierService");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tierService"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beanService");
        elemField.setXmlName(new javax.xml.namespace.QName("", "beanService"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actividades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "actividad"));
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
