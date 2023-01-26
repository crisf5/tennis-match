package org.tenis.cba.service;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TournamentModel;

import java.util.Scanner;

public class MenuService {

    public static void menuData(PlayerModel player1, PlayerModel player2, TournamentModel tournament){

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del Jugador 1: ");
        String namePlayer1 = sc.nextLine();
        player1.setNamePlayer(namePlayer1);

        System.out.print("Ingrese el nombre del Jugador 2: ");
        String namePlayer2 = sc.nextLine();
        player2.setNamePlayer(namePlayer2);

        System.out.print("Ingrese el nombre del torneo: ");
        String nameTournament = sc.nextLine();
        tournament.setTournamentName(nameTournament);

        System.out.print("Ingrese cantidad de sets (3 o 5): ");
        Integer bestSet = sc.nextInt();
        tournament.setBestSet(bestSet);

        System.out.print("Ingrese las probabilidades de ganar del 'Jugador 1' (0 a 100): ");
        Integer probability = sc.nextInt();
        player1.setProbabilityToWin(probability);
        player2.setProbabilityToWin(100 - probability);

    }

}
