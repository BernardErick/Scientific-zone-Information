using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            Console.WriteLine(A(3,4));
        }
        static int A(int m, int n)
        {
            if (m > 0)
            {
                if (n > 0)
                {
                    return A(m - 1, A(m, n - 1));
                }
                else if (n == 0)
                {
                    return A(m - 1, 1);
                }
            }
            return n + 1;
        }


    }


}
