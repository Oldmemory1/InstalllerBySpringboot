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

    @GetMapping("/download")
    public String downloadPage() {
        return "download-page"; // 对应src/main/resources/templates/download-page.html
    }


    @GetMapping("/download_file1")
    public ResponseEntity<Resource> downloadFile1() throws IOException {
        // 从classpath加载文件资源
        log.info("下载文件名:"+utility.getName1());

        Resource resource = new ClassPathResource("files/"+utility.getName1());

        // 验证文件存在
        if (!resource.exists()) {
            throw new RuntimeException("文件未找到:"+utility.getName1());
        }

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+utility.getName1());
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/download_file2")
    public ResponseEntity<Resource> downloadFile2() throws IOException {
        // 从classpath加载文件资源
        log.info("下载文件名:"+utility.getName2());

        Resource resource = new ClassPathResource("files/"+utility.getName2());

        // 验证文件存在
        if (!resource.exists()) {
            throw new RuntimeException("文件未找到:"+utility.getName2());
        }

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+utility.getName2());
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    @GetMapping("/download_file3")
    public ResponseEntity<Resource> downloadFile3() throws IOException {
        // 从classpath加载文件资源
        log.info("下载文件名:"+utility.getName3());

        Resource resource = new ClassPathResource("files/"+utility.getName3());

        // 验证文件存在
        if (!resource.exists()) {
            throw new RuntimeException("文件未找到:"+utility.getName3());
        }

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+utility.getName3());
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    @GetMapping("/download_merger")
    public ResponseEntity<Resource> downloadMerger() throws IOException {
        // 从classpath加载文件资源
        log.info("下载文件名:"+utility.getMergerName());

        Resource resource = new ClassPathResource("files/"+utility.getMergerName());

        // 验证文件存在
        if (!resource.exists()) {
            throw new RuntimeException("文件未找到:"+utility.getMergerName());
        }

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+utility.getMergerName());
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
