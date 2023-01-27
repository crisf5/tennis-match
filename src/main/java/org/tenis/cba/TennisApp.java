package org.tenis.cba;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TableModel;
import org.tenis.cba.model.TournamentModel;
import org.tenis.cba.service.MatchService;
import org.tenis.cba.service.MenuService;
import org.tenis.cba.service.TableService;

public class TennisApp
{
    public static void main( String[] args ) throws InterruptedException {

        PlayerModel player1 = new PlayerModel();
        PlayerModel player2 = new PlayerModel();
        TournamentModel tournament = new TournamentModel();
        TableModel tablePlayer1 = new TableModel();
        TableModel tablePlayer2 = new TableModel();

        MenuService.menuData(player1,player2,tournament);
        MenuService.probabilityWin(player1, player2);
        MenuService.speedSimulation(tournament);
        MatchService.firstServeBall(player1, player2);

        while(player1.getSetsWin() < MatchService.cantSet(tournament)
            && player2.getSetsWin() < MatchService.cantSet(tournament)){
            MatchService.points(player1, player2);
            MatchService.pointsTennis(player1);
            MatchService.pointsTennis(player2);

            MatchService.winGame(player1, player2);
            MatchService.serveBall(tournament, player1, player2);

            MatchService.winSet(tournament, player1, player2, tablePlayer1, tablePlayer2);

            TableService.generateTable(tournament, player1, player2, tablePlayer1, tablePlayer2);


            if(player1.getSetsWin() == MatchService.cantSet(tournament)
                    || player2.getSetsWin() == MatchService.cantSet(tournament)){

                MatchService.winner(tournament, player1, player2);
                MenuService.restartMatch(player1, player2, tablePlayer1, tablePlayer2);
            }
        }

        System.out.println("Fin del programa!\n");

    }
}
