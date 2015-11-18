/**
 * ServiciosTarjetaLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.twobig.sivale.servicios.tarjeta;

import com.twobig.sivale.servicios.SivaleServices;

public class ServiciosTarjetaLocator extends org.apache.axis.client.Service implements com.twobig.sivale.servicios.tarjeta.ServiciosTarjeta {

    public ServiciosTarjetaLocator() {
    }


    public ServiciosTarjetaLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiciosTarjetaLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiciosTarjetaTypePort
    private java.lang.String ServiciosTarjetaTypePort_address = SivaleServices.getServiciosTarjetaAddress();

    public java.lang.String getServiciosTarjetaTypePortAddress() {
        return ServiciosTarjetaTypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiciosTarjetaTypePortWSDDServiceName = "ServiciosTarjetaTypePort";

    public java.lang.String getServiciosTarjetaTypePortWSDDServiceName() {
        return ServiciosTarjetaTypePortWSDDServiceName;
    }

    public void setServiciosTarjetaTypePortWSDDServiceName(java.lang.String name) {
        ServiciosTarjetaTypePortWSDDServiceName = name;
    }

    public com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaType getServiciosTarjetaTypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiciosTarjetaTypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiciosTarjetaTypePort(endpoint);
    }

    public com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaType getServiciosTarjetaTypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaTypePortBindingStub _stub = new com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaTypePortBindingStub(portAddress, this);
            _stub.setPortName(getServiciosTarjetaTypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiciosTarjetaTypePortEndpointAddress(java.lang.String address) {
        ServiciosTarjetaTypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaTypePortBindingStub _stub = new com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaTypePortBindingStub(new java.net.URL(ServiciosTarjetaTypePort_address), this);
                _stub.setPortName(getServiciosTarjetaTypePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServiciosTarjetaTypePort".equals(inputPortName)) {
            return getServiciosTarjetaTypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "ServiciosTarjeta");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "ServiciosTarjetaTypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiciosTarjetaTypePort".equals(portName)) {
            setServiciosTarjetaTypePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
