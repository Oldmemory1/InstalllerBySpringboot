package org.example.installerbyspringboot.Controller;

import org.example.installerbyspringboot.Component.Utility;
import org.example.installerbyspringboot.Utils.MD5Calculator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
public class FileHashCheckController {
    private final Utility utility;

    public FileHashCheckController(Utility utility) {
        this.utility = utility;
    }

    @GetMapping("/file_hash_check")
    public String fileHashCheck(Model model) throws IOException, NoSuchAlgorithmException {
        Resource file1 = new ClassPathResource("files/"+utility.getName1());
        MD5Calculator calculator1 = new MD5Calculator(file1,"md5");
        String file1_md5_hash = calculator1.getFileHash();
        model.addAttribute("file1_md5_hash",file1_md5_hash);

        Resource file2 = new ClassPathResource("files/"+utility.getName2());
        MD5Calculator calculator2 = new MD5Calculator(file2,"md5");
        String file2_md5_hash = calculator2.getFileHash();
        model.addAttribute("file2_md5_hash",file2_md5_hash);

        Resource file3 = new ClassPathResource("files/"+utility.getName3());
        MD5Calculator calculator3 = new MD5Calculator(file3,"md5");
        String file3_md5_hash = calculator3.getFileHash();
        model.addAttribute("file3_md5_hash",file3_md5_hash);
        return "file-hash-check";
    }
    @GetMapping("api/get_file1_name")
    public ResponseEntity<?> getFile1Name(){
        return ResponseEntity.ok(
                Map.of(
                        "status","OK",
                        "message", "获取成功",
                        "data", utility.getName1()
                )
        );
    }

    @PostMapping("/api/submit_file")
    public ResponseEntity<?> submitAnswer(@RequestBody Map<String, String> requests) {
        String fileName = requests.get("fileName");
        if (fileName == null || fileName.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "ERROR",
                    "message", "文件名不能为空"
            ));
        }

        try {
            Resource file = new ClassPathResource("files/" + fileName);

            // 检查文件是否存在
            if (!file.exists() || !file.isReadable()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "status", "ERROR",
                        "message", "文件不存在或不可读取"
                ));
            }

            MD5Calculator calculator = new MD5Calculator(file, "md5");
            String fileHash = calculator.getFileHash();

            return ResponseEntity.ok(Map.of(
                    "status", "OK",
                    "message", "计算成功",
                    "data", fileHash
            ));

        } catch (NoSuchAlgorithmException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "ERROR",
                    "message", "不支持的哈希算法"
            ));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "ERROR",
                    "message", "文件读取失败"
            ));
        }
    }



}
