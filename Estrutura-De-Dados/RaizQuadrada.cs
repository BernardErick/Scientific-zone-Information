using System;
using System.Globalization;
namespace CursoProg
{
    class Program
    {
        static void Main(string[] args) //Main
        {
            Console.WriteLine(RaizQ(13, 3.2, 0.001));

        }
        static double RaizQ(int x,double x0, double E)
        {
            if ((Math.Pow(x0, 2) - x) <= E)
            {
                return x0;
            }
            else
            {
                return RaizQ(x, (Math.Pow(x0, 2) + x) / (2 * x0),E);
            }

        }


    }


}
