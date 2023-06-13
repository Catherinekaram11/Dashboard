package com.example.dashboard_backend.controller;

import com.example.dashboard_backend.entity.Quiz;
import com.example.dashboard_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveQuiz(@RequestBody Quiz quiz) {
        try {
            quizService.saveQuiz(quiz);
            return ResponseEntity.ok("Quiz saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save quiz!");
        }
    }

    @GetMapping("/getAll")
    public List<Quiz> findAllQuizzes() {
        return quizService.findAllQuizzes();
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateQuiz(@RequestParam Long quiz_id, @RequestBody Map<String, Object> fields) {
        try {
            Quiz quiz = quizService.updateQuiz(quiz_id, fields);
            return ResponseEntity.ok("Quiz updated successfully!");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Failed to update Quiz!");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteQuiz(@RequestParam Long quiz_id) {
        try {
            quizService.deleteQuiz(quiz_id);
            return ResponseEntity.ok("Quiz deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to delete quiz!");
        }
    }

}
