import static java.lang.System.out;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ProductInsert
{
public static void main (String...arguments)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter pro ID");
int proID =sc.nextInt();
System.out.println("Enter pro name");
String proName= sc.next();
System.out.println("Enter product discription");
String proDis= sc.next();



System.out.println("Enter rate");
float Prorate = sc.nextFloat();


try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
PreparedStatement st=connection.prepareStatement("insert into product values(?,?,?,?)");
st.setInt(1,proID);
st.setString(2,proName);
st.setString(3,proDis);

st.setFloat(4,Prorate);

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