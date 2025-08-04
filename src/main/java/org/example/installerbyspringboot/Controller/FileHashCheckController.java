package org.example.installerbyspringboot.Controller;

import org.example.installerbyspringboot.Component.Utility;
import org.example.installerbyspringboot.Utils.MD5Calculator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
public class FileHashCheckController {
    private final Utility utility;

    public FileHashCheckController(Utility utility) {
        this.utility = utility;
    }

    @GetMapping("/file_hash_check")
    public String fileHashCheck(Model model) throws IOException, NoSuchAlgorithmException {
        Resource file1 = new ClassPathResource("files/"+utility.getDownload_file1_name());
        MD5Calculator calculator1 = new MD5Calculator(file1,"md5");
        String file1_md5_hash = calculator1.getFileHash();
        model.addAttribute("file1_md5_hash",file1_md5_hash);

        Resource file2 = new ClassPathResource("files/"+utility.getDownload_file2_name());
        MD5Calculator calculator2 = new MD5Calculator(file2,"md5");
        String file2_md5_hash = calculator2.getFileHash();
        model.addAttribute("file2_md5_hash",file2_md5_hash);

        Resource file3 = new ClassPathResource("files/"+utility.getDownload_file3_name());
        MD5Calculator calculator3 = new MD5Calculator(file3,"md5");
        String file3_md5_hash = calculator3.getFileHash();
        model.addAttribute("file3_md5_hash",file3_md5_hash);
        return "file-hash-check";
    }
}
