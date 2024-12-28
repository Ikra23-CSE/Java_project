package GUI;
import EntityList.*;
import javax.swing.*;

//import Entity.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton passengersButton, taxiButton,employeesButton,logoutBtn;
	LogIn login;
    JLabel background;
    ImageIcon image;

	Font font = new Font("cambria", Font.BOLD, 20);
    PassengerList passengerList = new PassengerList(100);
    EmployeeList employeeList = new EmployeeList(100);
    TaxiList taxilist = new TaxiList(100);

    public Dashboard(LogIn login) {
        super("Ride Management System Dashboard");

        this.setSize(500, 500);
        this.setLocation(300, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.login = login;

        //pasenger buttor
        passengersButton = new JButton("Passengers");
        passengersButton.setBounds(140, 50, 200, 35);
        passengersButton.setFont(font);
        passengersButton.addActionListener(this);
        this.add(passengersButton); 

        //Taxi button
        taxiButton = new JButton("Rides");
        taxiButton.setBounds(140, 115, 200, 35);
        taxiButton.setFont(font);
        taxiButton.addActionListener(this);
        this.add(taxiButton); 

        //employee buttor
        employeesButton = new JButton("Employees");
        employeesButton.setBounds(140, 180, 200, 35);
        employeesButton.setFont(font);
        employeesButton.addActionListener(this);
        this.add(employeesButton); 

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(10, 400, 100, 30);
        logoutBtn.setFont(font);
		logoutBtn.setBackground(Color.RED);
		logoutBtn.setForeground(Color.BLACK);
        logoutBtn.addActionListener(this);
        this.add(logoutBtn);

        this.setVisible(true);

       // setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        image = new ImageIcon("./images/rie.jpg");
		background = new JLabel();
		background.setBounds(0,0,900,506);
		background.setIcon(image);
		this.add(background);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == employeesButton) {
            EmployeeGUI eg = new EmployeeGUI(this, employeeList);
            //EmployeeList employeeList = new EmployeeList();
            //new EmployeeGUI(employeeList);
            
        } 
        else if(e.getSource() == taxiButton) {
            RideGUI rg = new RideGUI(this, taxilist);
            //TaxiList taxilist = new TaxiList();
            //new RideGUI(taxilist);
            
        }
		
		 else if (e.getSource() == passengersButton) {
           
           // PassengerList passengerList = new PassengerList();
            PassengerGUI pg = new PassengerGUI(this, passengerList);
            
        }
        else if(logoutBtn == e.getSource()){
			login.setVisible(true);
			this.dispose();
		}
            
    }
}

