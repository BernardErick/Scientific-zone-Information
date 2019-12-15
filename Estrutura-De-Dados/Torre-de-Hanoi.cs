using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            MoveTorre(3, 'A', 'C', 'B');
        }
        static void MoveTorre(int n, char Orig, char Dest, char Aux)
        {
            if (n == 1)
            {
                MoveDisco(Orig, Dest);
            }
            else
            {
                MoveTorre(n - 1, Orig, Aux, Dest);
                MoveDisco(Orig, Dest);
                MoveTorre(n - 1, Aux, Dest, Orig);
            }
        }
        static void MoveDisco(char Orig, char Dest)
        {
            Console.WriteLine("Movimento: " + Orig + " -> " + Dest);
        }


    }


}
