//Conocido el n�mero en matem�tica PI ?, 
//pedir al usuario que ingrese el valor del radio de
//una circunferencia y calcular y mostrar por pantalla 
//el �rea y per�metro. Recuerde que para
//calcular el �rea y el per�metro se utilizan las siguientes f�rmulas:
//	area = PI * radio2
//	perimetro = 2 * PI * radio
Algoritmo sin_titulo
	definir num, area, perimetro, elevar Como Real
	Escribir "Por favor ingrese el radio de la circunferencia"
	Leer num
	Escribir "Ingrese el numero al que desea elevar cuando calculemos el area"
	Leer elevar
	area = PI * num ^ elevar
	perimetro = 2 * PI * num
	Escribir "El area del radio es ", area
	Escribir "Y el perimetro es ", perimetro
FinAlgoritmo
