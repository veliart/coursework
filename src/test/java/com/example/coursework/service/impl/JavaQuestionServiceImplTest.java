package com.example.coursework.service.impl;

import com.example.coursework.model.Question;
import com.example.coursework.repository.impl.JavaQuestionRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {
    @Mock
    private JavaQuestionRepositoryImpl javaQuestionRepository;
    @InjectMocks
    private JavaQuestionServiceImpl javaQuestionService;

    @Test
    public void shouldGetRandomJavaQuestionIsCorrect() {
        Collection<Question> expectedQuestions = new HashSet<>() {{
            add(new Question("Question1", "Answer1"));
            add(new Question("Question2", "Answer2"));
            add(new Question("Question3", "Answer3"));
            add(new Question("Question4", "Answer4"));
            add(new Question("Question5", "Answer5"));
        }};
        // when
        when(javaQuestionRepository.getAll()).thenReturn(expectedQuestions);
        //then
        Assertions.assertTrue(expectedQuestions.contains(javaQuestionService.getRandomQuestion()));
    }
}
