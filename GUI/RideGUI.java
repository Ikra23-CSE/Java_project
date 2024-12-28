package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Taxi;
import EntityList.TaxiList;
import File.FileIORide;

public class RideGUI extends JFrame implements ActionListener, MouseListener {
    Font titleFont = new Font("Cambria", Font.BOLD, 30);
    Font font15 = new Font("Cambria", Font.BOLD, 15);

    JTextField idTextField, nameTextField, sourceTextField, destinationTextField;
    JTextField searchTextField, deleteTextField;
    JButton addButton, updateButton, searchButton, deleteButton,backBtn, clearButton, showAllButton;
    JTextArea textArea;
    TaxiList taxilist;
    Dashboard dashboard;


    public RideGUI(Dashboard dashboard, TaxiList taxilist) {
        super("Taxi Management GUI");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(1000, 800);
        super.setLocation(150, 0);
          
        
        ImageIcon backgroundIcon = new ImageIcon("./images/Ride.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1000, 800);

        super.setContentPane(backgroundLabel);

        super.setLayout(null);

        
        this.dashboard = dashboard;
        this.taxilist = taxilist;

        JLabel title = new JLabel("Ride Management System");
        title.setBounds(230, 10, 500, 50);
        title.setFont(titleFont);

        JLabel subTitle = new JLabel("Taxi INFORMATIONS");
        subTitle.setBounds(300, 60, 320, 50);
        subTitle.setFont(new Font("Cambria", Font.BOLD, 25));

        int top = 100;
        int gap = 40;

        JLabel idLabel = new JLabel("Taxi ID");
        idLabel.setBounds(20, top, 200, 30);
        idLabel.setFont(font15);

        idTextField = new JTextField();
        idTextField.setBounds(20, top += gap, 200, 30);
        idTextField.setFont(font15);

        JLabel nameLabel = new JLabel("Driver Name");
        nameLabel.setBounds(20, top += gap, 200, 30);
        nameLabel.setFont(font15);

        nameTextField = new JTextField();
        nameTextField.setBounds(20, top += gap, 200, 30);
        nameTextField.setFont(font15);

        JLabel sourceLabel = new JLabel("Source Area");
        sourceLabel.setBounds(20, top += gap, 200, 30);
        sourceLabel.setFont(font15);

        sourceTextField = new JTextField();
        sourceTextField.setBounds(20, top += gap, 200, 30);
        sourceTextField.setFont(font15);

        JLabel destinationLabel = new JLabel("Destination Area");
        destinationLabel.setBounds(20, top += gap, 200, 30);
        destinationLabel.setFont(font15);

        destinationTextField = new JTextField();
        destinationTextField.setBounds(20, top += gap, 200, 30);
        destinationTextField.setFont(font15);

        

        addButton = new JButton("ADD");
        addButton.setBounds(20, top += gap + 20, 200, 30);
        addButton.setBackground(Color.GREEN);
        addButton.setFont(font15);
        addButton.addActionListener(this);
        addButton.addMouseListener(this);

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(20, top += gap, 200, 30);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.BLACK);
        updateButton.setFont(font15);
        updateButton.addActionListener(this);

        textArea = new JTextArea();
        textArea.setFont(font15);
        textArea.setEditable(false);

        reloadAllBikes();

        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setBounds(230, 120, 460, 500);

        super.add(jsp);

        top = 100;
        gap = 40;

        JLabel searchLabel = new JLabel("Search By taxi ID");
        searchLabel.setBounds(700, top, 200, 30);
        searchLabel.setFont(font15);

        searchTextField = new JTextField();
        searchTextField.setBounds(700, top += gap, 200, 30);
        searchTextField.setFont(font15);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(700, top += gap, 200, 30);
        searchButton.setBackground(Color.YELLOW);
        searchButton.setFont(font15);
        searchButton.addActionListener(this);

        JLabel deleteLabel = new JLabel("Delete By taxi ID");
        deleteLabel.setBounds(700, top += gap, 200, 30);
        deleteLabel.setFont(font15);

        deleteTextField = new JTextField();
        deleteTextField.setBounds(700, top += gap, 200, 30);
        deleteTextField.setFont(font15);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(700, top += gap, 200, 30);
        deleteButton.setBackground(Color.GREEN);
        deleteButton.setForeground(Color.BLACK);
        deleteButton.setFont(font15);
        deleteButton.addActionListener(this);

        //Back Button
		backBtn = new JButton("<=Back");
		backBtn.setBounds(700,600,200,30);//x,y,w,h
		backBtn.setFont(font15);
		backBtn.setBackground(Color.RED);
		backBtn.setForeground(Color.BLACK);
		backBtn.addActionListener(this);
		this.add(backBtn);

        showAllButton = new JButton("SHOW ALL");
        showAllButton.setBounds(700, 500, 200, 30);
        showAllButton.setBackground(Color.PINK);
        showAllButton.setForeground(Color.BLACK);
        showAllButton.setFont(font15);
        showAllButton.addActionListener(this);

        clearButton = new JButton("CLEAR SCREEN");
        clearButton.setBounds(700, 550, 200, 30);
        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setForeground(Color.BLACK);
        clearButton.setFont(font15);
        clearButton.addActionListener(this);

       

        super.add(title);
        super.add(subTitle);
        super.add(idLabel);
        super.add(idTextField);
        super.add(nameLabel);
        super.add(nameTextField);
        super.add(sourceLabel);
        super.add(sourceTextField);
        super.add(destinationLabel);
        super.add(destinationTextField);
 
        super.add(addButton);
        super.add(updateButton);
        super.add(searchLabel);
        super.add(searchTextField);
        super.add(searchButton);
        super.add(deleteLabel);
        super.add(deleteTextField);
        super.add(deleteButton);
        super.add(clearButton);
        super.add(showAllButton);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD")) {
            System.out.println("ADD CLICKED");

            if (
                    !idTextField.getText().isEmpty() &&
                            !nameTextField.getText().isEmpty() &&
                            !sourceTextField.getText().isEmpty() &&
                            !destinationTextField.getText().isEmpty()
                            
            ) {

                if (taxilist.getByTaxiID(idTextField.getText()) == null) {

                    Taxi taxi = new Taxi(
                            idTextField.getText(),
                            nameTextField.getText(),
                            sourceTextField.getText(),
                            destinationTextField.getText()
                            
                    );

                    taxilist.insert(taxi);
                    FileIORide.writeTaxiInFile(taxi);

                    reloadAllBikes();
                } else {
                    JOptionPane.showMessageDialog(this, "This ID is Already in use, Provide Another ID", "Provide Unique ID", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please Provide all Information for the Ride", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (updateButton == e.getSource()) {
            System.out.println("UPDATE CLICKED");

            if (!idTextField.getText().isEmpty()) {
                Taxi taxi = taxilist.getByTaxiID(idTextField.getText());
                if (taxi != null) {
                    if (!nameTextField.getText().isEmpty()) {
                        taxi.setTaxiName(nameTextField.getText());
                    }

                    if (!sourceTextField.getText().isEmpty()) {
                        taxi.setSourceArea(sourceTextField.getText());
                    }

                    if (!destinationTextField.getText().isEmpty()) {
                        taxi.setDestinationArea(destinationTextField.getText());
                    }

                    

                    FileIORide.updateTaxisInFile(taxilist);

                    reloadAllBikes();
                } else {
                    JOptionPane.showMessageDialog(this, "No Available Ride by This ID", "Ride Not Found", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide ID for the Ride", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (searchButton == e.getSource()) {
            System.out.println("SEARCH CLICKED");

            Taxi taxi = taxilist.getByTaxiID(searchTextField.getText());
            if (taxi != null) {
                textArea.setText(taxi.getTaxiInfoAsString());
            } else {
                JOptionPane.showMessageDialog(this, "NO Ride FOUND.", "Alert", JOptionPane.WARNING_MESSAGE);
            }

        } else if (deleteButton == e.getSource()) {
            System.out.println("DELETE CLICKED");

            if (!deleteTextField.getText().isEmpty()) {
                String taxiTODelete = deleteTextField.getText();
                Taxi TaxiToDelete = taxilist.getByTaxiID(taxiTODelete);

                if (TaxiToDelete != null) {
                    taxilist.delete(TaxiToDelete); 
                    FileIORide.updateTaxisInFile(taxilist);
                    reloadAllBikes();
                } else {
                    JOptionPane.showMessageDialog(this, "No Available Ride by This ID", "Ride Not Found", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide ID for the Ride to Delete", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (showAllButton == e.getSource()) {
            System.out.println("SHOW ALL CLICKED");
            

            reloadAllBikes();
        } else if (clearButton == e.getSource()) {
            System.out.println("CLEAR CLICKED");
            textArea.setText("");
        }
        else if(e.getSource() == backBtn){
			dashboard.setVisible(true);
			this.dispose();
		}
    }

    public void reloadAllBikes() {
        textArea.setText(taxilist.getAllTaxisAsString());
    }

    public void mouseExited(MouseEvent me) {
        if (addButton == me.getSource()) {
            addButton.setBackground(Color.GREEN);
        }
    }

    public void mouseEntered(MouseEvent me) {
        if (addButton == me.getSource()) {
            addButton.setBackground(Color.GRAY);
        }
    }

    public void mouseReleased(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseClicked(MouseEvent me) {

    }

    
}
