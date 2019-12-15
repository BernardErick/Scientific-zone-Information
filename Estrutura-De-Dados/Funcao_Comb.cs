using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            Console.WriteLine("Com recursividade: "+Comb_Recur(5,3));
            Console.WriteLine("Sem recursividade: "+Comb_Int(5,3));
            /*A função Comb(n, k), que representa o número de grupos distintos com k pessoas que
            podem ser formados a partir de n pessoas. */
        }

        static int Comb_Recur(int n, int k)
        {
            if (k == 1)
                return n;
            else if (k == n)
                return 1;
            else
                return Comb_Recur(n - 1, k - 1) + Comb_Recur(n - 1, k);
        }
        static int Comb_Int(int n, int k)
        {
            return Fatorial(n) / (Fatorial(k) * Fatorial(n - k));
        }
        static int Fatorial(int n)
        {
            int fatorial = 1;
            for (int i = 1; i <= n; i++)
            {
                fatorial *= i;
            }
            return fatorial;
        }
    }


}
