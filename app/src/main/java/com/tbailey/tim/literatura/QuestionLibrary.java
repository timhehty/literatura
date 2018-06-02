package com.tbailey.tim.literatura;

/**
 * Created by Tim on 5/29/2018.
 */

public class QuestionLibrary {

    private String mQuestions [] = {
            "The main character is this strongman of Umuofia.",
            "Okonkwo kills this adopted son of his.",
            "Which traditional event does he disrupt by beating his wife?",
            "Which one of his sons converts to Christianity?",
            "Who does Okonkwo defeat in a wrestling match?"
    };

    private String mChoices [][] = {
            {"Okonkwo","Richard Parker","M'baku","Obi"},
            {"Mandela","Ikemefuna","T'Challa","Ubuntu"},
            {"Week of Peace","Shark Week","Rain Dance","Week of Solace"},
            {"Omar","Steven Kumalo","Nwoye","Habibi"},
            {"Ekwefi the Lion, Akinfenwa the Goat, Ezinma the Dog, Amalinze the Cat"}
    };

    private String mCorrectAnswers[] = {"Okonkwo", "Ikemefuna", "Week of Peace", "Nwoye", "Amalinze the Cat"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a){
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a){
        String correctAnswer = mCorrectAnswers[a];
        return correctAnswer;
    }

    public int getLength(){
        return mQuestions.length;
    }

}
