package java_20190607;

public class Member {
	private String name;
	private String id;

	public Member(String id, String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "아이디 : " + id + ", 이름 : " + name;
	}
}
