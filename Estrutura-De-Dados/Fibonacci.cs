using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            int n = int.Parse(Console.ReadLine());
            Console.WriteLine(Fib(n));
        }
        static int Fib(int n)
        {
            if (n == 0 || n == 1)
                return n;
            else
                return Fib(n - 2) + Fib(n - 1); //recursividade            
        }

    }


}
