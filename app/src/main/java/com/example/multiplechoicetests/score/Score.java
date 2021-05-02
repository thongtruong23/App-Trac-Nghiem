package com.example.multiplechoicetests.score;

public class Score {
    private int _id;
    private String name;
    private String ghichu;
    private int score;
    private String date;

    public Score(int _id, String name, String ghichu, int score, String date) {
        this._id = _id;
        this.name = name;
        this.ghichu = ghichu;
        this.score = score;
        this.date = date;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}