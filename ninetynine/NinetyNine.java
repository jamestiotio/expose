package ninetynine;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The NinetyNine program implements an application with a main loop that interacts with the user to
 * play the <b>Ninety Nine (99)</b> game via the standard input/output streams.
 * <p>
 * Created for SUTD PADI EXPOSE 2022 Course Trial (Computer Science).
 *
 * @author James Raphael Tiovalen
 * @version 1.0.0
 * @since 2022-02-24
 */
public class NinetyNine {
    // We use this integer instead of using a circular doubly linked list data structure since this
    // is much simpler
    public static int currentPlayerIndex = 0;
    public static boolean isForward = true;
    public static int currentRunningTotal = 0;
    // By default, three players will play the game
    public static int numOfPlayers = 3;
    // By default, the hand size of each player is five
    public static int handSize = 5;
    // By convention, we always set the user to be the first player (with index 0)
    public static ArrayList<Player> players = new ArrayList<Player>();
    public static SecureRandom aceRandomizer = new SecureRandom();

    public static void main(String[] args) {
        // Specify some guard clauses
        if (args.length > 2) {
            System.out.println("Please provide only two arguments at most.");
            System.exit(0);
        }

        if (args.length <= 0) {
            System.out.println(
                    "No arguments are supplied. The default number of players of 3 and the default hand size of 5 will be used.\n");
        }

        if (args.length > 0) {
            try {
                int specifiedNumOfPlayers = Integer.parseInt(args[0]);

                if (specifiedNumOfPlayers < 2) {
                    System.out.println("Please provide at least two players.");
                    System.exit(0);
                }

                numOfPlayers = specifiedNumOfPlayers;
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid number of players.");
                System.exit(0);
            }
        }

        if (args.length == 2) {
            try {
                int specifiedHandSize = Integer.parseInt(args[1]);

                if (specifiedHandSize < 2) {
                    System.out.println("Please specify at least 2 for the hand size.");
                    System.exit(0);
                }

                handSize = specifiedHandSize;
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid hand size.");
                System.exit(0);
            }
        }

        System.out.println("Number of players for this game: " + numOfPlayers);
        System.out.println("Hand size for this game: " + handSize + "\n");

        // Initialize the players
        for (int i = 0; i < numOfPlayers; i++) {
            players.add(new Player(i));
        }

        // Initialize the hands of each players
        for (Player player : players) {
            player.hand.initialize(handSize);
        }

        // TODO: Initialize the Scanner to scan for user input as "scanner"
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print the current running total
            System.out.println("Current running total: " + currentRunningTotal + "\n");

            Player currentPlayer = players.get(currentPlayerIndex);
            // Print the hand of the current player
            currentPlayer.printHand();

            int currentPlayerID = currentPlayer.getPlayerID();

            if (currentPlayerID == 0) {
                System.out.println("Please enter the index of the card you want to play:");
                while (true) {
                    try {
                        // TODO: Read the user player's input and store it in "selectedCardIndex"
                        int selectedCardIndex = Integer.parseInt(scanner.nextLine().trim());

                        if (selectedCardIndex < 0 || selectedCardIndex >= handSize) {
                            System.out.println("Please select a valid card index:");
                            continue;
                        }

                        // Get the card at the specified index
                        Card selectedCard =
                                currentPlayer.hand.selectSpecificCard(selectedCardIndex);

                        // TODO: Print the current selected card
                        System.out.println("You selected: " + selectedCard.toString() + "\n");

                        // Add the value of the selected card to the current running total
                        int cardValue = selectedCard.getValue();
                        switch (cardValue) {
                            case 4:
                                isForward = !isForward;
                            case 9:
                                break;
                            case 10:
                                currentRunningTotal -= 10;
                                break;
                            case 11:
                            case 12:
                                currentRunningTotal += 10;
                                break;
                            case 13:
                                currentRunningTotal = 99;
                                break;
                            case 14:
                                System.out.println(
                                        "Please select the value of the Ace card (either 1 or 11):");
                                while (true) {
                                    try {
                                        int selectedCardValue =
                                                Integer.parseInt(scanner.nextLine().trim());

                                        if (selectedCardValue == 1 || selectedCardValue == 11) {
                                            currentRunningTotal += selectedCardValue;
                                        } else {
                                            System.out.println(
                                                    "Please select a valid Ace card value:");
                                            continue;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Please select a valid Ace card value:");
                                        continue;
                                    }
                                    break;
                                }
                                break;
                            default:
                                currentRunningTotal += cardValue;
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please select a valid card index:");
                        continue;
                    }
                    break;
                }
            } else {
                // Let the CPU players choose a random card to play
                System.out.println(
                        "CPU Player " + currentPlayerID + " is choosing a card to play...");
                Card selectedCard = currentPlayer.hand.selectRandomCard();
                System.out.println(
                        "CPU Player " + currentPlayerID + " selected: " + selectedCard + "\n");
                int cardValue = selectedCard.getValue();
                switch (cardValue) {
                    case 4:
                        isForward = !isForward;
                    case 9:
                        break;
                    case 10:
                        currentRunningTotal -= 10;
                        break;
                    case 11:
                    case 12:
                        currentRunningTotal += 10;
                        break;
                    case 13:
                        currentRunningTotal = 99;
                        break;
                    case 14:
                        int selectedCardValue = aceRandomizer.nextBoolean() ? 1 : 11;
                        System.out.println("CPU Player " + currentPlayerID + " selected the value "
                                + selectedCardValue + " for the Ace card.\n");
                        currentRunningTotal += selectedCardValue;
                        break;
                    default:
                        currentRunningTotal += cardValue;
                        break;
                }
            }

            // If the current running total is greater than 99, remove the current player from the
            // player list
            if (currentRunningTotal > 99) {
                // TODO: If the player loses, print "You lose!" (hint: player has ID 0)
                // Otherwise, print the CPU player that loses the game.
                // Hint: You can use "currentPlayerID" to get the current player's ID as an integer
                if (currentPlayerID == 0) {
                    System.out.println("You lose!\n");
                } else {
                    System.out.println(
                            "CPU Player " + currentPlayerID + " is removed from the game.\n");
                }
                players.remove(currentPlayerIndex);
                int currentNumOfPlayers = players.size();
                if (isForward) {
                    currentPlayerIndex =
                            (currentPlayerIndex - 1 + currentNumOfPlayers) % currentNumOfPlayers;
                } else {
                    currentPlayerIndex %= currentNumOfPlayers;
                }

                currentRunningTotal = 0;
            }

            // Change the current player index depending on the direction of the game, modulo the
            // current number of players
            int currentNumOfPlayers = players.size();
            if (isForward) {
                currentPlayerIndex = (currentPlayerIndex + 1) % currentNumOfPlayers;
            } else {
                currentPlayerIndex =
                        (currentPlayerIndex - 1 + currentNumOfPlayers) % currentNumOfPlayers;
            }

            // End the game when there is one person left
            if (players.size() == 1) {
                int winnerID = players.get(0).getPlayerID();
                if (winnerID == 0) {
                    System.out.println("You win!");
                } else {
                    System.out.println("CPU Player " + winnerID + " wins!");
                }
                break;
            }
        }

        // Close the Scanner to avoid memory resource leak
        scanner.close();
    }
}
