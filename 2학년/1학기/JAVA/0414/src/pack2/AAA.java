package pack2;

import pack1.Base;

public class AAA {

	public static void main(String[] args) {
		Base b = new Base();
		b.a = 100; //�ٸ� ��Ű������ public�� �� ���� ����
		b.test1(); //�ٸ� ��Ű������ public�� �� ���� ����
//		b.b = 300; //�ٸ� ��Ű������ private�� �� ���� �Ұ���
//		b.c = 500; //�ٸ� ��Ű������ protected�� �� ���� �Ұ���
//		b.d = 600; //�ٸ� ��Ű������ default�� �� ���� �Ұ���
	}

}
