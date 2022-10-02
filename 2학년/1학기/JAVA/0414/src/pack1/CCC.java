package pack1;

public class CCC {

	public static void main(String[] args) {
		Base b = new Base();
		b.a = 10;  //같은 패키지 public일 때 접근 가능
		b.test1(); //같은 패키지 public일 때 접근 가능
//		b.b; 	   //같은 패키지 private일 때 접근 불가능
		b.c = 30;  //같은 패키지 protected일 때 접근 가능
		b.d = 40;  //같은 패키지 default일 때 접근 가능
	}

}
