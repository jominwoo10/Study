package pack2;

import pack1.Base;

public class AAA {

	public static void main(String[] args) {
		Base b = new Base();
		b.a = 100; //다른 패키지에서 public일 때 접근 가능
		b.test1(); //다른 패키지에서 public일 때 접근 가능
//		b.b = 300; //다른 패키지에서 private일 때 접근 불가능
//		b.c = 500; //다른 패키지에서 protected일 때 접근 불가능
//		b.d = 600; //다른 패키지에서 default일 때 접근 불가능
	}

}
