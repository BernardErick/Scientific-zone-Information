using System;
using System.Globalization;
using System.Collections.Generic;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            Console.Write("Conjunto de símbolos a ser permutado: ");
            string conjunto = Console.ReadLine();
            Console.Write("Permutações possíveis: ");
            permuta("",conjunto);
        }
        static void permuta(string p, string s)
        {

            if (s.Length == 0)
            {
                Console.Write(p + " ");
            }
            else
            {
                void forenci(int i, int n)
                {

                    if (i < n)
                    {
                        permuta(p + s[i], s.Substring(0, i) + s.Substring(i + 1));
                        forenci(i + 1, n);
                    }

                }
                forenci(0, s.Length);                   
            }
        }

    }
}


