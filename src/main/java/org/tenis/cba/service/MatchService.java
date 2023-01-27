package org.tenis.cba.service;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TournamentModel;

public class MatchService {

    public static void points(PlayerModel player1, PlayerModel player2){
        Double prob = Math.random()*100;
        if(player1.getProbabilityToWin()>prob){
            player1.setPoints(player1.getPoints() + 1);
        }else{
            player2.setPoints(player2.getPoints() + 1);
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
            Thread.sleep(800);
        }else if (player2.getPoints() == 4){
            player2.setGamesWin(player2.getGamesWin() + 1);
            System.out.println(player2.getNamePlayer() + " ganó el Game.\n");
            player1.setPoints(0);
            player2.setPoints(0);
            player1.setPointsTennis(0);
            player2.setPointsTennis(0);
            Thread.sleep(800);
        }
    }

    public static void winSet(PlayerModel player1, PlayerModel player2) throws InterruptedException {

        if(player1.getGamesWin() == 6 && player2.getGamesWin()<5
                || player1.getGamesWin() == 7){
            player1.setSetsWin(player1.getSetsWin() + 1);
            System.out.println(player1.getNamePlayer() + " ganó el Set!");
            System.out.println("EL resultado total es " + player1.getSetsWin() + " a " + player2.getSetsWin() + "\n\n");
            player1.setGamesWin(0);
            player2.setGamesWin(0);
            Thread.sleep(1500);
        } else if (player2.getGamesWin() == 6 && player1.getGamesWin()<5
                || player2.getGamesWin() == 7){
            player2.setSetsWin(player2.getSetsWin() + 1);
            System.out.println(player2.getNamePlayer() + " ganó el Set!");
            System.out.println("EL resultado total es " + player1.getSetsWin() + " a " + player2.getSetsWin() + "\n\n");
            player1.setGamesWin(0);
            player2.setGamesWin(0);
            Thread.sleep(1500);
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
