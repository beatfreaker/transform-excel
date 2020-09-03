package com.example.demo.service;

import com.example.demo.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProcessExcelService {

    public String writeToTempDir(MultipartFile file) throws Exception {
        String tmpdir = "C:/data/";
        InputStream in = file.getInputStream();
        File currDir = new File(tmpdir);
        String path = currDir.getAbsolutePath();
        String fileLocation = tmpdir + file.getOriginalFilename();
        FileOutputStream f = new FileOutputStream(fileLocation);
        int ch = 0;
        while ((ch = in.read()) != -1) {
            f.write(ch);
        }
        f.flush();
        f.close();
        return fileLocation;
    }

    public void processExcelFile(String fileLocation) throws Exception {
        FileInputStream excelFile = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        List<Data> dataList = StreamSupport.stream(sheet.spliterator(), false)
                .skip(1)
                .map(r -> {
                    Data u = new Data();
                    u.setId(r.getCell(0).getStringCellValue());
                    u.setQuantity(String.valueOf(r.getCell(1).getNumericCellValue()));
                    u.setAmount(String.valueOf(r.getCell(2).getNumericCellValue()));
                    u.setNonBillableQuantity(String.valueOf(r.getCell(3).getNumericCellValue()));
                    u.setNonBillableAmount(String.valueOf(r.getCell(4).getNumericCellValue()));
                    u.setNotional(r.getCell(5).getStringCellValue());
                    return u;
                }).collect(Collectors.toList());
        String json = getJSON(dataList);
        System.out.println(json);
    }

    private String getJSON(List<Data> dataList) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);
        return json;
    }
}
