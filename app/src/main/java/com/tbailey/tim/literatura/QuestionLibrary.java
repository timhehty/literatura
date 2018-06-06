package com.tbailey.tim.literatura;

import android.widget.ProgressBar;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Tim on 5/29/2018.
 */

public class QuestionLibrary {

    private String mQuestions [] = {"", "", "", "", ""};

    private String mChoices [][] = {
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""}
    };

    private String mCorrectAnswers[] = {"","","","",""};

    private AsyncHttpClient client;

    public QuestionLibrary(final String bookName, final QuizActivity context) {
        this.client = new AsyncHttpClient();
        client.get("https://raw.githubusercontent.com/timhehty/question-library/master/questions.json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray library = response.getJSONArray("library");
                    for (int i = 0; i < library.length(); i++) {
                        JSONObject book = library.getJSONObject(i);
                        if (book.getString("name").equals(bookName)) {
                            JSONArray questions = book.getJSONArray("questions");
                            for (int j = 0; j < questions.length(); j++) {
                                System.out.println(questions.getString(j));
                                mQuestions[j] = questions.getString(j);
                            }
                            JSONArray choices = book.getJSONArray("choices");
                            for (int j = 0; j < choices.length(); j++) {
                                for (int k = 0; k < choices.getJSONArray(j).length(); k++) {
                                    mChoices[j][k] = choices.getJSONArray(j).getString(k);
                                }
                            }
                            JSONArray correctAnswers = book.getJSONArray("correctAnswers");
                            for (int j = 0; j < correctAnswers.length(); j++) {
                                mCorrectAnswers[j] = correctAnswers.getString(j);
                            }
                            break;
                        }
                    }
                    context.finishLoad();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }
        });
    }

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
