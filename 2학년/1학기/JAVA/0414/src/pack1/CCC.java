package pack1;

public class CCC {

	public static void main(String[] args) {
		Base b = new Base();
		b.a = 10;  //���� ��Ű�� public�� �� ���� ����
		b.test1(); //���� ��Ű�� public�� �� ���� ����
//		b.b; 	   //���� ��Ű�� private�� �� ���� �Ұ���
		b.c = 30;  //���� ��Ű�� protected�� �� ���� ����
		b.d = 40;  //���� ��Ű�� default�� �� ���� ����
	}

}
