package com.vucic.quizzgame;

import android.content.Context;

public class HighScoresFactory {
    public static HighScoreSaving getHighScoreSaving(Context context) {
        return new SharedPrefsHighScores(context);
    }
}
