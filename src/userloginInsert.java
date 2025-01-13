import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class userloginInsert
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter ID");
String userId=sc.next();
System.out.println("Enter Name");
String Name= sc.next();
System.out.println("Enter password");
String Pass= sc.next();



System.out.println("Enter contact");
float contact = sc.nextFloat();
System.out.println("Enter Email");
String email= sc.next();
System.out.println("Enter Address");
String Address= sc.next();
System.out.println("Enter city");
String city= sc.next();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("insert into userloginInsert values(?,?,?,?,?,?,?)");
    
st.setString(1,userId);
st.setString(2, Name);
st.setString(3,Pass);

st.setFloat(4,contact);
st.setString(5,email);
st.setString(6,Address);
st.setString(7,city);

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