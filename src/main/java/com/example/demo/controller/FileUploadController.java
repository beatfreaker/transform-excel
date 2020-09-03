package com.example.demo.controller;

import com.example.demo.service.ProcessExcelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileUploadController {

    @Inject
    ProcessExcelService service;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        String filePath = service.writeToTempDir(file);
        service.processExcelFile(filePath);
        return "uploaded to " + filePath;
    }
}
