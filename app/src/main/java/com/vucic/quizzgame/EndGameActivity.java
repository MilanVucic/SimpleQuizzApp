package com.vucic.quizzgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.vucic.quizzgame.util.Tags;

public class EndGameActivity extends AppCompatActivity {

    private TextView previousHighScoreTextView;
    private TextView newHighScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();
        int points = intent.getIntExtra(Tags.POINTS, 0);
        TextView pointsTextView = findViewById(R.id.pointsTextView);
        previousHighScoreTextView = findViewById(R.id.previousHighScoreTextView);
        newHighScoreTextView = findViewById(R.id.newHighScoreTextView);
        pointsTextView.setText(getString(R.string.points_with_placeholder, points));
        saveHighScore(points);
    }

    private void saveHighScore(int points) {
        // saveHighscore(int points)
        // List<HighScorer> getHighscore
        // highscore_1
        // name_1
        // int string
        HighScoreSaving highScoreSaving = HighScoresFactory.getHighScoreSaving(this);
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        int highScore = sharedPreferences.getInt(Tags.HIGH_SCORE, 0);
        previousHighScoreTextView.setText(getString(R.string.previous_high_score_with_placeholder, highScore));
        if (points > highScore) {
            newHighScoreTextView.setVisibility(View.VISIBLE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(Tags.HIGH_SCORE, points);
            editor.apply();
        }
    }
}