package com.example.coursework.service.impl;

import com.example.coursework.exception.InvalidAmountQuestionException;
import com.example.coursework.model.Question;
import com.example.coursework.service.ExaminerService;
import com.example.coursework.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new InvalidAmountQuestionException("Количество вопросов в задании превышает количество вопросов в базе данных.");
        }
        Set<Question> examQuestions= new HashSet<>();
        while (examQuestions.size() < amount) {
            examQuestions.add(questionService.getRandomQuestion());
        }
        return examQuestions;
    }
}
