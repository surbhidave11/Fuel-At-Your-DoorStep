import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class AdminViewComplain
{
public static void main (String...arguments)
{
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
DriverManager.getConnection(
"jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement(
        "select * from feedbackdetails ");

ResultSet rs=st.executeQuery();
while(rs.next())
{
    int id=rs.getInt(1);
    String proName=rs.getString(2);
    float contact=rs.getFloat(3);
    String email=rs.getString(4);
    String address=rs.getString(5);
    
    
    out.println(id+" "+proName+" "+contact+"  "+email+" "+address);
}
 
connection.close();
}
catch(SQLException | ClassNotFoundException ex)
{
ex.printStackTrace();
}

}
}


