Shinigami Hospital GUI

A Java Swing-based GUI application for managing hospital reservations, built using the MVC architecture and Observer pattern. This project allows users to view doctor information, create/update/delete reservations, and view reservation summaries.

Features





View Doctors: Displays doctor details (name, availability, type) in a tabbed interface.



Create Reservations: Users enter their name, select a reservation type, and choose a doctor from a dynamically updated combo box.



Manage Reservations: Update patient names or delete reservations using an auto-generated ID.



Summary: Displays all reservation details, updated in real-time.



Uses JTabbedPane, JComboBox, and event listeners for a seamless UI experience.

Technologies





Java



Swing (JTabbedPane, JComboBox, JTextArea, etc.)



MVC Architecture



Observer Pattern

Setup and Running





Clone the repository: git clone https://github.com/yourusername/shinigami-hospital-gui.git



Navigate to the project directory: cd shinigami-hospital-gui



Compile the Java files: javac *.java model/*.java



Run the application: java HospitalGUI

Project Structure





HospitalGUI.java: Main GUI class with tabbed panes.



DoctorPanel.java: Displays doctor information.



ReservationPanel.java: Handles reservation creation with combo boxes.



ManagePanel.java: Manages reservation updates and deletions.



ReportPanel.java: Shows reservation summaries.



model/: Contains model classes (Doctors, Reservations, etc.) for MVC.

Screenshots

(To be added: Upload images from your project report, e.g., View Doctors tab, Create Reservation tab, etc.)

Usage





Launch the app to view the GUI with four tabs: View Doctors, Create Reservation, Manage Reservation, and Summary.



Follow the user manual in the project report for detailed instructions.

Contributors





Vinuka



Tehara

Notes





Ensure Java is installed (JDK 8 or later recommended).



The project was developed using BlueJ, but it can be run via command line or any Java IDE.
