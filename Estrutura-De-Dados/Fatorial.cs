using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            int n = int.Parse(Console.ReadLine());
            Console.WriteLine(Fatorial(n)+"!");
        }
        static int Fatorial(int n)
        {
            if (n == 0)
                return 1;
            else
                return n * Fatorial(n - 1); //Recursividade
        }

    }


}
