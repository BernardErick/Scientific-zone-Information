using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            Console.WriteLine(F(3,3));
        }
        static int F(int x , int n)
        {
            if (n == 0)
            {
                return 1;
            }
            return x * F(x, n - 1);

        }


    }


}
