
public class Main 
{
	public static void main(String[] args) 
	{
		Queue<Integer> queue = new Queue<Integer>();
		queue.Enqueue(5);
		queue.Enqueue(7);
		queue.Enqueue(9);
		queue.Dequeue();

		System.out.println("Pegando pela ultima posição:");
		queue.GetPeloPrimeiro();
		
		
	}
}
