import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TeacherView extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable;
    private JButton teacherfindbutton,studentfindbutton,addscorebutton,logoutbutton;
    int intid=0;
    TeacherView(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Teacher's Window");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Teacher's Window");
        titlelable.setFont(f);
        titlelable.setBounds(270,10,250,50);
        c.add(titlelable);

        teacherfindbutton=new JButton("Teacher Detail");
        teacherfindbutton.setBounds(100,100,200,50);
        c.add(teacherfindbutton);
        
        studentfindbutton=new JButton("Search Student");
        studentfindbutton.setBounds(400,100,200,50);
        c.add(studentfindbutton);

        addscorebutton=new JButton("Add Score");
        addscorebutton.setBounds(100,200,200,50);
        c.add(addscorebutton);

        logoutbutton=new JButton("Logout");
        logoutbutton.setBounds(400,200,200,50);
        c.add(logoutbutton);

        teacherfindbutton.addActionListener(this);
        studentfindbutton.addActionListener(this);
        addscorebutton.addActionListener(this);
        logoutbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==teacherfindbutton){
            new TeacherInfo(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==studentfindbutton){
            new StudentScarch(2,intid).setVisible(true);
            this.setVisible(false);

        }
        else if(e.getSource()==addscorebutton){
            new AddScore(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==logoutbutton){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }
    
}

