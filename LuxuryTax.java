public class LuxuryTax {
    private String name;
    private int taxAmount;

    public LuxuryTax(String name, int taxAmount) {
        this.name = name;
        this.taxAmount = taxAmount;
    }

    public void collectLuxuryTax(Player player) {
        player.pay(taxAmount);
        System.out.println(player.getName() + " paid $" + taxAmount + " for luxury tax at " + name);
    }
}