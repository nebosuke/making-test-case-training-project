package com.kanjinumbers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexPageController {

    @RequestMapping("/")
    public void handleError(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

}
