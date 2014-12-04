package yona.app;

public class User{
	String username;
	String password;
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUserName(){ return username; }
	
	public String getPassword(){ return password; }
	
	public void setUsername(String username){ this.username = username; }
	
	public void setPassword(String password){ this.password = password; }
	
	@Override
	public String toString(){
		return "User [username=" + username + ", password=" + password + "]";
	}
}