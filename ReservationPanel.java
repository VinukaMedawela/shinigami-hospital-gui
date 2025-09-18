import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.awt.*;

import model.*;

public class ReservationPanel extends JPanel implements MyObserver {//step 3 of MVC
    private JComboBox<Doctor> doctorComboBox; // Use a JComboBox to select doctors
    private Reservations reservations;
    private Doctors doctors;

    private JTextField nameField = new JTextField(60);
    private JComboBox<ReservationType> typeComboBox = new JComboBox<>(ReservationType.values());
    private JButton createButton = new JButton("Create Reservation");
    private JTextArea outputArea;

    public ReservationPanel(Reservations reservations, Doctors doctors) {
        this.reservations = reservations;
        this.doctors = doctors;
        doctorComboBox = new JComboBox<>();
        outputArea = new JTextArea(25, 50);
        outputArea.setEditable(false);
        setup(reservations);
        build();
    }

    private void setup(Reservations reservations) {
        reservations.attach(this);//step 4 of MVC
        typeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDoctorComboBox(); // Update the doctor combo box
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = nameField.getText().trim();
                if (patientName.isEmpty()) {
                    outputArea.setText("Error, Please enter a valid patient name.\n");
                    return;
                }

                ReservationType reservationType = (ReservationType) typeComboBox.getSelectedItem();
                Doctor selectedDoctor = (Doctor) doctorComboBox.getSelectedItem();

                if (selectedDoctor != null) {
                    reservations.add(patientName, reservationType, selectedDoctor);

                    outputArea.append("Reservation added: " + patientName + "\n");
                    nameField.setText("");
                }
            }
        });
    }

    private void build() {

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(new JLabel("Patient Name:"));
        panel1.add(nameField);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(new JLabel("Reservation Type:"));
        panel2.add(typeComboBox);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.add(new JLabel("Select Doctor:"));
        panel3.add(doctorComboBox); // Adding the doctor combo box
        updateDoctorComboBox();

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel4.add(createButton);

        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel5. add(new JScrollPane(outputArea));
        
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);

       
       
    }

    private void updateDoctorComboBox() {
        doctorComboBox.removeAllItems();
        ReservationType selectedType = (ReservationType) typeComboBox.getSelectedItem();
        LinkedList<Doctor> filteredDoctors = doctors.showAvailableDoctorsForReservationType(selectedType);

        for (Doctor doctor : filteredDoctors) {
            doctorComboBox.addItem(doctor);
        }
    }

    @Override//step 3 of MVC
    public void update() {
        updateDoctorComboBox();
    }
}
