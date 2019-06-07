package java_20190607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class ConsoleApplication {
	private ArrayList<Member> list;

	public ConsoleApplication() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("**********************************************");
		System.out.println("1. Insert 2. Update 3. Delete 4. Search 5.Exit");
		System.out.println("**********************************************");
	}

	public String console(String message) throws IOException {
		System.out.print(message);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public void execute(String message) throws IOException {
		if (message.equals("1")) {
			System.out.println("insert");
			insert();
		} else if (message.equals("2")) {
			System.out.println("update");
			update();
		} else if (message.equals("3")) {
			System.out.println("delete");
			delete();
		} else if (message.equals("4")) {
			System.out.println("search");
			search();
		} else {
			System.out.println("프로그램을 종료합니다.");
		}
	}

	// 1. 아이디를 입력받는다.
	// 2. 이름을 입력받는다.
	// 3. ArrayList에 추가한다.
	// 4. ArrayList에 있는 모든 고객을 출력한다.
	// 5. print() 함수호출
	// 6. 선택하세요 : 메세지 출력 후 키보드 입력받을 준비
	public void insert() throws IOException {
		String id = console("아이디 : ");
		String name = console("이름 : ");
		Member m = new Member(id, name);
		list.add(m);

		common();
	}

	// 1. 수정할 아이디를 입력받는다.
	// 2. ArrayList에서 수정 할 아이디를 찾아서 있으면 수정 할 이름을 입력받고 ArrayList에서 수정하고
	// 없으면 수정 할 아이디가 없습니다. 메세지 출력한다.
	// 3. ArrayList에 있는 모든 고객을 출력한다.
	// 4. print() 함수호출
	// 5. 선택하세요 : 메세지 출력 후 키보드 입력받을 준비
	public void update() throws IOException {
		String updateId = console("수정 할 아이디 : ");
		boolean isExisted = false;

		for (Member m : list) {
			if (updateId.equals(m.getId())) {
				isExisted = true;
				break;
			}
		}
		if (isExisted) {
			String updateName = console("수정 할 이름 : ");
			for (int i = 0; i < list.size(); i++) {
				Member m1 = list.get(i);
				if (updateId.equals(m1.getId())) {
					m1.setName(updateName);
					// list.remove(i);
					// list.add(new Member(updateId, updateName));
					break;
				}
			}
		} else {
			System.out.println("수정 할 아이디가 없습니다.");
		}

		common();

	}

	// 1. 삭제할 아이디를 입력받는다
	// 2. ArrayList에서 삭제할 아이디를 찾아서 있으면 ArrayList에서 삭제하고
	// 없으면 삭제할 아이디가 없습니다. 메세지 출력한다.
	// 3. ArrayList에 있는 모든 고객을 출력한다.
	// 4. print() 함수호출
	// 5. 선택하세요 : 메세지 출력 후 키보드 입력받을 준비
	public void delete() throws IOException {
		String deleteId = console("삭제 할 아이디 : ");
		boolean isExisted = false;

		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);
			if (deleteId.equals(m.getId())) {
				isExisted = true;
				list.remove(i);
				break;
			}
		}
		if (!isExisted) {
			System.out.println("삭제 할 아이디가 없습니다.");
		}
		common();
	}

	// 1. 검색 할 아이디를 입력받는다
	// 2. ArrayList에서 검색 할 아이디를 찾아서 있으면 ArrayList에서 출력하고
	// 없으면 검색 할 아이디가 없습니다. 메세지 출력한다.
	// 3. ArrayList에 있는 모든 고객을 출력한다.
	// 4. print() 함수호출
	// 5. 선택하세요 : 메세지 출력 후 키보드 입력받을 준비
	public void search() throws IOException {
		String searchId = console("검색 할 아이디 : ");
		System.out.println("********************검색결과*********************");
		boolean isExisted = false;

		for (Member m : list) {
			if (searchId.equals(m.getId())) {
				isExisted = true;
				break;
			}
		}
		if (isExisted) {
			for (int i = 0; i < list.size(); i++) {
				Member m1 = list.get(i);
				if (searchId.equals(m1.getId())) {
					System.out.println("***********    " + m1 + "    ************");
					System.out.println("**********************************************");
					break;
				}
			}
		} else {
			System.out.println("검색 할 아이디가 없습니다.");
		}

		common();
	}

	// 중복 메서드 Refactor => Extract Method(Alt + Shift + m)
	private void common() throws IOException {
		for (Member m1 : list) {
			System.out.println(m1);
		}

		print();
		String message = console("선택하세요 : ");
		execute(message);  
	}

	public static void main(String[] args) throws IOException {
		ConsoleApplication c = new ConsoleApplication();
		c.print();
		String message = c.console("선택하세요 : ");
		c.execute(message);

	}

}
