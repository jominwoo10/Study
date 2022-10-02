
public class RunSubStInfo {

	public static void main(String[] args) {
		Substinfo s = new Substinfo();
		
		s.name = "손예진";
		s.phone = "010-5555-7777";
		s.age = 40;
		s.addr = "서울시 강남구 청담동";
		
		System.out.println("* StInfo의 name: " + s.name);
		System.out.println("* StInfo의 phone: " + s.phone);
		System.out.println("* StInfo의 age: " + s.age);
		System.out.println("* SubStInfo의 addr: " + s.addr);
	}

}
