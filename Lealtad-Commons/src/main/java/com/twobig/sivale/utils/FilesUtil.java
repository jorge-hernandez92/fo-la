package com.twobig.sivale.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


public class FilesUtil {
	
	//private static final Logger logger = LogManager.getLogger(FilesUtil.class);

	public static void saveFile(File file, String fileName, String filesDirectory) throws IOException{
		//BasicConfigurator.configure();
		FileInputStream in = null;
        FileOutputStream out = null;
        
        File dir = new File (filesDirectory);
        if ( !dir.exists() )
           dir.mkdirs();
        
        String targetPath =  dir.getPath() + File.separator + fileName;
        //logger.info("source file path ::"+file.getAbsolutePath());
        //logger.info("saving file to ::" + targetPath);
        File destinationFile = new File ( targetPath);
        try {
            in = new FileInputStream( file );
            out = new FileOutputStream( destinationFile );
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }

        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        
	}
}
