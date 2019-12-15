var numero = parseInt(prompt("Informe um número inteiro:"));
var invertido = 0;
for(q = numero ; q > 0; q = Math.floor(q/10))
{
		var digito = q %10;
		invertido = invertido * 10 + digito;
}
document.write("número original: "+numero+"<br>");
document.write("número invertido: "+invertido);