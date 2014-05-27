package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class DeleteThread extends HttpServlet {

        DBConnectie db = new DBConnectie(Variable.getDb(),Variable.getDbLogin(),Variable.getDbPassword());

        public void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        	    try{    
					
					HttpSession session = request.getSession(true);
					String sessionType = (String)session.getAttribute("member_title");
					String forum_id = request.getParameter("forum_id");
					String thread_id = request.getParameter("thread_id");
				
					if(sessionType.equals("Admin")){
        
                    	db.connect();
                    
                    	db.query("DELETE FROM forum_message WHERE forum_id=\"" + forum_id + "\" AND thread_id=\"" + thread_id + "\"");
					 	db.query("DELETE FROM forum_threads WHERE forum_id=\"" + forum_id + "\" AND thread_id=\"" + thread_id + "\"");	
					 					 
                    	db.close();
           		
	              		response.sendRedirect(Variable.getForumPath() + "index.jsp?page=thread&forum_id="+forum_id);
    				}          		
              	
                }catch(Exception e){}
                
             
        }
        public void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{ 
                doPost(request, response);
        }

}