package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Employee;
import EntityList.EmployeeList;
import File.FileIOE;

public class EmployeeGUI extends JFrame implements ActionListener, MouseListener {
    Font titleFont = new Font("Cambria", Font.BOLD, 32);
    Font font15 = new Font("Cambria", Font.BOLD, 16);

    JTextField idTextField, nidTextField, nameTextField, contactTextField, emailTextField;
    JTextField searchTextField, deleteTextField;
    JButton addButton, updateButton, searchButton, deleteButton,backBtn, clearButton, showAllButton;

    JTextArea textArea;
    EmployeeList employeeList;
    Dashboard dashboard;

    public EmployeeGUI(Dashboard dashboard, EmployeeList employeeList) {
        super("Ride Management System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(940, 700);
        this.setLocation(150, 0);

        ImageIcon backgroundIcon = new ImageIcon("./images/employee.png");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1000, 800);

        super.setContentPane(backgroundLabel);
        this.setLayout(null);

        this.dashboard = dashboard;
        this.employeeList = employeeList;

        JLabel title = new JLabel("RIDE MANAGEMENT ");
        title.setBounds(230, 10, 500, 50);
        title.setFont(titleFont);
        this.add(title);

        JLabel subTitle = new JLabel("Employees Informations");
        subTitle.setBounds(300, 60, 320, 50);
        subTitle.setFont(new Font("Cambria", Font.BOLD, 25));
        this.add(subTitle);

        int top = 100;
        int gap = 40;

        JLabel idLabel = new JLabel("Employee ID");
        idLabel.setBounds(20, top, 200, 30);
        idLabel.setFont(font15);
        this.add(idLabel);

        idTextField = new JTextField();
        idTextField.setBounds(20, top += gap, 200, 30);
        idTextField.setFont(font15);
        this.add(idTextField);

        JLabel nidLabel = new JLabel("Employee NID ");
        nidLabel.setBounds(20, top += gap, 200, 20);
        nidLabel.setFont(font15);
        this.add(nidLabel);

        nidTextField = new JTextField();
        nidTextField.setBounds(20, top += gap, 200, 30);
        nidTextField.setFont(font15);
        this.add(nidTextField);

        JLabel nameLabel = new JLabel("Employee Name ");
        nameLabel.setBounds(20, top += gap, 200, 20);
        nameLabel.setFont(font15);
        this.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(20, top += gap, 200, 30);
        nameTextField.setFont(font15);
        this.add(nameTextField);

        JLabel contactLabel = new JLabel("Employee Contact");
        contactLabel.setBounds(20, top += gap, 200, 20);
        contactLabel.setFont(font15);
        this.add(contactLabel);

        contactTextField = new JTextField();
        contactTextField.setBounds(20, top += gap, 200, 30);
        contactTextField.setFont(font15);
        this.add(contactTextField);

        JLabel emailLabel = new JLabel("Employee E mail ");
        emailLabel.setBounds(20, top += gap, 200, 20);
        emailLabel.setFont(font15);
        this.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(20, top += gap, 200, 30);
        emailTextField.setFont(font15);
        this.add(emailTextField);

        addButton = new JButton("Add");
        addButton.setBounds(20, top += gap + 10, 200, 30);
        addButton.setFont(font15);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(this);
        this.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(20, top += gap + 20, 200, 30);
        updateButton.setFont(font15);
        updateButton.setBackground(Color.GREEN);
        updateButton.addActionListener(this);
        this.add(updateButton);

        textArea = new JTextArea();
        textArea.setBounds(0, 0, 460, 470);
        textArea.setFont(font15);
        textArea.setEditable(false);

        reloadAllEmployees();

        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setBounds(230, 120, 460, 470);
        this.add(jsp);

        top = 100;
        gap = 40;

        JLabel searchLable = new JLabel("Search BY Employee ID");
        searchLable.setBounds(700, top, 200, 30);
        searchLable.setFont(font15);
        this.add(searchLable);

        searchTextField = new JTextField();
        searchTextField.setBounds(700, top += gap, 200, 30);
        searchTextField.setFont(font15);
        this.add(searchTextField);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(700, top += gap, 200, 30);
        searchButton.setBackground(Color.YELLOW);
        searchButton.setFont(font15);
        searchButton.addActionListener(this);
        this.add(searchButton);

        JLabel deleteLable = new JLabel("DELETE BY Employee ID");
        deleteLable.setBounds(700, top += gap, 200, 30);
        deleteLable.setFont(font15);
        this.add(deleteLable);

        deleteTextField = new JTextField();
        deleteTextField.setBounds(700, top += gap, 200, 30);
        deleteTextField.setFont(font15);
        this.add(deleteTextField);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(700, top += gap, 200, 30);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(font15);
        deleteButton.addActionListener(this);
        this.add(deleteButton);

        showAllButton = new JButton("SHOW ALL");
        showAllButton.setBounds(700, 500, 200, 30);
        showAllButton.setBackground(Color.PINK);
        showAllButton.setForeground(Color.BLACK);
        showAllButton.setFont(font15);
        showAllButton.addActionListener(this);
        this.add(showAllButton);

        //Back Button
		backBtn = new JButton("<=Back");
		backBtn.setBounds(700,600,200,30);//x,y,w,h
		backBtn.setFont(font15);
		backBtn.setBackground(Color.RED);
		backBtn.setForeground(Color.BLACK);
		backBtn.addActionListener(this);
		this.add(backBtn);

        clearButton = new JButton("CLEAR SCREEN");
        clearButton.setBounds(700, 550, 200, 30);
        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setForeground(Color.BLACK);
        clearButton.setFont(font15);
        clearButton.addActionListener(this);
        this.add(clearButton);  
		
		FileIOE.loadFromFile(employeeList);

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

                if (employeeList.getById(idTextField.getText()) == null) {

                    Employee emp = new Employee(
                            idTextField.getText(),
                            nidTextField.getText(),
                            nameTextField.getText(),
                            contactTextField.getText(),
                            emailTextField.getText()
                    );

                    employeeList.insert(emp);
                    FileIOE.writeEmployeeInFile(emp);
                    FileIOE.updateEmployeesInFile(employeeList);

                    reloadAllEmployees();
                } else {
                    JOptionPane.showMessageDialog(this, "This ID is Already in use, Provide Another ID", "Provide Unique ID", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please Provide all Information for the Employee", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == updateButton) {
            if (!idTextField.getText().isEmpty()) {
                Employee emp = employeeList.getById(idTextField.getText());
                if (emp != null) {
                    if (!nidTextField.getText().isEmpty()) {
                        emp.setEmployeeNID(nidTextField.getText());
                    }

                    if (!nameTextField.getText().isEmpty()) {
                        emp.setEmployeeName(nameTextField.getText());
                    }

                    if (!contactTextField.getText().isEmpty()) {
                        emp.setEmployeeContact(contactTextField.getText());
                    }

                    if (!emailTextField.getText().isEmpty()) {
                        emp.setEmployeeEmail(emailTextField.getText());
                    }

                    FileIOE.updateEmployeesInFile(employeeList);

                    reloadAllEmployees();
                } else {
                    JOptionPane.showMessageDialog(this, "No Available Employee by This ID", " Employee Not Found", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide ID for the Employee ", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == searchButton) {
            System.out.println("SEARCH CLICKED");

            Employee emp = employeeList.getById(searchTextField.getText());
            if (emp != null) {
                textArea.setText(emp.getEmployeeInfoAsString());
            } else {

                JOptionPane.showMessageDialog(this, "NO Employee  FOUND.", "Alert", JOptionPane.WARNING_MESSAGE);
            }

        } else if (deleteButton == e.getSource()) {
            System.out.println("DELETE CLICKED");

            String deleteEmployeeId = deleteTextField.getText();

            if (!deleteEmployeeId.isEmpty()) {
                Employee employeeToDelete = employeeList.getById(deleteEmployeeId);

                if (employeeToDelete != null) {
                    employeeList.delete(employeeToDelete);
                    FileIOE.updateEmployeesInFile(employeeList);
                    reloadAllEmployees();
                } else {
                    JOptionPane.showMessageDialog(this, "No Employee found with the provided ID", "Employee Not Found", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please provide Employee ID to delete", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (showAllButton == e.getSource()) {
            System.out.println("SHOW ALL CLICKED");
            //textArea.setText(employeeList.getAllEmployeesAsString());
			 reloadAllEmployees();
        } else if (clearButton == e.getSource()) {
            System.out.println("CLEAR CLICKED");
            textArea.setText("");
        }
        else if(e.getSource() == backBtn){
			dashboard.setVisible(true);
			this.dispose();
		}
    }

    public void reloadAllEmployees() {
        textArea.setText(employeeList.getAllEmployeesAsString());
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
