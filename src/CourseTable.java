import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CourseTable extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable,cnlable,durationlable,idlable;
    private JTextField cntf,durationtf,idtf;
    private JButton addbutton,updatebutton,deletebutton,clearbutton,backbutton;
    int intid;
    CourseTable(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Course Table");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Course Registration");
        titlelable.setFont(f);
        titlelable.setBounds(120,10,250,50);
        c.add(titlelable);

        cnlable = new JLabel("Course Name : ");
        cnlable.setBounds(10,80,140,30);
        c.add(cnlable);

        cntf=new JTextField();
        cntf.setBounds(110,80,200,30);
        cntf.setFont(f);
        c.add(cntf);

        durationlable = new JLabel("Duration : ");
        durationlable.setBounds(10,120,140,30);
        c.add(durationlable);

        durationtf=new JTextField();
        durationtf.setBounds(110,120,200,30);
        durationtf.setFont(f);
        c.add(durationtf);

        idlable = new JLabel("Id : ");
        idlable.setBounds(10,160,140,30);
        c.add(idlable);

        idtf=new JTextField();
        idtf.setBounds(110,160,200,30);
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
            String cname=cntf.getText();
            String duration=durationtf.getText();
            if(!cname.isEmpty() && !duration.isEmpty()){
                String query="insert into course(cname,duration) values(?,?)";
                try {
                    int ins=Connect.insertcourse(query, cname,duration);
                    System.out.println(ins+" rows are inserted");
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter values");
            }
            cntf.setText("");
            durationtf.setText("");
            idtf.setText("");
        }
        else if(e.getSource()==clearbutton){
            cntf.setText("");
            durationtf.setText("");
            idtf.setText("");
        }
        else if(e.getSource()==deletebutton){
            String id=idtf.getText();
                if(!id.isEmpty()){
                    int intid=Integer.parseInt(id);
                    String query="DELETE FROM course WHERE CID="+intid+";";
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
                idtf.setText("");
                cntf.setText("");
                durationtf.setText("");
        }
        else if(e.getSource()==updatebutton){
            String cname=cntf.getText().toString();
            String duration=durationtf.getText().toString();
            String id=idtf.getText();
            if(!cname.isEmpty() && !duration.isEmpty() && !id.isEmpty()){
                int intid=Integer.parseInt(id);
                String query="update course set id=?,cname=?,duration=? WHERE ID=?";
                try {
                    int upd=Connect.updatecourse(query, intid, cname, duration);
                    System.out.println(upd+" row is updated");
                } catch (Exception e1) {
                    System.out.println(e1);
                    JOptionPane.showMessageDialog(null,"Please enter all values correctly");
                }
            }
            cntf.setText("");
            durationtf.setText("");
            idtf.setText("");     
        }
        else if(e.getSource()==backbutton){
            new RegisterView(intid).setVisible(true);
            this.setVisible(false);
        }
    }
}