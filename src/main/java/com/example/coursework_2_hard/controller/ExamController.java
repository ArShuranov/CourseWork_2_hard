package com.example.coursework_2_hard.controller;

import com.example.coursework_2_hard.model.Question;
import com.example.coursework_2_hard.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(value = "/{amount}")
     public Collection<Question> getQuestion(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);

    }
}
