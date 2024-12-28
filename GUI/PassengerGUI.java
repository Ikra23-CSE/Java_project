package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Passenger;
import EntityList.PassengerList;
import File.FileIOP;

/*
Container :
JFrame ------ Creats window
Components :
JLabel ---- Show text in frame 
JTextField ----- takes single line input
JTextArea -----  takes Multiple line input 
JButton ------- performs and action 


AWT :
Font
Color
*/
public class PassengerGUI extends JFrame implements ActionListener, MouseListener {
	Font titleFont = new Font("Cambria",Font.BOLD,32);
	Font font15 = new Font("Cambria",Font.BOLD,16);
	
	JTextField idTextField,nidTextField,nameTextField,contactTextField,emailTextField;
	JTextField searchTextField,deleteTextField;
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,backBtn, showAllButton;
	
	JTextArea textArea;
	PassengerList passengerList;
	Dashboard dashboard;
	 
	public PassengerGUI(Dashboard dashboard, PassengerList passengerList){
		super("Ride Management System");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(940,700);
		this.setLocation(150,0);
		//this.getContentPane().setBackground(new Color(218,232,252));
		 ImageIcon backgroundIcon = new ImageIcon("./images/passenger.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1500,1100);

        super.setContentPane(backgroundLabel);
		this.setLayout(null);
		this.dashboard = dashboard;
		this.passengerList = passengerList;
		
		//============ Title ==============
		
		JLabel title = new JLabel("Ride Management");
		title.setBounds(230,10,500,50);
		title.setFont(titleFont);
		this.add(title);
		// ======= Subtitle =================
		
		JLabel subTitle = new JLabel("Passengers Informations");
		subTitle.setBounds(300,60,320,50);
		subTitle.setFont(new Font("Cambria",Font.BOLD,25));
		this.add(subTitle);
		 // ====== Passenger  Entry Form======
		 int top = 100;
		 int gap = 40;
		//==========Passenger Id Entry ========
		
		JLabel idLabel = new JLabel("Passenger ID");
		idLabel.setBounds(20,top,200,30);
		idLabel.setFont(font15);
		this.add(idLabel);
		
		
		 idTextField = new JTextField();
		idTextField.setBounds(20,top+=gap,200,30);
		idTextField.setFont(font15);
		this.add(idTextField);
		
		//==========Passenger NID Entry ========
		
		JLabel nidLabel = new JLabel("Passenger NID ");
		nidLabel.setBounds(20,top+=gap,200,20);
		nidLabel.setFont(font15);
		this.add(nidLabel);
		
		
		nidTextField = new JTextField();
		nidTextField.setBounds(20,top+=gap,200,30);
		nidTextField.setFont(font15);
		this.add(nidTextField);
		
		//==========Passenger Name  Entry ========
		
		JLabel nameLabel = new JLabel("Passenger Name ");
		nameLabel.setBounds(20,top+=gap,200,20);
		nameLabel.setFont(font15);
		this.add(nameLabel);
		
		
		 nameTextField = new JTextField();
		nameTextField.setBounds(20,top+=gap,200,30);
		nameTextField.setFont(font15);
		this.add(nameTextField);
		
		
		//==========Passengers Contact  Entry ========
		
		JLabel contactLabel = new JLabel("Passenger Contact");
		contactLabel.setBounds(20,top+=gap,200,20);
		contactLabel.setFont(font15);
		this.add(contactLabel);
		
		 contactTextField = new JTextField();
		contactTextField.setBounds(20,top+=gap,200,30);
		contactTextField.setFont(font15);
		this.add(contactTextField);
		
		//==========Passenger e mail  Entry ========
		
		JLabel emailLabel = new JLabel("Passenger E mail ");
		emailLabel.setBounds(20,top+=gap,200,20);
		emailLabel.setFont(font15);
		this.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(20,top+=gap,200,30);
		emailTextField.setFont(font15);
		this.add(emailTextField);
		
		// ========== Add Button =========
		addButton = new JButton("Add");
		addButton.setBounds(20,top+=gap+10,200,30);
		addButton.setFont(font15);
		addButton.setBackground(Color.GREEN);
		addButton.addActionListener(this);
		this.add(addButton);
		
	    updateButton = new JButton("Update");
		updateButton.setBounds(20,top+=gap+20,200,30);
		updateButton.setFont(font15);
		updateButton.setBackground(Color.GREEN);
		updateButton.addActionListener(this);
		this.add(updateButton);
		
		// Center Componenet 
		
		textArea = new JTextArea();
		textArea.setBounds(0,0,460,470);
		textArea.setFont(font15);
		textArea.setEditable(false);
		
		reloadAllPassengers();
		
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(230,120,460,470);
		this.add(jsp);
		
		
		// Right Side Components ======
		top = 100;
		gap = 40;
		
		// Passengers Search Entry =====
		
		JLabel searchLable = new JLabel ("Search BY Passenger ID");
		searchLable.setBounds(700,top,200,30);
		searchLable.setFont(font15);
		this.add(searchLable);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(700,top+=gap,200,30);
		searchTextField.setFont(font15);
		this.add(searchTextField);
		
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(700,top+=gap,200,30);
		searchButton.setBackground(Color.YELLOW);
		searchButton.setFont(font15);
		searchButton.addActionListener(this);
		this.add(searchButton);
		
		//Passenger Delete Entry 
		
		
		JLabel deleteLable = new JLabel ("DELETE BY Passenger ID");
		deleteLable.setBounds(700,top+=gap,200,30);
		deleteLable.setFont(font15);
		this.add(deleteLable);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(700,top+=gap,200,30);
		deleteTextField.setFont(font15);
		this.add(deleteTextField);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(700,top+=gap,200,30);
		deleteButton.setBackground(Color.RED);
		deleteButton.setForeground(Color.BLACK);
		deleteButton.setFont(font15);
		deleteButton.addActionListener(this);
		this.add(deleteButton);

		//Back Button
		backBtn = new JButton("<=Back");
		backBtn.setBounds(700,600,200,30);//x,y,w,h
		backBtn.setFont(font15);
		backBtn.setBackground(Color.RED);
		backBtn.setForeground(Color.BLACK);
		backBtn.addActionListener(this);
		this.add(backBtn);
		
		// Showall button
		
		showAllButton = new JButton("SHOW ALL");
		showAllButton.setBounds(700,500,200,30); //X,Y,W,H
		showAllButton.setBackground(Color.PINK);
		showAllButton.setForeground(Color.BLACK);
		showAllButton.setFont(font15);
		showAllButton.addActionListener(this);
		this.add(showAllButton);
		
		// Clear Screen ==========
		
		
		clearButton = new JButton("CLEAR SCREEN");
		clearButton.setBounds(700,550,200,30); //X,Y,W,H
		clearButton.setBackground(Color.WHITE);
		clearButton.setForeground(Color.BLACK);
		clearButton.setFont(font15);
		clearButton.addActionListener(this);
		this.add(clearButton);
		
			
		this.setVisible(true);
	}
	
	 @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (!idTextField.getText().isEmpty() &&
                !nidTextField.getText().isEmpty() &&
                !nameTextField.getText().isEmpty() &&
                !contactTextField.getText().isEmpty() &&
                !emailTextField.getText().isEmpty()) {

                if (passengerList.getById(idTextField.getText()) == null) {

                    Passenger p = new Passenger(
                            idTextField.getText(),
                            nidTextField.getText(),
                            nameTextField.getText(),
                            contactTextField.getText(),
                            emailTextField.getText()
                    );

                    passengerList.insert(p);
                    FileIOP.writePassengerInFile(p);
					FileIOP.updatePassengersInFile(passengerList);

                    reloadAllPassengers();
                } else {
                    JOptionPane.showMessageDialog(this, "This ID is Already in use, Provide Another ID", "Provide Unique ID", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please Provide all Information for the Passenger", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == updateButton) {
            if (!idTextField.getText().isEmpty()) {
                Passenger p = passengerList.getById(idTextField.getText());
                if (p != null) {
                    if (!nidTextField.getText().isEmpty()) {
                        p.setPassengerNID(nidTextField.getText());
                    }

                    if (!nameTextField.getText().isEmpty()) {
                        p.setPassengerName(nameTextField.getText());
                    }

                    if (!contactTextField.getText().isEmpty()) {
                        p.setPassengerContact(contactTextField.getText());
                    }

                    if (!emailTextField.getText().isEmpty()) {
                        p.setPassengerEmail(emailTextField.getText());
                    }

                    FileIOP.updatePassengersInFile(passengerList);

                    reloadAllPassengers();
                } else {
                    JOptionPane.showMessageDialog(this, "No Available Passenger by This ID", " Passenger Not Found", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide ID for the Passenger ", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }
        }
		else if(e.getSource() == searchButton){
			System.out.println("SEARCH CLICKED");
			
			Passenger p = passengerList.getById(searchTextField.getText());
			if(p!=null){
				textArea.setText( p.getPassengerInfoAsString() );
			}
			else{
				
				JOptionPane.showMessageDialog(this,"NO Passenger  FOUND.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			
			
			
		}
		else if(deleteButton == e.getSource()){
			System.out.println("DELETE CLICKED");
			
			String deletePassengerId = deleteTextField.getText();

        if (!deletePassengerId.isEmpty()) {
            Passenger passengerToDelete = passengerList.getById(deletePassengerId);

            if (passengerToDelete != null) {
                passengerList.delete(passengerToDelete);
                FileIOP.updatePassengersInFile(passengerList);
                reloadAllPassengers();
            } else {
                JOptionPane.showMessageDialog(this, "No Passenger found with the provided ID", "Passenger Not Found", JOptionPane.ERROR_MESSAGE);
            }
        
		} else {
            JOptionPane.showMessageDialog(this, "Please provide Passenger ID to delete", "Missing Information", JOptionPane.ERROR_MESSAGE);
		}
		
		} else if(showAllButton == e.getSource()){
			System.out.println("SHOW ALL CLICKED");
			
			reloadAllPassengers();
		}
		else if(clearButton == e.getSource()){
			System.out.println("CLEAR CLICKED");
			textArea.setText("");
		}
		else if(e.getSource() == backBtn){
			dashboard.setVisible(true);
			this.dispose();
		}
	}
	
	 public void reloadAllPassengers() {
        textArea.setText(passengerList.getAllPassengersAsString());
    }
	
	public void mouseExited(MouseEvent me){
		if(addButton == me.getSource()){
			addButton.setBackground(Color.GREEN);
		}
	}
	public void mouseEntered(MouseEvent me){
		if(addButton == me.getSource()){
			addButton.setBackground(Color.GRAY);
		}
	}
	public void mouseReleased(MouseEvent me){
		
	}
	public void mousePressed(MouseEvent me){
		
	}
	public void mouseClicked(MouseEvent me){
		
	}
	
	
	
}
	