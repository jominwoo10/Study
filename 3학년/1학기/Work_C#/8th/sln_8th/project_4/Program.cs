using System;


//static 키워드
//for문을 while을 while을 for로
//증감연산자
//

namespace project_4
{
    class Test
    {
        public static string prof = "조민우"; //static이 들어가면 클래스 변수 
        
        public int Power(int x, int y)
        {
            return x * y;
        }

        public int Abs(int x)
        {
            if (x > 0)
                return x;
            else
                return -x;
        }

        public int Power(int x)
        {
            Console.WriteLine(x + "의 절대값 : " + Abs(x));
            return x * x;
        }

        public static void PrintInfo() //static이 들어가면 클래스 메소드
        {
            Console.WriteLine("대학 : 유한대학교");
            Console.WriteLine("학과 : 컴퓨터소프트웨어공학과");
            Console.WriteLine("반 : B반");
            Console.WriteLine("성명 : 조민우");
            Console.WriteLine("주소 : 인천시 남구 주안동");
            Console.WriteLine(prof);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Test test1 = new Test();
            Test test2 = new Test();

            //test1.PrintInfo();
            Test.PrintInfo();

            Console.WriteLine(test1.Power(10, 30));
            Console.WriteLine(test1.Power(-10));
        }
    }
}
