package com.example.coursework_2_hard.controller;

import com.example.coursework_2_hard.model.Question;
import com.example.coursework_2_hard.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    Question addQuestion(@RequestParam(value = "question") String question,
                         @RequestParam(value = "answer") String answer) {

        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    Question removeQuestion(@RequestParam(value = "question") String question,
                            @RequestParam(value = "answer") String answer) {

        return questionService.remove(new Question(question, answer));
    }


    @GetMapping
    Collection<Question> getQuestion() {
        return questionService.getAll();

    }

}
