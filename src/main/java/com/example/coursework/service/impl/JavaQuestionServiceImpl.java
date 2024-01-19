package com.example.coursework.service.impl;

import com.example.coursework.model.Question;
import com.example.coursework.service.QuestionService;

import java.util.*;

public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();
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
        int randomIndex = random.nextInt(questions.size() - 1);
        ArrayList<Question> arrayQuestions = new ArrayList<>(questions.size());
        return arrayQuestions.get(randomIndex);
    }
}
