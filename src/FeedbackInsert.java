import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class FeedbackInsert
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Name");
String Name =sc.next();
System.out.println(" Rate out of 5 ");
String Rating= sc.next();
System.out.println(" Contact");
String Contact = sc.next();
System.out.println("Enter Email");
String Email = sc.next();
System.out.println("Enter Address");
String Address = sc.next();
System.out.println("Enter Description");
String Description = sc.next();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("insert into feedback values(?,?,?,?,?,?)");
st.setString(1,Name);
st.setString(2,Rating);


st.setString(3,Contact);
st.setString(4,Email);
st.setString(5,Address);
st.setString(6,Description);
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