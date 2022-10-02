using System;
using static System.Console;
namespace project_2nd
{
    class Program
    {
        static void Main(string[] args)
        {
            /*Console.WriteLine("Hello World!");
            Console.WriteLine();
            Console.Write("소프트웨어공학과");
            Console.Write("C#프로그래밍");
            Console.WriteLine();

            // 정수와 연산자
            Console.WriteLine(1 / 2); //0
            Console.WriteLine(1 % 2); //1
            Console.WriteLine(10 % 5); //0
            Console.WriteLine(10 % 3); //1

            //실수
            Console.WriteLine(57.273);
            Console.WriteLine(0.0);
            Console.WriteLine(0);
            Console.WriteLine(1.0+2.0); //3
            Console.WriteLine(1.0/2.0); //0.5
            Console.WriteLine(1/2); //0 

            //문자 : 글자 하나를 나타내는 자료형
            Console.WriteLine('A');
            Console.WriteLine('가');

            //문자열 : 문자의 집합
            Console.WriteLine("안녕하세요~"); 

            //문자열 연결 연산자(+)
            Console.WriteLine("가나다" + "라마" + "바사아"); 

            //문자열 선택[N]
            Console.WriteLine("안녕하세요."[0]);
            Console.WriteLine("안녕하세요."[2]);
            Console.WriteLine("안녕하세요."[5]);
            //Console.WriteLine("안녕하세요."[6]); -> INDEX번호는 0부터 시작이라 7번이 없기때문에 오류
            Console.WriteLine('안' + '녕'); 

            Console.Write("안녕하세요."[0]);
            Console.WriteLine("\n");
            Console.Write("안녕하세요."[2]);
            Console.WriteLine("\n");
            Console.Write("안녕하세요."[5]);

            Console.Write("안녕하세요."[0]);
            Console.WriteLine();
            Console.Write("안녕하세요."[2]);
            Console.WriteLine();
            Console.Write("안녕하세요."[5]);

            //이스캐이프 문자
            Console.WriteLine("컴퓨터\t소프트웨어\t공학과");

            //불 : 참과 거짓을 표현할 때 사용하는 비교연산자
            Console.WriteLine(52 == 273); //False
            Console.WriteLine(52 > 273); //False
            Console.WriteLine(52 < 273); //True*/

            /*비교연산자
             == 같다
             != 다르다
             >, <, >=, <=, *, /
             */

            /*
            //논리 연산자
            Console.WriteLine(!true); //False
            Console.WriteLine(!(35 > 75)); //True
            Console.WriteLine(DateTime.Now.Hour < 3 || 8 < DateTime.Now.Hour); //True
            Console.WriteLine(3 < DateTime.Now.Hour && DateTime.Now.Hour < 8); //False 

            //변수 : 값을 저장할 때 사용하는 식별자
            //정슈형 자료형(int(4), long(8))
            int a = 273;
            int b = 52;
            Console.WriteLine(a % b); //나머지 13

            int a1 = 2147483640;
            int b1 = 52273;
            Console.WriteLine(a1 + b1); //오버플로우

            //MaxValue와 MinValue
            Console.WriteLine(int.MaxValue);
            Console.WriteLine(int.MinValue);
            Console.WriteLine();
            Console.WriteLine(long.MaxValue);
            Console.WriteLine(long.MinValue);
            Console.WriteLine();
            Console.WriteLine(uint.MinValue);
            Console.WriteLine(uint.MaxValue);
            Console.WriteLine(ulong.MinValue);
            Console.WriteLine(ulong.MaxValue);

            //실수 자료형(float(4), double(8))
            double a2 = 52.273;
            double b2 = 103.32;
            Console.WriteLine(a2 + b2);*/

            //문자 자료형

            //sizeof(자료형) : sizeof 연산자를 활용해 각 자료형의 크기를 살펴보자
            //string는 클래스로 지정되어있기 때문에 사이즈를 알아볼 수 없다
            Console.WriteLine("int" + sizeof(int));
            Console.WriteLine("long" + sizeof(long));
            Console.WriteLine("float" + sizeof(float));
            Console.WriteLine("double" + sizeof(double));
            Console.WriteLine("char" + sizeof(char));
        }
    }
}
