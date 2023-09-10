package com.example.coursework_2_hard.service.impl;

import com.example.coursework_2_hard.exception.NumberMoreThanLimitStorage;
import com.example.coursework_2_hard.model.Question;
import com.example.coursework_2_hard.service.ExaminerService;
import com.example.coursework_2_hard.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    //get number of random questions depending on variable(amount)
    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> setOfRandomQuestions = new HashSet<>();

        if (amount > questionService.getAll().size()) {
            throw new NumberMoreThanLimitStorage("Превышено количество вопросов");
        }
        while (amount > setOfRandomQuestions.size()) {
            setOfRandomQuestions.add(questionService.getRandomQuestion());
        }
        return setOfRandomQuestions;
    }
}
