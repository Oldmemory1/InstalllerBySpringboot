package org.example.installerbyspringboot.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:settings.properties", encoding = "UTF-8")
public class Utility {
    @Value("${file1.name}")
    private String name1;
    @Value("${file2.name}")
    private String name2;
    @Value("${file3.name}")
    private String name3;

    public String getDownload_file1_name() {
        return name1;
    }
    public String getDownload_file2_name() {
        return name2;
    }
    public String getDownload_file3_name(){
        return name3;
    }
}
