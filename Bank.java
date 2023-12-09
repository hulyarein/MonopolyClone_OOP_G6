public class Bank {
    private int money;

    public Bank(int initialMoney) {
        this.money = initialMoney;
    }

    public void transferMoney(Player sender, Player receiver, int amount) {
        if (sender.canAfford(amount)) {
            sender.pay(amount);
            receiver.receiveMoney(amount);
            System.out.println(sender.getName() + " paid $" + amount + " to " + receiver.getName());
        } else {
            System.out.println(sender.getName() + " does not have enough money to make the transfer.");
            // Implement additional logic, e.g., bankrupt the player
        }
    }

    // Other methods for managing bank transactions, properties, etc.
}