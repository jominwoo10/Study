using System;

namespace project_3
{
    class Program
    {
        static void Main(string[] args)
        {
            //문자열 서식 맞추기
            //Console.WriteLine은 기본적으로 문자열을 출력하는 메소드이므로
            //숫자를 출력할 때는 문자열로 변환하는 과정이 필요하다.
            //C#은 문자열 서식화에 사용할 수 있는 간단한 방법 두 가지를 제공한다.
            //1) string 형식의 Format() 메소드
            //2) 문자열 보간
            /*
            Console.WriteLine("{0}, {1}",123,"최강컴소공");
            Console.WriteLine($"{123}, {"최강컴소공"}");
            Console.WriteLine("Total : {0, 10:D}", 255);//첨자 : 0, 맞춤: 7 서식문자열(10진수)
            Console.WriteLine("Total : {0, -10:D}",255);//string 형식의 Format() 메소드
            Console.WriteLine($"Total : {255,-10:D}");//문자열 보간
            */
            Console.WriteLine("{0:N0}",123456789);
            Console.WriteLine("{0:F}", 123.45);

            //서식항목
            //{첨자, 맞춤 : 서식문자열}

            string fmf = "{0,-20}{1,-15},{2,30}";
            Console.WriteLine(fmf, "Publisher", "Author", "Title");
            Console.WriteLine(fmf, "Marvel", "Stan Lee", "Iron Man");
            Console.WriteLine(fmf, "Yuhan", "Hong Gildong", "C# Programing");
            Console.WriteLine(fmf, "Cumpter", "Yoo Sanseul", "C Programing Language");

        }
    }
}
