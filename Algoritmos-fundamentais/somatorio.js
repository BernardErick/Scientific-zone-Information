var n = prompt("Quantidade de números?");
var soma = 0;
for(i = 1; i <= n; i++)
{
		var numero = parseInt(prompt("informe o "+i+"º numero:"));
		soma+=numero;
}
document.write("A soma dos "+n+" valores é:"+soma);