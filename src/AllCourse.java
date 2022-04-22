import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class AllCourse extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable;
    private JTable table;
    private JScrollPane scroll;
    private JButton backbutton;
    private String CID ,CNAME,DURATION;
    int intid=0;
    AllCourse(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Student Details");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
            String query="select * from COURSE;";
            ResultSet rs=Connect.select(query);
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model=(DefaultTableModel) table.getModel();
            int cols=rsmd.getColumnCount();
            String[] colname=new String[cols];
            for(int i=0;i<cols;i++){
                colname[i]=rsmd.getColumnName(i+1);
            }
            model.setColumnIdentifiers(colname);
            CID=(rs.getInt(1))+"";
            CNAME=rs.getString(2);
            DURATION=rs.getString(3);
            String[] row={CID,CNAME,DURATION};
            model.addRow(row);
            while(rs.next()){
                 CID=(rs.getInt(1))+"";
                 CNAME=rs.getString(2);
                 DURATION=rs.getString(3);
                String[] rows={CID,CNAME,DURATION};
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
