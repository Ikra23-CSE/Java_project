package GUI;
import javax.swing.*;
import File.FileIOS;
import java.awt.*;
import java.awt.event.*;


public class LogIn extends JFrame implements ActionListener{
    JLabel userNameLable, userPassLabel,textlabel;
    JTextField userName;
    JPasswordField password;
    JButton btnLogin,registerBtn;
    JLabel background;
    ImageIcon image;

    
   
    Font font = new Font("cambria", Font.BOLD, 20);
    Font font2 = new Font("cambria", Font.PLAIN, 20);

    public LogIn() {
        super("Login");
        System.out.println("login.java");
        this.setSize(900,506);
        this.setLocation(300, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

       
		//USER NAME Lable
        userNameLable = new JLabel("User Name");
        userNameLable.setBounds(150, 80, 130, 40);
        userNameLable.setFont(font);
        userNameLable.setForeground(Color.BLACK);
        this.add(userNameLable);

		//USER NAME TextField
        userName = new JTextField("");
        userName.setBounds(320, 80, 210, 50);
        userName.setFont(font2);
        this.add(userName);
		
		//User Password Label 
        userPassLabel = new JLabel("Password");
        userPassLabel.setBounds(150, 170, 130, 40);
        userPassLabel.setFont(font);
        userPassLabel.setForeground(Color.BLACK);
        this.add(userPassLabel);

        textlabel = new JLabel("Have not account?");
        textlabel.setBounds(110, 320, 200, 40);
        textlabel.setFont(font);
        textlabel.setForeground(Color.BLACK);
        this.add(textlabel);

		//User Password Password Field
        password = new JPasswordField("");
        password.setBounds(320, 170, 210, 50);
		password.setEchoChar('*');
        password.setFont(font2);
        this.add(password);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(320, 250, 120, 43);
        btnLogin.setFont(font2);
        btnLogin.setBackground(new Color(92, 101, 204));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.addActionListener(this);
        this.add(btnLogin);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(320, 320, 120, 43);
        registerBtn.setFont(font2);
        registerBtn.setBackground(new Color(92, 101, 204));
        registerBtn.setForeground(Color.BLACK);
        registerBtn.addActionListener(this);
        this.add(registerBtn);

        image = new ImageIcon("./images/log_2_900x506.jpeg");
		background = new JLabel();
		background.setBounds(0,0,900,506);
		background.setIcon(image);
		this.add(background);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (btnLogin == e.getSource()) {
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());
			int status = FileIOS.checkUser(name,pass,"./File/User.txt");
            if (status == 1) {
				
				JOptionPane.showMessageDialog(this, "Login Successfull");
				
               Dashboard dashboard = new Dashboard(this);
                dashboard.setVisible(true);
                userName.setText("");
                password.setText("");
                this.setVisible(false);
                this.dispose();
            }
			else if(status == 2){
                JOptionPane.showMessageDialog(this, "Invalid Password", 
											  "Error",JOptionPane.WARNING_MESSAGE);
            }
			else{
                JOptionPane.showMessageDialog(this, "USER NOT REGISTERED", 
											  "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(registerBtn == e.getSource()){
            Registration rs = new Registration(this);   
        }
    }
}
