package com.example.dashboard_backend.service;

import com.example.dashboard_backend.DAO.QuizDAO;
import com.example.dashboard_backend.entity.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class QuizService {

    @Autowired
    private QuizDAO quizDAO;

    public QuizService(QuizDAO quizDAO) {
        this.quizDAO = quizDAO;
    }

    @Transactional
    public Quiz saveQuiz(Quiz quiz) {
        quizDAO.save(quiz);
        return quiz;
    }

    @Transactional
    public List<Quiz> findAllQuizzes() {
        return quizDAO.findAll();
    }

    @Transactional
    public Quiz updateQuiz(Long quiz_id, Map<String, Object> fields) {
        Quiz quiz = quizDAO.findById(quiz_id).orElseThrow(() -> new NoSuchElementException("this quiz doesn't exist"));
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Quiz.class, key);
            field.setAccessible(true);
            try {
                ReflectionUtils.setField(field, quiz, value);
            } catch (IllegalArgumentException e) {
                ReflectionUtils.setField(field, quiz, Time.valueOf((String) value));
            }
        });
        quizDAO.save(quiz);
        return quiz;
    }

    @Transactional
    public void deleteQuiz(Long quiz_id) {
        quizDAO.deleteById(quiz_id);
    }

}
