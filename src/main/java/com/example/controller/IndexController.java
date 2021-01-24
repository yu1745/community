package com.example.controller;

import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping({"index", "index.html"})
    String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies)
            if ("token".equals(c.getName()))
                request.getSession().setAttribute("user", userMapper.findByToken(c.getValue()));
        return "index";
    }
}
