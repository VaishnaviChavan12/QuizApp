package com.infy.QuizApp.Repository;

import com.infy.QuizApp.Entity.Question;
import com.infy.QuizApp.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
