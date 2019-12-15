var n = prompt("Quantidade de notas?");
var cont = 0;
for(i = 1; i <= n;i++)
{
	var nota = prompt("informe a "+i+"º nota:");
	if(nota >= 50)
	{
		cont++;
	}
}
document.write("A quantidade de alunos aprovados foi:"+cont);