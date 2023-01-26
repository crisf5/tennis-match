package org.tenis.cba;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TournamentModel;
import org.tenis.cba.service.MatchService;
import org.tenis.cba.service.MenuService;
import org.tenis.cba.service.TableService;

/**
 * Hello world!
 *
 */
public class TennisApp
{
    public static void main( String[] args ) throws InterruptedException {

        PlayerModel player1 = new PlayerModel();
        PlayerModel player2 = new PlayerModel();
        TournamentModel tournament = new TournamentModel();

        MenuService.menuData(player1,player2,tournament);
        MenuService.probabilityWin(player1, player2);

        while(player1.getSetsWin() < MatchService.cantSet(tournament)
            && player2.getSetsWin() < MatchService.cantSet(tournament)){
            MatchService.points(player1, player2);
            MatchService.pointsTennis(player1);
            MatchService.pointsTennis(player2);

            MatchService.winGame(player1, player2);
            MatchService.winSet(player1,player2);

            TableService.generateTable(tournament, player1, player2);
        }

        MatchService.winner(tournament, player1, player2);

    }
}
