package com.example.coursework_2_hard;

import com.example.coursework_2_hard.model.Question;
import com.example.coursework_2_hard.service.QuestionService;
import com.example.coursework_2_hard.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class JavaQuestionServiceTest {
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
    }

    @Test
    void addByStringTest() {
        Question actual = questionService.add("Крошка сын к отцу пришел и спросила кроха", "Что такое хорошо и что такое плохо?");
        Question expected = new Question("Крошка сын к отцу пришел и спросила кроха", "Что такое хорошо и что такое плохо?");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionIfQuestionByStringAlredyExist() {
        Assertions.assertThrows(RuntimeException.class, () -> questionService.add("aaa", "aaa"));
    }

    @Test
    void addByModelTest() {
        Question tmp = new Question("Крошка сын к отцу пришел и спросила кроха", "Что такое хорошо и что такое плохо?");
        Question actual = questionService.add(tmp);
        Question expected = new Question("Крошка сын к отцу пришел и спросила кроха", "Что такое хорошо и что такое плохо?");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionIfQuestionByModelAlredyExist() {
        Question tmp = new Question("aaa", "aaa");
        Assertions.assertThrows(RuntimeException.class, () -> questionService.add(tmp));
    }

    @Test
    void removeTest() {
        //Такой тест объясняется тем, что метод возвращает, то что мы в него передаем
        // А мне хочется посмотреть, то что он реально удаляет из хранилища
        // может быть так нужно было делать и вдругих тестах, не знаю
        // так как я не могу сравнить два множества (не знаю как), но я могу удалить все повторяющиеся элементы
        //p.s. у меня хранилище создано в самом сервисе с ним и сравниваю

        Question tmp = new Question("aaa", "aaa");
        questionService.remove(tmp);
        Collection<Question> actual = questionService.getAll();
        Set<Question> expected = new HashSet<>(Set.of(new Question("ddd", "ddd"),
                new Question("cc", "cc"),
                new Question("sd", "sd")));
        actual.removeAll(expected);


        Assertions.assertEquals(0, actual.size());

    }

    @Test
    void shouldThrowExceptionIfRemoveNonExistentElement() {
        Question tmp = new Question("www", "www");
        Assertions.assertThrows(RuntimeException.class, () -> questionService.remove(tmp));
    }

    @Test
    void getAllTest() {
        // опять же проблема во множестве, я не могу сравнить его с полученным листом, а если приведу к листу
        // то не могу создать такой же лист в том же порядке, поэтому сравниваю только размер
        int actual = questionService.getAll().size();
        int expected = 4;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getRandomQuestionTest() {

        Question actual = questionService.getRandomQuestion();

        Assertions.assertTrue(actual.equals(new Question("ddd", "ddd")) || actual.equals(new Question("aaa", "aaa"))
        || actual.equals(new Question("cc", "cc")) || actual.equals(new Question("sd", "sd")));
    }
}