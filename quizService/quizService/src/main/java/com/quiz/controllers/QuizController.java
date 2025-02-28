package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/quiz"})
public class QuizController {

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    private QuizService quizService;
    @PostMapping({"/create"})
    public Quiz add(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }
    @GetMapping("/getAll")
    public List<Quiz> getAll(){
        return quizService.getAll();
    }
    @GetMapping("/get/{id}")
    public Quiz get(@PathVariable Long id){
        return quizService.get(id);
    }


}
