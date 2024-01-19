package com.example.coursework.service.impl;

import com.example.coursework.exception.InvalidAmountQuestionException;
import com.example.coursework.model.Question;
import com.example.coursework.repository.impl.JavaQuestionRepositoryImpl;
import com.example.coursework.repository.impl.MathQuestionRepositoryImpl;
import com.example.coursework.service.ExaminerService;
import com.example.coursework.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionRepositoryImpl javaQuestionRepository;
    private final MathQuestionRepositoryImpl mathQuestionRepository;
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(JavaQuestionRepositoryImpl javaQuestionRepository, MathQuestionRepositoryImpl mathQuestionRepository, @Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService, @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.javaQuestionRepository = javaQuestionRepository;
        this.mathQuestionRepository = mathQuestionRepository;
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {

        int allSubjectQuestionsSize = javaQuestionRepository.getAll().size() + mathQuestionRepository.getAll().size(); // общее количество вопросов по двум темам
        if (allSubjectQuestionsSize < amount) {
            throw new InvalidAmountQuestionException("Количество вопросов в задании превышает количество вопросов в базе данных.");
        }
        int amountJavaQuestion = random.nextInt(amount + 1); // Получаем общее количество вопросов по Java, +1 - чтобы не исключить возможность вопросов ТОЛЬКО по джава
        if (amountJavaQuestion > javaQuestionRepository.getAll().size()) {
            amountJavaQuestion = javaQuestionRepository.getAll().size();
        }
        int amountMathQuestion = amount - amountJavaQuestion;
        Set<Question> examQuestions= new HashSet<>();
        while (examQuestions.size() < amountJavaQuestion) {
            examQuestions.add(javaQuestionService.getRandomQuestion());
        }
        while (examQuestions.size() < amount) {
            examQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return examQuestions;
    }
}
