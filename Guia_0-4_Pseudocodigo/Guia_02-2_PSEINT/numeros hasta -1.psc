Algoritmo sin_titulo
//	Dada una secuencia de números ingresados por teclado que finaliza con un ?1, por 
//ejemplo: 5,3,0,2,4,4,0,0,2,3,6,0,??,-1; realizar un programa que calcule el promedio de los 
//	números ingresados. Suponemos que el usuario no insertará número negativos
	
	definir num, i, suma Como Entero
	
	suma = 1
	i = 1
	Hacer 
		Escribir "ingrese numero"
		leer num
		suma = suma + num
		i = i + 1
	Hasta Que num = - 1
	Escribir "el promedio es: " , suma / i
FinAlgoritmo
