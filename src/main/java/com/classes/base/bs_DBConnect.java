package base;
import java.sql.*;

//@SuppressWarnings("unused")
public class bs_DBConnect {
    //声明Connection对象
	private Connection con;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = null;
	private String user = null;
	private String password = null;
    
    public bs_DBConnect() {

    	bs_Configuration ini = new bs_Configuration();
    	url =  ini.getProperty("address");
    	user = ini.getProperty("dbid");
    	password = ini.getProperty("dbpw");
    	
        try {
            //加载驱动程序
            Class.forName(driver);
            //连接MySQL数据库
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
        }
        catch(ClassNotFoundException e) {   
    		//数据库驱动类异常处理
    		System.out.println("Sorry,can`t find the Driver!");   
    		e.printStackTrace();   
        } 
        catch (SQLException e) {
			e.printStackTrace();
        }
    }
        	
    public ResultSet exSql(String sql) {
    	ResultSet rs = null;
    	try {
            //创建statement类对象，用来执行SQL语句！！
	        Statement statement = con.createStatement();
	        rs = statement.executeQuery(sql);
	        return rs;
	    } 
    	catch(SQLException e) {
    		//数据库连接失败异常处理
    		e.printStackTrace();  
    		return rs;
        }
    	catch (Exception e) {
    		e.printStackTrace();
    		return rs;
    	}
    }

	public void close() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//public static void main(String[] args) { 
//	ResultSet rs = null;
//	String sql = "select * from studentinfo";
//	String name;
//	String id;
//	
//	bs_DBConnect con = new bs_DBConnect();
//	
//    try {
//    	rs=con.exSql(sql);
//		while(rs.next()){
//		    //获取stuname这列数据
//		    name = rs.getString("Name");
//		    id = rs.getString("ID");
//		    System.out.println(id + "\t" + name);
//			}
//		rs.close();
//	} 
//    catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//    con.close();
//}

}











