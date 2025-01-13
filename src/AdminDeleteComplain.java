import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class AdminDeleteComplain
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter ComID to delete the record");
int ComID=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement(
        "select * from complaintable where ComID=?");
st.setInt(1,ComID);
ResultSet rs=st.executeQuery();
if(rs.next())
{
PreparedStatement st1=connection.prepareStatement(
        "delete  from complaintable where ComID=?");
st1.setInt(1,ComID);
st1.executeUpdate();
out.println("hey!!!record deleted!!!");
}
else 
{
out.println("no record found to delete the record");
}
connection.close();
}
catch(SQLException | ClassNotFoundException ex)
{
ex.printStackTrace();
}

}
}


