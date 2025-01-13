import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class SearchRecord
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter emp id to load the record");
int empId=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("select * from employeetable1 where empId=?");
st.setInt(1,empId);
ResultSet rs=st.executeQuery();
if(rs.next())
{
    int id=rs.getInt(1);
    String eName=rs.getString(2);
    String pass=rs.getString(3);
    String post=rs.getString(4);
    float salary=rs.getFloat(5);
    String contact=rs.getString(6);
    out.println(id+" "+eName+" "+post+" "+pass+" "+salary+" "+contact);
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


