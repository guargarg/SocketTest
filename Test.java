/**
 * @author gu-ppy
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		String driverName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/user_info";
		String user="root";
		String password="123456";
		String sql="Select * from student_info";
		Connection con=null;
		Statement stm=null;
		ResultSet rs=null;
		ResultSetMetaData rdata=null;
		try {
				Class.forName(driverName);                 //加载驱动
				con= DriverManager.getConnection(url, user, password);   //连接
                stm= con.createStatement();
				rs=stm.executeQuery(sql);
				
				rdata=rs.getMetaData();
				System.out.println("查询结果为：");
				System.out.println(rdata.getColumnName(1)+"\t"+rdata.getColumnName(2)+"\t"+rdata.getColumnName(3)+"\t"+rdata.getColumnName(4));
				while(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"
							+rs.getString(3)+"\t"+rs.getString(4));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {e.printStackTrace();}
	}

}
