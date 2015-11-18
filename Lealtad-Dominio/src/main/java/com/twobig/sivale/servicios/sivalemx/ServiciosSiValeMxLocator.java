/**
 * ServiciosSiValeMxLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.twobig.sivale.servicios.sivalemx;

import com.twobig.sivale.servicios.SivaleServices;

public class ServiciosSiValeMxLocator extends org.apache.axis.client.Service implements com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMx {

    public ServiciosSiValeMxLocator() {
    }


    public ServiciosSiValeMxLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiciosSiValeMxLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiciosSiValeMxTypePort
    private java.lang.String ServiciosSiValeMxTypePort_address = SivaleServices.getServiciosSiValeMxAddress();

    public java.lang.String getServiciosSiValeMxTypePortAddress() {
        return ServiciosSiValeMxTypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiciosSiValeMxTypePortWSDDServiceName = "ServiciosSiValeMxTypePort";

    public java.lang.String getServiciosSiValeMxTypePortWSDDServiceName() {
        return ServiciosSiValeMxTypePortWSDDServiceName;
    }

    public void setServiciosSiValeMxTypePortWSDDServiceName(java.lang.String name) {
        ServiciosSiValeMxTypePortWSDDServiceName = name;
    }

    public com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxType getServiciosSiValeMxTypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiciosSiValeMxTypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiciosSiValeMxTypePort(endpoint);
    }

    public com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxType getServiciosSiValeMxTypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxTypePortBindingStub _stub = new com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxTypePortBindingStub(portAddress, this);
            _stub.setPortName(getServiciosSiValeMxTypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiciosSiValeMxTypePortEndpointAddress(java.lang.String address) {
        ServiciosSiValeMxTypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxTypePortBindingStub _stub = new com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxTypePortBindingStub(new java.net.URL(ServiciosSiValeMxTypePort_address), this);
                _stub.setPortName(getServiciosSiValeMxTypePortWSDDServiceName());
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
        if ("ServiciosSiValeMxTypePort".equals(inputPortName)) {
            return getServiciosSiValeMxTypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/sivalemx", "ServiciosSiValeMx");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/sivalemx", "ServiciosSiValeMxTypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiciosSiValeMxTypePort".equals(portName)) {
            setServiciosSiValeMxTypePortEndpointAddress(address);
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
