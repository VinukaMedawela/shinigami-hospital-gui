package model;
public class Record extends Updater {//step1 of MVC
    protected int id;
    protected String name;
    protected ReservationType reservationType;

    public Record(int id, String name, ReservationType reservationType) {
        this.id = id;
        this.name = name;
        this.reservationType = reservationType;
    }

    public boolean matches(int id) {
        return this.id == id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    @Override
    public String toString() {
        return "ID Number - " + id + " || Name - " + name + " || Reservation Type - " + reservationType;
    }
}

