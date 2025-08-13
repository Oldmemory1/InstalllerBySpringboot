package org.example.installerbyspringboot.Component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@PropertySource(value = "classpath:settings.properties", encoding = "UTF-8")
public class Utility {
    @Value("${file1.name}")
    private String name1;
    @Value("${file2.name}")
    private String name2;
    @Value("${file3.name}")
    private String name3;
    @Value("${merger.name}")
    private String mergerName;


}
