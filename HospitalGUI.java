import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;

public class HospitalGUI extends JFrame {
    private Doctors doctors;
    private Reservations reservations;

    public HospitalGUI() {
        super("Shinigami Hospital Reservation System");
        doctors = new Doctors();
        reservations = new Reservations();
        setup();
        build();
        setVisible(true);
    }

    private void setup() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void build() {
        JTabbedPane tabbedPane = new JTabbedPane();

        DoctorPanel docPanel = new DoctorPanel(doctors);
        ReservationPanel resPanel = new ReservationPanel(reservations, doctors);
        ManagePanel manPanel = new ManagePanel(reservations);
        ReportPanel repPanel = new ReportPanel(reservations);

        JPanel doctorPanel = docPanel;
        JPanel reservationPanel = resPanel;
        JPanel managePanel = manPanel;
        JPanel reportPanel = repPanel;

        tabbedPane.addTab("View Doctors", doctorPanel);
        tabbedPane.addTab("Create Reservation", reservationPanel);
        tabbedPane.addTab("Manage Reservations", managePanel);
        tabbedPane.addTab("Summary", reportPanel);

        add(tabbedPane);
    }

}
