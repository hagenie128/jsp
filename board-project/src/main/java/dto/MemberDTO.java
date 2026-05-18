package dto;

public class MemberDTO {

	private int no;
	private String id;
	private String passwd;
	private String userName;
	private String nickName;
	
	// 기본 생성자
	public MemberDTO() {
		super();
	}
	public MemberDTO(int no, String id, String passwd, String userName, String nickName) {
		super();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", passwd=" + passwd
				+ ", userName=" + userName + ", nickName=" + nickName + "]";
	}
}