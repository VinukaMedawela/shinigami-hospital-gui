package model;
    
import java.util.LinkedList;

public class Doctors extends Records {
    public Doctors() {
        setupDoctors();
    }

    private void setupDoctors() {
        add(new Doctor(id++, "Srimal Wijeysinghe", AvailableDay.MONDAY, ReservationType.DOCTOR_RESERVATION));
        add(new Doctor(id++, "M.H Sugathapala", AvailableDay.TUESDAY, ReservationType.LAB_RESERVATION));
        add(new Doctor(id++, "Banuka Ekanayake", AvailableDay.WEDNESDAY, ReservationType.DOCTOR_RESERVATION));
        add(new Doctor(id++, "Nayana Selavaraj", AvailableDay.THURSDAY, ReservationType.LAB_RESERVATION));
        add(new Doctor(id++, "Hameez Mohammed", AvailableDay.THURSDAY, ReservationType.DOCTOR_RESERVATION));
        add(new Doctor(id++, "James knox", AvailableDay.THURSDAY, ReservationType.DOCTOR_RESERVATION));
    }
    

    
    public Doctor find(int id) {
        return (Doctor) super.find(id);
    }
    

    public LinkedList<Doctor> showAvailableDoctorsForReservationType(ReservationType reservationType) {
        LinkedList<Doctor> availableDoctors = new LinkedList<>();
        for (Record record : records) {
            if (record instanceof Doctor) {
                Doctor doctor = (Doctor) record;
                if (doctor.getReservationType() == reservationType) {
                    availableDoctors.add(doctor);
                }
            }
        }
        return availableDoctors;
    }
    
    public Doctor findDoctorForReservationType(ReservationType reservationType) {
        for (Record record : records) {
            if (record instanceof Doctor) {
                Doctor doctor = (Doctor) record;
                if (doctor.getReservationType() == reservationType) {
                    return doctor;
                }
            }
        }
        return null; 
    }
    
    public Doctor findDoctorByIdInfilteredList(LinkedList<Doctor> selectedDoctors, int id) {
        for (Doctor doctor : selectedDoctors) {
            if (doctor.getId() == id) {  
                return doctor;
            }
        }
        return null;
    }
    
    public LinkedList<Doctor> getAllDoctors() {
        LinkedList<Doctor> allDoctors = new LinkedList<>();
        for (Record record : records) {
            if (record instanceof Doctor) {
                allDoctors.add((Doctor) record);
            }
        }
        return allDoctors;
    }
    
    @Override
    public String toString(){
        return "Doctors \n-----------------\n" + super.toString();
    }
    
}