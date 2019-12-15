function passarInteiro(str) //função parseInt()
{
	var numero = 0;
	for(i = 0;i <str.length ; i++)
	{
		var digito = str.charAt(i);
		var carac = digito.charCodeAt();
		numero = numero * 10 + (carac - 48);
	}
	return numero;
}
var a = passarInteiro(prompt("Digite um numero A:")); 
var b = passarInteiro(prompt("Digite um numero B:"));
document.write(a+b);