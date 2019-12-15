
public class Main 
{
	public static void main(String[] args) 
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.Push(5);
		stack.Push(3);
		stack.Push(2);
		stack.Pop();
		stack.Pop();
		stack.Push(1);
		stack.Push(22);

		System.out.println("Pegando pela ultima posição:");
		stack.GetPeloUltimo();

		
	}
}
