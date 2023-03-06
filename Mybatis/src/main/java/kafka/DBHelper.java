package kafka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	 public static final String url = "jdbc:mysql://82.156.185.58:3406/wcl_crm??useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false";  
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "dba";  
	    public static final String password = "dba1z2x3c4v";  
	 
	    public Connection conn = null;  
	    public PreparedStatement pst = null;  
	 
	    public DBHelper(String sql) {  
	        try {  
	            Class.forName(name);//ָ����������  
	            conn = DriverManager.getConnection(url,user,password);//��ȡ����  
	            pst = conn.prepareStatement(sql);//׼��ִ�����  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	 
	    public void close() {  
	        try {  
	            this.conn.close();  
	            this.pst.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }
}
