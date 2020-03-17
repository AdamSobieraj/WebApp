package com.eik.config;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

@Component
public class AdminConfig {

//    @Value("${folder.path}")
    private String folderPath;

    public String getFolderPath() {

            try {

                URL u = getClass().getProtectionDomain().getCodeSource().getLocation();
                File f = new File(u.toURI());
                int position = f.toString().indexOf("target");
                String folderPathClass = f.toString().substring(0, position);
                folderPath = folderPathClass + "SampleData";
            }catch (Exception e){
            }

        return folderPath;
    }
}
