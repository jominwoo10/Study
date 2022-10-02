using System;

namespace project_1
{
    class Program
    {
        static void Main(string[] args)
        {
            //if 조건문
            Console.WriteLine("숫자 입력 : ");
            int input = int.Parse(Console.ReadLine());

            if (input % 2 == 0)
            {
                Console.WriteLine("짝수입니다.");
            }

            if (input % 2 == 1)
            {
                Console.WriteLine("홀수입니다.");
            }

            //if else 조건문
            if (input % 2 == 0)
            {
                Console.WriteLine("짝수입니다.");
            }

            else
            {
                Console.WriteLine("홀수입니다.");
            }

            //switch 조건문
            switch (input % 2)
            {
                case 0:
                    Console.WriteLine("짝수입니다.");
                    break;

                case 1:
                    Console.WriteLine("홀수입니다.");
                    break;

                default:
                    break;
            }

            //현재 시간 구하기
            Console.WriteLine(DateTime.Now.Minute);

            //오전과 오후 구분하기
            if (DateTime.Now.Hour < 12)
            {
                Console.WriteLine("오전입니다.");
            }
            else
            {
                Console.WriteLine("오후입니다.");
            }

            //중첩 조건문
            if (DateTime.Now.Hour < 11)
            {
                Console.WriteLine("아침 먹을 시간입니다.");
            }
            else
            {
                if (DateTime.Now.Hour < 15)
                {
                    Console.WriteLine("점심 먹을 시간입니다.");
                }

                else
                {
                    Console.WriteLine("저녁 먹을 시간입니다.");
                }
             }

            //if - else if - else
            //if - else if 조건문
            //if - else는 조건을 반복적으로 점검하여 상황에 딱 맞는 명령을 선택한다.
            if (DateTime.Now.Hour < 11)
            {
                Console.WriteLine("아침 먹을 시간입니다.");
            }
            else if (DateTime.Now.Hour < 15)
            {
                    Console.WriteLine("점심 먹을 시간입니다.");
            }
            else
            {
                    Console.WriteLine("저녁 먹을 시간입니다.");
            }

        }
    }
}
