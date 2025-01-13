import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class EmployeeInsert
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter ID");
int ID =sc.nextInt();
System.out.println("Enter Name");
String Name= sc.next();
System.out.println("Enter address");
String Add= sc.next();



System.out.println("Enter contact");
float Contact = sc.nextFloat();
System.out.println("Enter Email");
String email= sc.next();
System.out.println("Enter gender");
String gender= sc.next();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("insert into employeefuel values(?,?,?,?,?,?)");
st.setInt(1,ID);
st.setString(2,Name);
st.setString(3,Add);

st.setFloat(4,Contact);
st.setString(5,email);
st.setString(6,gender);

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