package com.twobig.sivale.utils;

import java.io.IOException;

import sun.misc.BASE64Encoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;

public class ImageUtils {
	
	
	public  String encodeToString(BufferedImage image, String type) {
		String imageString = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {
			ImageIO.write(image, type, bos);
			byte[] imageBytes = bos.toByteArray();

			BASE64Encoder encoder = new BASE64Encoder();
			imageString = encoder.encode(imageBytes);

			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageString;
	}
	
	public String imageToBase64(String path) throws IOException{
		
		String extension = FilenameUtils.getExtension(path);
		
		BufferedImage img = ImageIO.read(new File(path));
		BufferedImage newImg;
		String imgstr;
		imgstr = encodeToString(img, extension);
		
		String result = imgstr.replaceAll("[\r\n]+", ""); 
		
		System.out.println(result);
		
		return result;
	}
	
//	public static void main (String args[]) throws IOException {
//		/* Test image to string and string to image start */
//		
//		String path = "images/im1.png";
//		
//		System.out.println(imageToBase64(path));
//
//	}

}
