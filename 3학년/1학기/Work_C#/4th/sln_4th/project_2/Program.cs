using System;

namespace project_2
{
    class Program
    {
        static void Main(string[] args)
        {
            //if 조건문
            /*
            Console.WriteLine("숫자 입력 : ");
            int input = int.Parse(Console.ReadLine());

            if(input % 2 == 0)
            {
                Console.WriteLine("짝수 입니다.");
            }
            if(input % 2 == 1)
            {
                Console.WriteLine("홀수 입니다.");
            }
            */
            //if else 조건문
            Console.WriteLine("숫자 입력 : ");
            int input = int.Parse(Console.ReadLine());

            if (input % 2 == 0)
            {
                Console.WriteLine("짝수 입니다.");
                Console.WriteLine("{0} : 짝수",input);
            }
            else
            {
                Console.WriteLine("홀수 입니다.");
            }
        }
    }
}
