package com.example.coursework.service.impl.repository.impl;

import com.example.coursework.model.Question;
import com.example.coursework.repository.impl.JavaQuestionRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

public class JavaQuestionRepositoryImplTest {
    private final JavaQuestionRepositoryImpl javaQuestionRepository = new JavaQuestionRepositoryImpl() {{
        add(new Question("Question1", "Answer1"));
        add(new Question("Question2", "Answer2"));
        add(new Question("Question3", "Answer3"));
        add(new Question("Question4", "Answer4"));
        add(new Question("Question5", "Answer5"));
    }};
    @Test
    public void shouldAddJavaQuestionIsCorrect() {
        // given
        Question expectedQuestion = new Question("Test question.", "Test answer.");
        // when
        Question actualQuestion = javaQuestionRepository.add(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        // then
        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    public void shouldRemoveJavaQuestionIsCorrect() {
        // given
        Question removedQuestion = new Question("Question5", "Answer5");
        // when
        Question actualQuestion = javaQuestionRepository.remove(removedQuestion);
        // then
        Assertions.assertEquals(removedQuestion, actualQuestion);
    }

    @Test
    public void shouldGetAllJavaQuestionIsCorrect() {
        // given
        Collection<Question> expectedQuestions = new HashSet<>() {{
            add(new Question("Question1", "Answer1"));
            add(new Question("Question2", "Answer2"));
            add(new Question("Question3", "Answer3"));
            add(new Question("Question4", "Answer4"));
            add(new Question("Question5", "Answer5"));
        }};
        // when
        Collection<Question> actualQuestions = javaQuestionRepository.getAll();
        // then
        Assertions.assertEquals(expectedQuestions, actualQuestions);
    }

}
