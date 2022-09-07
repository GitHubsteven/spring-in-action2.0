package pers.asa.spring.boot.upload.file.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/10/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/6/24 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping(value = "/upload")
    public String upload(MultipartFile file) {
        return String.valueOf(file.getSize());
    }

}
