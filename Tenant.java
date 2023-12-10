public class Tenant extends Player {
    public Tenant(String name) {
        super(name);
    }

    public void payRent(Property property) {
        int rentAmount = property.getRent();
        Player owner = property.getOwner();

        if (owner != null) {
            if (canAfford(rentAmount)) {
                pay(rentAmount);
                owner.receiveRent(rentAmount);
                System.out.println(getName() + " paid rent of $" + rentAmount + " to " + owner.getName());
            } else {
                System.out.println(getName() + " cannot afford the rent for " + property.getName());
                // Implement additional logic here, e.g., bankrupt the player
            }
        } else {
            System.out.println(property.getName() + " is not owned. No rent is paid.");
        }
    }
}
