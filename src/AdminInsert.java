import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AdminInsert
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter LOGIN");
int ID =sc.nextInt();
System.out.println("Enter Name");
String Name= sc.next();
System.out.println("Enter Address");
String Address = sc.next();

System.out.println("Contact");
int Contact= sc.nextInt();
System.out.println("Password");
String password= sc.next();


try
{
Class.forName("com.mysql.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("insert into admin11 values(?,?,?,?,?)");
st.setInt(1,ID);
st.setString(2,Name);
st.setString(3,Address);
st.setInt(4,Contact);
st.setString(5,password);




st.executeUpdate();
connection.close();
}

catch(SQLException | ClassNotFoundException ex)
{
ex.printStackTrace();
}
out.println("record inserted!!!!");
}
}