using System;
using System.Collections.Generic;
using System.Text;

namespace project_3
{
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
}
