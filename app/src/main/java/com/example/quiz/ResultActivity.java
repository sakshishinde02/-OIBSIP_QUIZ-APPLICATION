package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ResultActivity extends Activity {
    EditText res;
    LinearLayout restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        res = (EditText) findViewById(R.id.result);
        restart = (LinearLayout) findViewById(R.id.btn_tryAgain);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String score = b.getString("result");

        res.setText(score);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), QuizPage.class);
                startActivity(i);
            }

        });
    }
}
