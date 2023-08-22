//Ingrese un número de tres cifras y muestra la unidad, decena y la centena.
//Por ejemplo si el número ingresado por pantalla es 123 el programa debe mostrar
//CENTENA: 1
//DECENA: 2
//UNIDAD: 3
Algoritmo ejcooperativo
	Definir num, un, dec, cen Como Real
	Escribir "Ingrese un numero de 3 cifras"
	Leer num
	
	Cen = trunc(num/100)
	dec = trunc ((num - cen * 100) / 10)
	un = num - cen*100 - dec*10
	
	Escribir "La centena es " cen " La decena es " dec " y la unidad es " un
FinAlgoritmo
