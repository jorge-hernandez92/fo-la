package com.twobig.sivale.service.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HTMLParserServiceImplTest {

	@Test
	public void getHTML() {
		HTMLParserServiceImpl htmlParser = new HTMLParserServiceImpl();
		String data = "{\"BONO 1\":\" $-   \",\"ID STARS GERENTE\":\"000983868\",\"CONCATENADO\":\"M1188SLSMGR\",\"BONO TOTAL\":\" $-   \",\"Ajustado\":\"38 \",\"APELLIDO\":\"GALEANA SOBERANIS\",\"Abs\":\"29%\",\"NOMBRE GERENTE\":\"MICAELA\",\"x\":\"29.00%\",\"BID\":\"M1188\",\"CVP\":\"0\",\"Original\":\"38 \",\"BONO 2\":\" $-   \",\"Razón Social\":\"Acapulco, S.A.\",\"Volumen\":\"11 \"}";
		String html = htmlParser.getHTML("src/test/resources/template.html", data);
		assertNotNull("html Null", html);
		System.out.println(html);
	}
	
	@Test
	public void getHTML_Null() {
		HTMLParserServiceImpl htmlParser = new HTMLParserServiceImpl();
		String data = null;
		String html = htmlParser.getHTML("src/test/resources/template.html", data);
		assertNotNull("html Null", html);
		System.out.println(html);
	}
}
