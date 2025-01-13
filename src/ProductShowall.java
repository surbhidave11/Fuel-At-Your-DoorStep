import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class ProductShowall
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
        "select * from product ");

ResultSet rs=st.executeQuery();
while(rs.next())
{
    int id=rs.getInt(1);
    String proName=rs.getString(2);
    String proDis=rs.getString(3);
    
    float rate=rs.getFloat(4);
    
    out.println(id+" "+proName+" "+proDis+" "+rate);
}
 
connection.close();
}
catch(SQLException | ClassNotFoundException ex)
{
ex.printStackTrace();
}

}
}


