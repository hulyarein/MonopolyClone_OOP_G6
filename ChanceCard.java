import java.util.Random;

public class ChanceCard extends Card {
    public ChanceCard(String description) {
        super(description);
    }
    public void executeAction(Player player) {

        Random random = new Random();
        int actionType = random.nextInt(2);

        switch (actionType) {
            case 0:
                collectMoney(player);
                break;
            case 1:
                movePlayer(player);
                break;
            // Add more cases for other actions
        }
    }

    private void collectMoney(Player player) {
        int amount = generateRandomAmount();
        player.receiveMoney(amount);
        System.out.println(player.getName() + " collected $" + amount + " from Chance.");
    }

    private void movePlayer(Player player) {
        int steps = generateRandomSteps();
        player.move(steps);
        System.out.println(player.getName() + " moved " + steps + " steps from Chance.");
    }

    private int generateRandomAmount() {
        Random random = new Random();
        return random.nextInt(151) + 50;
    }

    private int generateRandomSteps() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}