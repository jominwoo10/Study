
public class DynamicArray {

	public static void main(String[] args) {
		//int[][] dArr = {{1, 2},{3, 4, 5},{6},{7, 8}};
		
		int num = 0;
		int[][] dArr = new int[4][];
		int[] count = {2, 3, 1, 2};
		
		for (int i = 0; i < dArr.length; i++) 
		{
			dArr[i] = new int[count[i]]; //�����迭�� ���鶧 �ʼ� ���� ��ü����
			for (int j = 0; j < dArr[i].length; j++) 
			{
				dArr[i][j] = ++num;
			}
		}
	}

}
