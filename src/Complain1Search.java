import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class Complain1Search
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter login to load the record");
int login=sc.nextInt();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("select * from complain1 where login=?");
st.setInt(1,login);
ResultSet rs=st.executeQuery();
if(rs.next())
{
    int ID = rs.getInt(1);
    String password=rs.getString(2);
    String fullName=rs.getString(3);
int ComplainID=rs.getInt(4);
String dis=rs.getString(5);
String ComCat=rs.getString(6);
String status=rs.getString(7);
String dateofComplain=rs.getString(8);
String dateofComSol=rs.getString(9);
String solvedby=rs.getString(10);
    
    
    
    
    
    
    out.println(ID+" "+password+" "+fullName+" "+ComplainID+" "+dis+" "+ComCat+" "+status+""+dateofComplain+" "+dateofComSol+""+solvedby);
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


