package com.example.demo.service;

import com.example.demo.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import java.util.Objects;
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

    public String processExcelFile(String fileLocation) throws Exception {
        FileInputStream excelFile = new FileInputStream(new File(fileLocation));
        Workbook workbook = new HSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        List<Data> dataList = StreamSupport.stream(sheet.spliterator(), false)
                .skip(2)
                .filter(r -> Objects.nonNull(r.getCell(0)))
                .map(r -> {
                    Data u = new Data();
                    u.setCusip(r.getCell(0).getStringCellValue());
                    u.setCategory(r.getCell(1).getStringCellValue());
                    u.setTrans(r.getCell(2).getStringCellValue());
                    u.setStatus(r.getCell(3).getStringCellValue());
                    u.setType(r.getCell(4).getStringCellValue());
                    u.setOrders(String.valueOf(r.getCell(5).getNumericCellValue()));
                    u.setQuantity((long)r.getCell(6).getNumericCellValue());
                    u.setNonBillableOrders((long)r.getCell(7).getNumericCellValue());
                    u.setQtyForNonBillableOrder((long)r.getCell(8).getNumericCellValue());
                    u.setNotional(u.getQuantity() * 1000);
                    u.setNonBillableNotional(u.getQtyForNonBillableOrder() * 1000);
                    return u;
                }).collect(Collectors.toList());
        String json = getJSON(dataList);
        System.out.println(json);
        return json;
    }

    private String getJSON(List<Data> dataList) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);
        return json;
    }
}
