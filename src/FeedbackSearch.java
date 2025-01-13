import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class FeedbackSearch
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter proId to load the record");
int proID=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("select * from feedbackdetails where proID=?");
st.setInt(1,proID);
ResultSet rs=st.executeQuery();
if(rs.next())
{
    int ID= rs.getInt(1);
    String proName=rs.getString(2);
   
    float contact=rs.getFloat(3);
    String email=rs.getString(4);
    String address=rs.getString(5);
    
    out.println(ID+" "+proName+" "+contact+" "+email+""+address);
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


