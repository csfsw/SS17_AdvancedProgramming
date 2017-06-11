package Entities;

import java.lang.reflect.Array;





public class Score {
    private int score;
    private Array mark;

    public Score(int score, Array mark) {
        this.score = score;
        this.mark = mark;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Array getMark() {
        return mark;
    }

    public void setMark(Array mark) {
        this.mark = mark;
    }
 
}
