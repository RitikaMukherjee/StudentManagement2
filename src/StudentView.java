import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class StudentView extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable;
    private JButton studentfindbutton,logoutbutton;
    int intid=0;
    
    StudentView(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Student's Window");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Student's Window");
        titlelable.setFont(f);
        titlelable.setBounds(270,10,250,50);
        c.add(titlelable);

        studentfindbutton=new JButton("Search Student");
        studentfindbutton.setBounds(100,100,200,50);
        c.add(studentfindbutton);

        logoutbutton=new JButton("Logout");
        logoutbutton.setBounds(400,100,200,50);
        c.add(logoutbutton);

        studentfindbutton.addActionListener(this);
        logoutbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==studentfindbutton){
            new StudentInfo(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==logoutbutton){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }
}

