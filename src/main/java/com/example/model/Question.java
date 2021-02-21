package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private Long id;

    private String title;

    private Long gmtCreate;

    private Long gmtModified;

    private Long creator;

    private int commentCount;

    private int viewCount;

    private int likeCount;

    private String tag;

    private int sticky;

    private String description;

}