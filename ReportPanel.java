import javax.swing.*;
import model.*;
import java.awt.event.*;

public class ReportPanel extends JPanel implements MyObserver//step 3 of MVC
{
    private JTextArea outputArea;
    private JLabel resultLbl = new JLabel("-");    
    private JPanel panel = new JPanel();
    private Reservations reservations;

    
    
    public ReportPanel(Reservations reservations) {
       
        this.reservations = reservations;
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);

        setup(reservations);
        build();

        reservations.attach(this);//step 4 of MVC
        

    }

    private void setup(Reservations reservations){

        reservations.attach(this);//step 4 of MVC

        
    }
    
    private void build() {
        add(new JScrollPane(outputArea));
        add(resultLbl);
    }

    
    @Override
        public void update() //step 3 of MVC
        {
            
            outputArea.setText(reservations.toString());
        }
    }
    
