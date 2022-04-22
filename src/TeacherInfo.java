import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
public class TeacherInfo extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable,fnlable,fnlable2,lnlable,lnlable2,phonelable,phonelable2,courselable,courselable2,paymentlable,paymentlable2,idlable,idlable2,joininglable,joininglable2;
    private JButton backbutton;
    int intid=0;
    TeacherInfo(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Teacher Deatils");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Serch Teacher");
        titlelable.setFont(f);
        titlelable.setBounds(120,10,250,50);
        c.add(titlelable);

        idlable = new JLabel("Id : ");
        idlable.setBounds(10,80,140,30);
        c.add(idlable);

        idlable2 = new JLabel(intid+"");
        idlable2.setBounds(110,80,140,30);
        c.add(idlable2);

        fnlable = new JLabel("First Name : ");
        fnlable.setBounds(10,120,140,30);
        c.add(fnlable);

        fnlable2 = new JLabel();
        fnlable2.setBounds(110,120,140,30);
        c.add(fnlable2);

        lnlable = new JLabel("Last Name : ");
        lnlable.setBounds(10,160,140,30);
        c.add(lnlable);

        lnlable2 = new JLabel();
        lnlable2.setBounds(110,160,140,30);
        c.add(lnlable2);

        phonelable = new JLabel("Phone : ");
        phonelable.setBounds(10,200,140,30);
        c.add(phonelable);

        phonelable2 = new JLabel();
        phonelable2.setBounds(110,200,140,30);
        c.add(phonelable2);

        joininglable = new JLabel("Joining Date : ");
        joininglable.setBounds(10,240,140,30);
        c.add(joininglable);

        joininglable2 = new JLabel();
        joininglable2.setBounds(110,240,140,30);
    
        c.add(joininglable2);

        paymentlable = new JLabel("Payment : ");
        paymentlable.setBounds(10,280,140,30);
        c.add(paymentlable);

        paymentlable2 = new JLabel();
        paymentlable2.setBounds(110,280,140,30);
    
        c.add(paymentlable2);

        courselable = new JLabel("Course : ");
        courselable.setBounds(10,320,140,30);
        c.add(courselable);

        courselable2 = new JLabel();
        courselable2.setBounds(110,320,140,30);

        c.add(courselable2);

        backbutton=new JButton("Back");
        backbutton.setBounds(350,500,80,30);
        c.add(backbutton);

        backbutton.addActionListener(this);

        String query="select * from teacher where tid="+intid+";";
        try {
            ResultSet rs = Connect.select(query);
            fnlable2.setText(rs.getString("fname"));
            lnlable2.setText(rs.getString("lname"));
            phonelable2.setText(rs.getString("phone"));
            joininglable2.setText(rs.getString("date"));
            paymentlable2.setText(rs.getString("payment"));
            courselable2.setText(rs.getString("cname"));
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Incorrect Id");
            System.out.println(e1);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backbutton){
            new TeacherView(intid).setVisible(true);
            this.setVisible(false);
        }
    }
}
