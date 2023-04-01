package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.app.Dialog;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPage extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    RadioButton question1_choice3;
    RadioButton question2_choice2;
    RadioButton question3_choice1;
    RadioButton question4_choice2;
    RadioButton question5_choice1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_quiz_page);
    }

    public void submitAnswers(View view) {
        CharSequence resultsDisplay;
        Log.e(LOG_TAG, " " + this.findViewById(R.id.question3_choice3));
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int final_score;

        Boolean answer1;

        question1_choice3 = (RadioButton) this.findViewById(R.id.question1_choice3);
        answer1 = question1_choice3.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        Boolean answer2;

        question2_choice2 = (RadioButton) this.findViewById(R.id.question2_choice2);
        answer2 = question2_choice2.isChecked();
        if (answer2) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        Boolean answer3;

        question3_choice1= (RadioButton) this.findViewById(R.id.question3_choice1);
        answer3 = question3_choice1.isChecked();
        if (answer3) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        Boolean answer4;

        question4_choice2 = (RadioButton) this.findViewById(R.id.question4_choice2);
        answer4 = question4_choice2.isChecked();
        if (answer4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        Boolean answer5;

        question5_choice1 = (RadioButton) this.findViewById(R.id.question5_choice1);
        answer5 = question5_choice1.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }

        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;
        if (final_score == 5) {
            resultsDisplay = "Great! You scored 5 out of 5";
        } else {
            resultsDisplay = "Try again.You scored " + final_score + " out of 5";
        }

        Bundle b = new Bundle();
        b.putString("result", (String) resultsDisplay);

        Intent i = new Intent(getApplicationContext(), ResultActivity.class);
        i.putExtras(b);
        startActivity(i);


        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
