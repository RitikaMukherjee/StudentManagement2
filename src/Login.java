import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class Login extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable,useridlable,passwordlable;
    private JTextField useridtf;
    JPasswordField passwordtf;
    private JButton loginbutton,clearbutton;
    
    Login(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Student Table");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Candidate Login");
        titlelable.setFont(f);
        titlelable.setBounds(120,10,250,50);
        c.add(titlelable);

        useridlable = new JLabel("User Id : ");
        useridlable.setBounds(10,80,140,30);
        c.add(useridlable);

        useridtf=new JTextField();
        useridtf.setBounds(110,80,200,30);
        useridtf.setFont(f);
        c.add(useridtf);

        passwordlable = new JLabel("Password : ");
        passwordlable.setBounds(10,120,140,30);
        c.add(passwordlable);

        passwordtf=new JPasswordField();
        passwordtf.setBounds(110,120,200,30);
        passwordtf.setFont(f);
        c.add(passwordtf);

        

        loginbutton=new JButton("Login");
        loginbutton.setBounds(400,80,80,30);
        c.add(loginbutton);

        clearbutton=new JButton("Clear");
        clearbutton.setBounds(400,120,80,30);
        c.add(clearbutton);

        loginbutton.addActionListener(this);
        clearbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==clearbutton){
            useridtf.setText("");
            passwordtf.setText("");
        }
        else if(e.getSource()==loginbutton){

            String user=useridtf.getText().toString().toLowerCase();
            char[] password=passwordtf.getPassword();
            String p=String.valueOf(password);
            int pass=Integer.parseInt(p);

            try {
                if(user.matches("student")){
                
                    String query= "SELECT * from student WHERE sid = "+pass+";";
                    ResultSet rs=Connect.login(query);
                    System.out.print("rs check: "+rs);
                    if(rs.next())
                    {
                        new StudentView(pass).setVisible(true);
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                    }
                    useridtf.setText("");
                    passwordtf.setText("");
                    this.setVisible(false);
                }
                else if(user.matches("teacher")){
                    String query= "SELECT * from teacher WHERE tid = "+pass+";";
                    ResultSet rs=Connect.login(query);
                    if(rs.next()){
                        new TeacherView(pass).setVisible(true);
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                    }
                    useridtf.setText("");
                    passwordtf.setText("");
                    
                }
                else if(user.matches("admin")){
                        int admn=1;
                        if(pass==admn){

                            new RegisterView(pass).setVisible(true);
                            this.setVisible(false);
                            useridtf.setText("");
                            passwordtf.setText("");
                        }else{

                            JOptionPane.showMessageDialog(null, "Invalid Credentials");
                            useridtf.setText("");
                            passwordtf.setText("");
                        }
                        
                    }
                    else{
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
                
            } 
        }
    
}
