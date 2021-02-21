package com.example.controller;

import com.example.dto.QuestionDTO;
import com.example.mapper.QuestionMapper;
import com.example.mapper.UserMapper;
import com.example.model.Question;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping({"/","index", "index.html"})
    String index(HttpServletRequest request,
                 Model model) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies)
            if ("token".equals(c.getName())) {
                request.getSession().setAttribute("user", userMapper.findByToken(c.getValue()));
                break;
            }
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
//        for (int i = 0; i < 100; i++) {
//            System.out.println("nmsl");
//        }
        return "index";
    }
}
