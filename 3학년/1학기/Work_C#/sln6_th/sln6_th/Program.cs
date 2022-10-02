using System;

namespace sln6_th
{
    class Program
    {
        static void Main(string[] args)
        {
            //1부터 입력한 수 까지 정수의 합을 구해보자.
            Console.WriteLine("정수 입력 : ");
            int k = int.Parse(Console.ReadLine());

            int sum = 0;
            for(int i = 0; i <= k; i++)
            {
                sum += i;
                Console.WriteLine($"1부터 {i}까지의 합은 {sum}이다.");
            }
            
        }
    }
}
