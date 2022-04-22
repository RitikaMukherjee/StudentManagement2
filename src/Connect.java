import java.sql.*;
import java.time.LocalDateTime;
public class Connect {
    public static ResultSet select(String query) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        return rs;
    }
    public static ResultSet selectcourse(String query,String name) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1, name);
        ResultSet rs=st.executeQuery();
        rs.next();
        return rs;
    }
    public static int insertstudent(String query,String fname,String lname,String phone,String payment,int tid,String course) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1, fname);
        st.setString(2, lname);
        st.setString(3, phone);
        st.setString(4, payment);
        st.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
        st.setInt(6, tid);
        st.setString(7, course);
        return(st.executeUpdate());
    }
    public static int insertscore(String query,int score) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1,score);
        return(st.executeUpdate());
    }
    public static int insertteacher(String query,String fname,String lname,String phone,String payment,String course) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1, fname);
        st.setString(2, lname);
        st.setString(3, phone);
        st.setString(4, payment);
        st.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
        st.setString(6, course);
        return(st.executeUpdate());
    }
    public static int delete(String query) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        Statement st=con.createStatement();
        return(st.executeUpdate(query));
    }
    public static int updateteacher(String query,int id,String fname,String lname,String phone,String payment,String course) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1, id);
        st.setString(2, fname);
        st.setString(3, lname);
        st.setString(4, phone);
        st.setString(5,payment);
        st.setString(6, course);
        st.setInt(7, id);
        return(st.executeUpdate());
    }
    public static int updatestudent(String query,int id,String fname,String lname,String phone,String payment,String course,int tid) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1, id);
        st.setString(2, fname);
        st.setString(3, lname);
        st.setString(4, phone);
        st.setString(5,payment);
        st.setString(6, course);
        st.setInt(7, tid);
        st.setInt(8, id);
        return(st.executeUpdate());
    }
    public static int insertcourse(String query,String cname,String duration) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1, cname);
        st.setString(2, duration);
        return(st.executeUpdate());
    }
    public static int updatecourse(String query,int id,String cname,String duration) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1, id);
        st.setString(2, cname);
        st.setString(3, duration);
        st.setInt(4, id);
        return(st.executeUpdate());
    }
    public static ResultSet login(String query) throws Exception{
        String url="jdbc:mysql://localhost:3306/ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user="root";
        String password="Ritika@123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url, user, password);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        return rs;
    }
}
