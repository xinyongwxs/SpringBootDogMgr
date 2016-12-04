package com.wxs.management.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping(value = "/upload")
public class FileUploadController {
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> handleFileUpload(HttpServletRequest request){  
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        for (int i =0; i< files.size(); ++i) {  
            MultipartFile file = files.get(i);  
            String name = file.getName();  
            if (!file.isEmpty()) {  
                try {  
                    byte[] bytes = file.getBytes();  
                    BufferedOutputStream stream =  
                            new BufferedOutputStream(new FileOutputStream(new File(name + i)));  
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {  
                    return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);  
                }
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);  
            }  
        }  
        return new ResponseEntity<Void>(HttpStatus.CREATED);  
    } 
}
