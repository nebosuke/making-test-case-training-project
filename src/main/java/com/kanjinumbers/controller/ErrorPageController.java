package com.kanjinumbers.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<String> handleError() {
        return new ResponseEntity<String>("https://github.com/nebosuke/making-test-case-training-project",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
