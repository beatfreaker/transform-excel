package com.example.demo.controller;

import com.example.demo.service.ApiService;
import com.example.demo.service.ProcessExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileUploadController {

    @Autowired
    ProcessExcelService service;

    @Autowired
    ApiService apiService;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        String filePath = service.writeToTempDir(file);
        String json = service.processExcelFile(filePath);
        apiService.callAPI(json);
        return "uploaded to " + filePath;
    }
}
