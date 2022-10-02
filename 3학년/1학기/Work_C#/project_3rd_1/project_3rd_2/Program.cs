using System;

namespace project_3rd_2
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
            //입력
            string input = Console.ReadLine();
            Console.WriteLine("input : " + input);
            Console.WriteLine("\n");

            //강제 자료형 변환 : 강제적으로 자료형으로 변환하는 것
            var a = (int)10.0;
            var b = (float)10;
            var c = (double)10;

            //데이터 손실
            long longNumbe = 2147483647L + 2147483647L;
            int intNumber = (int)longNumbe;
            Console.WriteLine(intNumber);
            
            //다른 자료형을 숫자로 변환
            Console.WriteLine(int.Parse("52").GetType());
            Console.WriteLine(double.Parse("103.52").GetType());
            */

            Console.WriteLine("inch 단위 : ");
            double inch = double.Parse(Console.ReadLine());
            Console.WriteLine(inch + "inch는 " + (inch * 2.54) + "cm입니다.");
            Console.WriteLine();
        }
    }
}
