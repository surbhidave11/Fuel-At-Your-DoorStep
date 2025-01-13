import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Complain1Insert
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("login");
int login =sc.nextInt();
System.out.println("Name");
String Name= sc.next();
System.out.println("Enter address");
String address= sc.next();


System.out.println("Description");
String Description= sc.next();
System.out.println("Contact");
String Contact= sc.next();

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("insert into Complain values(?,?,?,?,?)");
st.setInt(1,login);
st.setString(2,Name);
st.setString(3,address);
st.setString(4,Description);
st.setString(5,Contact);



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