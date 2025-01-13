import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class ComplainUpdate
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter Com id to update the record");
int ComID=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("select * from complaintable where ComID=?");
st.setInt(1,ComID);
ResultSet rs=st.executeQuery();
if(rs.next())
{
 out.println("Enter updated ComAdd");
 String uComAdd=sc.next();
PreparedStatement st1=connection.prepareStatement("update complaintable set ComAdd=? where ComID=?"); 
st1.setString(1,uComAdd);
st1.setInt(2,ComID);
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


