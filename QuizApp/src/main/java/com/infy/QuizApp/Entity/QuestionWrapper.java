package com.infy.QuizApp.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuestionWrapper {


        int id;
        String difficultylevel;
        String questionTitle;
        String option1;
        String option2;
        String option3;
        String option4;


        public QuestionWrapper(int id, String difficultylevel, String questionTitle, String option1, String option2, String option3, String option4) {
                this.id = id;
                this.difficultylevel = difficultylevel;
                this.questionTitle = questionTitle;
                this.option1 = option1;
                this.option2 = option2;
                this.option3 = option3;
                this.option4 = option4;

        }
}
