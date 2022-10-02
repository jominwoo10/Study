package test.sync1;

public class Orange {
	static int orange_count = 50;
	
	public static synchronized void takeOut(String name, int num) {
		if(orange_count >= num) {
			orange_count -= num;
			System.out.println(name + "가(이) 오렌지를 " + num + "개 꺼내감.");
		}else {
			System.out.println(name + "님 오렌지 개수가 부족합니다.");
			
		}
		System.out.println("** 남은 오렌지의 개수는 " + orange_count + "개입니다.");
	}
}
