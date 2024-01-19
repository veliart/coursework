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
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        add("Что такое ООП?", "методология программирования");
        add("Что такое класс в Java?", "Базовый элемент ООП");
        add("Как объявить класс в коде?", "class MyClass {}");
        add("Для чего используется оператор NEW?", "Для создания экземпляра класса.");
        add("Что означает ключевое слово extends?", "Что данный класс наследуется от другого.");
        add("Что означает перегрузка метода в Java (overload).", "Несколько методов с одинаковым названием, но разным набором параметров.");
        add("Что означает переопределение метода в Java (override).", "Изменение поведения метода класса относительно родительского.");
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
