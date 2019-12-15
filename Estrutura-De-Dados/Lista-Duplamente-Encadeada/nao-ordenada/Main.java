
public class Main 
{
	public static void main(String[] args) 
	{
		List<Integer> list = new List<Integer>();
		list.Add(1);
		list.Add(3);
		list.Add(4);
		list.Add(5);
		list.Add(6);
		//list.remove(2);
		//list.removeNoFim();
		list.inserirNaPos(1, 2);
		list.inserirNaPos(5, 7);
		list.removeNoInicio();
		list.removeNoFim();
		//list.zerarLista();
		System.out.println(list.Find(8));
		list.FindPos(4);
		System.out.println("Pegando pela ultima posição:");
		list.GetPeloUltimo();
		System.out.println("------------------------------");
		System.out.println("Pegando pela primeira posição:");
		list.GetPeloPrimeiro();
		
	}
}
