package org.tenis.cba.model;

public class TournamentModel {

    private String tournamentName;
    private Integer bestSet;
    private Integer countGames = 0;
    private Integer currentSet = 0;
    private Integer speedMatch;

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Integer getBestSet() {
        return bestSet;
    }

    public void setBestSet(Integer bestSet) {
        this.bestSet = bestSet;
    }

    public Integer getCountGames() {
        return countGames;
    }

    public void setCountGames(Integer countGames) {
        this.countGames = countGames;
    }

    public Integer getCurrentSet() {
        return currentSet;
    }

    public void setCurrentSet(Integer currentSet) {
        this.currentSet = currentSet;
    }

    public Integer getSpeedMatch() {
        return speedMatch;
    }

    public void setSpeedMatch(Integer speedMatch) {
        this.speedMatch = speedMatch;
    }
}
