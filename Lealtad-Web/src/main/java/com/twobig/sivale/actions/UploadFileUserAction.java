package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.constants.CommonsConstants;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.constants.UserLoadConstants;
import com.twobig.sivale.service.TAttachedFileService;
import com.twobig.sivale.service.TUserService;
import com.twobig.sivale.service.impl.ExcelServiceImpl;
import com.twobig.sivale.utils.FilesUtil;

public class UploadFileUserAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(UploadFileUserAction.class);
	private Map<String, Object> session;
	private String[] filesFileName;
	private File[] files;
	@Autowired 
	public TAttachedFileService tAttachedFileService;	
	@Autowired
	public TUserService tUserService;
	
	@Action(value = "uploadFileUserAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	
	public String uploadFileUserAction(){
		TUser user = (TUser) session.get("user");
		logger.info("uploadFileUserAction. CARGA DE ARCHIVO DE USUARIOS");
		if (user == null) {
			return ERROR;
		}
		if (files == null || files.length == 0) {
			return ERROR;
		}
		logger.info(""+files[0]);
		logger.info(""+filesFileName[0]);
		Integer attachedFileId  = saveFileOnDataBase();
		saveFileOnDiskFile(attachedFileId);
		loadDataExcel(attachedFileId);
		return SUCCESS;
	}
	
	private void loadDataExcel(Integer attachedFileId){
		String directory = PathConstants.ATTACHED_USER_FILE + attachedFileId + File.separator;
		ExcelServiceImpl excelservice = new ExcelServiceImpl();
		ExcelBean excelBean = excelservice.getExcelData(directory+filesFileName[0]);
		logger.info(excelBean.getHeader().toString());
		logger.info(excelBean.getRows().toString());
		updateInsertUser(excelBean);
		
//		List<String> listStars = getListStars(excelBean,CommonsConstants.COLUMN_STARS);
//		for (String string : listStars) {
//			if(!string.isEmpty()){
//				logger.info(string);
//			}
//		}
//		List<TUser> listUser = tUserService.getUsersByStars(listStars);
//		for (TUser tUser : listUser) {
//			logger.info(tUser.toString());
//		}
	}
	
	private void saveFileOnDiskFile(Integer attachedFileId){
		String directory = PathConstants.ATTACHED_USER_FILE + attachedFileId + File.separator;
		for (int i = 0; i < files.length; i++) {
			try {
				FilesUtil.saveFile(files[i], filesFileName[i], directory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Integer saveFileOnDataBase(){
		TAttachedFile attachedFile = new TAttachedFile();
		attachedFile.setFileName(filesFileName[0]);
		tAttachedFileService.insertTAttachedFile(attachedFile);
		return attachedFile.getAttachedFileId();
	}
	
	public void updateInsertUser(ExcelBean excelBean){
		if(excelBean != null){
			List<HashMap<String, String>> rows = excelBean.getRows();
			if (existKey(excelBean, UserLoadConstants.COL_USER_LOAD_STARS)){
				for (HashMap<String, String> hashMap : rows) {
					String stars = hashMap.get(CommonsConstants.COLUMN_STARS);
					TUser tUser = tUserService.getUsersByStars(stars);
					if(tUser != null){
						logger.info("Actualizar registro");
						logger.info(tUser.toString());
						String bid = hashMap.get(UserLoadConstants.COL_USER_LOAD_BID);
						String razonSocial = hashMap.get(UserLoadConstants.COL_USER_LOAD_RAZON_SOCIAL);
						String ecaps =  hashMap.get(UserLoadConstants.COL_USER_LOAD_ECAPS);
						String identificacion = hashMap.get(UserLoadConstants.COL_USER_LOAD_IDENTIFICACION);
						String acuseFordLincoln = hashMap.get(UserLoadConstants.COL_USER_LOAD_ACUSE_FORD_LINCOLN);
						String inscritoPrograma = hashMap.get(UserLoadConstants.COL_USER_LOAD_INSCRITO_EN_PROGRAMA);
						String acuseFordCredit = hashMap.get(UserLoadConstants.COL_USER_LOAD_ACUSE_FORD_CREDIT);
						String cartaDoblePerfil = hashMap.get(UserLoadConstants.COL_USER_LOAD_CARTA_DOBLE_PERFIL);
						String comentarios = hashMap.get(UserLoadConstants.COL_USER_LOAD_COMENTARIOS);
						String estatusGeneral = hashMap.get(UserLoadConstants.COL_USER_LOAD_ESTATUS_GENERAL_PARTICIPANTE);
						String codigoProcedencia = hashMap.get(UserLoadConstants.COL_USER_LOAD_CODIGO);
						String nombreParticipante = hashMap.get(UserLoadConstants.COL_USER_LOAD_NOMBRE_PARTICIPANTE);
						String tarjetaActiva = hashMap.get(UserLoadConstants.COL_USER_LOAD_TARJETA_ACTIVA);
						if(!nombreParticipante.isEmpty()){
							tUser.setFullName(nombreParticipante);
						}
						if(!tarjetaActiva.isEmpty()){
							tUser.setTjCardNumber(tarjetaActiva);
						}
						if(!bid.isEmpty()){
							tUser.setTjBid(bid);
						}
						if(!razonSocial.isEmpty()){
							tUser.setTjRazonSocial(razonSocial);
						}
						if(!ecaps.isEmpty()){
							tUser.setTjEcaps(ecaps);
						}
						if(!identificacion.isEmpty()){
							if(identificacion.toLowerCase().contains("sí") || identificacion.toLowerCase().contains("si")){
								tUser.setTjIdentificacion(true);
							}
						}
						else{
							tUser.setTjIdentificacion(false);
						}
						if(!acuseFordLincoln.isEmpty()){
							if(acuseFordLincoln.toLowerCase().contains("sí") || acuseFordLincoln.toLowerCase().contains("si")){
								tUser.setTjIdentificacion(true);
							}
						}
						else{
							tUser.setTjIdentificacion(false);
						}
						if(!inscritoPrograma.isEmpty()){
							if(inscritoPrograma.toLowerCase().contains("sí") || inscritoPrograma.toLowerCase().contains("si")){
								tUser.setTjInscritoEnPrograma(true);
							}
						}
						else{
							tUser.setTjInscritoEnPrograma(false);
						}
						if(!acuseFordCredit.isEmpty()){
							if(acuseFordCredit.toLowerCase().contains("sí") || acuseFordCredit.toLowerCase().contains("si")){
								tUser.setTjAcuseFordCredit(true);
							}
						}
						else{
							tUser.setTjAcuseFordCredit(false);
						}
						if(!cartaDoblePerfil.isEmpty()){
							if(cartaDoblePerfil.toLowerCase().contains("sí") || cartaDoblePerfil.toLowerCase().contains("si")){
								tUser.setTjCartaDoblePerfil(true);
							}
						}
						else{
							tUser.setTjCartaDoblePerfil(true);
						}
						if(!comentarios.isEmpty()){
							tUser.setTjComentarios(comentarios);
						}
						if(!estatusGeneral.isEmpty()){
							tUser.setTjEstatusGeneral(estatusGeneral);
						}
						if(!codigoProcedencia.isEmpty()){
							Integer codigo;
							try{
								codigo = Integer.parseInt(codigoProcedencia);
								tUser.setTjCodigoProcedencia(codigo);
							}
							catch(NumberFormatException e){
								logger.error("ERRORde CODIGO ORIGEN: "+codigoProcedencia);
								e.getStackTrace();
							}
						}
						logger.info(tUser.toString());
						tUserService.updateUser(tUser);
					}
					else{
						
						if(!stars.isEmpty()){
							logger.info("Nuevo registro");
							tUser = new TUser();
							tUser.setTjStars(stars);
							String bid = hashMap.get(UserLoadConstants.COL_USER_LOAD_BID);
							String razonSocial = hashMap.get(UserLoadConstants.COL_USER_LOAD_RAZON_SOCIAL);
							String ecaps =  hashMap.get(UserLoadConstants.COL_USER_LOAD_ECAPS);
							String identificacion = hashMap.get(UserLoadConstants.COL_USER_LOAD_IDENTIFICACION);
							String acuseFordLincoln = hashMap.get(UserLoadConstants.COL_USER_LOAD_ACUSE_FORD_LINCOLN);
							String inscritoPrograma = hashMap.get(UserLoadConstants.COL_USER_LOAD_INSCRITO_EN_PROGRAMA);
							String acuseFordCredit = hashMap.get(UserLoadConstants.COL_USER_LOAD_ACUSE_FORD_CREDIT);
							String cartaDoblePerfil = hashMap.get(UserLoadConstants.COL_USER_LOAD_CARTA_DOBLE_PERFIL);
							String comentarios = hashMap.get(UserLoadConstants.COL_USER_LOAD_COMENTARIOS);
							String estatusGeneral = hashMap.get(UserLoadConstants.COL_USER_LOAD_ESTATUS_GENERAL_PARTICIPANTE);
							String codigoProcedencia = hashMap.get(UserLoadConstants.COL_USER_LOAD_CODIGO);
							String nombreParticipante = hashMap.get(UserLoadConstants.COL_USER_LOAD_NOMBRE_PARTICIPANTE);
							String tarjetaActiva = hashMap.get(UserLoadConstants.COL_USER_LOAD_TARJETA_ACTIVA);
							if(!nombreParticipante.isEmpty()){
								tUser.setFullName(nombreParticipante);
							}
							if(!tarjetaActiva.isEmpty()){
								tUser.setTjCardNumber(tarjetaActiva);
							}
							if(!bid.isEmpty()){
								tUser.setTjBid(bid);
							}
							if(!razonSocial.isEmpty()){
								tUser.setTjRazonSocial(razonSocial);
							}
							if(!ecaps.isEmpty()){
								tUser.setTjEcaps(ecaps);
							}
							if(!identificacion.isEmpty()){
								if(identificacion.toLowerCase().contains("sí") || identificacion.toLowerCase().contains("si")){
									tUser.setTjIdentificacion(true);
								}
							}
							else{
								tUser.setTjIdentificacion(false);
							}
							if(!acuseFordLincoln.isEmpty()){
								if(acuseFordLincoln.toLowerCase().contains("sí") || acuseFordLincoln.toLowerCase().contains("si")){
									tUser.setTjIdentificacion(true);
								}
							}
							else{
								tUser.setTjIdentificacion(false);
							}
							if(!inscritoPrograma.isEmpty()){
								if(inscritoPrograma.toLowerCase().contains("sí") || inscritoPrograma.toLowerCase().contains("si")){
									tUser.setTjInscritoEnPrograma(true);
								}
							}
							else{
								tUser.setTjInscritoEnPrograma(false);
							}
							if(!acuseFordCredit.isEmpty()){
								if(acuseFordCredit.toLowerCase().contains("sí") || acuseFordCredit.toLowerCase().contains("si")){
									tUser.setTjAcuseFordCredit(true);
								}
							}
							else{
								tUser.setTjAcuseFordCredit(false);
							}
							if(!cartaDoblePerfil.isEmpty()){
								if(cartaDoblePerfil.toLowerCase().contains("sí") || cartaDoblePerfil.toLowerCase().contains("si")){
									tUser.setTjCartaDoblePerfil(true);
								}
							}
							else{
								tUser.setTjCartaDoblePerfil(true);
							}
							if(!comentarios.isEmpty()){
								tUser.setTjComentarios(comentarios);
							}
							if(!estatusGeneral.isEmpty()){
								tUser.setTjEstatusGeneral(estatusGeneral);
							}
							if(!codigoProcedencia.isEmpty()){
								Integer codigo;
								try{
									codigo = Integer.parseInt(codigoProcedencia);
									tUser.setTjCodigoProcedencia(codigo);
								}
								catch(NumberFormatException e){
									logger.error("ERRORde CODIGO ORIGEN: "+codigoProcedencia);
									e.getStackTrace();
								}
							}
							logger.info(tUser.toString());
							
							TUser user = (TUser) session.get("user");
							tUser.setCompany(user.getCompany());
							tUser.setCatProfile(1);
							tUser.setUserLogin("login"+stars);
							tUser.setPassword("pass"+stars);
							
							tUserService.insertUser(tUser);
						}
						
						
					}
				}
			}
		}
	}
	
	public List<String> getListStars(ExcelBean excelBean, String Id) {
		List<String> listStars = new ArrayList<String>();
		if (excelBean != null) {
			if (excelBean.getHeader() != null && excelBean.getHeader().size() > 0 && excelBean.getRows() != null
					&& excelBean.getRows().size() > 0) {
				if (!this.existKey(excelBean, Id)){
					return null;
				}
				for (HashMap<String, String> row : excelBean.getRows()) {
					String stars = row.get(Id);
					listStars.add(stars);
				}
				return listStars;
			}
			return null;
		} else {
			return null;
		}
	}
	
	private boolean existKey(ExcelBean excelBean, String headKey) {
		for (String key : excelBean.getHeader()) {
			if (headKey.equals(key)){
				return true;
			}
		}
		return false;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
