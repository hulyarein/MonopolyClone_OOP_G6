public class FreeParking {
    private String name;

    public FreeParking(String name) {
        this.name = name;
    }

    public FreeParking() {

    }

    public void handleFreeParking(Player player) {
        System.out.println(player.getName() + " landed on Free Parking at " + name);
    }
}