using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            Console.WriteLine("F(3): "+F(3));
            Console.WriteLine("F(7): "+F(7));
        }
        static int F(int n)
        {
            if (n < 4)
            {
                return 3 * n;
            }
            else
            {
                return 2 * F(n - 4) + 5;
            }
        }


    }


}
