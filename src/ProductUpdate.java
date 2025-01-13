import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class ProductUpdate
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter pro id to update the record");
int proID=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("select * from product where proID=?");
st.setInt(1,proID);
ResultSet rs=st.executeQuery();
if(rs.next())
{
 out.println("Enter updated dis");
 String proDis=sc.next();
PreparedStatement st1=connection.prepareStatement("update productdetails set proDis=? where proID=?"); 
st1.setString(1,proDis);
st1.setInt(2,proID);
st1.executeUpdate();
System.out.println("record updated!!!");
}
else 
{
out.println("no record found to load the record");
}
connection.close();
}
catch(SQLException | ClassNotFoundException ex)
{
ex.printStackTrace();
}
out.println("record inserted!!!!");
}
}


