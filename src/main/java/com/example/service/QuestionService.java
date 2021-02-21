package com.example.service;

import com.example.dto.QuestionDTO;
import com.example.mapper.QuestionMapper;
import com.example.mapper.UserMapper;
import com.example.model.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list(){
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> list = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            QuestionDTO dto = new QuestionDTO();
            BeanUtils.copyProperties(questions.get(i),dto);
            dto.setUser(userMapper.findById(questions.get(i).getCreator()));
            list.add(dto);
        }
        return list;
    }
}
