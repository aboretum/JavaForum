package forum;


public class Variable {
	
	static String dbDatabase = "userdb";
	static String dbLogin = "admin";
	static String dbPassword = "test";
	static String forumPath = "/JavaForum/";
	static String forumName = "My Forum";
	static String messagePerPage = "10";
	
	
	
	public static String getDb(){
		return dbDatabase;
	}
	
	public static String getDbLogin(){
		return dbLogin;
	}	
	
	public static String getDbPassword(){
		return dbPassword;
	}

	public static String getForumPath(){
		return forumPath;
	}
	
	public static String getForumName(){
		return forumName;
	}
	
	public static String getMessagePerPage(){
		return messagePerPage;
	}
}