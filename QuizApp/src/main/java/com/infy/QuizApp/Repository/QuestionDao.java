package com.infy.QuizApp.Repository;

import com.infy.QuizApp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "select * from Question where category=:category order by RAND() Limit :numQ", nativeQuery = true )
    List<Question> getRandomQuestion(String category, int numQ);

}
