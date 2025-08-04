package org.example.installerbyspringboot.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Utility {
    @Value("part1.bin")
    private String name1;
    @Value("part2.bin")
    private String name2;
    @Value("part3.bin")
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
