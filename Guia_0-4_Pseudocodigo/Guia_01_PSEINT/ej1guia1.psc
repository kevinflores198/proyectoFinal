//Conocido el n�mero en matem�tica PI ?, pedir al usuario que ingrese el valor del radio de
//una circunferencia y calcular y mostrar por pantalla el �rea y per�metro. Recuerde que
//para calcular el �rea y el per�metro se utilizan las siguientes f�rmulas:
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
