package pt.tecnico.mydrive.presentation;

public class MdShell extends Shell {

	private long userToken;
	private String userName; 
	//Segundo o stor precisamos de um mapa de tokens e usernames;
	
	
	public static void main(String[] args) throws Exception {
		MdShell sh = new MdShell();
		sh.execute();
	}

	public MdShell() { // add commands here
		super("MyDrive");
		new Login(this);
		new ChangeWorkingDirectory(this);
		new List(this);
		new Execute(this);
		new Write(this);
		new Environment(this);
		new Key(this);
	}
	
	public long getUserToken() {
		return userToken;
	}

	public void setUserToken(long userToken) {
		this.userToken = userToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
