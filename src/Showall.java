import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class Showall
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
        "select * from employeetable1 ");

ResultSet rs=st.executeQuery();
while(rs.next())
{
    int id=rs.getInt(1);
    String eName=rs.getString(2);
    String pass=rs.getString(3);
    String post=rs.getString(4);
    float salary=rs.getFloat(5);
    String contact=rs.getString(6);
    out.println(id+" "+eName+" "+post+" "+pass+" "+salary+" "+contact);
}
 
connection.close();
}
catch(SQLException | ClassNotFoundException ex)
{
ex.printStackTrace();
}

}
}


