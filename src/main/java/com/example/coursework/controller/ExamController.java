package com.example.coursework.controller;

import com.example.coursework.model.Question;
import com.example.coursework.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(value = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
