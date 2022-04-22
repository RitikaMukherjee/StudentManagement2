import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
public class StudentInfo extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable,fnlable,fnlable2,lnlable,lnlable2,phonelable,phonelable2,courselable,courselable2,paymentlable,paymentlable2,teacherlable,teacherlable2,scorelable,scorelable2,admissionlable,admissionlable2,idlable,idlable2;
    private JButton backbutton;
    int intid=0;
    StudentInfo(int id){
        intid=id;
        initComponents(intid);
    }
    public void initComponents(int intid){
        this.setTitle("Student Details");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Serch Student");
        titlelable.setFont(f);
        titlelable.setBounds(120,10,250,50);
        c.add(titlelable);

        idlable = new JLabel("Id : ");
        idlable.setBounds(10,80,140,30);
        c.add(idlable);

        idlable2 = new JLabel();
        idlable2.setBounds(110,80,140,30);
        idlable2.setText(intid+"");
        c.add(idlable2);

        fnlable = new JLabel("First Name : ");
        fnlable.setBounds(10,120,140,30);
        c.add(fnlable);

        fnlable2 = new JLabel();
        fnlable2.setBounds(110,120,140,30);
        fnlable2.setText("");
        c.add(fnlable2);

        lnlable = new JLabel("Last Name : ");
        lnlable.setBounds(10,160,140,30);
        c.add(lnlable);

        lnlable2 = new JLabel();
        lnlable2.setBounds(110,160,140,30);
        lnlable2.setText("");
        c.add(lnlable2);

        phonelable = new JLabel("Phone : ");
        phonelable.setBounds(10,200,140,30);
        c.add(phonelable);

        phonelable2 = new JLabel();
        phonelable2.setBounds(110,200,140,30);
        phonelable2.setText("");
        c.add(phonelable2);

        courselable = new JLabel("Course : ");
        courselable.setBounds(10,240,140,30);
        c.add(courselable);

        courselable2 = new JLabel();
        courselable2.setBounds(110,240,140,30);
        courselable2.setText("");
        c.add(courselable2);

        teacherlable = new JLabel("Teacher Name : ");
        teacherlable.setBounds(10,280,140,30);
        c.add(teacherlable);

        teacherlable2 = new JLabel();
        teacherlable2.setBounds(110,280,140,30);
        teacherlable2.setText("");
        c.add(teacherlable2);

        scorelable = new JLabel("Score : ");
        scorelable.setBounds(10,320,140,30);
        c.add(scorelable);

        scorelable2 = new JLabel();
        scorelable2.setBounds(110,320,140,30);
        scorelable2.setText("");
        c.add(scorelable2);

        admissionlable = new JLabel("Admission Date : ");
        admissionlable.setBounds(10,360,140,30);
        c.add(admissionlable);

        admissionlable2 = new JLabel();
        admissionlable2.setBounds(110,360,140,30);
        admissionlable2.setText("");
        c.add(admissionlable2);

        paymentlable = new JLabel("Payment : ");
        paymentlable.setBounds(10,400,140,30);
        c.add(paymentlable);

        paymentlable2 = new JLabel();
        paymentlable2.setBounds(110,400,140,30);
        paymentlable2.setText("");
        c.add(paymentlable2);

        backbutton=new JButton("Back");
        backbutton.setBounds(350,500,80,30);
        c.add(backbutton);

        backbutton.addActionListener(this);

        String query="select * from student where sid="+intid+";";
        try {
            ResultSet rs = Connect.select(query);
            fnlable2.setText(rs.getString("fname"));
            lnlable2.setText(rs.getString("lname"));
            phonelable2.setText(rs.getString("phone"));
            scorelable2.setText(rs.getString("score"));
            admissionlable2.setText(rs.getString("date"));
            paymentlable2.setText(rs.getString("payment"));
            courselable2.setText(rs.getString("cname"));

            int tid =rs.getInt("tid");
            String query2="select * from teacher where tid="+tid+";";
            ResultSet rs2 = Connect.select(query2);
            teacherlable2.setText(rs2.getString("fname")+" "+rs2.getString("lname"));
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Invalid Id");
            System.out.println(e1);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backbutton){
            new StudentView(intid).setVisible(true);
            this.setVisible(false);
        }  
    }    
}

