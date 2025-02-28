package com.quiz.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizList = quizRepository.findAll();
        List<Quiz> newQuizList = quizList
                .stream()
                .map(quiz ->{
                        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
                        return quiz;
                        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(()->
                                                    new RuntimeException("Quiz not found!"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(id));
        return quiz;
    }
}
