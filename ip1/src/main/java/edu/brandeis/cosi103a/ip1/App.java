package edu.brandeis.cosi103a.ip1;

import java.util.Scanner;
import java.util.Random;

/**
 * Two-player dice game where players take turns rolling a die
 * and accumulating points over 10 rounds.
 */
public class App 
{
    private static final int TURNS_PER_PLAYER = 10;
    private static final int MAX_REROLLS = 2;
    private static final int DIE_SIDES = 6;
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String player1Name = getPlayerName(scanner, 1);
        String player2Name = getPlayerName(scanner, 2);
        
        int player1Score = playGame(scanner, random, player1Name, player2Name);
        int player2Score = playGame(scanner, random, player2Name, player1Name);
        
        // Play alternating turns for each round
        int[] scores = new int[2];
        scores[0] = 0;
        scores[1] = 0;
        
        for (int turn = 0; turn < TURNS_PER_PLAYER; turn++) {
            System.out.println("\n--- Turn " + (turn + 1) + " ---");
            scores[0] += playTurn(scanner, random, player1Name);
            scores[1] += playTurn(scanner, random, player2Name);
            
            printScores(player1Name, scores[0], player2Name, scores[1]);
        }
        
        displayGameOver(player1Name, scores[0], player2Name, scores[1]);
        scanner.close();
    }
    
    /**
     * Get player name from user input
     */
    protected static String getPlayerName(Scanner scanner, int playerNumber)
    {
        System.out.print("Enter Player " + playerNumber + " name: ");
        return scanner.nextLine();
    }
    
    /**
     * Play a single turn for a player
     */
    protected static int playTurn(Scanner scanner, Random random, String playerName)
    {
        System.out.println("\n" + playerName + "'s turn:");
        
        int dieValue = rollDie(random);
        System.out.println("You rolled: " + dieValue);
        
        dieValue = handleRerolls(scanner, random, dieValue);
        
        System.out.println(playerName + " ends turn with: " + dieValue + " points");
        return dieValue;
    }
    
    /**
     * Handle reroll logic for a player's turn
     */
    protected static int handleRerolls(Scanner scanner, Random random, int currentDie)
    {
        int rerollsUsed = 0;
        
        while (rerollsUsed < MAX_REROLLS) {
            System.out.print("Do you want to reroll? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            
            if (isAffirmative(response)) {
                currentDie = rollDie(random);
                System.out.println("You rolled: " + currentDie);
                rerollsUsed++;
            } else {
                break;
            }
        }
        
        return currentDie;
    }
    
    /**
     * Check if response is affirmative
     */
    protected static boolean isAffirmative(String response)
    {
        return response.equals("yes") || response.equals("y");
    }
    
    /**
     * Roll a 6-sided die
     */
    protected static int rollDie(Random random)
    {
        return random.nextInt(DIE_SIDES) + 1;
    }
    
    /**
     * Determine the winner between two players
     */
    protected static String determineWinner(String player1Name, int player1Score, 
                                           String player2Name, int player2Score)
    {
        if (player1Score > player2Score) {
            return player1Name;
        } else if (player2Score > player1Score) {
            return player2Name;
        }
        return "Tie";
    }
    
    /**
     * Print current scores
     */
    protected static void printScores(String player1Name, int player1Score, 
                                      String player2Name, int player2Score)
    {
        System.out.println("\nScores: " + player1Name + ": " + player1Score + 
                         " | " + player2Name + ": " + player2Score);
    }
    
    /**
     * Display game over message and winner
     */
    protected static void displayGameOver(String player1Name, int player1Score,
                                         String player2Name, int player2Score)
    {
        System.out.println("\n--- GAME OVER ---");
        System.out.println(player1Name + " final score: " + player1Score);
        System.out.println(player2Name + " final score: " + player2Score);
        
        String winner = determineWinner(player1Name, player1Score, player2Name, player2Score);
        if (winner.equals("Tie")) {
            System.out.println("\nIt's a tie!");
        } else {
            System.out.println("\n" + winner + " wins!");
        }
    }
    
    /**
     * Main game loop (placeholder for future expansion)
     */
    protected static int playGame(Scanner scanner, Random random, String playerName, String opponentName)
    {
        return 0; // Placeholder
    }
}
