/**
 * ServiciosTarjetaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.twobig.sivale.servicios.tarjeta;

public interface ServiciosTarjetaType extends java.rmi.Remote {
    public ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo consultarSaldo(ws.sivale.com.mx.messages.request.tarjeta.RequestBase consultarSaldoRequest) throws java.rmi.RemoteException;
    public ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo consultarMovimientos(ws.sivale.com.mx.messages.request.tarjeta.RequestMovimientos consultarMovimientosRequest) throws java.rmi.RemoteException;
    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado consultarEstado(ws.sivale.com.mx.messages.request.tarjeta.RequestBase consultarEstadoRequest) throws java.rmi.RemoteException;
    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado cambiarEstado(ws.sivale.com.mx.messages.request.tarjeta.RequestEstado cambiarEstadoRequest) throws java.rmi.RemoteException;
    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado bloquearTemporal(ws.sivale.com.mx.messages.request.tarjeta.RequestBase bloquearTemporalRequest) throws java.rmi.RemoteException;
    public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado desbloquearTemporal(ws.sivale.com.mx.messages.request.tarjeta.RequestBase desbloquearTemporalRequest) throws java.rmi.RemoteException;
}
