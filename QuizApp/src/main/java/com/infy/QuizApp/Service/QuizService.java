package com.infy.QuizApp.Service;

import com.infy.QuizApp.Entity.Question;
import com.infy.QuizApp.Entity.QuestionWrapper;
import com.infy.QuizApp.Entity.Quiz;
import com.infy.QuizApp.Entity.Response;
import com.infy.QuizApp.Repository.QuestionDao;
import com.infy.QuizApp.Repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, String title, int numQ) {
        Quiz quiz=new Quiz();
        quiz.setTitle(title);

        List<Question> questionList = questionDao.getRandomQuestion(category, numQ);
        quiz.setQuestions(questionList);
        quizDao.save(quiz);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser=new ArrayList<>();

        for(Question q: questionsFromDB)
        {
            QuestionWrapper questionWrapper=new QuestionWrapper(q.getId(),q.getDifficultylevel(),q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(questionWrapper);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> response) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questions=quiz.get().getQuestions();
        int right=0,i=0;
        for(Response r: response)
        {
            if(r.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

}
