

import javax.swing.*;
import model.*;
import java.util.LinkedList;

public class DoctorPanel extends JPanel implements MyObserver {//step 3 of MVC
    private JTextArea doctorArea;
    private Doctors doctors;

    public DoctorPanel(Doctors doctors) {
        this.doctors = doctors;
        doctorArea = new JTextArea(25, 55);
        doctorArea.setEditable(false);
        setup(doctors);
        build();
    }

    private void setup(Doctors doctors) {
        // Attach this panel as an observer to the doctors
        doctors.attach(this); //step 4 of MVC
    }

    private void build() {
        add(new JScrollPane(doctorArea));
        updateDoctorArea();
    }

    private void updateDoctorArea() {
        doctorArea.setText("");
        LinkedList<Doctor> allDoctors = doctors.getAllDoctors();
        for (Doctor doctor : allDoctors) {
            doctorArea.append(doctor.toString() + "\n");
        }
    }

    @Override // step 3 of MVC
    public void update() {
        updateDoctorArea();
    }
}
