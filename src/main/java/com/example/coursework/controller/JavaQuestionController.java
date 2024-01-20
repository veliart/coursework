package com.example.coursework.controller;

import com.example.coursework.model.Question;
import com.example.coursework.repository.QuestionRepository;
import com.example.coursework.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionRepository questionRepository;
    public JavaQuestionController(@Qualifier("javaQuestionRepositoryImpl")QuestionRepository questionRepository) {
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
