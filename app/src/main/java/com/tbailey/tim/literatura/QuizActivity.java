package com.tbailey.tim.literatura;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    Book book = new Book();
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary(book.title);

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 1;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                if (mButtonChoice1.getText() == mAnswer){
                    updateScore();
                    updateQuestion();
                    mScore++;
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    mButtonChoice1.setBackgroundColor(Color.GREEN); //set the color to green
                    // Delay of 1 second (100 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice1.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    mButtonChoice1.setBackgroundColor(Color.RED); //set the color to red
                    // Delay of 2 seconds (200 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice1.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                    //updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    updateScore();
                    updateQuestion();
                    mScore++;
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    mButtonChoice2.setBackgroundColor(Color.GREEN); //set the color to green
                    // Delay of 1 second (100 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice2.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    mButtonChoice2.setBackgroundColor(Color.RED); //set the color to red
                    // Delay of 2 seconds (200 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice2.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                    //updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    updateScore();
                    updateQuestion();
                    mScore++;
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    mButtonChoice3.setBackgroundColor(Color.GREEN); //set the color to green
                    // Delay of 1 second (100 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice3.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    mButtonChoice3.setBackgroundColor(Color.RED); //set the color to red
                    // Delay of 2 seconds (200 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice3.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                    //updateQuestion();
                }
            }
        });
        //End of Button Listener for Button3

        //Start of Button Listener for Button4
        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                if (mButtonChoice4.getText() == mAnswer){
                    updateScore();
                    updateQuestion();
                    mScore++;
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    mButtonChoice4.setBackgroundColor(Color.GREEN); //set the color to green
                    // Delay of 1 second (100 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice4.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    mButtonChoice4.setBackgroundColor(Color.RED); //set the color to red
                    // Delay of 1 second (100 ms) before changing back the color to black
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mButtonChoice4.setBackgroundColor(Color.GRAY); //set the color back
                        }
                    }, 100);
                    //updateQuestion();
                }
            }
        });
        //End of Button Listener for Button4
    }

    private void updateQuestion(){
        System.out.println(mQuestionNumber);
        if(mQuestionNumber < mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else{
            Toast.makeText(QuizActivity.this, "Congratulations, you scored " + mScore + " out of 5!", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

    private void updateScore() {
        mScoreView.setText("" + mScore + "/5");
    }

}


