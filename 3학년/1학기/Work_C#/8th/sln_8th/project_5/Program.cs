using System;
using System.Collections.Generic;

namespace project_5
{
    class Program
    {
        static void Main(string[] args)
        {
            //인스턴스 변수 생성과 동시에 초기화

            Pet pet1 = new Pet() { name = "두부", age = 1, category = "강아지" };
            Pet pet2 = new Pet() { name = "나비", age = 3, category = "고양이" };

            Person h1 = new Person()
            {
                name = "조민우",
                addr = "경기도 김포시",
                pets = new List<Pet>() { pet1, pet2 }
            };

            Console.WriteLine("입양인의 이름 : " + h1.name);
            Console.WriteLine("입양인의 주소 : " + h1.addr);
            Console.WriteLine("-------------------------");

            foreach(Pet p in h1.pets)
            {
                Console.WriteLine("반려동물명 : " + p.name);
                Console.WriteLine("반려동물 나이 : " + p.age);
                Console.WriteLine("반려동물 종류 : " + p.category);
                Console.WriteLine("-------------------------");
            }
        }
    }
}
