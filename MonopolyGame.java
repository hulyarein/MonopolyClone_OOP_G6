import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MonopolyGame extends JFrame {
    private JPanel mainPanel;
    private JLabel backgroundImageLabel;

    public static void main(String[] args) {
        MonopolyGame frame = new MonopolyGame();
        // Set up the main frame
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setContentPane(frame.mainPanel);
        frame.setSize(1440, 1080);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Initialize game variables and start the game
        startGame();
    }
    public MonopolyGame() {
        // Load the background image
        ImageIcon backgroundImageIcon = new ImageIcon("monopoly_original.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1440, 900, Image.SCALE_DEFAULT);
        backgroundImageIcon = new ImageIcon(backgroundImage);

        // Set up the layout
        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundImageLabel, GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundImageLabel, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
    }

    private static void startGame() {
        // Create players and board spaces
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        StreetProperty mediterraneanAve = new StreetProperty("Mediterranean Avenue", 60, "Brown");
        StreetProperty balticAve = new StreetProperty("Baltic Avenue", 60, "Brown");
        StreetProperty orientalAve = new StreetProperty("Oriental Avenue", 100, "LightBlue");
        StreetProperty vermontAve = new StreetProperty("Vermont Avenue", 100, "LightBlue");
        StreetProperty connecticutAve = new StreetProperty("Connecticut Avenue", 100, "LightBlue");
        StreetProperty STcharlesPlace = new StreetProperty("St. Charles Place", 140, "Pink");
        StreetProperty statesAve = new StreetProperty("States Avenue", 140, "Pink");
        StreetProperty virginiaAve = new StreetProperty("Virginia Avenue", 160, "Pink");
        StreetProperty STjamesPlace = new StreetProperty("St. James Place", 140, "Orange");
        StreetProperty tennesseeAve = new StreetProperty("Tennessee Avenue", 180, "Orange");
        StreetProperty newyorkAve = new StreetProperty("New York Avenue", 200, "Orange");
        StreetProperty kentuckyAve = new StreetProperty("Kentucky Avenue", 220, "Red");
        StreetProperty indianaAve = new StreetProperty("Indiana Avenue", 220, "Red");
        StreetProperty illinoisAve = new StreetProperty("Illinois Avenue", 240, "Red");
        StreetProperty atlanticAve = new StreetProperty("Atlantic Avenue", 260, "Yellow");
        StreetProperty ventnorAve = new StreetProperty("Ventnor Avenue", 260, "Yellow");
        StreetProperty marvinGardens = new StreetProperty("Marvin Gardens", 280, "Yellow");
        StreetProperty pacificAve = new StreetProperty("Pacific Avenue", 300, "Green");
        StreetProperty northcarolinaAve = new StreetProperty("North Carolina Avenue", 300, "Green");
        StreetProperty pennsylvaniaAve = new StreetProperty("Pennsylvania Avenue", 320, "Green");
        StreetProperty parkPlace = new StreetProperty("Park Place", 350, "Blue");
        StreetProperty boardWalk = new StreetProperty("Board Walk", 400, "Blue");

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
//                case 1: // Go, Collect Salary
//                    // Already handled when passing Go
//                    break;
                case 2: // Mediterranean Avenue
                    try {
                        Handle.handleStreetProperty(currentPlayer, mediterraneanAve);
                    } catch (Exception e) {
                        System.out.println("Exception occurred on Mediterranean Avenue: " + e.getMessage());
                    }
                    break;
                case 3: // Community Chest
                    CommunityChestCard communityChestCard = new CommunityChestCard("Community Chest Card Description"); // add desc here
                    communityChestCard.executeAction(currentPlayer);
                    break;
                case 4: // Baltic Avenue
                    Handle.handleStreetProperty(currentPlayer, balticAve);
                    break;
                case 5: // Income Tax
                    IncomeTax incomeTax = new IncomeTax("Income Tax", 200);
                    incomeTax.collectIncomeTax(currentPlayer);
                    break;
                case 6: // Reading Railroad
                    Handle.handleRailroadProperty(currentPlayer, "Reading Railroad", 200);
                    break;
                case 7: // Oriental Avenue
                    Handle.handleStreetProperty(currentPlayer, orientalAve);
                    break;
                case 8: // Chance
                    ChanceCard chanceCard = new ChanceCard("Chance Card Description"); // Add pata desc here
                    chanceCard.executeAction(currentPlayer);
                    break;
                case 9: // Vermont Avenue
                    Handle.handleStreetProperty(currentPlayer, vermontAve);
                    break;
                case 10: // Connecticut Avenue
                    Handle.handleStreetProperty(currentPlayer, connecticutAve);
                    break;
                case 11: // Just Visiting/In Jail
                    if (!jail.isPlayerInJail(currentPlayer)) {
                        System.out.println(currentPlayer.getName() + " is just visiting Jail.");
                    } else {
                        System.out.println(currentPlayer.getName() + " is in Jail. Pay $50 to get out or roll doubles on your next turn.");
                        // Implement additional logic for handling Jail, e.g., paying to get out or rolling doubles
                    }
                    break;
                case 12: // St. Charles Place
                    Handle.handleStreetProperty(currentPlayer, STcharlesPlace);
                    break;
                case 13: // Electric Company
                    Handle.handleUtilityProperty(currentPlayer, "Electric Company", 150);
                    break;
                case 14: // States Avenue
                    Handle.handleStreetProperty(currentPlayer, statesAve);
                    break;
                case 15: // Virginia Avenue
                    Handle.handleStreetProperty(currentPlayer, virginiaAve);
                    break;
                case 16: // Pennsylvania Railroad
                    Handle.handleRailroadProperty(currentPlayer, "Pennsylvania Railroad", 200);
                    break;
                case 17: // St. James Place
                    Handle.handleStreetProperty(currentPlayer, STjamesPlace);
                    break;
                case 18: // Community Chest
                    CommunityChestCard communityChestCard2 = new CommunityChestCard("Community Chest Card Description"); // Add pata desc here
                    communityChestCard2.executeAction(currentPlayer);
                    break;
                case 19: // Tennessee Avenue
                    Handle.handleStreetProperty(currentPlayer, tennesseeAve);
                    break;
                case 20: // New York Avenue
                    Handle.handleStreetProperty(currentPlayer, newyorkAve);
                    break;
                case 21: // Free Parking
                    freeParking.handleFreeParking(currentPlayer);
                    break;
                case 22: // Kentucky Avenue
                    Handle.handleStreetProperty(currentPlayer, kentuckyAve);
                    break;
                case 23: // Chance
                    ChanceCard chanceCard2 = new ChanceCard("Chance Card Description"); // Add pata desc here
                    chanceCard2.executeAction(currentPlayer);
                    break;
                case 24: // Indiana Avenue
                    Handle.handleStreetProperty(currentPlayer, indianaAve);
                    break;
                case 25: // Illinois Avenue
                    Handle.handleStreetProperty(currentPlayer, illinoisAve);
                    break;
                case 26: // B. & O. Railroad
                    Handle.handleRailroadProperty(currentPlayer, "B. & O. Railroad", 200);
                    break;
                case 27: // Atlantic Avenue
                    Handle.handleStreetProperty(currentPlayer, atlanticAve);
                    break;
                case 28: // Ventnor Avenue
                    Handle.handleStreetProperty(currentPlayer, ventnorAve);
                    break;
                case 29: // Water Works
                    Handle.handleUtilityProperty(currentPlayer, "Water Works", 150);
                    break;
                case 30: // Marvin Gardens
                    Handle.handleStreetProperty(currentPlayer, marvinGardens);
                    break;
                case 31: // Go to Jail
                    jail.sendToJail(currentPlayer);
                    break;
                case 32: // Pacific Avenue
                    Handle.handleStreetProperty(currentPlayer, pacificAve);
                    break;
                case 33: // North Carolina Avenue
                    Handle.handleStreetProperty(currentPlayer, northcarolinaAve);
                    break;
                case 34: // Community Chest
                    CommunityChestCard communityChestCard3 = new CommunityChestCard("Community Chest Card Description"); // Add pata desc here
                    communityChestCard3.executeAction(currentPlayer);
                    break;
                case 35: // Pennsylvania Avenue
                    Handle.handleStreetProperty(currentPlayer, pennsylvaniaAve);
                    break;
                case 36: // Short Line
                    Handle.handleRailroadProperty(currentPlayer, "Short Line", 200);
                    break;
                case 37: // Chance
                    ChanceCard chanceCard3 = new ChanceCard("Chance Card Description"); // Add pata desc here
                    chanceCard3.executeAction(currentPlayer);
                    break;
                case 38: // Park Place
                    Handle.handleStreetProperty(currentPlayer, parkPlace);
                    break;
                case 39: // Luxury Tax
                    ChanceCard.LuxuryTax luxuryTax = new ChanceCard.LuxuryTax("Luxury Tax", 100);
                    luxuryTax.collectLuxuryTax(currentPlayer);
                    break;
                case 0: // Boardwalk //
                    Handle.handleStreetProperty(currentPlayer, boardWalk);
                    break;
                // CASE 40 IS UNREACHABLE == ILISAN UG "case 0:" NEED FIX!
//                currentPlayer.getPosition() % 40 range from 0 to 39, not including 40. Therefore,
//                    the case 40: is unreachable because the maximum value it can take is 39.
//                To fix this issue, you can remove the case 40: and handle the case when
//                        currentPlayer.getPosition() % 40 is 0 separately.
                default:
                    // throw new IllegalStateException("Unexpected value: " + currentPlayer.getPosition() % 40);
                    System.err.println("Unexpected value: " + currentPlayer.getPosition() % 40);
                    break;
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
