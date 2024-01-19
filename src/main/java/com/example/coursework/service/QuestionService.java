package com.example.coursework.service;

import com.example.coursework.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
@Service
public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
