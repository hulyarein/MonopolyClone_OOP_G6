public class Jail {
    private String name;

    public Jail(String name) {
        this.name = name;
    }

    public Jail() {

    }

    public void sendToJail(Player player) {
        player.setPosition(11);
        player.setInJail(true);
        System.out.println(player.getName() + " is in jail!");
    }

    public boolean isPlayerInJail(Player player) {
        return player.isInJail();
    }
}