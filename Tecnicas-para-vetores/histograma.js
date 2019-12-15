var cont = [];
var n = parseInt(prompt("Quantidade de notas?"));

for(var i = 0; i <= 100;i++)
{
	cont[i] = 0; //vai zerar todos os indices de 0 a 100.
}

for(var i = 1; i <= n; i++)
{
	var nota = parseInt(prompt("Qual a nota do "+i+"º aluno?"));
	cont[nota]++; //vai aumentar 1 ponto para cada indice q for informado seu respectivo valor, Ex: nota = 20 , então cont[20] recebe 1 ponto.
}
document.write("Conclusão dos dados:"+"<br>");
for(var i = 0;i < cont.length ; i++)
{
	if (cont[i] == 0) 
	{
	  continue;  //não vai exibir os indices q estiverem zerados.
	}
	document.write("Nota: " + i + ", Houveram: " + cont[i] + "<br>");
}