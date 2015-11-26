package com.xm.sivale.services.test;

import java.util.List;
import java.util.Map;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;

public class Test {

	public static void main(String args []){
		
		ServicesUser services = new ServicesUser();
		
		List<Map> classifications = services.getMyClassifications((Integer)1);
		List<Map> campains = services.getCampaings((Integer)1, (Integer)1);
		List<TPublication> publications = services.getPubliations((Integer)1, (Integer)1);
		Map publicationDetail = services.showPublication((Integer)1, (Integer)1);
		
		System.out.println("******************************************************");
		System.out.println(classifications.toString());
		System.out.println("******************************************************");
		System.out.println(campains.toString());
		System.out.println("******************************************************");
		System.out.println(publications.toString());
		System.out.println("******************************************************");
		System.out.println(publicationDetail.toString());
	}
}
