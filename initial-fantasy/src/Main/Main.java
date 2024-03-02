package Main;

import Entities.Dwarf;
import Entities.Elf;
import Entities.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String gameState = "choosingRace";
        ArrayList<String> situations = new ArrayList<>();

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Boas vindas a Initial Fantasy!");
        System.out.println("Vamos começar a sua jornada criando seu personagem:");

        int raceIndex = 0;
        while(gameState == "choosingRace"){
            if(raceIndex == 1 || raceIndex == 2 || raceIndex == 3){
                System.out.println("Certo! agora vamos escolher o seu nome:");
                gameState = "choosingName";
            }else if(raceIndex == 4){
                System.out.println("Humano: vida 1000, força 15, magia 20, agilidade 25, inteligência 100");
                System.out.println("Elfo: vida 700, força 10, magia 50, agilidade 30, inteligência 150");
                System.out.println("Anão: vida 1800, força 15, magia 20, agilidade 15, inteligência 50");
            }else {
                System.out.println("Por favor, digite um número entre 1 e 4.");
            }
            System.out.println("Escolha a sua raça: 1 - Humano; 2 - Anão; 3 - Elfo");
            System.out.println("(Digite 4 caso queira saber os status de cada classe");
            raceIndex = input.nextInt();
        }

        while (gameState == "choosingName"){
            String playerName = input.nextLine();
            System.out.println("Perfeito! Seu personagem será "+playerName+"! vamos começar a sua jornada agora.");
            if(raceIndex == 1){
                Human player = new Human(playerName, 15, 20, 25, 1000,100);
            }else if(raceIndex == 2){
                Dwarf player = new Dwarf(playerName, 15, 20, 15, 1800,50);
            }else{
                Elf player = new Elf(playerName, 10, 50, 30, 700,150);
            }
            gameState = "journey";
        }

        while (gameState == "journey"){
            int a = 1;
            a++;
        }
    }
}