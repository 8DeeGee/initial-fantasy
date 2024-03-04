package Main;

import Entities.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random randomizer = new Random();
        String gameState = "choosingRace";
        //gameState can be = "choosingRace", "choosingName", "journey" and "combat";
        ArrayList<String> situations = new ArrayList<>(asList(
                "monsterEncounter",
                "potionEncounter",
                "itemEncounter"));

        ArrayList<Monster> enemies = new ArrayList<>();
        Playable player = null;
        Monster enemy = null;

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
            if(gameState == "choosingRace"){
                System.out.println("Escolha a sua raça: 1 - Humano; 2 - Anão; 3 - Elfo");
                System.out.println("(Digite 4 caso queira saber os status de cada classe)");
                raceIndex = input.nextInt();
            }
        }
        String playerName;
        while (gameState == "choosingName"){
            playerName = input.next();
            if(raceIndex == 1){
                player = new Human(playerName, 15, 20, 25, 1000,100);
            }else if(raceIndex == 2){
                player = new Dwarf(playerName, 15, 20, 15, 1800,50);
            }else{
                player = new Elf(playerName, 10, 50, 30, 700,150);
            }
            gameState = "journey";
            System.out.println("Perfeito! Seu personagem será "+playerName+"! vamos começar a sua jornada agora.");
        }

        String illusionOfFreeChoise;
        while (gameState == "journey"){
            if(player.getLevel() < 10){
                System.out.println("Digite 1 para ir para a esquerda; digite 2 para ir para frente; digite 3 para ir para a direita");
                illusionOfFreeChoise = input.next();
                int randomEncounter = randomizer.nextInt(10);

                if (randomEncounter == 0){
                    //found hp potion
                    int hpPotion = player.getLevel() * 100;
                    System.out.println("Você encontrou uma poção de vida! (+"+hpPotion+" de vida adicionados)");
                    player.setHealth(player.getHealth() + hpPotion);

                } else if (randomEncounter == 1){
                    //found a weapon
                    int weaponDamage = 10 + randomizer.nextInt(20);
                    System.out.println("Você encontrou uma arma! Ela adiciona +" + weaponDamage + " de força.");
                    player.setStrength(player.getStrength() + weaponDamage);

                } else if (randomEncounter == 2){
                    //found gold
                    int weaponDamage = 10 + randomizer.nextInt(20);
                    System.out.println("Você encontrou um cajado! Recebeu " + weaponDamage + " de poder mágico.");
                    player.setMagic(player.getMagic() + weaponDamage);

                } else if (randomEncounter <= 6){
                    //found monster
                    System.out.println("Oh não! você se deparou com um monstro!");
                    int randomMonsterHp = 500 + randomizer.nextInt(300);
                    int randomMonsterStrength = 10 + randomizer.nextInt(10);
                    int randomMonsterAgility = 10 + randomizer.nextInt(10);
                    enemy = new Monster(randomMonsterHp, randomMonsterStrength, randomMonsterAgility);
                    enemies.add(enemy);

                    Elf placeholder = new Elf("Patches", 2, 2, 2, 2000, 2);
                    Arena.fight(player, placeholder);

                } else if (randomEncounter == 7){
                    //found a friendly NPC
                    int manaRegenerated = 5 + randomizer.nextInt(10);
                    System.out.println("Você encontrou um NPC amigável! ele te dá um café revigorante (+"+manaRegenerated+" de mana).");

                } else if (randomEncounter == 8){
                    //found a trap
                    int trapDamage = 100 + randomizer.nextInt(50);
                    System.out.println("Você caiu em uma armadilha! Sofreu " + trapDamage + " de dano.");
                    player.setHealth(player.getHealth() - trapDamage);

                } else if (randomEncounter == 9){
                    //found a mysterious item
                    System.out.println("Você encontrou um item misterioso! Quem sabe o que ele faz...");

                }else if (randomEncounter > 9){
                    //found monster
                    System.out.println("Você não encontrou nada de interessante...");
                }
            }else {

            }
        }

        while (gameState.equals("combat")) {
            int playerTurnCounter = 0;
            int enemyTurnCounter = 0;

            playerTurnCounter += 1 * player.getAgility();
            enemyTurnCounter += 1 * enemy.getAgility();

            if(playerTurnCounter >= 100){
                System.out.println("");
            }

        }
    }
}