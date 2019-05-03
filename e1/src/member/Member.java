package member;

public class Member {
	private String memberId;
	private String password;
	private String name;
	
	public Member(String memberId, String password, String name) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
