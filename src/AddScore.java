import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class AddScore extends JFrame implements ActionListener{
    private Container c;
    private Font f;
    private JLabel titlelable,idlable,scorelable;
    private JTextField idtf,scoretf;
    private JButton addbutton,clearbutton,backbutton;
    int intid=0;
    AddScore(int id){
        intid=id;
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Add Score");
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,18);

        titlelable=new JLabel("Add Score");
        titlelable.setFont(f);
        titlelable.setBounds(120,10,250,50);
        c.add(titlelable);

        idlable = new JLabel("Id : ");
        idlable.setBounds(10,80,140,30);
        c.add(idlable);

        idtf=new JTextField();
        idtf.setBounds(110,80,200,30);
        idtf.setFont(f);
        c.add(idtf);

        scorelable = new JLabel("Add Score : ");
        scorelable.setBounds(10,120,140,30);
        c.add(scorelable);

        scoretf = new JTextField();
        scoretf.setBounds(110,120,140,30);
        scoretf.setFont(f);
        c.add(scoretf);

        addbutton=new JButton("Add");
        addbutton.setBounds(400,80,80,30);
        c.add(addbutton);

        clearbutton=new JButton("Clear");
        clearbutton.setBounds(400,120,80,30);
        c.add(clearbutton);

        backbutton=new JButton("Back");
        backbutton.setBounds(350,500,80,30);
        c.add(backbutton);

        addbutton.addActionListener(this);
        clearbutton.addActionListener(this);
        backbutton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addbutton){

            String id = idtf.getText();
            int intid=Integer.parseInt(id);
            String score = scoretf.getText();
            int intscore=Integer.parseInt(score);
            if(intscore>100 || intscore<0){
                JOptionPane.showMessageDialog(null, "Enter a valid score");
                System.exit(1);
            }
            if(!id.isEmpty()){
                String query="update student set score=? where sid="+intid+";";
                try {
                    int ins=Connect.insertscore(query,intscore);
                    System.out.println(ins+" row is updated");
                } catch (Exception e1) {

                    System.out.println(e1);
                }
                idtf.setText("");
                scoretf.setText("");
                JOptionPane.showMessageDialog(null, "Score Updated");

            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter all values");
            }
            
        }
        else if(e.getSource()==clearbutton){
            idtf.setText("");
            scoretf.setText("");
        }
        else if(e.getSource()==backbutton){
            new TeacherView(intid).setVisible(true);
            this.setVisible(false);
        }
        
    }
}

