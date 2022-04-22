import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class StudentTable extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable,fnlable,lnlable,phonelable,courselable,paymentlable,idlable;
    private JTextField fntf,lntf,phonetf,coursetf,paymenttf,idtf;
    private JButton addbutton,updatebutton,deletebutton,clearbutton,backbutton;
    int intid=0;
    StudentTable(int id){
        intid=id;
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

        titlelable=new JLabel("Student Registration");
        titlelable.setFont(f);
        titlelable.setBounds(120,10,250,50);
        c.add(titlelable);

        fnlable = new JLabel("First Name : ");
        fnlable.setBounds(10,80,140,30);
        c.add(fnlable);

        fntf=new JTextField();
        fntf.setBounds(110,80,200,30);
        fntf.setFont(f);
        c.add(fntf);

        lnlable = new JLabel("Last Name : ");
        lnlable.setBounds(10,120,140,30);
        c.add(lnlable);

        lntf=new JTextField();
        lntf.setBounds(110,120,200,30);
        lntf.setFont(f);
        c.add(lntf);

        phonelable = new JLabel("phone : ");
        phonelable.setBounds(10,160,140,30);
        c.add(phonelable);

        phonetf=new JTextField();
        phonetf.setBounds(110,160,200,30);
        phonetf.setFont(f);
        c.add(phonetf);

        courselable = new JLabel("Course : ");
        courselable.setBounds(10,200,140,30);
        c.add(courselable);

        coursetf=new JTextField();
        coursetf.setBounds(110,200,200,30);
        coursetf.setFont(f);
        c.add(coursetf);

        paymentlable = new JLabel("Payment : ");
        paymentlable.setBounds(10,240,140,30);
        c.add(paymentlable);

        paymenttf=new JTextField();
        paymenttf.setBounds(110,240,200,30);
        paymenttf.setFont(f);
        c.add(paymenttf);

        idlable = new JLabel("Id : ");
        idlable.setBounds(10,280,140,30);
        c.add(idlable);

        idtf=new JTextField();
        idtf.setBounds(110,280,200,30);
        idtf.setFont(f);
        c.add(idtf);

        addbutton=new JButton("Add");
        addbutton.setBounds(400,80,80,30);
        c.add(addbutton);

        updatebutton=new JButton("Update");
        updatebutton.setBounds(400,120,80,30);
        c.add(updatebutton);

        deletebutton=new JButton("Delete");
        deletebutton.setBounds(400,160,80,30);
        c.add(deletebutton);

        clearbutton=new JButton("Clear");
        clearbutton.setBounds(400,200,80,30);
        c.add(clearbutton);

        backbutton=new JButton("Back");
        backbutton.setBounds(350,500,80,30);
        c.add(backbutton);

        addbutton.addActionListener(this);
        clearbutton.addActionListener(this);
        deletebutton.addActionListener(this);
        updatebutton.addActionListener(this);
        backbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addbutton){

            String fname=fntf.getText().toString();
            String lname=lntf.getText().toString();
            String phone=phonetf.getText().toString();
            String course=coursetf.getText().toString();
            String payment=paymenttf.getText().toString();
            int tid=-1;
            if(!fname.isEmpty() && !lname.isEmpty() && !phone.isEmpty() && !course.isEmpty() && !payment.isEmpty()){

                String query1="select * from teacher where cname=?;";
                try {
                    ResultSet rs = Connect.selectcourse(query1,course);
                    tid=rs.getInt("TID");
                } catch (Exception e1) {
                    System.out.println(e1);
                    JOptionPane.showMessageDialog(null, "Subject not available");
                }

                String query="insert into student(fname,lname,phone,payment,date,TID,CNAME) values(?,?,?,?,?,?,?);";
                try {
                    int ins=Connect.insertstudent(query, fname, lname, phone, payment,tid,course);
                    System.out.println(ins+" row is inserted");
                    JOptionPane.showMessageDialog(null, "Student added");
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter all values");
            }
            
            fntf.setText("");
            lntf.setText("");
            phonetf.setText("");
            coursetf.setText("");
            paymenttf.setText("");
            idtf.setText("");
        }
        else if(e.getSource()==clearbutton){
            fntf.setText("");
            lntf.setText("");
            phonetf.setText("");
            coursetf.setText("");
            paymenttf.setText("");
            idtf.setText("");
        }
        else if(e.getSource()==deletebutton){
                String id=idtf.getText();
                if(!id.isEmpty()){
                    int intid=Integer.parseInt(id);
                    String query="DELETE FROM student WHERE SId="+intid+";";
                    try {
                        int del=Connect.delete(query);
                        System.out.println(del+" row is deleted");
                    } catch (Exception e1) {
                        System.out.println(e1);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter valid id value");
                }
                fntf.setText("");
                lntf.setText("");
                phonetf.setText("");
                coursetf.setText("");
                paymenttf.setText("");
                idtf.setText("");
            
        }
        else if(e.getSource()==updatebutton){
            String fname=fntf.getText().toString();
            String lname=lntf.getText().toString();
            String phone=phonetf.getText().toString();
            String course=coursetf.getText().toString();
            String payment=paymenttf.getText().toString();
            String id=idtf.getText();

            
            if(!fname.isEmpty() && !lname.isEmpty() && !phone.isEmpty() && !course.isEmpty() && !payment.isEmpty() && !id.isEmpty()){
                String query1="select * from teacher where cname=?;";
                int tid=0;
                try {
                    ResultSet rs = Connect.selectcourse(query1,course);
                    tid=rs.getInt("TID");
                } catch (Exception e1) {
                    System.out.println(e1);
                    JOptionPane.showMessageDialog(null, "Subject not available");
                }
                int intid=Integer.parseInt(id);
                String query="update student set SID=?,fname=?,lname=?,phone=?,payment=?,cname=?,tid=? WHERE SID=?";
                try {
                    int upd=Connect.updatestudent(query, intid, fname, lname, phone, payment,course,tid);
                    System.out.println(upd+" row is updated");
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Please enter all fields");
            }
            
            fntf.setText("");
            lntf.setText("");
            phonetf.setText("");
            coursetf.setText("");
            paymenttf.setText("");
            idtf.setText("");
        }
        else if(e.getSource()==backbutton){
            new RegisterView(intid).setVisible(true);
            this.setVisible(false);
        }  
    }
}