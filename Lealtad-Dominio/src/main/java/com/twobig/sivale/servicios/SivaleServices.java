package com.twobig.sivale.servicios;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.xml.soap.SOAPException;

import org.apache.axis.message.SOAPHeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ws.sivale.com.mx.messages.response.ResponseError;
import ws.sivale.com.mx.messages.response.sivalemx.ResponseMensaje;
import ws.sivale.com.mx.messages.response.tarjeta.ResponseSaldo;
import ws.sivale.com.mx.messages.types.TypeTransaccion;

import com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxLocator;
import com.twobig.sivale.servicios.sivalemx.ServiciosSiValeMxTypePortBindingStub;
import com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaLocator;
import com.twobig.sivale.servicios.tarjeta.ServiciosTarjetaTypePortBindingStub;
import com.twobig.sivale.utils.PropUtils;

public class SivaleServices {

	private static Logger LOGGER = LoggerFactory.getLogger(SivaleServices.class);
	private static Properties props;
	private static String serviciosSiValeMxAddress;
	private static String serviciosTarjetaAddress;
	private static String appPassword;
	private static String appUser;
	private static String appPetitioner;

	EncryptionSivale encrypt = new EncryptionSivale();

	// public static void main(String[] args) throws SivaleServicesException {
	// SivaleServices services = new SivaleServices();
	// boolean isLogged = services.validateLogin("5273740100000314",
	// "M0tz1LOBKUh3YK4ocepdg+SApHWIOjMrMDHQJMfNDkMhZ9hqiI6kAjzaAapPWcC+3M/4lRo6+lHs9PbKN43ThtiV3pVd1OjC+L46Z8zsgc9O/WTkK7niyNibOgIARySElKPXvxb4jN6MGKisvuts1DhoXaiZib8fMB3o4ixpLIE=");
	// double balance = services.getBalance("5273740100000249");
	//
	// System.out.println(isLogged);
	// System.out.println(balance);
	// }

	static {
		props = PropUtils.getProperties();
		appPassword = props.getProperty("ws.app.pass");
		appUser = props.getProperty("ws.app.user");
		appPetitioner = props.getProperty("ws.app.solicitante");
	}

	public double getBalance(String card) throws SivaleServicesException {
		try {
			ServiciosTarjetaLocator service = new ServiciosTarjetaLocator();
			String uri = service.getServiciosTarjetaTypePortAddress();
			URL url = new URL(uri);
			ServiciosTarjetaTypePortBindingStub wbind = new ServiciosTarjetaTypePortBindingStub(url, service);

			wbind.setHeader(getSivaleHeader(uri));

			ws.sivale.com.mx.messages.request.tarjeta.RequestBase req = new ws.sivale.com.mx.messages.request.tarjeta.RequestBase(
					card);
			ResponseSaldo response = wbind.consultarSaldo(req);

			String mensaje = response.getMensaje();
			double saldo = response.getSaldo();
			ResponseError responseError = response.getResponseError();
			Integer errCodigo = responseError.getCodigo();
			String errMensaje = responseError.getMensaje();

			LOGGER.debug("mensaje " + mensaje);
			LOGGER.debug("saldo " + saldo);
			LOGGER.debug("Err: " + errCodigo);
			LOGGER.debug("Err: " + errMensaje);

			if (errCodigo == 0) {
				return saldo;
			} else {
				return 0;
			}
		} catch (MalformedURLException e) {
			throw new SivaleServicesException(
					"No namespace detected for web service at " + getServiciosTarjetaAddress(), e);
		} catch (SOAPException e) {
			throw new SivaleServicesException("Could not add header for web service at " + getServiciosTarjetaAddress(),
					e);
		} catch (RemoteException e) {
			throw new SivaleServicesException("Error calling web service at " + getServiciosTarjetaAddress(), e);
		} catch (Throwable e) {
			throw new SivaleServicesException(
					"Error encrypting data for web service at " + getServiciosTarjetaAddress(), e);
		}
	}

	public List<TypeTransaccion> getMovements(String card) throws SivaleServicesException {

		try {
			ServiciosTarjetaLocator service = new ServiciosTarjetaLocator();
			String uri = service.getServiciosTarjetaTypePortAddress();
			URL url = new URL(uri);
			ServiciosTarjetaTypePortBindingStub wbind = new ServiciosTarjetaTypePortBindingStub(url, service);

			wbind.setHeader(getSivaleHeader(uri));

			ws.sivale.com.mx.messages.request.tarjeta.RequestMovimientos req = new ws.sivale.com.mx.messages.request.tarjeta.RequestMovimientos(
					card, null, null, null);
			ResponseSaldo response = wbind.consultarMovimientos(req);

			String mensaje = response.getMensaje();

			ResponseError responseError = response.getResponseError();
			Integer errCodigo = responseError.getCodigo();
			String errMensaje = responseError.getMensaje();

			TypeTransaccion[] typeTransactions = response.getTransacciones();

			LOGGER.debug("mensaje " + mensaje);
			LOGGER.debug("Err: " + errCodigo);
			LOGGER.debug("Err: " + errMensaje);

			if (errCodigo == 0) {

				if (typeTransactions != null && typeTransactions.length > 0) {

					List<TypeTransaccion> transactionsList = Arrays.asList(typeTransactions);
					return transactionsList;
				}
				return null;
			} else {
				return null;
			}
		} catch (MalformedURLException e) {
			throw new SivaleServicesException(
					"No namespace detected for web service at " + getServiciosTarjetaAddress(), e);
		} catch (SOAPException e) {
			throw new SivaleServicesException("Could not add header for web service at " + getServiciosTarjetaAddress(),
					e);
		} catch (RemoteException e) {
			throw new SivaleServicesException("Error calling web service at " + getServiciosTarjetaAddress(), e);
		} catch (Throwable e) {
			throw new SivaleServicesException(
					"Error encrypting data for web service at " + getServiciosTarjetaAddress(), e);
		}
	}

	public boolean validateLogin(String user, String pass) throws SivaleServicesException {
		try {
			ServiciosSiValeMxLocator service = new ServiciosSiValeMxLocator();
			String uri = service.getServiciosSiValeMxTypePortAddress();
			URL url = new URL(uri);
			ServiciosSiValeMxTypePortBindingStub wbind = new ServiciosSiValeMxTypePortBindingStub(url, service);

			wbind.setHeader(getSivaleHeader(uri));

			String encryptedPass = encrypt.encryptData(pass);
			LOGGER.info("Authenticating user: " + user);
			LOGGER.info(encryptedPass);

			ws.sivale.com.mx.messages.request.sivalemx.RequestBase req = new ws.sivale.com.mx.messages.request.sivalemx.RequestBase(
					user, encryptedPass);
			ResponseMensaje response = wbind.login(req);
			String mensaje = response.getMensaje();
			ResponseError responseError = response.getResponseError();
			Integer errCodigo = responseError.getCodigo();
			String errMensaje = responseError.getMensaje();

			LOGGER.debug(mensaje);
			LOGGER.debug("Err:" + errCodigo);
			LOGGER.debug("Err:" + errMensaje);

			if (errCodigo == 0 && "valido".equals(mensaje)) {
				return true;
			} else {
				return false;
			}
		} catch (RemoteException e) {
			throw new SivaleServicesException(
					"No namespace detected for web service at " + getServiciosSiValeMxAddress(), e);
		} catch (SOAPException e) {
			throw new SivaleServicesException(
					"Could not add header for web service at " + getServiciosSiValeMxAddress(), e);
		} catch (MalformedURLException e) {
			throw new SivaleServicesException("Error calling web service at " + getServiciosSiValeMxAddress(), e);
		} catch (Throwable e) {
			throw new SivaleServicesException(
					"Error encrypting data for web service at " + getServiciosSiValeMxAddress(), e);
		}
	}

	private SOAPHeaderElement getSivaleHeader(String uri) throws Throwable {
		SOAPHeaderElement identificacion = new SOAPHeaderElement(uri, "identificacion");
		SOAPHeaderElement usuario = new SOAPHeaderElement(uri, "usuario", appUser);
		SOAPHeaderElement password = new SOAPHeaderElement(uri, "password", encrypt.encryptData(appPassword));
		SOAPHeaderElement solicitante = new SOAPHeaderElement(uri, "solicitante", appPetitioner);
		identificacion.addChildElement(usuario);
		identificacion.addChildElement(password);
		identificacion.addChildElement(solicitante);
		return identificacion;
	}

	public static String getServiciosSiValeMxAddress() {
		if (serviciosSiValeMxAddress == null) {
			serviciosSiValeMxAddress = props.getProperty("ws.address.serviciossivalemx");
		}
		return serviciosSiValeMxAddress;
	}

	public static String getServiciosTarjetaAddress() {
		if (serviciosTarjetaAddress == null) {
			serviciosTarjetaAddress = props.getProperty("ws.address.serviciostarjeta");
		}
		return serviciosTarjetaAddress;
	}
}
