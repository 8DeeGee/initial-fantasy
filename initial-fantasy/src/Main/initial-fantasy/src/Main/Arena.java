package Main;

import Entities.Playable;

import java.util.Random;
import java.util.Scanner;

public class Arena {
    public static void fight(Playable player1, Playable player2) {
        Scanner input = new Scanner(System.in);
        Random randomizer = new Random();
        System.out.println("Que a batalha comece!");

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            System.out.println(player1.getName() + " (HP: " + player1.getHealth() + ", Mana: " + player1.getMagic() + ")");
            System.out.println("Choose your attack: (0 - Slash Dash (-5 mana);");
            System.out.println("(1 - Fire Blast (-4 mana);");
            System.out.println("(2 - Divine Spears (-3 mana);");
            System.out.println("(3 - Mach Rush (-4 mana);");
            System.out.println("(4 - Nourish (+10 mana);");
            int player1Damage = 0;
            int player1Choice = input.nextInt();
            if(player1Choice == 0){
                player1Damage = player1.atk_SlashDash();
                System.out.println(player1.getName() + " usou Slash Dash em " + player2.getName() + " e causou " + player1Damage + " de dano.");
                player2.receiveDamage(player1Damage);
            }else if(player1Choice == 1){
                player1Damage = player1.atk_FireBlast();
                System.out.println(player1.getName() + " usou Fire Blast em " + player2.getName() + " e causou " + player1Damage + " de dano.");
                player2.receiveDamage(player1Damage);
            }else if(player1Choice == 2){
                player1Damage = player1.atk_DivineSpears();
                System.out.println(player1.getName() + " usou Divine Spears em " + player2.getName() + " e causou " + player1Damage + " de dano.");
                player2.receiveDamage(player1Damage);
            }else if(player1Choice == 3){
                player1Damage = player1.atk_MachRush();
                System.out.println(player1.getName() + " usou Mach Rush " + player2.getName() + " e causou " + player1Damage + " de dano.");
                player2.receiveDamage(player1Damage);
            }else if(player1Choice == 4){
                player1.setMana(player1.spell_Nourish());
                System.out.println(player1.getName()+" usou Nourish e recuperou "+ player1.spell_Nourish()+" de mana.");
            }

            if (player2.getHealth() <= 0) {
                System.out.println(player2.getName() + " foi derrotado!");
                break;
            }



            int player2Choice = randomizer.nextInt(5);
            int player2Damage = 0;
            if(player2Choice == 0){
                player2Damage = player2.atk_SlashDash();
                System.out.println(player2.getName() + " usou Slash Dash em " + player1.getName() + " e causou " + player2Damage + " de dano.");
                player1.receiveDamage(player2Damage);
            }else if(player2Choice == 1){
                player2Damage = player2.atk_FireBlast();
                System.out.println(player2.getName() + " usou Fire Blast em " + player1.getName() + " e causou " + player2Damage + " de dano.");
                player1.receiveDamage(player2Damage);
            }else if(player2Choice == 2){
                player2Damage = player2.atk_DivineSpears();
                System.out.println(player2.getName() + " usou Divine Spears em " + player1.getName() + " e causou " + player2Damage + " de dano.");
                player1.receiveDamage(player2Damage);
            }else if(player2Choice == 3){
                player2Damage = player2.atk_MachRush();
                System.out.println(player2.getName() + " usou Mach Rush " + player1.getName() + " e causou " + player2Damage + " de dano.");
                player1.receiveDamage(player2Damage);
            }else if(player1Choice == 4){
                player2.setMana(player2.spell_Nourish());
                System.out.println(player2.getName()+" usou Nourish e recuperou "+ player2.spell_Nourish()+" de mana.");
            }


            if (player1.getHealth() <= 0) {
                System.out.println(player1.getName() + " foi derrotado!");
                break;
            }
        }
    }
}
