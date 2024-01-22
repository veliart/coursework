package com.example.coursework.service.impl;

import com.example.coursework.exception.InvalidAmountQuestionException;
import com.example.coursework.model.Question;
import com.example.coursework.repository.impl.JavaQuestionRepositoryImpl;
import com.example.coursework.repository.impl.MathQuestionRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionRepositoryImpl javaQuestionRepository;
    @Mock
    MathQuestionRepositoryImpl mathQuestionRepository;
    @Mock
    JavaQuestionServiceImpl javaQuestionService;
    @Mock
    MathQuestionServiceImpl mathQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    public void shouldInvalidAmountQuestionException() {
        //given
        int amount = 10;
        // when
        when(javaQuestionRepository.getAll()).thenReturn(List.of());
        when(mathQuestionRepository.getAll()).thenReturn(List.of());
        //then
        Assertions.assertThrows(InvalidAmountQuestionException.class, () ->
                examinerService.getQuestions(amount));
    }

    @Test
    public void shouldGetQuestionsIsCorrect() {
        //given
        int amount = 2;
        List<Question> questions = List.of(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question3", "Answer3"),
                new Question("Question4", "Answer4"),
                new Question("Question5", "Answer5")

        );
        //when

        when(javaQuestionService.getSizeQuestionRepository()).thenReturn(10);
        when(mathQuestionService.getSizeQuestionRepository()).thenReturn(10);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0)
        );
        when(mathQuestionService.getRandomQuestion()).thenReturn(
                questions.get(1)
        );
        Collection<Question> actualQuestion = examinerService.getQuestions(amount);
        //then
        Assertions.assertEquals(
                Set.of(questions.get(0), questions.get(1)),
                actualQuestion
        );
    }

}
