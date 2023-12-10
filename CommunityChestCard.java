import java.util.Random;

public class CommunityChestCard extends Card {
    public CommunityChestCard(String description) {
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
                payFine(player);
                break;
            // Add more cases for other actions
        }
    }

    private void collectMoney(Player player) {
        int amount = generateRandomAmount();
        player.receiveMoney(amount);
        System.out.println(player.getName() + " collected $" + amount + " from Community Chest.");
    }

    private void payFine(Player player) {
        int amount = generateRandomAmount();
        player.pay(amount);
        System.out.println(player.getName() + " paid a fine of $" + amount + " to Community Chest.");
    }

    private int generateRandomAmount() {
        Random random = new Random();
        return random.nextInt(151) + 50;
    }
}
