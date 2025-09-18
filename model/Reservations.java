package model;

import java.util.LinkedList;

public class Reservations extends Records {

    public Reservation find(int id) {
        return (Reservation) super.find(id);
    }

    public void add(String patientName, ReservationType reservationType, Doctor doctor) {
        Reservation reservation = new Reservation(id++, patientName, reservationType, doctor);
        super.add(reservation);
        updateViews(); //step 1 of MVC
    }

    public void remove(int reservationId) {
        Reservation reservationToRemove = find(reservationId);
        if (reservationToRemove != null) {
            records.remove(reservationToRemove);
            updateViews(); //step 1 of MVC
        }
    }

    public Doctor findDoctorForReservation(Reservation reservation) {
        for (Record record : records) {
            if (record instanceof Doctor) {
                Doctor doctor = (Doctor) record;
                if (hasReservation(reservation)) {
                    return doctor;
                }
            }
        }
        return null;
    }

    public void updateReservationPatientName(int reservationId, String newPatientName) {
        for (Record record : records) {
            if (record instanceof Reservation) {
                Reservation reservation = (Reservation) record;
                if (reservation.getId() == reservationId) {
                    reservation.setPatientName(newPatientName);
                    updateViews();
                    
                }
            }
        }
        
    }

    public boolean hasReservation(Reservation reservation) {
        for (Record record : records) {
            if (record instanceof Reservation && record.getId() == reservation.getId()) {
                return true;
            }
        }
        return false;
    }

    public int getReservationsCount() {
        int count = 0;
        for (Record record : records) {
            if (record instanceof Reservation) {
                count++;
            }
        }
        return count;
    }
    
    @Override
    public String toString() {
        return "Reservations \n-----------------\n" + super.toString();
    }
}
