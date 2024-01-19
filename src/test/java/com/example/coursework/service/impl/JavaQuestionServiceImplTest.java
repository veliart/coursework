package com.example.coursework.service.impl;

import com.example.coursework.model.Question;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceImplTest {
    private final JavaQuestionServiceImpl javaQuestionService = new JavaQuestionServiceImpl() {{
        add(new Question("Question1", "Answer1"));
        add(new Question("Question2", "Answer2"));
        add(new Question("Question3", "Answer3"));
        add(new Question("Question4", "Answer4"));
        add(new Question("Question5", "Answer5"));
    }};
    @Test
    public void shouldAddQuestionIsCorrect() {
        //given
        Question expectedQuestion = new Question("Test question.", "Test answer.");
        //when
        Question actualQuestion = javaQuestionService.add(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        //then
        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }
    @Test
    public void shouldRemoveQuestionIsCorrect() {
        //given
        Question expectedQuestion = new Question("Question5.", "Answer5");
        //when
        Question actualQuestion = javaQuestionService.remove(expectedQuestion);
        //then
        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }
    @Test
    public void shouldGetAllQuestionIsCorrect() {
        //given
        Collection<Question> expectedQuestions = new HashSet<>() {{
            add(new Question("Question1", "Answer1"));
            add(new Question("Question2", "Answer2"));
            add(new Question("Question3", "Answer3"));
            add(new Question("Question4", "Answer4"));
            add(new Question("Question5", "Answer5"));
        }};
        //when
        Collection<Question> actualQuestions = javaQuestionService.getAll();
        Assertions.assertEquals(expectedQuestions, actualQuestions);
    }

}
