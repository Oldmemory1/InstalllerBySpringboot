package org.example.installerbyspringboot.Controller;

import lombok.extern.java.Log;
import org.example.installerbyspringboot.Component.Utility;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
@Log
@Controller
public class FileDownloadController {
    private final Utility utility;

    public FileDownloadController(Utility utility) {
        this.utility = utility;
    }

    // 提供下载页面的HTML
    @GetMapping("/download")
    public String downloadPage() {
        return "download-page"; // 对应src/main/resources/templates/download-page.html
    }

    // 处理文件下载请求
    @GetMapping("/download_file")
    public ResponseEntity<Resource> downloadFile() throws IOException {
        // 从classpath加载文件资源
        log.info("下载文件名:"+utility.getDownload_file1_name());

        Resource resource = new ClassPathResource(utility.getDownload_file1_name());

        // 验证文件存在
        if (!resource.exists()) {
            throw new RuntimeException("文件未找到: data.exe");
        }

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.exe");
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
