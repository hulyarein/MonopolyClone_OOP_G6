public class Tenant extends Player {
    public Tenant(String name) {
        super(name);
    }

    public void payRent(Property property) {
        int rentAmount = property.getRent();
        if (canAfford(rentAmount)) {
            pay(rentAmount);
            property.getOwner().receiveRent(rentAmount);
            System.out.println(getName() + " paid rent of $" + rentAmount + " to " + property.getOwner().getName());
        } else {
            System.out.println(getName() + " cannot afford the rent for " + property.getName());
            // Implement additional logic here, e.g., bankrupt the player
        }
    }


}
