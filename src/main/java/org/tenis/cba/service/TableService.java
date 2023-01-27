package org.tenis.cba.service;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TableModel;
import org.tenis.cba.model.TournamentModel;

public class TableService {

    public static void generateTable(
            TournamentModel tournament, PlayerModel player1, PlayerModel player2,
            TableModel tablePlayer1, TableModel tablePlayer2) throws InterruptedException {

        System.out.printf("--------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %23s %17s | %-51s |%n", tournament.getTournamentName(),""
                ,"Mejor de " + tournament.getBestSet() + " sets");

        System.out.printf("--------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-5s | %-15s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s |%n"
                , "Sets", "Player", "Ball" ,"Points","Games", "Set 1º","Set 2º","Set 3º","Set 4º","Set 5º");
        System.out.printf("--------------------------------------------------------------------------------------------------%n");

        System.out.printf("| %-5s | %-15s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s |%n",
                player1.getSetsWin(),player1.getNamePlayer(), player1.getBall() , player1.getPointsTennis(),
                player1.getGamesWin(), tablePlayer1.getSet1(), tablePlayer1.getSet2(), tablePlayer1.getSet3(),
                tablePlayer1.getSet4(), tablePlayer1.getSet5());
        System.out.printf("| %-5s | %-15s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s | %-6s |%n",
                player2.getSetsWin(),player2.getNamePlayer(), player2.getBall(), player2.getPointsTennis(),
                player2.getGamesWin(), tablePlayer2.getSet1(), tablePlayer2.getSet2(), tablePlayer2.getSet3(),
                tablePlayer2.getSet4(), tablePlayer2.getSet5());

        System.out.printf("--------------------------------------------------------------------------------------------------%n");

        System.out.printf("\n\n");

        Thread.sleep(tournament.getSpeedMatch());
    }
}
