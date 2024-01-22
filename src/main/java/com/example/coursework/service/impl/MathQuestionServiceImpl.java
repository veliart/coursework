package com.example.coursework.service.impl;

import com.example.coursework.model.Question;
import com.example.coursework.repository.impl.MathQuestionRepositoryImpl;
import com.example.coursework.service.QuestionService;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionServiceImpl implements QuestionService {
    private final MathQuestionRepositoryImpl mathQuestionRepository;
    private final Random random = new Random();

    public MathQuestionServiceImpl(MathQuestionRepositoryImpl mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }
    public int getSizeQuestionRepository() {
        int sizeOfMathQuestionRepository = mathQuestionRepository.getAll().size();
        return sizeOfMathQuestionRepository;
    }
    @Override
    public Question getRandomQuestion() {

        int randomIndex = random.nextInt(getSizeQuestionRepository()); // результат nextInt < question.size
        ArrayList<Question> arrayQuestions = new ArrayList<>(mathQuestionRepository.getAll());
        return arrayQuestions.get(randomIndex);
    }
}
