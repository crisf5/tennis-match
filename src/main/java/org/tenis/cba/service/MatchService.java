package org.tenis.cba.service;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TableModel;
import org.tenis.cba.model.TournamentModel;

public class MatchService {

    public static void firstServeBall(PlayerModel player1, PlayerModel player2 ){
        Double num = Math.random()*100;
        if(num>50){
            player1.setBall("*");
            player2.setBall("");
        }else{
            player2.setBall("*");
            player1.setBall("");
        }
    }

    public static void points(PlayerModel player1, PlayerModel player2){
        Double prob = Math.random()*100;
        if(player1.getProbabilityToWin()>prob){
            player1.setPoints(player1.getPoints() + 1);
            System.out.println(player1.getNamePlayer() + " ganó un punto.");
        }else{
            player2.setPoints(player2.getPoints() + 1);
            System.out.println(player2.getNamePlayer() + " ganó un punto.");
        }
    }

    public static void pointsTennis(PlayerModel player){
        if(player.getPoints()==0){
            player.setPointsTennis(0);
        }else if(player.getPoints()==1){
            player.setPointsTennis(15);
        }else if (player.getPoints()==2){
            player.setPointsTennis(30);
        }else if (player.getPoints()==3){
            player.setPointsTennis(40);
        }
    }

    public static void winGame(PlayerModel player1, PlayerModel player2) throws InterruptedException {
        if (player1.getPoints() == 4){
            player1.setGamesWin(player1.getGamesWin() + 1);
            System.out.println(player1.getNamePlayer() + " ganó el Game.\n");
            player1.setPoints(0);
            player2.setPoints(0);
            player1.setPointsTennis(0);
            player2.setPointsTennis(0);
            Thread.sleep(1000);
        }else if (player2.getPoints() == 4){
            player2.setGamesWin(player2.getGamesWin() + 1);
            System.out.println(player2.getNamePlayer() + " ganó el Game.\n");
            player1.setPoints(0);
            player2.setPoints(0);
            player1.setPointsTennis(0);
            player2.setPointsTennis(0);
            Thread.sleep(1000);
        }
    }

    public static void serveBall(TournamentModel tournament,PlayerModel player1, PlayerModel player2){

        if(player1.getGamesWin() + player2.getGamesWin() > tournament.getCountGames()
                && player1.getBall().equalsIgnoreCase("*")){
            player1.setBall("");
            player2.setBall("*");
            tournament.setCountGames(tournament.getCountGames() + 1);
        }
        if(player1.getGamesWin() + player2.getGamesWin() > tournament.getCountGames()
                && player2.getBall().equalsIgnoreCase("*")){
            player2.setBall("");
            player1.setBall("*");
            tournament.setCountGames(tournament.getCountGames() + 1);
        }

    }

    private static void insertSets(
            TournamentModel tournament,
            PlayerModel player1, PlayerModel player2,
            TableModel tablePlayer1, TableModel tablePlayer2){

        tournament.setCurrentSet(tournament.getCurrentSet() + 1);

        if(tournament.getCurrentSet() == 1){
            tablePlayer1.setSet1(player1.getGamesWin());
            tablePlayer2.setSet1(player2.getGamesWin());
        }else if(tournament.getCurrentSet() == 2){
            tablePlayer1.setSet2(player1.getGamesWin());
            tablePlayer2.setSet2(player2.getGamesWin());
        }else if(tournament.getCurrentSet() == 3){
            tablePlayer1.setSet3(player1.getGamesWin());
            tablePlayer2.setSet3(player2.getGamesWin());
        }else if(tournament.getCurrentSet() == 4){
            tablePlayer1.setSet4(player1.getGamesWin());
            tablePlayer2.setSet4(player2.getGamesWin());
        }else if(tournament.getCurrentSet() == 5){
            tablePlayer1.setSet5(player1.getGamesWin());
            tablePlayer2.setSet5(player2.getGamesWin());
        }

    }

    public static void winSet(TournamentModel tournament,
                              PlayerModel player1, PlayerModel player2,
                              TableModel tablePlayer1, TableModel tablePlayer2) throws InterruptedException {

        if(player1.getGamesWin() == 6 && player2.getGamesWin()<5
                || player1.getGamesWin() == 7){
            player1.setSetsWin(player1.getSetsWin() + 1);
            insertSets(tournament, player1, player2, tablePlayer1, tablePlayer2);
            System.out.println(player1.getNamePlayer() + " ganó el Set!");
            System.out.println("EL resultado total es " + player1.getSetsWin() + " a " + player2.getSetsWin() + "\n\n");
            player1.setGamesWin(0);
            player2.setGamesWin(0);
            tournament.setCountGames(0);
            Thread.sleep(1200);
        } else if (player2.getGamesWin() == 6 && player1.getGamesWin()<5
                || player2.getGamesWin() == 7){
            player2.setSetsWin(player2.getSetsWin() + 1);
            insertSets(tournament, player1, player2, tablePlayer1, tablePlayer2);
            System.out.println(player2.getNamePlayer() + " ganó el Set!");
            System.out.println("EL resultado total es " + player1.getSetsWin() + " a " + player2.getSetsWin() + "\n\n");
            player1.setGamesWin(0);
            player2.setGamesWin(0);
            tournament.setCountGames(0);
            Thread.sleep(1200);
        }
    }

    public static Integer cantSet(TournamentModel tournament){

        Integer maxWin = 0;

        if(tournament.getBestSet() == 3){
            maxWin = 2;
        } else if (tournament.getBestSet() == 5) {
            maxWin = 3;
        }
        return maxWin;

    }

    public static void winner(TournamentModel tournament, PlayerModel player1, PlayerModel player2){

        if(player1.getSetsWin() > player2.getSetsWin()){
            System.out.println("El jugador " + player1.getNamePlayer() +
                    " es el ganador del torneo " + tournament.getTournamentName() + "!!\n");
        }else{
            System.out.println("El jugador " + player2.getNamePlayer() +
                    " es el ganador del torneo " + tournament.getTournamentName() + "!!\n");
        }
    }
}
