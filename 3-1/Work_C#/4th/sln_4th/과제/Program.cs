using System;

namespace 과제
{
    class Program
    {
        static void Main(string[] args)
        {
            /*//1번 문제
            Console.WriteLine("1inch = 2.54cm");
            Console.Write("inch : ");
            int i = int.Parse(Console.ReadLine());
            double d = i * 2.54;
            Console.WriteLine(i + "inch = " + d + "cm");

            //2번 문제
            Console.WriteLine("1kg = 2.20462262pound");
            Console.Write("kg : ");
            int kg = int.Parse(Console.ReadLine());
            double pound = kg * 2.20462262;
            Console.WriteLine(kg + "kg = " + pound + "pound");*/

            //3번 문제
            Console.WriteLine("둘레 = 2 * PI * 반지름, 넓이 = PI * 반지름 * 반지름");
            Console.Write("원의 반지름 입력 : ");
            double r = double.Parse(Console.ReadLine());
            Console.WriteLine("둘레 = " + 2 * Math.PI * r + ", 넓이 = " + Math.PI * r * r);
        }
    }
}
