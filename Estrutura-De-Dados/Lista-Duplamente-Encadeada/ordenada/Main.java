
public class Main 
{
	public static void main(String[] args) 
	{
		List list = new List();
		list.addOrdenado(5);
		list.addOrdenado(9);
		list.addOrdenado(1);
		list.addOrdenado(50);
		list.addOrdenado(30);
		list.addOrdenado(70);
		list.inserirNaPos(1,500);
		System.out.println("Pegando pela ultima posição:");
		list.GetPeloUltimo();
		System.out.println("------------------------------");
		System.out.println("Pegando pela primeira posição:");
		list.GetPeloPrimeiro();
		
	}
}
