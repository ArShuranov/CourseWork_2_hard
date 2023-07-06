package com.example.coursework_2_hard;

import com.example.coursework_2_hard.exception.NumberMoreThanLimitStorage;
import com.example.coursework_2_hard.model.Question;
import com.example.coursework_2_hard.service.impl.ExaminerServiceImpl;
import com.example.coursework_2_hard.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;


    private final Set<Question> storageForTest = new HashSet<>(List.of(
            new Question("aaa", "aaa"),
            new Question("ddd", "ddd"),
            new Question("sd", "sd")));

    private final List<Question> randomQuestion = new ArrayList<>(List.of(
            // new Question("aaa", "aaa"),
            //new Question("ddd", "ddd"),
            new Question("sd", "sd")));

    @Test
    public void getQuestionsTest() {
        // Given
        int amount = 1;
        Set<Question> storageForTest = new HashSet<>(Set.of(new Question("aaa", "aaa")));
        given(questionService.getAll()).willReturn(storageForTest);
        given(questionService.getRandomQuestion()).willReturn(new Question("aaa", "aaa"));
        // When
        Set<Question> actual = examinerService.getQuestions(amount);
        Set<Question> expected = storageForTest;
        // Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowLimitException() {
        //given
        final int amount = 10; // Здесь какой-то косяк, если число поставить чтобы исключение не вылетело, то выполняется бесконечно, ну или очень долго.

        given(questionService.getAll()).willReturn(storageForTest);

        Assertions.assertThrows(NumberMoreThanLimitStorage.class, () -> {
            examinerService.getQuestions(amount);
        });

    }

}
