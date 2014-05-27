package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class DeleteForum extends HttpServlet {

        DBConnectie db = new DBConnectie(Variable.getDb(),Variable.getDbLogin(),Variable.getDbPassword());

        public void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        	    try{    
					
					HttpSession session = request.getSession(true);
					String sessionType = (String)session.getAttribute("member_title");
					
					String forum_id = request.getParameter("forum_id");
					
					if(sessionType.equals("Admin")){

                    	db.connect();
                    
                    	db.query("DELETE FROM forum_message WHERE forum_id=\"" + forum_id + "\"");
                    	db.query("DELETE FROM forum_forums WHERE forum_id=\"" + forum_id + "\"");
					 					 
                    	db.close();
           		
	              		response.sendRedirect(Variable.getForumPath() + "index.jsp");
    				}          		
              	
                }catch(Exception e){}
                
             
        }
        public void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{ 
                doPost(request, response);
        }

}