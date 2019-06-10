package java_20190528;

public class SwitchDemo {
	public static void main(String[] args){
		//args[0] 프로그램 실행시 입력받은 값 
		//Integer.parseInt() 메소드는 문자열을 int 변환하는 기능
		int month = Integer.parseInt(args[0]);
		
		/*
		switch(month){
			default :
				System.out.println(month+"월은 계절이 아닙니다."); break;
			case 12 : 
			case 1 : 
			case 2 : 
				System.out.println(month+"월은 겨울 입니다.");break;
			case 3 :
			case 4 : 
			case 5 :
				System.out.println(month+"월은 봄 입니다."); break;
			case 6 :
			case 7 : 
			case 8 :
				System.out.println(month+"월은 여름 입니다."); break;
			case 9 :
			case 10 : 
			case 11 :
				System.out.println(month+"월은 가을 입니다."); break;
		}
		System.out.println(month+"월은 가을 입니다.");
		*/
		
		String season = null;
		switch(month){
			default :
				System.out.println(month+"월은 계절이 아닙니다."); break;
			case 12 : 
			case 1 : 
			case 2 : 
				season = "겨울";break;
			case 3 :
			case 4 : 
			case 5 :
				season = "봄"; break;
			case 6 :
			case 7 : 
			case 8 :
				season = "여름"; break;
			case 9 :
			case 10 : 
			case 11 :
				season = "가을"; break;
		}
		System.out.println(month+"월은 "+season+" 입니다.");
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
