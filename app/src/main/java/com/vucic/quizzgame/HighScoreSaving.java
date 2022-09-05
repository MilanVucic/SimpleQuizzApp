package com.vucic.quizzgame;

import java.util.List;

public interface HighScoreSaving {
    void saveHighScore(String name, int points);
    List<HighScorer> getHighScores();
}
