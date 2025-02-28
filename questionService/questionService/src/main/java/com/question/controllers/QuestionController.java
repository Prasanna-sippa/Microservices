package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/question"})
public class QuestionController {
    private QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping({"/create"})
    public Question add(@RequestBody Question quiz){
        return questionService.add(quiz);
    }
    @GetMapping({"/getAll"})
    public List<Question> getAll(){
        return questionService.getAll();
    }
    @GetMapping({"/get/{questionId}"})
    public Question get(@PathVariable Long questionId){
        return questionService.get(questionId);
    }
    @GetMapping({"/get/quiz/{quizId}"})
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getAllQuestionsOfQuiz(quizId);
    }
}
