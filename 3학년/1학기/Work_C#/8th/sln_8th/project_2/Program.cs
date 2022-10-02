using System;

namespace project_2
{
    
    class Program
    {
        //2. 클래스 생성 : 클래스 내부에 클래스 생성
        class Cat
        {
            public string Name;
            public string Color;

            public Cat(string name, string color)
            {
                Name = name;
                Color = color;
            }

            public void Meow()
            {
                Console.WriteLine($"{Name} : 야옹!");
            }
        }
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
