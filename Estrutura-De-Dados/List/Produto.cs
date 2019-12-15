using System;
using System.Collections.Generic;
using System.Text;

namespace CursoProg
{
    class Produto
    {
        public int Codigo;
        public double Preco;
        public int Quantidade;
        public Produto(int codigo, double preco, int quantidade)
        {
            Codigo = codigo;
            Preco = preco;
            Quantidade = quantidade;
        }
    }
}
