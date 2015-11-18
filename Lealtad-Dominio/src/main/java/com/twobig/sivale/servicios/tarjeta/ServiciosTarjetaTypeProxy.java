package com.twobig.sivale.servicios.tarjeta;

public class ServiciosTarjetaTypeProxy implements com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaType {
  private String _endpoint = null;
  private com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaType serviciosTarjetaType = null;
  
  public ServiciosTarjetaTypeProxy() {
    _initServiciosTarjetaTypeProxy();
  }
  
  public ServiciosTarjetaTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiciosTarjetaTypeProxy();
  }
  
  private void _initServiciosTarjetaTypeProxy() {
    try {
      serviciosTarjetaType = (new com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaLocator()).getServiciosTarjetaTypePort();
      if (serviciosTarjetaType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviciosTarjetaType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviciosTarjetaType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviciosTarjetaType != null)
      ((javax.xml.rpc.Stub)serviciosTarjetaType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaType getServiciosTarjetaType() {
    if (serviciosTarjetaType == null)
      _initServiciosTarjetaTypeProxy();
    return serviciosTarjetaType;
  }
  
  public ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo consultarSaldo(ws.sivale.com.mx.messages.request.tarjeta.RequestBase consultarSaldoRequest) throws java.rmi.RemoteException{
    if (serviciosTarjetaType == null)
      _initServiciosTarjetaTypeProxy();
    return serviciosTarjetaType.consultarSaldo(consultarSaldoRequest);
  }
  
  public ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo consultarMovimientos(ws.sivale.com.mx.messages.request.tarjeta.RequestMovimientos consultarMovimientosRequest) throws java.rmi.RemoteException{
    if (serviciosTarjetaType == null)
      _initServiciosTarjetaTypeProxy();
    return serviciosTarjetaType.consultarMovimientos(consultarMovimientosRequest);
  }
  
  public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado consultarEstado(ws.sivale.com.mx.messages.request.tarjeta.RequestBase consultarEstadoRequest) throws java.rmi.RemoteException{
    if (serviciosTarjetaType == null)
      _initServiciosTarjetaTypeProxy();
    return serviciosTarjetaType.consultarEstado(consultarEstadoRequest);
  }
  
  public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado cambiarEstado(ws.sivale.com.mx.messages.request.tarjeta.RequestEstado cambiarEstadoRequest) throws java.rmi.RemoteException{
    if (serviciosTarjetaType == null)
      _initServiciosTarjetaTypeProxy();
    return serviciosTarjetaType.cambiarEstado(cambiarEstadoRequest);
  }
  
  public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado bloquearTemporal(ws.sivale.com.mx.messages.request.tarjeta.RequestBase bloquearTemporalRequest) throws java.rmi.RemoteException{
    if (serviciosTarjetaType == null)
      _initServiciosTarjetaTypeProxy();
    return serviciosTarjetaType.bloquearTemporal(bloquearTemporalRequest);
  }
  
  public ws.sivale.com.mx.messages.response.tarjeta.ResponseEstado desbloquearTemporal(ws.sivale.com.mx.messages.request.tarjeta.RequestBase desbloquearTemporalRequest) throws java.rmi.RemoteException{
    if (serviciosTarjetaType == null)
      _initServiciosTarjetaTypeProxy();
    return serviciosTarjetaType.desbloquearTemporal(desbloquearTemporalRequest);
  }
  
  
}