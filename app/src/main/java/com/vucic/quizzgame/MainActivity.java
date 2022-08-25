package com.vucic.quizzgame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vucic.quizzgame.models.Answer;
import com.vucic.quizzgame.models.Question;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int COUNT_DOWN_INTERVAL = 1000;
    public static final int TOTAL_TIME = 30000;
    private TextView timerTextView, questionTextView;
    private Button answer1Button, answer2Button, answer3Button;
    private int questionIndex = 0;
    private List<Question> allQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = findViewById(R.id.timerTextView);
        questionTextView = findViewById(R.id.questionTextView);
        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);

        allQuestions = Question.getAllQuestions();
        displayQuestion(allQuestions.get(questionIndex));

        startTimer();
    }

    private void startTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(TOTAL_TIME, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(getString(R.string.time_with_placeholder, l / 1000));
            }

            @Override
            public void onFinish() {
                gameOver();
            }
        };
        countDownTimer.start();
    }

    private void displayQuestion(Question question) {
        questionTextView.setText(question.getText());
        answer1Button.setText(question.getAnswer1().getText());
        answer2Button.setText(question.getAnswer2().getText());
        answer3Button.setText(question.getAnswer3().getText());

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswerCorrect(question.getAnswer1());
            }
        });
        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswerCorrect(question.getAnswer2());
            }
        });
        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswerCorrect(question.getAnswer3());
            }
        });
    }

    private void checkAnswerCorrect(Answer answer) {
        if (answer.isCorrect()) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }

        questionIndex++;
        if (questionIndex == allQuestions.size()) {
            gameOver();
        } else {
            displayQuestion(allQuestions.get(questionIndex));
        }
    }

    private void gameOver() {
        Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show();
    }
}