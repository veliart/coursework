package com.example.coursework.controller;

import com.example.coursework.model.Question;
import com.example.coursework.repository.QuestionRepository;
import com.example.coursework.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")

public class MathQuestionController {
    public final QuestionRepository questionRepository;

    public MathQuestionController(@Qualifier("mathQuestionRepositoryImpl") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/add")
    public Question add(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer) {
        return questionRepository.add(question, answer);
    }
    @GetMapping("/remove")
    public Question remove(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer) {
        return questionRepository.remove(new Question(question, answer));
    }
    @GetMapping
    public Collection<Question> allQuestions() {
        return questionRepository.getAll();
    }
}