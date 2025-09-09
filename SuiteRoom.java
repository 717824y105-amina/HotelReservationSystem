package assignment1;

public class SuiteRoom extends Room {
    private boolean privatePool;
    private double luxuryTax;

    public SuiteRoom(int roomNo, double basePrice, boolean privatePool, double luxuryTax) {
        super(roomNo, "Suite", basePrice);
        this.privatePool = privatePool;
        this.luxuryTax = luxuryTax;
    }

    public boolean hasPrivatePool() { return privatePool; }
    public void setPrivatePool(boolean privatePool) { this.privatePool = privatePool; }
    public double getLuxuryTax() { return luxuryTax; }
    public void setLuxuryTax(double luxuryTax) { this.luxuryTax = luxuryTax; }

    @Override
    public double computeBill() {
        double total = getBasePrice();
        if (privatePool) total += 1000;
        total += luxuryTax;
        return total;
    }
}
