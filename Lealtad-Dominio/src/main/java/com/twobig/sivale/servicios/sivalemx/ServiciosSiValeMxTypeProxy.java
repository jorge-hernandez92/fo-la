package com.twobig.sivale.servicios.sivalemx;

public class ServiciosSiValeMxTypeProxy implements com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxType {
  private String _endpoint = null;
  private com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxType serviciosSiValeMxType = null;
  
  public ServiciosSiValeMxTypeProxy() {
    _initServiciosSiValeMxTypeProxy();
  }
  
  public ServiciosSiValeMxTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiciosSiValeMxTypeProxy();
  }
  
  private void _initServiciosSiValeMxTypeProxy() {
    try {
      serviciosSiValeMxType = (new com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxLocator()).getServiciosSiValeMxTypePort();
      if (serviciosSiValeMxType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviciosSiValeMxType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviciosSiValeMxType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviciosSiValeMxType != null)
      ((javax.xml.rpc.Stub)serviciosSiValeMxType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxType getServiciosSiValeMxType() {
    if (serviciosSiValeMxType == null)
      _initServiciosSiValeMxTypeProxy();
    return serviciosSiValeMxType;
  }
  
  public ws.sivale.com.mx.messages.response.sivalemx.ResponseMensaje login(ws.sivale.com.mx.messages.request.sivalemx.RequestBase loginRequest) throws java.rmi.RemoteException{
    if (serviciosSiValeMxType == null)
      _initServiciosSiValeMxTypeProxy();
    return serviciosSiValeMxType.login(loginRequest);
  }
  
  public ws.sivale.com.mx.messages.response.sivalemx.ResponseUsuario consultarUsuario(ws.sivale.com.mx.messages.request.sivalemx.RequestBase consultarUsuarioRequest) throws java.rmi.RemoteException{
    if (serviciosSiValeMxType == null)
      _initServiciosSiValeMxTypeProxy();
    return serviciosSiValeMxType.consultarUsuario(consultarUsuarioRequest);
  }
  
  
}