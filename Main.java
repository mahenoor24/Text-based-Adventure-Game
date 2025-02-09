import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        String enemies[] = { "Skeleton", "Zombie", "Witch", "Giant Spider", "Dragon" };
        int maxEnemiesHealth = 75;
        int enemyAttackDamage = 25;

        int health = 100;
        int attackDmg = 50;
        int numHealthPots = 3;
        int healthPotionHealAmt = 30;
        int healthPotionDropChance = 50; // percentage

        boolean running = true;

        System.out.println("Welcome to the Adventure!");

        GAME: while (running) {
            System.out.println("----------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemiesHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t#" + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Use health potion");
                System.out.println("\t3. Run");

                String input = in.nextLine();
                
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDmg);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPots > 0) {
                        health += healthPotionHealAmt;
                        numHealthPots--;
                        System.out.println("\t> You drink a health potion, healing for " + healthPotionHealAmt + "."
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numHealthPots + " health potions left.\n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME;
                } else {
                    System.out.println("\tInvalid command!");
                }
            }

            if (health < 1) {
                System.out.println("You limp out of the adventure, weak from battle.");
                break;
            }

            System.out.println("----------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. #");

            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPots++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPots + " health potion(s). # ");
            }

            System.out.println("----------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit adventure");

            String input = in.nextLine();
            
            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("\tInvalid command!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue on your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the adventure, successful from your battles!");
                break;
            }
        }

        System.out.println("#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("#######################");
        in.close();
    }
}
