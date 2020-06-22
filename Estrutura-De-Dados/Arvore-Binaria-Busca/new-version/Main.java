public class Main
{
    public static void main(String[] args)
    {
        BinaryTree arvore = new BinaryTree();
        arvore.add(16);
        arvore.add(26);
        arvore.add(36);
        arvore.add(46);
        arvore.add(56);
        arvore.add(66);
        arvore.printPreOrdem();
        System.out.println("----------------");
        arvore.printEmOrdem();
        System.out.println("----------------");
        arvore.printPosOrdem();
        System.out.println("----------------");
        System.out.println(arvore.search(9));
        System.out.println(arvore.search(10));
    }
}