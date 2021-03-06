package forum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import org.gjt.mm.mysql.*;

public class DBConnectie{
	
	String DBName, DBUser, DBPass, SQLQuery;
    Connection conn;
    Statement stmt;
    ResultSet result;	
	
	public DBConnectie(String DBName, String DBUser, String DBPass){
    	this.DBName = DBName;
        this.DBUser = DBUser;
        this.DBPass = DBPass;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){}
    }	
	
	public void connect() {
    	try {
        	conn = DriverManager.getConnection("jdbc:mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/" + "javaforum798" + "?user=" + "adminvGKk55S" + "&password=" + "9AaaIVFFLYCa");
        }catch(Exception e){}
    }
	
    public ResultSet selectQuery(String SQLQuery){
    	this.SQLQuery = SQLQuery;

        try {
        	stmt = conn.createStatement();
            result = stmt.executeQuery( SQLQuery );
        }
        catch( Exception e ){}
    	return result;
    }
    
    public void query(String SQLQuery){
    	this.SQLQuery = SQLQuery;
        try {
        	stmt = conn.createStatement();
            stmt.executeUpdate( SQLQuery );
        }
        catch( Exception e ){}
    }
    
    public void close(){
    	try {
        	stmt.close();
            conn.close();
        }
        catch(Exception e){}
    }
}

