package com.example.coursework.service.impl;

import com.example.coursework.model.Question;
import com.example.coursework.repository.impl.JavaQuestionRepositoryImpl;
import com.example.coursework.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final JavaQuestionRepositoryImpl javaQuestionRepository;

    private final Random random = new Random();

    public JavaQuestionServiceImpl(JavaQuestionRepositoryImpl javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(javaQuestionRepository.getAll().size()); // результат nextInt < question.size
        ArrayList<Question> arrayQuestions = new ArrayList<>(javaQuestionRepository.getAll());
        return arrayQuestions.get(randomIndex);
    }
}
