using System;

namespace project_2
{
    class Program
    {
        static void Main(string[] args)
        {
            //삼항 연산자
            //불_표현식 ? 참 : 거짓
            //string input = Console.ReadLine();
            //int number = int.Parse(input);
            int number = int.Parse(Console.ReadLine());
            //참과 거짓 위치에 불 자료형 사용
            Console.WriteLine(number % 2 == 0 ? true : false);

            //참과 거짓 위치에 문자열 자료형 사용
            Console.WriteLine(number % 2 == 0 ? "짝수" : "홀수");

            //삼항연산자를 이용한 자연수 판별
            Console.WriteLine(number > 0 ? "자연수입니다" : "자연수가 아닙니다");

            //switch 조건문
            Console.WriteLine("숫자 입력 : ");
            int input = int.Parse(Console.ReadLine());

            switch
        }
    }
}
