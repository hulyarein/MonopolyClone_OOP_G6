public class IncomeTax {
    private String name;
    private int fixedTaxAmount;

    public IncomeTax(String name, int fixedTaxAmount) {
        this.name = name;
        this.fixedTaxAmount = fixedTaxAmount;
    }

    public void collectIncomeTax(Player player) {
        int taxToPay = Math.min(fixedTaxAmount, player.getMoney());
        player.pay(taxToPay);
        System.out.println(player.getName() + " paid $" + taxToPay + " in income tax at " + name);
    }
}
