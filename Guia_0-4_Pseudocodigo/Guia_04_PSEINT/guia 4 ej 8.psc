//Realizar un programa que rellene una
//matriz de 3x3 con 9 valores ingresados 
//por el usuario y
//los muestre por pantalla
Algoritmo sin_titulo
	Definir matriz, i, j Como Entero
	Dimension matriz(3,3)
	Escribir "Ingrese los valores para la matriz"
	para i=0 hasta 2 Hacer
		para j=0 hasta 2 Hacer
			Escribir "(", i "," ,j ")" 
			Leer matriz(i,j)
		FinPara
	FinPara
	para i=0 hasta 2 Hacer
		Escribir ""
		para j=0 hasta 2 Hacer
			Escribir sin saltar matriz(i,j) " "
		FinPara
	FinPara
FinAlgoritmo
