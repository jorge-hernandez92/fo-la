/**
 * ServiciosTarjetaTypePortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.twobig.sivale.servicios.tarjeta;

public class ServiciosTarjetaTypePortBindingStub extends org.apache.axis.client.Stub implements com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarSaldo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "consultarSaldoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestBase"), ws.sivale.com.mx.messages.request.tarjeta.RequestBase.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseSaldo"));
        oper.setReturnClass(ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "consultarSaldoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarMovimientos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "consultarMovimientosRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestMovimientos"), ws.sivale.com.mx.messages.request.tarjeta.RequestMovimientos.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseSaldo"));
        oper.setReturnClass(ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "consultarMovimientosResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarEstado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "consultarEstadoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestBase"), ws.sivale.com.mx.messages.request.tarjeta.RequestBase.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseEstado"));
        oper.setReturnClass(ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "consultarEstadoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cambiarEstado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "cambiarEstadoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestEstado"), ws.sivale.com.mx.messages.request.tarjeta.RequestEstado.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseEstado"));
        oper.setReturnClass(ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "cambiarEstadoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bloquearTemporal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "bloquearTemporalRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestBase"), ws.sivale.com.mx.messages.request.tarjeta.RequestBase.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseEstado"));
        oper.setReturnClass(ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "bloquearTemporalResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("desbloquearTemporal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "desbloquearTemporalRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestBase"), ws.sivale.com.mx.messages.request.tarjeta.RequestBase.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseEstado"));
        oper.setReturnClass(ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mx.com.sivale.ws/exposition/servicios/tarjeta", "desbloquearTemporalResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

    }

    public ServiciosTarjetaTypePortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ServiciosTarjetaTypePortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ServiciosTarjetaTypePortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestBase");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.request.tarjeta.RequestBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestEstado");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.request.tarjeta.RequestEstado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/request/tarjeta", "RequestMovimientos");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.request.tarjeta.RequestMovimientos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", ">ResponseSaldo>transacciones");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.types.TypeTransaccion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeTransaccion");
            qName2 = new javax.xml.namespace.QName("", "transaccion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseBase");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.response.tarjeta.ResponseBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseEstado");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response/tarjeta", "ResponseSaldo");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response", "ResponseError");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.response.ResponseError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/response", "ResponseEstadisticas");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.response.ResponseEstadisticas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", ">TypeEstadistica>actividades");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.types.TypeEstadistica[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica");
            qName2 = new javax.xml.namespace.QName("", "actividad");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeEstadistica");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.types.TypeEstadistica.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mx.com.sivale.ws/messages/types", "TypeTransaccion");
            cachedSerQNames.add(qName);
            cls = ws.sivale.com.mx.messages.types.TypeTransaccion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo consultarSaldo(ws.sivale.com.mx.messages.request.tarjeta.RequestBase consultarSaldoRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:consultarSaldo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarSaldo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {consultarSaldoRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo) _resp;
            } catch (java.lang.Exception _exception) {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo) org.apache.axis.utils.JavaUtils.convert(_resp, ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo consultarMovimientos(ws.sivale.com.mx.messages.request.tarjeta.RequestMovimientos consultarMovimientosRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:consultarMovimientos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarMovimientos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {consultarMovimientosRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo) _resp;
            } catch (java.lang.Exception _exception) {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo) org.apache.axis.utils.JavaUtils.convert(_resp, ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado consultarEstado(ws.sivale.com.mx.messages.request.tarjeta.RequestBase consultarEstadoRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:consultarEstado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarEstado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {consultarEstadoRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) org.apache.axis.utils.JavaUtils.convert(_resp, ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado cambiarEstado(ws.sivale.com.mx.messages.request.tarjeta.RequestEstado cambiarEstadoRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:cambiarEstado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "cambiarEstado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cambiarEstadoRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) org.apache.axis.utils.JavaUtils.convert(_resp, ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado bloquearTemporal(ws.sivale.com.mx.messages.request.tarjeta.RequestBase bloquearTemporalRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:bloquearTemporal");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "bloquearTemporal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {bloquearTemporalRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) org.apache.axis.utils.JavaUtils.convert(_resp, ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado desbloquearTemporal(ws.sivale.com.mx.messages.request.tarjeta.RequestBase desbloquearTemporalRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:desbloquearTemporal");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "desbloquearTemporal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {desbloquearTemporalRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) _resp;
            } catch (java.lang.Exception _exception) {
                return (ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado) org.apache.axis.utils.JavaUtils.convert(_resp, ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
