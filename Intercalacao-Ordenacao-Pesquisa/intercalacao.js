
var a = [15, 18, 42, 51];
var b = [8, 11, 16, 17, 44, 58, 71, 74];
var c = [];
var x = 0;
var y = 0;
var tam = a.length + b.length;
for(var k = 0;k < tam;k++)
{
	if(a[x] < b[y] || y == b.length)
	{
		c[k] = a[x];
		x++;
	}
	else
	{
		c[k] = b[y];
		y++;
	}
}
document.write(c);



