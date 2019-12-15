
namespace CursoProg
{
    class No
    {
        public Produto Dado { get; private set; }
        public No Proximo { get; set; }

        public No(Produto valor)
        {
            Dado = valor;
        }

    }
}
