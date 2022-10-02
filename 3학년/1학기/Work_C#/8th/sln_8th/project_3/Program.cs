using System;

namespace project_3
{
    class Program
    {
        //3. 클래스 생성 : 서로 다른 파일에 클래스 생성
        static void Main(string[] args)
        {
            Cat kitty = new Cat("키티", "하얀색");
            kitty.Meow();
            Console.WriteLine($"{kitty.Name} : {kitty.Color}");

            Cat nero = new Cat("네로", "검은색");
            nero.Meow();
            Console.WriteLine($"{nero.Name} : {nero.Color}");

            Cat happy = new Cat("해피", "갈색");
            happy.Meow();
            Console.WriteLine($"{happy.Name} : {happy.Color}");
        }
    }
}
