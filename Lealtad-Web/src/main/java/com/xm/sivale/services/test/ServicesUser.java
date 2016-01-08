package com.xm.sivale.services.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.CatPublicationType;
import com.twobig.sivale.bd.to.CatView;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;

import ws.sivale.com.mx.messages.types.TypeTransaccion;

public class ServicesUser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicesUser.class);
	
	
	//Agregar a excel
	public List<CatClassificationCampaign> getClassificationsAdmin(Integer userId){
		return getMyClassifications(userId);
	}
	
	public List<CatClassificationCampaign> getChilds(Integer ClassId){
		
		List<CatClassificationCampaign> childs = new ArrayList<CatClassificationCampaign>();
		
		CatClassificationCampaign classif = new CatClassificationCampaign();
		classif.setClassName("classification 1");
		classif.setCatClassificationCampaignsId(0);
		
		childs.add(classif);
		
		classif = new CatClassificationCampaign();
		classif.setClassName("classification 2");
		classif.setCatClassificationCampaignsId(1);
		
		childs.add(classif);
		
		classif = new CatClassificationCampaign();
		classif.setClassName("classification 3");
		classif.setCatClassificationCampaignsId(2);
		
		childs.add(classif);
		
		return childs;
		
	}
	
	
	public List<CatClassificationCampaign> getMyClassifications(Integer userId){
		
		LOGGER.info("UserId Value = " + userId);
		
		ArrayList<String> logos = new ArrayList<String>();
		ArrayList<String> style = new ArrayList<String>();
		
		logos.add("Ford");
		logos.add("FordCredit");
		logos.add("Lincoln");
		
		style.add("ford.css");
		style.add("ford_credit.css");
		style.add("lincoln.css");
		style.add("sivale.css");
		style.add("sivale.css");
		
		List<CatClassificationCampaign> classifications = new ArrayList<CatClassificationCampaign>();
		
		for (int i = 0; i < 3; i++){
			
			CatClassificationCampaign classification = new CatClassificationCampaign();
			classification.setClassName("Classification " + i);
			classification.setDescription("Description ...");
			classification.setCatClassificationCampaignsId(i);
			
			CatView catView = new CatView();
			
			catView.setLogos(logos.get(i));
			catView.setColors(style.get(i));
			
			classification.setCatViews(catView);
			
			classifications.add(classification);
		}
		
		return classifications;
		
	}

	
	public List<CampaignDetailBean> getCampaigns(Integer userId , Integer classification){
		
		List<CampaignDetailBean> campaigns= new ArrayList<CampaignDetailBean>();
		Date date = new Date(115,11,1,0,0,0);
		
		List<String> classifications;
		CampaignDetailBean campaign;
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa A");
		classifications.add("Subprograma A");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(0);
		campaign.setCampaignName("campaign Name A");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa A");
		classifications.add("Subprograma B");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(1);
		campaign.setCampaignName("campaign Name B");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa B");
		classifications.add("Subprograma C");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(2);
		campaign.setCampaignName("campaign Name C");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa B");
		classifications.add("Subprograma D");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(3);
		campaign.setCampaignName("campaign Name D");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa C");
		classifications.add("Subprograma E");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(4);
		campaign.setCampaignName("campaign Name E");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		return campaigns;
	}
	
	
	public List<CampaignDetailBean> searchCampaigns(){
		
		List<CampaignDetailBean> campaigns= new ArrayList<CampaignDetailBean>();
		Date date = new Date(115,11,1,0,0,0);
		
		List<String> classifications;
		CampaignDetailBean campaign;
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia X");
		classifications.add("Programa A");
		classifications.add("Subprograma A");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(0);
		campaign.setCampaignName("campaign Name A");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia X");
		classifications.add("Programa A");
		classifications.add("Subprograma B");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(1);
		campaign.setCampaignName("campaign Name B");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia X");
		classifications.add("Programa B");
		classifications.add("Subprograma C");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(2);
		campaign.setCampaignName("campaign Name C");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia X");
		classifications.add("Programa B");
		classifications.add("Subprograma D");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(3);
		campaign.setCampaignName("campaign Name D");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia X");
		classifications.add("Programa C");
		classifications.add("Subprograma E");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailBean();
		campaign.setCampaignId(4);
		campaign.setCampaignName("campaign Name E");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
			
		campaigns.add(campaign);
		
		return campaigns;
	}


	public List<TPublication> getPubliations(Integer UserId, Integer CampaignId){
		
		LOGGER.info("UserId = " + UserId + "     "+ "CampaignId = " + CampaignId);
		
		List<TPublication> publications= new ArrayList<TPublication>();
		
		for (int i = 0; i < 5; i++) {

			TPublication publication = new TPublication();
			
			Date date = new Date(115,11,1,0,0,0);
			CatPublicationType catPublicationType = new CatPublicationType();
			catPublicationType.setName("Teaser");
			
			publication.setPublicationId(i);
			publication.setName("Publication Name " + i);
			publication.setPublishedDate(date);
			publication.setDescription("Description "+i);
			publication.setCatPublicationType(catPublicationType);
			
			publications.add(publication);
		}
		
		return publications;
		
	}
	
	public Map showPublication(Integer UserId, Integer PublicationId){
		
		LOGGER.info("UserId = " + UserId + "     "+ "PublicationId = " + PublicationId);
		
		Map map = new HashMap<>();
		
		String html="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html><head>    <title></title>    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />    <style type=\"text/css\">.font-sans-serif {  font-family: sans-serif;}.font-avenir {  font-family: Avenir, sans-serif;}.mso .wrapper .font-avenir {  font-family: sans-serif !important;}.font-lato {  font-family: Lato, Tahoma, sans-serif;}.mso .wrapper .font-lato {  font-family: Tahoma, sans-serif !important;}.font-cabin {  font-family: Cabin, Avenir, sans-serif;}.mso .wrapper .font-cabin {  font-family: sans-serif !important;}.font-open-Sans {  font-family: \"Open Sans\", sans-serif;}.mso .wrapper .font-open-Sans {  font-family: sans-serif !important;}.font-roboto {  font-family: Roboto, Tahoma, sans-serif;}.mso .wrapper .font-roboto {  font-family: Tahoma, sans-serif !important;}.font-ubuntu {  font-family: Ubuntu, sans-serif;}.mso .wrapper .font-ubuntu {  font-family: sans-serif !important;}.font-pt-sans {  font-family: \"PT Sans\", \"Trebuchet MS\", sans-serif;}.mso .wrapper .font-pt-sans {  font-family: \"Trebuchet MS\", sans-serif !important;}.font-georgia {  font-family: Georgia, serif;}.font-merriweather {  font-family: Merriweather, Georgia, serif;}.mso .wrapper .font-merriweather {  font-family: Georgia, serif !important;}.font-bitter {  font-family: Bitter, Georgia, serif;}.mso .wrapper .font-bitter {  font-family: Georgia, serif !important;}.font-pt-serif {  font-family: \"PT Serif\", Georgia, serif;}.mso .wrapper .font-pt-serif {  font-family: Georgia, serif !important;}.font-pompiere {  font-family: Pompiere, \"Trebuchet MS\", sans-serif;}.mso .wrapper .font-pompiere {  font-family: \"Trebuchet MS\", sans-serif !important;}.font-roboto-slab {  font-family: \"Roboto Slab\", Georgia, serif;}.mso .wrapper .font-roboto-slab {  font-family: Georgia, serif !important;}@media only screen and (max-width: 620px) {  .wrapper .column .size-8 {    font-size: 8px !important;    line-height: 14px !important;  }  .wrapper .column .size-9 {    font-size: 9px !important;    line-height: 16px !important;  }  .wrapper .column .size-10 {    font-size: 10px !important;    line-height: 18px !important;  }  .wrapper .column .size-11 {    font-size: 11px !important;    line-height: 19px !important;  }  .wrapper .column .size-12 {    font-size: 12px !important;    line-height: 19px !important;  }  .wrapper .column .size-13 {    font-size: 13px !important;    line-height: 21px !important;  }  .wrapper .column .size-14 {    font-size: 14px !important;    line-height: 21px !important;  }  .wrapper .column .size-15 {    font-size: 15px !important;    line-height: 23px !important;  }  .wrapper .column .size-16 {    font-size: 16px !important;    line-height: 24px !important;  }  .wrapper .column .size-17 {    font-size: 17px !important;    line-height: 26px !important;  }  .wrapper .column .size-18 {    font-size: 17px !important;    line-height: 26px !important;  }  .wrapper .column .size-20 {    font-size: 17px !important;    line-height: 26px !important;  }  .wrapper .column .size-22 {    font-size: 18px !important;    line-height: 26px !important;  }  .wrapper .column .size-24 {    font-size: 20px !important;    line-height: 28px !important;  }  .wrapper .column .size-26 {    font-size: 22px !important;    line-height: 31px !important;  }  .wrapper .column .size-28 {    font-size: 24px !important;    line-height: 32px !important;  }  .wrapper .column .size-30 {    font-size: 26px !important;    line-height: 34px !important;  }  .wrapper .column .size-32 {    font-size: 28px !important;    line-height: 36px !important;  }  .wrapper .column .size-34 {    font-size: 30px !important;    line-height: 38px !important;  }  .wrapper .column .size-36 {    font-size: 30px !important;    line-height: 38px !important;  }  .wrapper .column .size-40 {    font-size: 32px !important;    line-height: 40px !important;  }  .wrapper .column .size-44 {    font-size: 34px !important;    line-height: 43px !important;  }  .wrapper .column .size-48 {    font-size: 36px !important;    line-height: 43px !important;  }  .wrapper .column .size-56 {    font-size: 40px !important;    line-height: 47px !important;  }  .wrapper .column .size-64 {    font-size: 44px !important;    line-height: 50px !important;  }}body {  margin: 0;  padding: 0;  min-width: 100%;}.mso body {  mso-line-height-rule: exactly;}.no-padding .wrapper .column .column-top,.no-padding .wrapper .column .column-bottom {  font-size: 0px;  line-height: 0px;}table {  border-collapse: collapse;  border-spacing: 0;}td {  padding: 0;  vertical-align: top;}.spacer,.border {  font-size: 1px;  line-height: 1px;}.spacer {  width: 100%;}img {  border: 0;  -ms-interpolation-mode: bicubic;}.image {  font-size: 12px;  mso-line-height-rule: at-least;}.image img {  display: block;}.logo {  mso-line-height-rule: at-least;}.logo img {  display: block;}strong {  font-weight: bold;}h1,h2,h3,p,ol,ul,blockquote,.image {  font-style: normal;  font-weight: 400;}ol,ul,li {  padding-left: 0;}blockquote {  Margin-left: 0;  Margin-right: 0;  padding-right: 0;}.column-top,.column-bottom {  font-size: 34px;  line-height: 34px;  transition-timing-function: cubic-bezier(0, 0, 0.2, 1);  transition-duration: 150ms;  transition-property: all;}.half-padding .column .column-top,.half-padding .column .column-bottom {  font-size: 17px;  line-height: 17px;}.column {  text-align: left;}.contents {  table-layout: fixed;  width: 100%;}.padded {  padding-left: 32px;  padding-right: 32px;  word-break: break-word;  word-wrap: break-word;}.wrapper {  display: table;  table-layout: fixed;  width: 100%;  min-width: 620px;  -webkit-text-size-adjust: 100%;  -ms-text-size-adjust: 100%;}.wrapper a {  transition: opacity 0.2s ease-in;}table.wrapper {  table-layout: fixed;}.one-col,.two-col,.three-col {  Margin-left: auto;  Margin-right: auto;  width: 600px;}.centered {  Margin-left: auto;  Margin-right: auto;}.btn a {  border-radius: 3px;  display: inline-block;  font-size: 14px;  font-weight: 700;  line-height: 24px;  padding: 13px 35px 12px 35px;  text-align: center;  text-decoration: none !important;}.btn a:hover {  opacity: 0.8;}.two-col .btn a {  font-size: 12px;  line-height: 22px;  padding: 10px 28px;}.three-col .btn a {  font-size: 11px;  line-height: 19px;  padding: 6px 18px 5px 18px;}@media only screen and (max-width: 620px) {  .btn a {    display: block !important;    font-size: 14px !important;    line-height: 24px !important;    padding: 13px 10px 12px 10px !important;  }}.two-col .column {  width: 300px;}.two-col .first .padded {  padding-left: 32px;  padding-right: 32px;}.two-col .second .padded {  padding-left: 32px;  padding-right: 32px;}.three-col .column {  width: 200px;}.three-col .first .padded {  padding-left: 32px;  padding-right: 12px;}.three-col .second .padded {  padding-left: 22px;  padding-right: 22px;}.three-col .third .padded {  padding-left: 12px;  padding-right: 32px;}@media only screen and (min-width: 0) {  .wrapper {    text-rendering: optimizeLegibility;  }}@media only screen and (max-width: 620px) {  [class=wrapper] {    min-width: 320px !important;    width: 100% !important;  }  [class=wrapper] .one-col,  [class=wrapper] .two-col,  [class=wrapper] .three-col {    width: 320px !important;  }  [class=wrapper] .column,  [class=wrapper] .gutter {    display: block;    float: left;    width: 320px !important;  }  [class=wrapper] .padded {    padding-left: 20px !important;    padding-right: 20px !important;  }  [class=wrapper] .block {    display: block !important;  }  [class=wrapper] .hide {    display: none !important;  }  [class=wrapper] .image img {    height: auto !important;    width: 100% !important;  }}.footer {  width: 100%;}.footer .inner {  padding: 58px 0 29px 0;  width: 600px;}.footer .left td,.footer .right td {  font-size: 12px;  line-height: 22px;}.footer .left td {  text-align: left;  width: 400px;}.footer .right td {  max-width: 200px;  mso-line-height-rule: at-least;}.footer .links {  line-height: 26px;  Margin-bottom: 26px;  mso-line-height-rule: at-least;}.footer .links a:hover {  opacity: 0.8;}.footer .links img {  vertical-align: middle;}.footer .address {  Margin-bottom: 18px;}.footer .campaign {  Margin-bottom: 18px;}.footer .campaign a {  font-weight: bold;  text-decoration: none;}.footer .sharing div {  Margin-bottom: 5px;}.wrapper .footer .fblike,.wrapper .footer .tweet,.wrapper .footer .linkedinshare,.wrapper .footer .forwardtoafriend {  background-repeat: no-repeat;  background-size: 200px 56px;  border-radius: 2px;  color: #ffffff;  display: block;  font-size: 11px;  font-weight: bold;  line-height: 11px;  padding: 8px 11px 7px 28px;  text-align: left;  text-decoration: none;}.wrapper .footer .fblike:hover,.wrapper .footer .tweet:hover,.wrapper .footer .linkedinshare:hover,.wrapper .footer .forwardtoafriend:hover {  color: #ffffff !important;  opacity: 0.8;}.footer .fblike {  background-image: url(https://i3.createsend1.com/static/eb/master/08-tint/imgf/fblike.png);}.footer .tweet {  background-image: url(https://i4.createsend1.com/static/eb/master/08-tint/imgf/tweet.png);}.footer .linkedinshare {  background-image: url(https://i7.createsend1.com/static/eb/master/08-tint/imgf/lishare.png);}.footer .forwardtoafriend {  background-image: url(https://i5.createsend1.com/static/eb/master/08-tint/imgf/forward.png);}@media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min--moz-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min-device-pixel-ratio: 2), only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx) {  .footer .fblike {    background-image: url(https://i6.createsend1.com/static/eb/master/08-tint/imgf/fblike@2x.png) !important;  }  .footer .tweet {    background-image: url(https://i9.createsend1.com/static/eb/master/08-tint/imgf/tweet@2x.png) !important;  }  .footer .linkedinshare {    background-image: url(https://i8.createsend1.com/static/eb/master/08-tint/imgf/lishare@2x.png) !important;  }  .footer .forwardtoafriend {    background-image: url(https://i10.createsend1.com/static/eb/master/08-tint/imgf/forward@2x.png) !important;  }}@media only screen and (max-width: 620px) {  .footer {    width: 320px !important;  }  .footer td {    display: none;  }  .footer .inner,  .footer .inner td {    display: block;    text-align: center !important;    max-width: 320px !important;    width: 320px !important;  }  .footer .sharing {    Margin-bottom: 40px;  }  .footer .sharing div {    display: inline-block;  }  .footer .fblike,  .footer .tweet,  .footer .linkedinshare,  .footer .forwardtoafriend {    display: inline-block !important;  }}.wrapper h1,.wrapper h2,.wrapper h3,.wrapper p,.wrapper ol,.wrapper ul,.wrapper li,.wrapper blockquote,.image,.btn,.divider {  Margin-bottom: 0;  Margin-top: 0;}.wrapper .column h1 + * {  Margin-top: 18px;}.wrapper .column h2 + * {  Margin-top: 12px;}.wrapper .column h3 + * {  Margin-top: 10px;}.wrapper .column p + *,.wrapper .column ol + *,.wrapper .column ul + *,.wrapper .column blockquote + *,.image + .contents td > :first-child {  Margin-top: 25px;}.contents:nth-last-child(n+3) h1:last-child,.no-padding .contents:nth-last-child(n+2) h1:last-child {  Margin-bottom: 18px;}.contents:nth-last-child(n+3) h2:last-child,.no-padding .contents:nth-last-child(n+2) h2:last-child {  Margin-bottom: 12px;}.contents:nth-last-child(n+3) h3:last-child,.no-padding .contents:nth-last-child(n+2) h3:last-child {  Margin-bottom: 10px;}.contents:nth-last-child(n+3) p:last-child,.no-padding .contents:nth-last-child(n+2) p:last-child,.contents:nth-last-child(n+3) ol:last-child,.no-padding .contents:nth-last-child(n+2) ol:last-child,.contents:nth-last-child(n+3) ul:last-child,.no-padding .contents:nth-last-child(n+2) ul:last-child,.contents:nth-last-child(n+3) blockquote:last-child,.no-padding .contents:nth-last-child(n+2) blockquote:last-child,.contents:nth-last-child(n+3) .image,.no-padding .contents:nth-last-child(n+2) .image,.contents:nth-last-child(n+3) .divider,.no-padding .contents:nth-last-child(n+2) .divider,.contents:nth-last-child(n+3) .btn,.no-padding .contents:nth-last-child(n+2) .btn {  Margin-bottom: 25px;}.two-col .column p + *,.two-col .column ol + *,.two-col .column ul + *,.two-col .column blockquote + *,.two-col .image + .contents td > :first-child {  Margin-top: 28px;}.two-col .contents:nth-last-child(n+3) p:last-child,.no-padding .two-col .contents:nth-last-child(n+2) p:last-child,.two-col .contents:nth-last-child(n+3) ol:last-child,.no-padding .two-col .contents:nth-last-child(n+2) ol:last-child,.two-col .contents:nth-last-child(n+3) ul:last-child,.no-padding .two-col .contents:nth-last-child(n+2) ul:last-child,.two-col .contents:nth-last-child(n+3) blockquote:last-child,.no-padding .two-col .contents:nth-last-child(n+2) blockquote:last-child,.two-col .contents:nth-last-child(n+3) .image,.no-padding .two-col .contents:nth-last-child(n+2) .image,.two-col .contents:nth-last-child(n+3) .divider,.no-padding .two-col .contents:nth-last-child(n+2) .divider,.two-col .contents:nth-last-child(n+3) .btn,.no-padding .two-col .contents:nth-last-child(n+2) .btn {  Margin-bottom: 28px;}.three-col .column p + *,.three-col .column ol + *,.three-col .column ul + *,.three-col .column blockquote + *,.three-col .image + .contents td > :first-child {  Margin-top: 18px;}.three-col .contents:nth-last-child(n+3) p:last-child,.no-padding .three-col .contents:nth-last-child(n+2) p:last-child,.three-col .contents:nth-last-child(n+3) ol:last-child,.no-padding .three-col .contents:nth-last-child(n+2) ol:last-child,.three-col .contents:nth-last-child(n+3) ul:last-child,.no-padding .three-col .contents:nth-last-child(n+2) ul:last-child,.three-col .contents:nth-last-child(n+3) blockquote:last-child,.no-padding .three-col .contents:nth-last-child(n+2) blockquote:last-child,.three-col .contents:nth-last-child(n+3) .image,.no-padding .three-col .contents:nth-last-child(n+2) .image,.three-col .contents:nth-last-child(n+3) .divider,.no-padding .three-col .contents:nth-last-child(n+2) .divider,.three-col .contents:nth-last-child(n+3) .btn,.no-padding .three-col .contents:nth-last-child(n+2) .btn {  Margin-bottom: 18px;}@media only screen and (max-width: 620px) {  .wrapper p + *,  .wrapper ol + *,  .wrapper ul + *,  .wrapper blockquote + *,  .image + .contents td > :first-child {    Margin-top: 25px !important;  }  .contents:nth-last-child(n+3) p:last-child,  .no-padding .contents:nth-last-child(n+2) p:last-child,  .contents:nth-last-child(n+3) ol:last-child,  .no-padding .contents:nth-last-child(n+2) ol:last-child,  .contents:nth-last-child(n+3) ul:last-child,  .no-padding .contents:nth-last-child(n+2) ul:last-child,  .contents:nth-last-child(n+3) blockquote:last-child,  .no-padding .contents:nth-last-child(n+2) blockquote:last-child,  .contents:nth-last-child(n+3) .image:last-child,  .no-padding .contents:nth-last-child(n+2) .image:last-child,  .contents:nth-last-child(n+3) .divider:last-child,  .no-padding .contents:nth-last-child(n+2) .divider:last-child,  .contents:nth-last-child(n+3) .btn:last-child,  .no-padding .contents:nth-last-child(n+2) .btn:last-child {    Margin-bottom: 25px !important;  }}.preheader {  font-size: 11px;  line-height: 17px;}.preheader .title {  padding: 9px;  text-align: left;  width: 50%;}.preheader .webversion {  padding: 9px;  text-align: right;  width: 50%;}.separator {  font-size: 34px;  line-height: 34px;}.divider {  font-size: 3px;  line-height: 3px;  Margin-left: auto;  Margin-right: auto;  width: 60px;}.mso .divider {  Margin-left: 238px;  Margin-right: 238px;}.mso .two-col .divider {  Margin-left: 96px;  Margin-right: 96px;}.mso .three-col .divider {  Margin-left: 48px;  Margin-right: 48px;}.wrapper h1 a,.wrapper h2 a,.wrapper h3 a {  text-decoration: none;}.wrapper h1 {  font-size: 36px;  line-height: 44px;}.wrapper h2 {  font-size: 24px;  line-height: 32px;}.wrapper h3 {  font-size: 14px;  line-height: 22px;}.wrapper p,.wrapper ol,.wrapper ul {  font-size: 16px;  line-height: 25px;}.mso .wrapper li {  padding-left: 5px !important;  margin-left: 10px !important;}.mso .wrapper ol,.mso .wrapper ul {  margin-left: 20px !important;}.wrapper blockquote {  Margin-left: 0;  padding-right: 0;}.one-col-bg,.two-col-bg,.three-col-bg,.one-col-feature-bg {  width: 100%;}.one-col,.two-col,.three-col,.one-col-feature {  background-color: #ffffff;}.one-col ol,.one-col ul {  Margin-left: 17px;}.one-col li {  padding-left: 4px;}.one-col blockquote {  padding-left: 16px;}.two-col ol,.two-col ul {  Margin-left: 15px;}.two-col li {  padding-left: 3px;}.two-col blockquote {  padding-left: 13px;}.three-col ol,.three-col ul {  Margin-left: 15px;}.three-col li {  padding-left: 4px;}.three-col blockquote {  padding-left: 13px;}.one-col-feature .column {  width: 600px;}.one-col-feature-top {  padding-top: 32px;}.one-col-feature-bottom {  padding-bottom: 32px;}.one-col-feature .border {  font-size: 3px;  line-height: 3px;  Margin-left: 32px;  Margin-right: 32px;}.one-col-feature h1,.one-col-feature h2,.one-col-feature h3,.one-col-feature p,.one-col-feature .btn {  text-align: center;}.one-col-feature ol {  Margin-left: 31px;}.one-col-feature ol li {  padding-left: 0;}.one-col-feature ul {  Margin-left: 23px;}.one-col-feature ul li {  padding-left: 9px;}.wrapper .one-col-feature blockquote {  border-left: none;  Margin-left: 0;  padding-left: 0;}.wrapper h1 {  font-weight: 500;}.wrapper h2 {  font-weight: 500;}.wrapper h3 {  font-weight: 700;}.wrapper blockquote {  font-style: italic;}.preheader a,.header a {  font-weight: 700;  letter-spacing: 0.01em;  text-decoration: none;}.preheader {  width: 100%;}.one-col,.two-col,.three-col,.one-col-feature {  table-layout: fixed;}.two-col .first .padded {  padding-left: 32px;  padding-right: 16px;}.two-col .second .padded {  padding-left: 16px;  padding-right: 32px;}.header {  width: 100%;}.logo {  width: 600px;}.logo div {  font-weight: 400;}.logo div.logo-center {  text-align: center;}.logo div.logo-center img {  Margin-left: auto;  Margin-right: auto;}@media only screen and (max-width: 620px) {  [class=wrapper] blockquote {    border-left-width: 5px !important;    padding-left: 15px !important;  }  [class=wrapper] .preheader .title {    display: none;  }  [class=wrapper] .preheader .webversion {    text-align: center !important;  }  [class=wrapper] .logo {    width: 280px !important;    padding-left: 10px !important;    padding-right: 10px !important;  }  [class=wrapper] .logo img {    max-width: 280px !important;    height: auto !important;  }  [class=wrapper] h1 {    font-size: 36px !important;    line-height: 44px !important;  }  [class=wrapper] h2 {    font-size: 24px !important;    line-height: 32px !important;  }  [class=wrapper] h3 {    font-size: 14px !important;    line-height: 22px !important;  }  [class=wrapper] p,  [class=wrapper] ol,  [class=wrapper] ul {    line-height: 25px !important;    font-size: 16px !important;  }  [class=wrapper] ol,  [class=wrapper] ul {    margin-left: 17px;  }  [class=wrapper] li {    padding-left: 4px;  }  [class=wrapper] .divider {    Margin: 0 auto 25px auto !important;    width: 60px;  }  [class=wrapper] .separator {    width: 320px !important;  }  [class=wrapper] .second .column-top,  [class=wrapper] .third .column-top {    display: none;  }  [class=wrapper] .one-col-feature ol {    margin-left: 28px !important;  }  [class=wrapper] .one-col-feature ol li {    padding-left: 0 !important;  }  [class=wrapper] .one-col-feature ul {    margin-left: 20px !important;  }  [class=wrapper] .one-col-feature ul li {    padding-left: 8px !important;  }  [class=wrapper] .one-col-feature blockquote {    border-left: none !important;    padding-left: 0 !important;  }}</style>  <style type=\"text/css\">.wrapper h1{}.wrapper h1{font-family:Avenir,sans-serif}.mso .wrapper h1{font-family:sans-serif !important}.wrapper h2{}.wrapper h2{font-family:Avenir,sans-serif}.mso .wrapper h2{font-family:sans-serif !important}.wrapper h3{}.wrapper h3{font-family:Avenir,sans-serif}.mso .wrapper h3{font-family:sans-serif !important}.wrapper p,.wrapper ol,.wrapper ul,.wrapper .image{}.wrapper p,.wrapper ol,.wrapper ul,.wrapper .image{font-family:Avenir,sans-serif}.mso .wrapper p,.mso .wrapper ol,.mso .wrapper ul,.mso .wrapper .image{font-family:sans-serif !important}.wrapper .btn a{}.wrapper .btn a{font-family:Avenir,sans-serif}.mso .wrapper .btn a{font-family:sans-serif !important}.logo div{}.logo div{font-family:\"PT Sans\",\"Trebuchet MS\",sans-serif}.mso .logo div{font-family:\"Trebuchet MS\",sans-serif !important}.title,.webversion,.fblike,.tweet,.linkedinshare,.forwardtoafriend,.link,.address,.permission,.campaign{}.title,.webversion,.fblike,.tweet,.linkedinshare,.forwardtoafriend,.link,.address,.permission,.campaign{font-family:Avenir,sans-serif}.mso .title,.mso .webversion,.mso .fblike,.mso .tweet,.mso .linkedinshare,.mso .forwardtoafriend,.mso .link,.mso .address,.mso .permission,.mso .campaign{font-family:sans-serif !important}body,.wrapper,.emb-editor-canvas{background-color:#c5cbd1}.mso body{background-color:#fff !important}.mso .separator,.mso .header,.mso .footer,.mso .one-col-bg,.mso .two-col-bg,.mso .three-col-bg,.mso .one-col-feature-bg{background-color:#c5cbd1}.wrapper h1 a,.wrapper h2 a,.wrapper h3 a,.wrapper p a,.wrapper li a{color:#438fd1}.wrapper h1 a:hover,.wrapper h2 a:hover,.wrapper h3 a:hover,.wrapper p a:hover,.wrapper li a:hover{color:#2c75b5 !important}.wrapper h1{color:#44596b}.wrapper h2{color:#44596b}.wrapper h3{color:#44596b}.wrapper p,.wrapper ol,.wrapper ul{color:#8e8e8e}.wrapper .image{color:#8e8e8e}.wrapper .one-col-feature h1 a,.wrapper .one-col-feature h2 a,.wrapper .one-col-feature h3 a,.wrapper .one-col-feature p a,.wrapper .one-col-feature li a{color:#438fd1}.wrapper .one-col-feature h1 a:hover,.wrapper .one-col-feature h2 a:hover,.wrapper .one-col-feature h3 a:hover,.wrapper .one-col-feature p a:hover,.wrapper .one-col-feature li a:hover{color:#2c75b5 !important}.wrapper blockquote{border-left:5px solid #aeb5bc}.wrapper .btn a{background-color:#386994;color:#fff}.wrapper .btn a:hover{color:#fff !important}.logo div{color:#606b75}.logo div a{color:#606b75}.logo div a:hover{color:#606b75 !important}.divider{background-color:#aeb5bc}.one-col-feature .border{background-color:#aeb5bc}.preheader td,.footer .inner td{color:#606b75}.wrapper .preheader a,.wrapper .footer a{color:#606b75}.wrapper .preheader a:hover,.wrapper .footer a:hover{color:#3e454b !important}.preheader .title{background-color:#bac0c6}.preheader .webversion{background-color:#b2b9c0}.emb-editor-canvas{background-color:#b7bdc4}@media (min-width:0){body{background-color:#b7bdc4}}.wrapper .footer .fblike,.wrapper .footer .tweet,.wrapper .footer .linkedinshare,.wrapper .footer .forwardtoafriend{background-color:#636669}</style><meta name=\"robots\" content=\"noindex,nofollow\" /><meta property=\"og:title\" content=\"My First Campaign\" /></head><!--[if mso]>  <body class=\"mso\"><![endif]--><!--[if !mso]><!-->  <body class=\"full-padding\" style=\"margin: 0;padding: 0;min-width: 100%;background-color: #c5cbd1;\"><!--<![endif]-->    <center class=\"wrapper\" style=\"display: table;table-layout: fixed;width: 100%;min-width: 620px;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;background-color: #c5cbd1;\">      <table class=\"preheader\" style=\"border-collapse: collapse;border-spacing: 0;font-size: 11px;line-height: 17px;width: 100%;\">        <tbody><tr>          <td class=\"title\" style=\"padding: 9px;vertical-align: top;font-family: Avenir,sans-serif;color: #606b75;text-align: left;width: 50%;background-color: #bac0c6;\">                      </td>          <td class=\"webversion\" style=\"padding: 9px;vertical-align: top;font-family: Avenir,sans-serif;color: #606b75;text-align: right;width: 50%;background-color: #b2b9c0;\">            No Images? <webversion>Click here</webversion>          </td>        </tr>      </tbody></table>                      <table class=\"one-col-bg\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%;\">            <tbody><tr>              <td style=\"padding: 0;vertical-align: top;\" align=\"center\">                <table class=\"one-col centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;background-color: #ffffff;table-layout: fixed;\" emb-background-style>                  <tbody><tr>                    <td class=\"column\" style=\"padding: 0;vertical-align: top;text-align: left;\">                                  <div class=\"image\" style=\"font-size: 12px;mso-line-height-rule: at-least;font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 0;font-family: Avenir,sans-serif;color: #8e8e8e;\" align=\"center\">              <img class=\"gnd-corner-image gnd-corner-image-center gnd-corner-image-top\" style=\"border: 0;-ms-interpolation-mode: bicubic;display: block;max-width: 900px;\" src=\"images/audi-car-clouds-23943.jpg\" alt=\"\" width=\"600\" height=\"314\" />            </div>                                  <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 32px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                              <h2 style=\"font-style: normal;font-weight: 500;Margin-bottom: 0;Margin-top: 25px;font-size: 24px;line-height: 32px;font-family: Avenir,sans-serif;color: #44596b;text-align: center;\"><strong style=\"font-weight: bold;\">The all-new Model 232i</strong></h2><blockquote style=\"font-style: italic;font-weight: 400;Margin-left: 0;Margin-right: 0;padding-right: 0;Margin-bottom: 25px;Margin-top: 12px;border-left: 5px solid #aeb5bc;padding-left: 16px;\"><p style=\"font-style: normal;font-weight: 400;Margin-bottom: 25px;Margin-top: 0;font-size: 16px;line-height: 25px;font-family: Avenir,sans-serif;color: #8e8e8e;\">Come join us for our holiday special event to debut the all new Model 232i's at the Sunnyvale dealership location. Bring the whole family and test drive the new models.&nbsp;</p></blockquote>                            </td>                          </tr>                        </tbody></table>                                              <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 32px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                                          <div class=\"btn btn--center\" style=\"Margin-bottom: 0;Margin-top: 0;text-align: center;\">              <![if !mso]><a style=\"border-radius: 3px;display: inline-block;font-size: 14px;font-weight: 700;line-height: 24px;padding: 13px 35px 12px 35px;text-align: center;text-decoration: none !important;transition: opacity 0.2s ease-in;font-family: Avenir,sans-serif;background-color: #386994;color: #fff;\" href=\"http://google.com\">REGISTER NOW</a><![endif]>            <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://google.com\" style=\"width:180px\" arcsize=\"7%\" fillcolor=\"#386994\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,12px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#FFFFFF;font-family:sans-serif;font-weight:700;mso-line-height-rule:exactly;mso-text-raise:4px\">REGISTER NOW</center></v:textbox></v:roundrect><![endif]--></div>                                      </td>                          </tr>                        </tbody></table>                                            <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div>                    </td>                  </tr>                </tbody></table>              </td>            </tr>          </tbody></table>                  <table class=\"two-col-bg\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%;\">            <tbody><tr>              <td style=\"padding: 0;vertical-align: top;\" align=\"center\">                <table class=\"two-col centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;background-color: #ffffff;table-layout: fixed;\" emb-background-style>                  <tbody><tr>                    <td class=\"column first\" style=\"padding: 0;vertical-align: top;text-align: left;width: 300px;\">                      <div><div class=\"column-top\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div></div>                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 32px;padding-right: 16px;word-break: break-word;word-wrap: break-word;\">                                          <div class=\"image\" style=\"font-size: 12px;mso-line-height-rule: at-least;font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 0;font-family: Avenir,sans-serif;color: #8e8e8e;\" align=\"center\">              <img style=\"border: 0;-ms-interpolation-mode: bicubic;display: block;max-width: 480px;\" src=\"images/car-fast-power-3658-828x55011.jpg\" alt=\"\" width=\"252\" height=\"252\" />            </div>                                      </td>                          </tr>                        </tbody></table>                                            <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div>                    </td>                    <td class=\"column second\" style=\"padding: 0;vertical-align: top;text-align: left;width: 300px;\">                      <div><div class=\"column-top\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div></div>                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 16px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                              <h2 style=\"font-style: normal;font-weight: 500;Margin-bottom: 0;Margin-top: 0;font-size: 24px;line-height: 32px;font-family: Avenir,sans-serif;color: #44596b;\"><strong style=\"font-weight: bold;\">Model 247i</strong></h2><p style=\"font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 12px;font-size: 16px;line-height: 25px;font-family: Avenir,sans-serif;color: #8e8e8e;\">Price: $70,500<br />Engine: 2.4L</p><h3 style=\"font-style: normal;font-weight: 700;Margin-bottom: 0;Margin-top: 28px;font-size: 14px;line-height: 22px;font-family: Avenir,sans-serif;color: #44596b;\">ANCAP RATING</h3><h1 style=\"font-style: normal;font-weight: 500;Margin-bottom: 18px;Margin-top: 10px;font-size: 36px;line-height: 44px;font-family: Avenir,sans-serif;color: #44596b;\">&#9733;&#9733;&#9733;&#9733;&#9733;</h1>                            </td>                          </tr>                        </tbody></table>                                              <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 16px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                                          <div class=\"btn btn--left\" style=\"Margin-bottom: 0;Margin-top: 0;text-align: left;\">              <![if !mso]><a style=\"border-radius: 3px;display: inline-block;font-size: 12px;font-weight: 700;line-height: 22px;padding: 10px 28px;text-align: center;text-decoration: none !important;transition: opacity 0.2s ease-in;font-family: Avenir,sans-serif;background-color: #386994;color: #fff;\" href=\"http://test.com\">REQUEST A BROCHURE</a><![endif]>            <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://test.com\" style=\"width:198px\" arcsize=\"8%\" fillcolor=\"#386994\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,9px,0px,9px\"><center style=\"font-size:12px;line-height:22px;color:#FFFFFF;font-family:sans-serif;font-weight:700;mso-line-height-rule:exactly;mso-text-raise:4px\">REQUEST A<br>BROCHURE</center></v:textbox></v:roundrect><![endif]--></div>                                      </td>                          </tr>                        </tbody></table>                                            <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div>                    </td>                  </tr>                </tbody></table>              </td>            </tr>          </tbody></table>                  <table class=\"two-col-bg\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%;\">            <tbody><tr>              <td style=\"padding: 0;vertical-align: top;\" align=\"center\">                <table class=\"two-col centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;background-color: #ffffff;table-layout: fixed;\" emb-background-style>                  <tbody><tr>                    <td class=\"column first\" style=\"padding: 0;vertical-align: top;text-align: left;width: 300px;\">                      <div><div class=\"column-top\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div></div>                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 32px;padding-right: 16px;word-break: break-word;word-wrap: break-word;\">                                          <div class=\"image\" style=\"font-size: 12px;mso-line-height-rule: at-least;font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 0;font-family: Avenir,sans-serif;color: #8e8e8e;\" align=\"center\">              <img style=\"border: 0;-ms-interpolation-mode: bicubic;display: block;max-width: 480px;\" src=\"images/audi-cabriolet-car-2568-829x55011.jpg\" alt=\"\" width=\"252\" height=\"252\" />            </div>                                      </td>                          </tr>                        </tbody></table>                                            <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div>                    </td>                    <td class=\"column second\" style=\"padding: 0;vertical-align: top;text-align: left;width: 300px;\">                      <div><div class=\"column-top\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div></div>                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 16px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                              <h2 style=\"font-style: normal;font-weight: 500;Margin-bottom: 0;Margin-top: 0;font-size: 24px;line-height: 32px;font-family: Avenir,sans-serif;color: #44596b;\"><strong style=\"font-weight: bold;\">Model 236i</strong></h2><p style=\"font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 12px;font-size: 16px;line-height: 25px;font-family: Avenir,sans-serif;color: #8e8e8e;\">Price: $70,500<br />Engine: 2.4L</p><h3 style=\"font-style: normal;font-weight: 700;Margin-bottom: 0;Margin-top: 28px;font-size: 14px;line-height: 22px;font-family: Avenir,sans-serif;color: #44596b;\">ANCAP RATING</h3><h1 style=\"font-style: normal;font-weight: 500;Margin-bottom: 18px;Margin-top: 10px;font-size: 36px;line-height: 44px;font-family: Avenir,sans-serif;color: #44596b;\">&#9733;&#9733;&#9733;&#9733;&#9733;</h1>                            </td>                          </tr>                        </tbody></table>                                              <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 16px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                                          <div class=\"btn btn--left\" style=\"Margin-bottom: 0;Margin-top: 0;text-align: left;\">              <![if !mso]><a style=\"border-radius: 3px;display: inline-block;font-size: 12px;font-weight: 700;line-height: 22px;padding: 10px 28px;text-align: center;text-decoration: none !important;transition: opacity 0.2s ease-in;font-family: Avenir,sans-serif;background-color: #386994;color: #fff;\" href=\"http://test.com\">REQUEST A BROCHURE</a><![endif]>            <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://test.com\" style=\"width:198px\" arcsize=\"8%\" fillcolor=\"#386994\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,9px,0px,9px\"><center style=\"font-size:12px;line-height:22px;color:#FFFFFF;font-family:sans-serif;font-weight:700;mso-line-height-rule:exactly;mso-text-raise:4px\">REQUEST A<br>BROCHURE</center></v:textbox></v:roundrect><![endif]--></div>                                      </td>                          </tr>                        </tbody></table>                                            <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div>                    </td>                  </tr>                </tbody></table>              </td>            </tr>          </tbody></table>                  <table class=\"two-col-bg\" style=\"border-collapse: collapse;border-spacing: 0;width: 100%;\">            <tbody><tr>              <td style=\"padding: 0;vertical-align: top;\" align=\"center\">                <table class=\"two-col centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;background-color: #ffffff;table-layout: fixed;\" emb-background-style>                  <tbody><tr>                    <td class=\"column first\" style=\"padding: 0;vertical-align: top;text-align: left;width: 300px;\">                      <div><div class=\"column-top\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div></div>                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 32px;padding-right: 16px;word-break: break-word;word-wrap: break-word;\">                                          <div class=\"image\" style=\"font-size: 12px;mso-line-height-rule: at-least;font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 0;font-family: Avenir,sans-serif;color: #8e8e8e;\" align=\"center\">              <img style=\"border: 0;-ms-interpolation-mode: bicubic;display: block;max-width: 480px;\" src=\"images/kaboompics.com_Cleaning-of-wheels.png\" alt=\"\" width=\"252\" height=\"252\" />            </div>                                      </td>                          </tr>                        </tbody></table>                                            <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div>                    </td>                    <td class=\"column second\" style=\"padding: 0;vertical-align: top;text-align: left;width: 300px;\">                      <div><div class=\"column-top\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div></div>                        <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 16px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                              <h2 style=\"font-style: normal;font-weight: 500;Margin-bottom: 0;Margin-top: 0;font-size: 24px;line-height: 32px;font-family: Avenir,sans-serif;color: #44596b;\"><strong style=\"font-weight: bold;\">Model 449i</strong></h2><p style=\"font-style: normal;font-weight: 400;Margin-bottom: 0;Margin-top: 12px;font-size: 16px;line-height: 25px;font-family: Avenir,sans-serif;color: #8e8e8e;\">Price: $100,500<br />Engine: 2.4L</p><h3 style=\"font-style: normal;font-weight: 700;Margin-bottom: 0;Margin-top: 28px;font-size: 14px;line-height: 22px;font-family: Avenir,sans-serif;color: #44596b;\">ANCAP RATING</h3><h1 style=\"font-style: normal;font-weight: 500;Margin-bottom: 18px;Margin-top: 10px;font-size: 36px;line-height: 44px;font-family: Avenir,sans-serif;color: #44596b;\">&#9733;&#9733;&#9733;&#9733;&#9733;</h1>                            </td>                          </tr>                        </tbody></table>                                              <table class=\"contents\" style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%;\">                          <tbody><tr>                            <td class=\"padded\" style=\"padding: 0;vertical-align: top;padding-left: 16px;padding-right: 32px;word-break: break-word;word-wrap: break-word;\">                                          <div class=\"btn btn--left\" style=\"Margin-bottom: 0;Margin-top: 0;text-align: left;\">              <![if !mso]><a style=\"border-radius: 3px;display: inline-block;font-size: 12px;font-weight: 700;line-height: 22px;padding: 10px 28px;text-align: center;text-decoration: none !important;transition: opacity 0.2s ease-in;font-family: Avenir,sans-serif;background-color: #386994;color: #fff;\" href=\"http://test.com\">REQUEST A BROCHURE</a><![endif]>            <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://test.com\" style=\"width:198px\" arcsize=\"8%\" fillcolor=\"#386994\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,9px,0px,9px\"><center style=\"font-size:12px;line-height:22px;color:#FFFFFF;font-family:sans-serif;font-weight:700;mso-line-height-rule:exactly;mso-text-raise:4px\">REQUEST A<br>BROCHURE</center></v:textbox></v:roundrect><![endif]--></div>                                      </td>                          </tr>                        </tbody></table>                                            <div class=\"column-bottom\" style=\"font-size: 34px;line-height: 34px;transition-timing-function: cubic-bezier(0, 0, 0.2, 1);transition-duration: 150ms;transition-property: all;\">&nbsp;</div>                    </td>                  </tr>                </tbody></table>              </td>            </tr>          </tbody></table>                  <div class=\"spacer\" style=\"font-size: 1px;line-height: 34px;width: 100%;\">&nbsp;</div>              <table class=\"footer centered\" style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 100%;\">        <tbody><tr>          <td style=\"padding: 0;vertical-align: top;\">&nbsp;</td>          <td class=\"inner\" style=\"padding: 58px 0 29px 0;vertical-align: top;width: 600px;\">            <table class=\"right\" style=\"border-collapse: collapse;border-spacing: 0;\" align=\"right\">              <tbody><tr>                <td style=\"padding: 0;vertical-align: top;color: #606b75;font-size: 12px;line-height: 22px;max-width: 200px;mso-line-height-rule: at-least;\">                  <div class=\"sharing\">                    <div style=\"Margin-bottom: 5px;\">                      <fblike class=\"fblike\" style=\"font-family: Avenir,sans-serif;background-image: url(https://i3.createsend1.com/static/eb/master/08-tint/imgf/fblike.png);background-repeat: no-repeat;background-size: 200px 56px;border-radius: 2px;color: #ffffff;display: block;font-size: 11px;font-weight: bold;line-height: 11px;padding: 8px 11px 7px 28px;text-align: left;text-decoration: none;background-color: #636669;\" cs-button data-width=\"70\" left-align-text=\"true\">                        Like                      </fblike>                    </div>                    <div style=\"Margin-bottom: 5px;\">                      <tweet class=\"tweet\" style=\"font-family: Avenir,sans-serif;background-image: url(https://i4.createsend1.com/static/eb/master/08-tint/imgf/tweet.png);background-repeat: no-repeat;background-size: 200px 56px;border-radius: 2px;color: #ffffff;display: block;font-size: 11px;font-weight: bold;line-height: 11px;padding: 8px 11px 7px 28px;text-align: left;text-decoration: none;background-color: #636669;\" cs-button data-width=\"70\" left-align-text=\"true\">                        Tweet                      </tweet>                    </div>                                                          </div>                </td>              </tr>            </tbody></table>            <table class=\"left\" style=\"border-collapse: collapse;border-spacing: 0;\" align=\"left\">              <tbody><tr>                <td style=\"padding: 0;vertical-align: top;color: #606b75;font-size: 12px;line-height: 22px;text-align: left;width: 400px;\">                  <div class=\"links emb-web-links\" style=\"line-height: 26px;Margin-bottom: 26px;mso-line-height-rule: at-least;\">                                      </div>                  <div class=\"address\" style=\"font-family: Avenir,sans-serif;Margin-bottom: 18px;\">                                      </div>                  <div class=\"permission\" style=\"font-family: Avenir,sans-serif;\">                                      </div>                  <div class=\"campaign\" style=\"font-family: Avenir,sans-serif;Margin-bottom: 18px;\">                    <span>                      <preferences lang=\"en\">Preferences</preferences>                      &nbsp;&nbsp;|&nbsp;&nbsp;                    </span>                    <unsubscribe>Unsubscribe</unsubscribe>                  </div>                </td>              </tr>            </tbody></table>          </td>          <td style=\"padding: 0;vertical-align: top;\">&nbsp;</td>        </tr>      </tbody></table>    </center>  </body></html>";
		
		List<TAttachedFile> files = new ArrayList<TAttachedFile>();
		
		TAttachedFile file = new TAttachedFile();
		file.setFileName("File1");
		file.setFileExtension("xlsx");
		file.setAttachedFileId(1);
		files.add(file);
		
		file = new TAttachedFile();
		file.setFileName("File2");
		file.setFileExtension("docx");
		file.setAttachedFileId(2);
		files.add(file);
		
		file = new TAttachedFile();
		file.setFileName("File3");
		file.setFileExtension("pdf");
		file.setAttachedFileId(2);
		files.add(file);
		
		map.put("html", html);
		map.put("filesList", files);
		
		return map;
	}

	public TUser getUser(String userName, String password){
		TUser user = null;
		
		if(userName.equals("latbcuser") && password.equals("111")){
			user = new TUser();
			user.setCatProfile(1);
			user.setUserId(100);
			user.setFirstName("userName");
			user.setLastName1("lastName1");
			user.setLastName2("lastName2");
			user.setFullName(user.getFirstName() + " " + user.getLastName1() + " " + user.getLastName2());
			user.setEmail("user@latbc.com.mx");
			user.setTjCardNumber("100022030909378");
		}
		else if(userName.equals("latbcadmin") && password.equals("111")){
			user = new TUser();
			user.setCatProfile(0);
			user.setUserId(100);
			user.setFirstName("userName");
			user.setLastName1("lastName1");
			user.setLastName2("lastName2");
			user.setFullName(user.getFirstName() + " " + user.getLastName1() + " " + user.getLastName2());
			user.setEmail("user@latbc.com.mx");
			user.setTjCardNumber("100022030909378");
		}
		
		return user;
		
	}
	
	public List<TypeTransaccion> getLastTransactions(){
		
		List<TypeTransaccion> lastTransactions = new ArrayList<TypeTransaccion>();
		TypeTransaccion lastTransaction;
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-230));
		lastTransaction.setAcceptorName("Comercial Mexicana S.A. de C.V.");
		lastTransactions.add(lastTransaction);
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-433));
		lastTransaction.setAcceptorName("OXXO S.A. de C.V.");
		lastTransactions.add(lastTransaction);
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-610));
		lastTransaction.setAcceptorName("Farmacia Guadalajara");
		lastTransactions.add(lastTransaction);		
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-433));
		lastTransaction.setAcceptorName("OXXO S.A. de C.V.");
		lastTransactions.add(lastTransaction);
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-610));
		lastTransaction.setAcceptorName("Farmacia Guadalajara");
		lastTransactions.add(lastTransaction);		
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-433));
		lastTransaction.setAcceptorName("OXXO S.A. de C.V.");
		lastTransactions.add(lastTransaction);
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-610));
		lastTransaction.setAcceptorName("Farmacia Guadalajara");
		lastTransactions.add(lastTransaction);		
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-433));
		lastTransaction.setAcceptorName("OXXO S.A. de C.V.");
		lastTransactions.add(lastTransaction);
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-610));
		lastTransaction.setAcceptorName("Farmacia Guadalajara");
		lastTransactions.add(lastTransaction);		
		
		lastTransaction = new TypeTransaccion();
		lastTransaction.setTransactionDate ("20151029 72236");
		lastTransaction.setAmount(new Double(-433));
		lastTransaction.setAcceptorName("OXXO S.A. de C.V.");
		lastTransactions.add(lastTransaction);
		
		return lastTransactions;
	}

public List<CampaignDetailAdminBean> getCampaignsAdmin(){
		
		List<CampaignDetailAdminBean> campaigns= new ArrayList<CampaignDetailAdminBean>();
		Date date = new Date(115,11,1,0,0,0);
		
		List<String> classifications;
		CampaignDetailAdminBean campaign;
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa A");
		classifications.add("Subprograma A");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailAdminBean();
		campaign.setCampaignId(0);
		campaign.setCampaignName("campaign Name A");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
		campaign.setStatus("Activa");
		campaign.setTotalWon("$ 0.00");
		campaign.setTotalScattered("$ 0.00");
		
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa A");
		classifications.add("Subprograma B");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailAdminBean();
		campaign.setCampaignId(1);
		campaign.setCampaignName("campaign Name B");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
		campaign.setStatus("Activa");
		campaign.setTotalWon("$ 0.00");
		campaign.setTotalScattered("$ 0.00");
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa B");
		classifications.add("Subprograma C");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailAdminBean();
		campaign.setCampaignId(2);
		campaign.setCampaignName("campaign Name C");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
		campaign.setStatus("Activa");
		campaign.setTotalWon("$ 0.00");
		campaign.setTotalScattered("$ 0.00");
		
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa B");
		classifications.add("Subprograma D");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailAdminBean();
		campaign.setCampaignId(3);
		campaign.setCampaignName("campaign Name D");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
		campaign.setStatus("Activa");
		campaign.setTotalWon("$ 0.00");
		campaign.setTotalScattered("$ 0.00");
			
		campaigns.add(campaign);
		
		
		classifications = new ArrayList<String>();
		classifications.add("Compañia A");
		classifications.add("Programa C");
		classifications.add("Subprograma E");
		classifications.add("Unidad A");
		
		campaign = new CampaignDetailAdminBean();
		campaign.setCampaignId(4);
		campaign.setCampaignName("campaign Name E");
		campaign.setStartDate(date);
		campaign.setEndDate(date);
		campaign.setClassification(classifications);
		campaign.setStatus("Activa");
		campaign.setTotalWon("$ 0.00");
		campaign.setTotalScattered("$ 0.00");
		
		campaigns.add(campaign);
		
		return campaigns;
	}

	public List<SelectClassificationCampaignBean> getClassificationsList(){
		
		List<SelectClassificationCampaignBean> list = new ArrayList<SelectClassificationCampaignBean>();
		
		SelectClassificationCampaignBean item = new SelectClassificationCampaignBean();
		item.setId(-1);
		item.setName("Ninguno");
		list.add(item);
		
		item = new SelectClassificationCampaignBean();
		item.setId(1);
		item.setName("Opcion 1");
		list.add(item);
		
		item = new SelectClassificationCampaignBean();
		item.setId(2);
		item.setName("Opcion 2");
		list.add(item);
		
		item = new SelectClassificationCampaignBean();
		item.setId(3);
		item.setName("Opcion 2");
		list.add(item);
		
		item = new SelectClassificationCampaignBean();
		item.setId(-2);
		item.setName("Añadir nuevo");
		list.add(item);
		
		return list;
	}
}
