//Solicitar al usuario que ingrese la base y altura de un rectángulo, y calcular y mostrar por
//pantalla el área y perímetro del mismo
//area = base * altura
//perimetro = 2 * altura + 2 * base.
Algoritmo ej2guia1
	Definir ar, per, bas, alt Como Real
	Escribir "Ingrese la base y la altura de un rectangulo"
	Leer bas, alt
	
	per = 2 * alt + 2 * bas
	ar = bas * alt
	
	Escribir "El perimetro del rectangulo es " per " y el area es " ar
	
FinAlgoritmo
