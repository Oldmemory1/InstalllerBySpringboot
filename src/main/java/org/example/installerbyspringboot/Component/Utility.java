package org.example.installerbyspringboot.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Utility {
    @Value("${download_file1.name}")
    private String name;

    public String getDownload_file1_name() {
        return name;
    }
    public void setDownload_file1_name(String name) {
        this.name = name;
    }
}
