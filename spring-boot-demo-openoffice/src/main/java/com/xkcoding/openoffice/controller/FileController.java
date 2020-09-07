package com.xkcoding.openoffice.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.jodconverter.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private DocumentConverter converter;

    @PostMapping("/toPdf")
    public String toPdf(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        try {
            File newFile = new File("D:/Work/Resource/file/pdf");
            if (!newFile.exists()) {
                newFile.mkdirs();
            }

            // 编码文件名
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String fileName = file.getOriginalFilename().replace(extension, "");

            // 保存原文件
            File desc = new File("D:/Work/Resource/file" + File.separator + file.getOriginalFilename());
            if (!desc.getParentFile().exists())
            {
                desc.getParentFile().mkdirs();
            }
            if (!desc.exists())
            {
                desc.createNewFile();
            }
            file.transferTo(desc);

            // 开始转换
            String pdfFileName = newFile.getPath() + File.separator + fileName + ".pdf";
            converter.convert(desc).to(new File(pdfFileName)).execute();

            ServletOutputStream outputStream = response.getOutputStream();
            FileInputStream inputStream = new FileInputStream(new File(pdfFileName));
            int i = IOUtils.copy(inputStream, outputStream);
            System.out.println(i);
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    @PostMapping("/pdfToWord")
    public String pdfToWord(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        try {
            File newFile = new File("D:/Work/Resource/file/word");
            if (!newFile.exists()) {
                newFile.mkdirs();
            }

            // 编码文件名
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String fileName = file.getOriginalFilename().replace(extension, "");

            // 保存原文件
            File desc = new File("D:/Work/Resource/file" + File.separator + file.getOriginalFilename());
            if (!desc.getParentFile().exists())
            {
                desc.getParentFile().mkdirs();
            }
            if (!desc.exists())
            {
                desc.createNewFile();
            }
            file.transferTo(desc);

            // 开始转换
            String pdfFileName = newFile.getPath() + File.separator + fileName + ".doc";
            converter.convert(desc).to(new File(pdfFileName)).execute();

            ServletOutputStream outputStream = response.getOutputStream();
            FileInputStream inputStream = new FileInputStream(new File(pdfFileName));
            int i = IOUtils.copy(inputStream, outputStream);
            System.out.println(i);
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

}
