import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class Ordershowall11
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
        "select * from orders ");

ResultSet rs=st.executeQuery();
while(rs.next())
{
    int ComID=rs.getInt(1);
    String ComName=rs.getString(2);
    
   String ComDis=rs.getString(3);
     float contact=rs.getFloat(4);
    String ComAdd=rs.getString(5);
    
    
    
    out.println(ComID+" "+ComName+" "+ComDis+" "+contact+" "+ComAdd);
}
 
connection.close();
}
catch(SQLException | ClassNotFoundException ex)
{
ex.printStackTrace();
}

}
}


