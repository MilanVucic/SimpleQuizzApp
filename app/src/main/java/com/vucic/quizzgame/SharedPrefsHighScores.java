package com.vucic.quizzgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;

public class SharedPrefsHighScores implements HighScoreSaving {
    private SharedPreferences sharedPreferences;

    public SharedPrefsHighScores(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void saveHighScore(String name, int points) {

    }

    @Override
    public List<HighScorer> getHighScores() {
        return null;
    }
}
