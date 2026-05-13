package dto;

public class MemberDTO {

	private int no;
	private String id;
	private String passwd;
	private String userName;
	private String nickName;

	public MemberDTO(int no, String id, String passwd, String userName, String nickName) {
		this.no = no;
		this.id = id;
		this.passwd = passwd;
		this.userName = userName;
		this.nickName = nickName;
	}
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickName;
	}

	public void setNickname(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", passwd=" + passwd
				+ ", userName=" + userName + ", nickName=" + nickName + "]";
	}
}