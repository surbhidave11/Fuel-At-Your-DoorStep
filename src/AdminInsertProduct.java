import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AdminInsertProdcut
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter Order id");
int OrderID=sc.nextInt();
System.out.println("Enter Order name");
String OrderName= sc.next();
System.out.println("Enter order address");
String OrderAdd= sc.next();
System.out.println("Enter order Discription");
String OrderDis= sc.next();


System.out.println("Enter contact");
float contact= sc.nextFloat();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("insert into orders values(?,?,?,?,?)");
st.setInt(1,OrderID);
st.setString(2,OrderName);
st.setString(3,OrderAdd);
st.setString(4,OrderDis);
st.setFloat(5,contact);

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