package com.example.coursework.service.impl;

import com.example.coursework.exception.InvalidAmountQuestionException;
import com.example.coursework.model.Question;
import com.example.coursework.service.ExaminerService;
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
    private JavaQuestionServiceImpl javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    public void  shouldThrowInvalidAmountQuestionException() {
        //given
        int amount = 20;
        when(javaQuestionService.getAll()).thenReturn(List.of());
        //when
        //then
        Assertions.assertThrows(InvalidAmountQuestionException.class, () ->
            examinerService.getQuestions(amount));
    }
    @Test
    public void shouldGetQuestionIsCorrect() {
        //given
        int amount = 2;
        List<Question> questions = List.of(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question3", "Answer3"),
                new Question("Question4", "Answer4"),
                new Question("Question5", "Answer5")

        );
        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1)
        );
        //when
        Collection<Question> actualQuestion = examinerService.getQuestions(amount);
        //then
        Assertions.assertEquals(
                Set.of(questions.get(0), questions.get(1)),
                actualQuestion
        );
    }

}
