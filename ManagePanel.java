import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import model.*;

public class ManagePanel extends JPanel implements MyObserver {//step 3
    private JTextArea outputArea;
    private Reservations reservations;

    private JLabel reservationIdLabel = new JLabel("Reservation ID:");
    private JTextField reservationIdField = new JTextField(10);
    
    private JLabel newPatientNameLabel = new JLabel("New Patient Name:");
    private JTextField newPatientNameField = new JTextField(20);

    private JButton deleteButton = new JButton("Delete Reservation");
    
    private JButton updateButton = new JButton("Update Patient Name");

    public ManagePanel(Reservations reservations) {
        this.reservations = reservations;
        
        //outputArea.setEditable(false);
        setup();
        build();
    }

    private void setup() {
        // Attach this panel as an observer to the reservations            
        deleteButton.addActionListener(new DeleteListener());
        updateButton.addActionListener(new UpdateListener());
        reservations.attach(this);

    }
                   
        
    private class DeleteListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent e) {
            String reservationIdText = reservationIdField.getText();
            if (!isValidReservationId(reservationIdText)) {
                outputArea.append("Please enter a valid reservation ID.Error");
                return;
            }
    
            int reservationId = Integer.parseInt(reservationIdText);
            Reservation reservation = reservations.find(reservationId);
    
            if (reservation != null) {
                reservations.remove(reservationId);
                outputArea.append("Reservation deleted: ID " + reservationId + "\n");
            }else {
                outputArea.append("Reservation with ID " + reservationId + " not found.Error");
            }
    
            reservationIdField.setText("");
                    
        }
    }
        
    private class UpdateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                
                
            String reservationIdText = reservationIdField.getText();
                        
            String newPatientName = newPatientNameField.getText();
        
            if (!isValidReservationId(reservationIdText)) {
                outputArea.append("Please enter a valid reservation ID.");
                return;
            }
        
            int reservationId = Integer.parseInt(reservationIdText);
            Reservation reservation = reservations.find(reservationId);
        
            if (reservation != null) {
            
                reservations.updateReservationPatientName(reservationId, newPatientName);
                if(reservations.find(reservationId).getName() == newPatientName){
                    outputArea.append("Patient Name updated for reservation with ID " + reservationId);
                }
                else{
                    outputArea.append("Reservation with ID " + reservationId + " not found");
                }
                update();
            } else {
                outputArea.append("Reservation with ID " + reservationId + " not found.");
            }
        
            reservationIdField.setText("");
            newPatientNameField.setText("");
        }
            
    }

    private void build() {
        // Build the panel components and layout
        
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(reservationIdLabel);
        panel1.add(reservationIdField);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(deleteButton);
        

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.add(newPatientNameLabel);
        panel3.add(newPatientNameField);
        panel3.add(updateButton);
        

        add(panel1);
        add(panel2);
        add(panel3);
        
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outputArea = new JTextArea(25, 50);
        panel4.add(new JScrollPane(outputArea)); // Added scroll pane
        
    
        
        add(panel4);
        
        

    }

    private boolean isValidReservationId(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        try {
            int reservationId = Integer.parseInt(input);
            return reservationId >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // This method gets called when the reservations update
    @Override//step3
    public void update() {
        // Clear and update the output area with reservation information
        outputArea.setText(reservations.toString()); // Assuming you have a toString() method in Reservations
    }
}
