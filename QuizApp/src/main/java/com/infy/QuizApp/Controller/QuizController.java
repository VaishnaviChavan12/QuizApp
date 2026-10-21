package com.infy.QuizApp.Controller;

import com.infy.QuizApp.Entity.Question;
import com.infy.QuizApp.Entity.QuestionWrapper;
import com.infy.QuizApp.Entity.Response;
import com.infy.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,  @RequestParam String title, @RequestParam int NumQ)
    {
        return quizService.createQuiz(category,title, NumQ);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id)
    {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response)
    {
        return quizService.calculateResult(id,response);
    }
}
