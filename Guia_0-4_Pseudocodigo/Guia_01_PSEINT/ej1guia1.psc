//Conocido el número en matemática PI ?, pedir al usuario que ingrese el valor del radio de
//una circunferencia y calcular y mostrar por pantalla el área y perímetro. Recuerde que
//para calcular el área y el perímetro se utilizan las siguientes fórmulas:
//		area = PI * radio^2
//		perimetro = 2 * PI *radio
Algoritmo ej1guia1
	Definir ar, per, rad, num Como Real
	Escribir "Ingrese el valor del radio de una circunferencia"
	Leer rad
	ar = PI * rad^2
	per = 2 * PI * rad
	Escribir "el radio de la circunferencia es " rad " y el perimetro " per
FinAlgoritmo
