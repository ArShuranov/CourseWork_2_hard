package com.example.coursework_2_hard.service.impl;

import com.example.coursework_2_hard.model.Question;
import com.example.coursework_2_hard.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> storage = new HashSet<>(Set.of(new Question("aaa", "aaa"), new Question("ddd", "ddd"),
            new Question("cc", "cc"),
            new Question("sd", "sd")));


    @Override
    public Question add(String question, String answer) {
        Question tmp = new Question(question, answer);
        if (storage.contains(tmp)) {
            throw new RuntimeException("Этот вопрос уже есть в базе");
        }
        storage.add(tmp);
        return tmp;
    }

    @Override
    public Question add(Question question) {
        if (storage.contains(question)) {
            throw new RuntimeException("Этот вопрос уже есть в базе");
        }
        storage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!storage.contains(question)) {
            throw new RuntimeException("Впорос не найден");
        }
        storage.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> listForTakingRandom = new ArrayList<>(getAll());
        Question result = listForTakingRandom.get(random.nextInt(listForTakingRandom.size()));

        return result;
    }
}
