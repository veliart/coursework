package com.example.coursework.repository.impl;

import com.example.coursework.model.Question;
import com.example.coursework.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Component
@Service
public class MathQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        add("2 + 2 = ?", "4");
        add("20 - 10 = ?", "10");
        add("2 * 2 = ?", "4");
        add("10 / 2 = ?", "5");
        add("20 * 10 = ?", "200");
        add("13 + 2 = ?", "15");
        add("5 / 0 = ?", "Бесконечность");
    }

    @Override
    public Question add(String question, String answer) {
        Question addedQuestion = new Question(question, answer);
        questions.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    public Question add(Question question) {
        Question addedQuestion = question;
        questions.add(question);
        return addedQuestion;
    }

    @Override
    public Question remove(Question question) {
        Question removedQuestion = question;
        questions.remove(question);
        return removedQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
