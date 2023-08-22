//Escribir un programa que realice la búsqueda lineal de un número entero ingresado por el
//usuario en una matriz de 5x5, llena de números aleatorios y devuelva por pantalla las
//coordenadas donde se encuentra el valor, es decir en que fila y columna se encuentra. En
//caso de no encontrar el valor dentro de la matriz se debe mostrar un mensaje.

Algoritmo BusquedadMatriz
	Definir matriz ,num,n Como Entero
	n=5
	Dimension matriz(n,n)
	LlenarMatriz(matriz,n)
	MostrarMatriz(matriz,n)
	Escribir "----------------------------"
	PedirNum(num)
	Escribir "----------------------------"
	BuscarNum(matriz,n,num)
	Escribir ""
FinAlgoritmo

SubProceso LlenarMatriz(matriz Por Referencia,n)
	Definir i,j como entero
	Para i=0 hasta n-1 Hacer
		Para j=0 hasta n-1 Hacer
			matriz(i,j)=Aleatorio(1, 10)
		FinPara
	FinPara
FinSubProceso
SubProceso MostrarMatriz(matriz,n)
	Definir i,j como entero
	Para i=0 hasta n-1 Hacer
		Para j=0 hasta n-1 Hacer
			Escribir Sin Saltar "[ " matriz(i,j) " ]"
		FinPara
		Escribir ""
	FinPara	
FinSubProceso
SubProceso PedirNum(num Por Referencia)
	Escribir "Ingrese el numero a buscar"
	Leer num
FinSubProceso
SubProceso BuscarNum(matriz,n,num)
	Definir i,j, cont Como Entero
	cont=0
	Para i=0 hasta n-1 Hacer
		Para j=0 hasta n-1 Hacer
			Si matriz(i,j)=num Entonces
				Escribir "El numero se encuentra en la pos " i+1 "," j+1
				cont=cont+1
			FinSi
		FinPara
	FinPara	
	Si cont=0 Entonces
		Escribir "EL numero no se encontro"
	FinSi
FinSubProceso
	