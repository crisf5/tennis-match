package org.tenis.cba.service;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TournamentModel;

import java.util.Scanner;

public class TennisService {

    public static void menuData(PlayerModel player1, PlayerModel player2, TournamentModel tournament){

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del Jugador 1: ");
        String namePlayer1 = sc.nextLine();
        player1.setNamePlayer(namePlayer1);

        System.out.print("Ingrese el nombre del Jugador 1: ");
        String namePlayer2 = sc.nextLine();
        player2.setNamePlayer(namePlayer2);

        System.out.print("Ingrese el nombre del torneo: ");
        String nameTournament = sc.nextLine();
        tournament.setTournamentName(nameTournament);



    }
}
