package com.example.coursework.service.impl;

import com.example.coursework.model.Question;
import com.example.coursework.repository.impl.MathQuestionRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceImplTest {
    @Mock
    MathQuestionRepositoryImpl mathQuestionRepository;
    @InjectMocks
    MathQuestionServiceImpl mathQuestionService;
    @Test
    public void shouldGetRandomMathQuestionIsCorrect() {
        Collection<Question> expectedQuestions = new HashSet<>() {{
            add(new Question("Question1", "Answer1"));
            add(new Question("Question2", "Answer2"));
            add(new Question("Question3", "Answer3"));
            add(new Question("Question4", "Answer4"));
            add(new Question("Question5", "Answer5"));
        }};
        // when
        when(mathQuestionRepository.getAll()).thenReturn(expectedQuestions);
        //then
        Assertions.assertTrue(expectedQuestions.contains(mathQuestionService.getRandomQuestion()));
    }
}
