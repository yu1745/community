package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GithubUser {
    private Long id;
    private String name;
    private String bio;
    private String avatarUrl;
}
