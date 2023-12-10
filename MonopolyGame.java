import java.util.Scanner;

public class MonopolyGame {

    public static void main(String[] args) {
        // Create players and board spaces
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        StreetProperty mediterraneanAve = new StreetProperty("Mediterranean Avenue", 60, "Brown");
        StreetProperty balticAve = new StreetProperty("Baltic Avenue", 60, "Brown");
        // ZED GWAPO
        // ... Create other street properties, utilities, railroads, and other spaces

        Jail jail = new Jail();
        FreeParking freeParking = new FreeParking();

        // Initialize game variables
        int currentPlayerIndex = 0; // Start with the first player
        boolean gameIsRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (gameIsRunning) {
            Player currentPlayer = (currentPlayerIndex == 0) ? player1 : player2;

            // Simulate dice roll
            int diceRoll = (int) (Math.random() * 6) + 1;

            // Update player position based on dice roll
            currentPlayer.move(diceRoll);

            // Check for passing Go and collect salary
            if (currentPlayer.getPosition() % 40 == 1) {
                int rotations = currentPlayer.getPosition() / 40;
                int salary = 200 * rotations;
                currentPlayer.addToMoney(salary);
                System.out.println(currentPlayer.getName() + " passed Go and collected $" + salary);
            }

            // Handle board spaces based on player position
            switch (currentPlayer.getPosition() % 40) {
                case 1: // Go, Collect Salary
                    // Already handled when passing Go
                    break;
                case 2: // Mediterranean Avenue
                    // Implement logic for Mediterranean Avenue
                    break;
                case 3: // Community Chest
                    // Implement logic for Community Chest
                    break;
                case 4: // Baltic Avenue
                    // Implement logic for Baltic Avenue
                    break;
                // ... Repeat for other board spaces

                case 11: // Just Visiting/In Jail
                    // Implement logic for Jail
                    break;
                // ... Repeat for other board spaces

                case 21: // Free Parking
                    // Implement logic for Free Parking
                    break;
                // ... Repeat for other board spaces

                case 31: // Go to Jail
                    // Implement logic for Go to Jail
                    jail.sendToJail(currentPlayer);
                    break;
                // ... Repeat for other board spaces

                // ... Repeat for other board spaces
            }

            // Check if a player is bankrupt
            if (currentPlayer.getMoney() <= 0) {
                System.out.println(currentPlayer.getName() + " is bankrupt. Game over!");
                gameIsRunning = false;
            }

            // Switch to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % 2;

            // Ask for user input to continue the game
            System.out.println("Press Enter to continue or type 'quit' to end the game:");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("quit")) {
                gameIsRunning = false;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
