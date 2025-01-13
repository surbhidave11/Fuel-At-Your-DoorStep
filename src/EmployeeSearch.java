import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class EmployeeSearch
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter ID to load the record");
int empID=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("select * from employeefuel where empID=?");
st.setInt(1,empID);
ResultSet rs=st.executeQuery();
if(rs.next())
{
    int ID= rs.getInt(1);
    String Name=rs.getString(2);
    String Add=rs.getString(3);
    float Contact=rs.getFloat(4);
    String email=rs.getString(5);
    String gender=rs.getString(6);
    
    
    out.println(empID+" "+Name+" "+Add+" "+Contact+" "+email+" "+gender);
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

}
}


