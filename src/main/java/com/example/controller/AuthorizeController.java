package com.example.controller;

import com.example.dto.AccessTokenDTO;
import com.example.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider provider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state) {
        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setCode(code);
        dto.setState(state);
        dto.setRedirect_uri(redirectUri);
        dto.setClient_id(clientId);
        dto.setState(String.valueOf(new Random().nextInt()));
        dto.setClient_secret(clientSecret);
        System.out.println(provider.getUser(provider.getAccessToken(dto)));
        return "index";
    }
}
