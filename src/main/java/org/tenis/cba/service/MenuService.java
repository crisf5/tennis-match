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

    public static void probabilityWin(PlayerModel player1, PlayerModel player2) throws InterruptedException {

        System.out.println("\nLas probabilidades de ganar de "
                + player1.getNamePlayer() + " son del " + player1.getProbabilityToWin() + "%");
        System.out.println("Las probabilidades de ganar de "
                + player2.getNamePlayer() + " son del " + player2.getProbabilityToWin() + "%\n");
        Thread.sleep(1500);
    }

    public static void restartMatch(PlayerModel player1, PlayerModel player2){
        Scanner sc = new Scanner(System.in);

        System.out.print("Quiere la revancha? (Conteste si o no): ");
        String restart = sc.nextLine();
        System.out.println("\n\n");

        if(restart.equalsIgnoreCase("si")){
            player1.setPoints(0);
            player1.setGamesWin(0);
            player1.setSetsWin(0);
            player2.setPoints(0);
            player2.setGamesWin(0);
            player2.setSetsWin(0);
        }
    }
}
