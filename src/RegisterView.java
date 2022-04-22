import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class RegisterView extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable;
    private JButton teacherregistrationbutton,studentregistrationbutton,courseregistrationbutton,teacherfindbutton,studentfindbutton,coursefindbutton,allteacherbutton,allstudentbutton,allcoursebutton,logoutbutton;
    int intid=0;
    RegisterView(int id){
        id=intid;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Register's Window");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Register's Window");
        titlelable.setFont(f);
        titlelable.setBounds(270,10,250,50);
        c.add(titlelable);

        teacherregistrationbutton=new JButton("Teacher Registration");
        teacherregistrationbutton.setBounds(100,100,200,50);
        c.add(teacherregistrationbutton);
        
        studentregistrationbutton=new JButton("Student Registration");
        studentregistrationbutton.setBounds(100,200,200,50);
        c.add(studentregistrationbutton);
        
        courseregistrationbutton=new JButton("Course Registration");
        courseregistrationbutton.setBounds(100,300,200,50);
        c.add(courseregistrationbutton);
        
        teacherfindbutton=new JButton("Search Teacher");
        teacherfindbutton.setBounds(400,100,200,50);
        c.add(teacherfindbutton);
        
        studentfindbutton=new JButton("Search Student");
        studentfindbutton.setBounds(400,200,200,50);
        c.add(studentfindbutton);

        coursefindbutton=new JButton("Search Course");
        coursefindbutton.setBounds(400,300,200,50);
        c.add(coursefindbutton);

        allteacherbutton=new JButton("All Teacher Details");
        allteacherbutton.setBounds(100,400,200,50);
        c.add(allteacherbutton);

        allstudentbutton=new JButton("All Student Details");
        allstudentbutton.setBounds(400,400,200,50);
        c.add(allstudentbutton);

        allcoursebutton=new JButton("All Course Details");
        allcoursebutton.setBounds(100,500,200,50);
        c.add(allcoursebutton);

        logoutbutton=new JButton("Logout");
        logoutbutton.setBounds(400,500,200,50);
        c.add(logoutbutton);

        teacherregistrationbutton.addActionListener(this);
        studentregistrationbutton.addActionListener(this);
        courseregistrationbutton.addActionListener(this);
        teacherfindbutton.addActionListener(this);
        studentfindbutton.addActionListener(this);
        coursefindbutton.addActionListener(this);
        allteacherbutton.addActionListener(this);
        allstudentbutton.addActionListener(this);
        allcoursebutton.addActionListener(this);
        logoutbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==teacherregistrationbutton){
            new TeacherTable(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==studentregistrationbutton){
            new StudentTable(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==courseregistrationbutton){
            new CourseTable(intid).setVisible(true); 
            this.setVisible(false); 
        }
        else if(e.getSource()==teacherfindbutton){
            new TeacherScarch(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==studentfindbutton){
            new StudentScarch(1,intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==coursefindbutton){
            new CourseScarch(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==allteacherbutton){
            new AllTeacher(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==allstudentbutton){
            new AllStudent(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==allcoursebutton){
            new AllCourse(intid).setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==logoutbutton){
            new Login().setVisible(true);
            this.setVisible(false);
        }
        
    }
}

