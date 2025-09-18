package model;
public class Doctor extends Record {
    private AvailableDay availableDay;

    public Doctor(int id, String name, AvailableDay availableDay, ReservationType reservationType) {
        super(id, name, reservationType);
        this.availableDay = availableDay;
    }

    public AvailableDay getAvailableDay() {
        return availableDay;
    }

    @Override
    public String toString() {
        return super.toString() + " || Available on " + availableDay;
    }
}

