package com.eik.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {

    @Value("${folder.path}")
    private String folderPath;

    public String getFolderPath() {
        return folderPath;
    }
}
