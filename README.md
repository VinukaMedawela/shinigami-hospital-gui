Shinigami Hospital GUI

Shinigami Hospital GUI is a Java Swing-based application designed to streamline hospital reservation management. Built with the Model-View-Controller (MVC) architecture and the Observer pattern, it provides an intuitive interface for patients to view doctor details, create and manage reservations, and access real-time summaries.

Features





View Doctors: Browse doctor information (name, availability, and specialization) in a dedicated tab.



Create Reservations: Enter a patient name, select a reservation type (e.g., Doctor or Lab), and choose from dynamically filtered doctors using combo boxes.



Manage Reservations: Update patient names or delete reservations using auto-generated IDs, with real-time feedback.



Reservation Summary: View all reservations, automatically updated after edits, in a clear, scrollable display.



Responsive UI: Leverages JTabbedPane, JComboBox, and event listeners for a seamless user experience.

Technologies Used





Java: Core programming language.



Swing: For GUI components (JTabbedPane, JComboBox, JTextArea, etc.).



MVC Architecture: Ensures modular, maintainable code.



Observer Pattern: Enables real-time updates across panels.

Getting Started

Prerequisites





Java Development Kit (JDK) 8 or later.



Git (optional, for cloning the repository).

Installation and Setup





Clone the repository:

git clone https://github.com/VinukaMedawela/shinigami-hospital-gui.git



Navigate to the project directory:

cd shinigami-hospital-gui



Compile the Java files:

javac *.java model/*.java



Run the application:

java HospitalGUI

Project Structure





HospitalGUI.java: Initializes the main GUI window with tabbed panes.



DoctorPanel.java: Displays doctor details in a scrollable text area.



ReservationPanel.java: Manages reservation creation with dynamic combo boxes.



ManagePanel.java: Handles reservation updates and deletions with validation.



ReportPanel.java: Shows a real-time summary of all reservations.



model/: Contains MVC model classes (e.g., Doctors.java, Reservations.java).



.gitignore: Excludes compiled .class and BlueJ .ctxt files.



README.md: Project documentation.

Usage





Launch the application to access a tabbed interface with four sections:





View Doctors: See available doctors and their details.



Create Reservation: Enter patient details and select options to book.



Manage Reservation: Update or delete reservations by ID.



Summary: View all reservations, reflecting real-time changes.



Refer to the project report (upload your report to a docs/ folder) for a detailed user manual.

Screenshots

Coming soon: Screenshots of the GUI tabs (View Doctors, Create Reservation, Manage Reservation, Summary) will be added to the screenshots/ folder.

Contributors





Vinuka Medawela (GitHub)



Tehara



Notes





Developed in BlueJ, but compatible with any Java IDE or command-line environment.



Ensure all model classes in the model/ directory are included for full functionality.



Feedback and contributions are welcome! Open an issue or submit a pull request.
