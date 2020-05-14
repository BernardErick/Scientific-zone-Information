public class Disco {

    public String id;
    public double raio;

    public Disco(String id, double raio)
    {
        this.id = id;
        this.raio = raio;
    }

    @Override
    public String toString()
    {
        String shape = "";
        for(int i = 0; i < raio;i++)
        {
            shape+="⊡";
        }
        return shape;
    }
}