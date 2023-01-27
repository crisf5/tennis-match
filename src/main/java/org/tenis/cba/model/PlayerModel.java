package org.tenis.cba.model;

public class PlayerModel {

    private String namePlayer;
    private Integer probabilityToWin;
    private String ball;
    private Integer points = 0;
    private Integer pointsTennis;
    private Integer gamesWin = 0;
    private Integer setsWin = 0;

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public Integer getProbabilityToWin() {
        return probabilityToWin;
    }

    public void setProbabilityToWin(Integer probabilityToWin) {
        this.probabilityToWin = probabilityToWin;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPointsTennis() {
        return pointsTennis;
    }

    public void setPointsTennis(Integer pointsTennis) {
        this.pointsTennis = pointsTennis;
    }

    public Integer getGamesWin() {
        return gamesWin;
    }

    public void setGamesWin(Integer gamesWin) {
        this.gamesWin = gamesWin;
    }

    public Integer getSetsWin() {
        return setsWin;
    }

    public void setSetsWin(Integer setsWin) {
        this.setsWin = setsWin;
    }

    public String getBall() {
        return ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }
}
