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
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService, @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        int allSubjectQuestionsSize = javaQuestionService.getSizeQuestionRepository() + mathQuestionService.getSizeQuestionRepository(); // общее количество вопросов по двум темам
        if (allSubjectQuestionsSize < amount) {
            throw new InvalidAmountQuestionException("Количество вопросов в задании превышает количество вопросов в базе данных.");
        }
        int amountJavaQuestion = random.nextInt(amount + 1); // Получаем общее количество вопросов по Java, +1 - чтобы не исключить возможность вопросов только по одному предмету при amount =1;
        if (amountJavaQuestion > javaQuestionService.getSizeQuestionRepository()) { // Проверка, что количество вопросов по Java не превышает количество в репозитории. По математике не делаем, так как проверили сумму
            amountJavaQuestion = javaQuestionService.getSizeQuestionRepository();
        }
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
