package GUI;

import File.FileIOS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registration extends JFrame implements ActionListener {
    JLabel namelabel,passlabel,phonelabel;
    JTextField name,phone;
    JPasswordField pass;
    JButton RegisterBtn,cancelBtn;
    LogIn lg;
    ImageIcon image;
    JLabel background;
    Font font = new Font("cambria", Font.PLAIN, 20);
    
    public Registration(LogIn lg){
        super("Registration page");
        this.lg = lg;
        this.setSize(900,600);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

       

        //Label
        namelabel = new JLabel("Enter username");
        namelabel.setBounds(500, 140, 180, 51);
        namelabel.setFont(font);
        namelabel.setForeground(Color.BLACK);
        this.add(namelabel);

        passlabel = new JLabel("Enter password");
        passlabel.setBounds(500, 230, 170, 40);
        passlabel.setFont(font);
        passlabel.setForeground(Color.BLACK);
        this.add(passlabel);

        phonelabel = new JLabel("Enter your Phone");
        phonelabel.setBounds(500, 310, 160, 40);
        phonelabel.setFont(font);
        phonelabel.setForeground(Color.BLACK);
        this.add(phonelabel);

        //textfield
        name = new JTextField();
        name.setBounds(680, 150, 160, 40);
        name.setFont(font);
        this.add(name);

        pass = new JPasswordField();
        pass.setBounds(680, 230, 160, 40);
        pass.setFont(font);
        this.add(pass);

        phone = new JTextField();
        phone.setBounds(680, 310, 160, 40);
        phone.setFont(font);
        this.add(phone);

        //btn
        RegisterBtn = new JButton("Register");
        RegisterBtn.setBounds(530, 410, 130, 40);
        RegisterBtn.setFont(font);
        RegisterBtn.setBackground(new Color(92, 101, 204));
        RegisterBtn.setForeground(Color.white);
        RegisterBtn.addActionListener(this);
        this.add(RegisterBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(720, 410, 120, 40);
        cancelBtn.setFont(font);
        cancelBtn.setBackground(new Color(92, 101, 204));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn); 
        
        image = new ImageIcon("./images/rr.jpg");
		background = new JLabel();
		background.setBounds(0,0,1000,600);
		background.setIcon(image);
		this.add(background);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(RegisterBtn == e.getSource()){
            boolean flag= FileIOS.registerUser(name.getText(), String.valueOf(pass.getPassword()), "./File/User.txt");

                if(flag){
                    JOptionPane.showMessageDialog(this, "Registration successful");
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Registration failed. duplicate data");
                }
                
        }
        if(e.getSource()==cancelBtn){
            this.setVisible(false);
        }
    }
}
