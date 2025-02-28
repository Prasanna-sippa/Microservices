package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question quiz);
    List<Question> getAll();
    Question get(Long id);
    List<Question> getAllQuestionsOfQuiz(Long quizId);
}
