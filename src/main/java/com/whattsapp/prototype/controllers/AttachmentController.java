package com.whattsapp.prototype.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/files")
public class AttachmentController {


    public  final String VIDEO_URL="C:\\whattsapmessengerapp\\src\\main\\resources\\static\\root\\videos";


    public  final String PICTURE_URL="C:\\whattsapmessengerapp\\src\\main\\resources\\static\\root\\image";


    public static final Logger logger= LoggerFactory.getLogger(AttachmentController.class);

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")  MultipartFile file) throws IOException {

         upload(file);

        return ResponseEntity.status(HttpStatus.OK).body("working");



    }
/*

UTILITY METHOD

 */
    public String upload(MultipartFile file) throws IOException {

        if (file.getContentType().equals("image/jpeg")){

              InputStream ios =file.getInputStream();
              byte data [] =new byte[ios.available()];
              ios.read(data);

              //write
            FileOutputStream fileOutputStream=new FileOutputStream(PICTURE_URL+"\\"+file.getOriginalFilename());




        } else if (file.getContentType().equals("video/mp4")) {
            InputStream ios =file.getInputStream();
            byte data [] =new byte[ios.available()];
            ios.read(data);

            //write
            FileOutputStream fileOutputStream=new FileOutputStream(VIDEO_URL+"\\"+file.getOriginalFilename());

        }

        else {

            logger.info("Unsupported content type");

        }
   return "success";
    }

}
