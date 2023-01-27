package org.tenis.cba.service;

import org.tenis.cba.model.PlayerModel;
import org.tenis.cba.model.TournamentModel;

import java.util.Scanner;

public class MenuService {

    public static void menuData(PlayerModel player1, PlayerModel player2, TournamentModel tournament){

        Scanner sc = new Scanner(System.in);


        String namePlayer1 = "";
        while (namePlayer1.isBlank()){
            System.out.print("Ingrese el nombre del Jugador 1: ");
            namePlayer1 = sc.nextLine();
            player1.setNamePlayer(namePlayer1);
        }

        String namePlayer2="";
        while(namePlayer2.isBlank()){
            System.out.print("Ingrese el nombre del Jugador 2: ");
            namePlayer2 = sc.nextLine();
            player2.setNamePlayer(namePlayer2);
        }

        String nameTournament = "";
        while(nameTournament.isBlank()){
            System.out.print("Ingrese el nombre del torneo: ");
            nameTournament = sc.nextLine();
            tournament.setTournamentName(nameTournament);
        }

        Boolean incorrectNum = true;
        while (incorrectNum){
            System.out.print("Ingrese cantidad de sets (3 o 5): ");
            Integer bestSet = sc.nextInt();
            tournament.setBestSet(bestSet);
            if(bestSet == 3 || bestSet == 5){
                incorrectNum = false;
            }
        }

        Integer probability = -1;
        while(probability<0 || probability>100){
            System.out.print("Ingrese las probabilidades de ganar del 'Jugador 1' (0 a 100): ");
            probability = sc.nextInt();
            player1.setProbabilityToWin(probability);
            player2.setProbabilityToWin(100 - probability);
        }


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

        Boolean incorrectWord = true;
        String restart = "";
        while(incorrectWord){
            System.out.print("Quiere la revancha? (Conteste si o no): ");
            restart = sc.nextLine();
            if(restart.equalsIgnoreCase("si") || restart.equalsIgnoreCase("no")){
                incorrectWord = false;
            }
        }

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
