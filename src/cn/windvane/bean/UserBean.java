package cn.windvane.bean;

public class UserBean {
	
	private String username;
	private String password;
	
	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public boolean equals(Object obj) {
		UserBean user= (UserBean)obj;
		if(this.username.equals(user.getUsername())&this.password.equals(user.getPassword()))
		{
			return true;
		}else
		{
			return false;
		}
	}
}
