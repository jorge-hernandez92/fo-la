/**
 * ServiciosSiValeMxType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.twobig.sivale.servicios.sivalemx;

public interface ServiciosSiValeMxType extends java.rmi.Remote {
    public ws.sivale.com.mx.messages.response.sivalemx.ResponseMensaje login(ws.sivale.com.mx.messages.request.sivalemx.RequestBase loginRequest) throws java.rmi.RemoteException;
    public ws.sivale.com.mx.messages.response.sivalemx.ResponseUsuario consultarUsuario(ws.sivale.com.mx.messages.request.sivalemx.RequestBase consultarUsuarioRequest) throws java.rmi.RemoteException;
}
