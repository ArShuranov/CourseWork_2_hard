package com.example.coursework_2_hard.service;


import com.example.coursework_2_hard.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
