public class Player {
    private String name;
    private int position;
    private int money;
    private boolean inJail;
    private boolean hasGetOutOfJailFreeCard;
    public Player(String name) {
        this.name = name;
        this.position = 1; // Starting position on the board
        this.money = 1500; // Starting money
        this.inJail = false;
        this.hasGetOutOfJailFreeCard = false;
    }

    public void move(int steps) {
        position += steps;
        System.out.println(name + " moved to position " + position);
    }

    public boolean canAfford(int cost) {
        return money >= cost;
    }

    public void pay(int amount) {
        if (canAfford(amount)) {
            money -= amount;
        } else {
            System.out.println(name + " does not have enough money to pay " + amount);
            // Implement additional logic here, e.g., bankrupt the player
        }
    }

    public void receiveRent(int amount) {
        money += amount;
    }

    // Add getters and setters as needed

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void receiveMoney(int amount) {
        money += amount;
        System.out.println(name + " received $" + amount);
    }
    public boolean isInJail() {
        return inJail;
    }
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
    public void addToMoney(int amount) {
        money += amount;
        System.out.println(name + " received $" + amount + ". Current balance: $" + money);
    }

    public void payRent(int amount) {
        this.money -= amount;
    }

    public void sendToJail(Player player) {
        player.setPosition(11);
        player.setInJail(true);
        System.out.println(player.getName() + " is in jail!");
    }

    public void receiveGetOutOfJailFreeCard() {
        this.hasGetOutOfJailFreeCard = true;
    }

    public boolean hasGetOutOfJailFreeCard() {
        return this.hasGetOutOfJailFreeCard;
    }

}

