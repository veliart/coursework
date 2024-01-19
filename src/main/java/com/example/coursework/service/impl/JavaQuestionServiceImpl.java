package com.example.coursework.service.impl;

import com.example.coursework.model.Question;
import com.example.coursework.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

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
    // Добавление по вопросу и ответу
    public Question add(String question, String answer) {
        Question addedQuestion = new Question(question, answer);
        questions.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    // добавление по вопросу
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

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size()); // результат nextInt < question.size
        ArrayList<Question> arrayQuestions = new ArrayList<>(questions);
        return arrayQuestions.get(randomIndex);
    }
}
