import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class AllStudent extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable;
    private JTable table;
    private JScrollPane scroll;
    private JButton backbutton;
    private String SID ,FNAME,LNAME,PHONE,PAYMENT,SCORE,TID,CNAME,DATE;
    int intid=0;
    AllStudent(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Student Details");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Student Details");
        titlelable.setFont(f);
        titlelable.setBounds(300,10,250,50);
        c.add(titlelable); 

        backbutton=new JButton("Back");
        backbutton.setBounds(350,500,80,30);
        c.add(backbutton);

        table=new JTable();
        try {
            String query="select * from student;";
            ResultSet rs=Connect.select(query);
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model=(DefaultTableModel) table.getModel();
            int cols=rsmd.getColumnCount();
            String[] colname=new String[cols];
            for(int i=0;i<cols;i++){
                colname[i]=rsmd.getColumnName(i+1);
            }
            model.setColumnIdentifiers(colname);
            SID=(rs.getInt(1))+"";
            FNAME=rs.getString(2);
            LNAME=rs.getString(3);
            PHONE=rs.getString(4);
            PAYMENT=rs.getString(5);
            DATE=rs.getString(6);
            SCORE=rs.getString(7);
            TID=rs.getString(8);
            CNAME=rs.getString(9);
            String[] row={SID,FNAME,LNAME,PHONE,PAYMENT,DATE,SCORE,TID,CNAME};
            model.addRow(row);
            while(rs.next()){
                 SID=(rs.getInt(1))+"";
                 FNAME=rs.getString(2);
                 LNAME=rs.getString(3);
                 PHONE=rs.getString(4);
                 PAYMENT=rs.getString(5);
                 DATE=rs.getString(6);
                 SCORE=rs.getString(7);
                 TID=rs.getString(8);
                 CNAME=rs.getString(9);
                String[] rows={SID,FNAME,LNAME,PHONE,PAYMENT,DATE,SCORE,TID,CNAME};
                model.addRow(rows);
            }
            table.setModel(model);
            c.add(table);
            table.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }        
        scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(30,100, 700, 400);
        c.add(scroll);
        backbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backbutton){
            new RegisterView(intid).setVisible(true);
            this.setVisible(false);
        }        
    }
}
