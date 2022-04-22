import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
public class CourseScarch extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable,cnamelable,idlable,idlable2,durationlable,durationlable2;
    private JTextField cnametf;
    private JButton serchbutton,clearbutton,backbutton;
    int intid=0;
    CourseScarch(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Scerch Course");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Serch Course");
        titlelable.setFont(f);
        titlelable.setBounds(120,10,250,50);
        c.add(titlelable);

        cnamelable = new JLabel("Course Name : ");
        cnamelable.setBounds(10,80,140,30);
        c.add(cnamelable);

        cnametf=new JTextField();
        cnametf.setBounds(110,80,200,30);
        cnametf.setFont(f);
        c.add(cnametf);

        idlable = new JLabel("Course Id : ");
        idlable.setBounds(10,120,140,30);
        c.add(idlable);

        idlable2 = new JLabel();
        idlable2.setBounds(110,120,140,30);
        idlable2.setText("");
        c.add(idlable2);

        durationlable = new JLabel("Duration : ");
        durationlable.setBounds(10,160,140,30);
        c.add(durationlable);

        durationlable2 = new JLabel();
        durationlable2.setBounds(110,160,140,30);
        durationlable2.setText("");
        c.add(durationlable2);

        serchbutton=new JButton("Serch");
        serchbutton.setBounds(400,80,80,30);
        c.add(serchbutton);

        clearbutton=new JButton("Clear");
        clearbutton.setBounds(400,120,80,30);
        c.add(clearbutton);

        backbutton=new JButton("Back");
        backbutton.setBounds(350,500,80,30);
        c.add(backbutton);

        serchbutton.addActionListener(this);
        clearbutton.addActionListener(this);
        backbutton.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==serchbutton){

            String cname = cnametf.getText().toString();
            if(!cname.isEmpty()){
                String query="select * from course where cname=?;";
                try {
                    ResultSet rs = Connect.selectcourse(query,cname);
                    idlable2.setText(rs.getString("cid"));
                    durationlable2.setText(rs.getString("duration"));
                    cnametf.setText("");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Invalid values");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter valid values");
            }
            
        }
        else if(e.getSource()==clearbutton){
            idlable2.setText("");
            durationlable2.setText("");
            cnametf.setText("");
        }
        else if(e.getSource()==backbutton){
            new RegisterView(intid).setVisible(true);
            this.setVisible(false);
        }
    }
}
