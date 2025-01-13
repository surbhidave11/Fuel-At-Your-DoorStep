import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class Complain1Delete
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter login to delete the record");
int login=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement(
        "select * from complain1 where login=?");
st.setInt(1,login);
ResultSet rs=st.executeQuery();
if(rs.next())
{
PreparedStatement st1=connection.prepareStatement(
        "delete  from complain1 where login=?");
st1.setInt(1,login);
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


