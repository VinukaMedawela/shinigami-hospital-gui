package model;

public class Reservation extends Record {
    private Doctor doctor;

    public Reservation(int id, String patientName, ReservationType reservationType, Doctor doctor) {
        super(id, patientName, reservationType);
        this.doctor = doctor;
    }

    public void setPatientName(String patientName) {
        this.name = patientName;
        updateViews(); //step 1 of MVC
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return super.toString() + " and doctor is " + doctor.getName();
    }
}

