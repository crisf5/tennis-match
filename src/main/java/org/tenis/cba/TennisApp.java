package org.tenis.cba;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TournamentModel;
import org.tenis.cba.service.TennisService;

/**
 * Hello world!
 *
 */
public class TennisApp
{
    public static void main( String[] args )
    {

        PlayerModel player1 = new PlayerModel();
        PlayerModel player2 = new PlayerModel();
        TournamentModel tournament = new TournamentModel();

        TennisService.menuData(player1,player2,tournament);

        System.out.println(player1.getNamePlayer());
        System.out.println(player2.getNamePlayer());
        System.out.println(tournament.getTournamentName());








    }
}
