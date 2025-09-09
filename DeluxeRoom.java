package assignment1;

public class DeluxeRoom extends Room {
    private boolean breakfastIncluded;
    private double extraAmenitiesCharge;

    public DeluxeRoom(int roomNo, double basePrice, boolean breakfastIncluded, double extraAmenitiesCharge) {
        super(roomNo, "Deluxe", basePrice);
        this.breakfastIncluded = breakfastIncluded;
        this.extraAmenitiesCharge = extraAmenitiesCharge;
    }

    public boolean isBreakfastIncluded() { return breakfastIncluded; }
    public void setBreakfastIncluded(boolean breakfastIncluded) { this.breakfastIncluded = breakfastIncluded; }
    public double getExtraAmenitiesCharge() { return extraAmenitiesCharge; }
    public void setExtraAmenitiesCharge(double extraAmenitiesCharge) { this.extraAmenitiesCharge = extraAmenitiesCharge; }

    public void book(boolean breakfast, String couponCode) {
        if (!isBooked()) {
            setBooked(true);
            this.breakfastIncluded = breakfast;
            double discount = couponCode.equalsIgnoreCase("DISC10") ? 0.1 : 0;
            System.out.println("Deluxe Room " + getRoomNo() + " booked with discount: " + (discount * 100) + "%");
        } else {
            System.out.println("Room already booked.");
        }
    }

    @Override
    public double computeBill() {
        double total = getBasePrice() + extraAmenitiesCharge;
        if (breakfastIncluded) total += 200;
        return total;
    }
}
