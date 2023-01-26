package org.tenis.cba.service;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TournamentModel;

public class TableService {

    public static void generateTable(TournamentModel tournament, PlayerModel player1, PlayerModel player2) throws InterruptedException {


        System.out.printf("------------------------------------------------%n");
        System.out.printf("|                %-15s               |%n", tournament.getTournamentName());

        System.out.printf("------------------------------------------------%n");
        System.out.printf("| %-5s | %-15s | %-6s | %-6s |%n", "Sets", "Player", "Points","Games");
        System.out.printf("------------------------------------------------%n");

        System.out.printf("| %-5s | %-15s | %-6s | %-6s |%n",
                player1.getSetsWin(),player1.getNamePlayer(), player1.getPointsTennis(), player1.getGamesWin());
        System.out.printf("| %-5s | %-15s | %-6s | %-6s |%n",
                player2.getSetsWin(),player2.getNamePlayer(),  player2.getPointsTennis(), player2.getGamesWin());

        System.out.printf("------------------------------------------------%n");

        System.out.printf("\n\n");

        Thread.sleep(1500);
    }
}
