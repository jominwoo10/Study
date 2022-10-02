using System;

namespace project_3rd_1
{
    class Program
    {
        static void Main(string[] args)
        {
            //복합 대입 연산자
            //자료형이 적용하는 기본 연산자와 =연산자를 함께 사용
            /*int output = 0;
            output += 52; //output = output + 52;
            output += 273;
            output += 103;
            Console.WriteLine(output); //428

            //+(문자열 연결 연산자)
            string input = "Hello ";
            input += "world ";
            input += "!";
            Console.WriteLine(input); //Hello world !

            //증감 연산자
            int number1 = 10;
            number1++;
            Console.WriteLine(number1); //11
            number1--;
            Console.WriteLine(number1); //10
         

            //증감 연산자와 후위 형태
            int number2 = 20;
            Console.WriteLine(number2); //20
            Console.WriteLine(number2++); //20 -> 21
            Console.WriteLine(number2--); //21 -> 20
            Console.WriteLine(number2); // 20
          

            //증감 연산자의 전위 형태
            int number3 = 30;
            Console.WriteLine(number3); //30
            Console.WriteLine(++number3); //31
            Console.WriteLine(--number3); //30
            Console.WriteLine(number3); //30
            

            //증감 연산자의 이해도 확인
            int number4 = 40;
            Console.WriteLine(number4++); //40
            Console.WriteLine(++number4); //42
            Console.WriteLine(number4--); //42
            Console.WriteLine(--number4); //40

            //여러 줄로 나누어 적은 증감 연산자
            int number5 = 50;
            Console.WriteLine(number5); //50
            number5++; //51
            number5++; //52
            Console.WriteLine(number5); //52
            number5--; //51
            number5--; //50
            Console.WriteLine(number5); //50
            

            //자료형 검사 : 변수 선언
            int _int = 273;
            long _long = 522731033265;
            float _float = 52.273F;
            double _double = 52.273;
            char _char = '글';
            string _string = "문자열";

            //GetType() 메소드를 활용해서 자료형 출력
            Console.WriteLine(_int.GetType());
            Console.WriteLine(_long.GetType());
            Console.WriteLine(_float.GetType());
            Console.WriteLine(_double.GetType());
            Console.WriteLine(_char.GetType());
            Console.WriteLine(_string.GetType());
            */

            Console.WriteLine((273).GetType());
            Console.WriteLine((522731033265.GetType()));

            //var 키워드 : 자료형을 자동으로 지정
            /* var 키워드를 사용하기 위한 조건 두 가지
            1. 지역 변수로 선언하는 경우(메소드 내부에 선언되어 있는 변수)
                ※ 메소드 외부에 var키워드를 사용하면 오류 발생
            2. 변수 선언과 동시에 초기화 하는 경우
             */

            var numberA = 100;
            var numberB = 100L; //long 자료형
            var numberC = 100.13;
            var numberD = 100.13F; //float 자료형
            Console.WriteLine(numberA);
            Console.WriteLine(numberB);
            Console.WriteLine(numberC);
            Console.WriteLine(numberD);
        }
    }
}
