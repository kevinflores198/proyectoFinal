//Crear una matriz de orden n * m (donde n y m son valores ingresados por el usuario), llenarla
//con números aleatorios entre 1 y 100 y mostrar su traspuesta.

Algoritmo MatrizNxM
	Definir n,m Como Entero
	Escribir "Ingrese las filas y las columnas"
	Leer n, m
	Definir matriz,matrizT ,i ,j Como Entero
	Dimension matriz(n,m)
	Dimension matrizT(m,n)
	
	Para i=0 hasta n-1 Hacer
		para j=0 hasta m-1 hacer
			matriz(i,j)=Aleatorio(1,10)
		FinPara
	FinPara
	Escribir "-----------------------"
	
	para i=0 hasta n-1 Hacer
		para j=0 hasta m-1 Hacer
			Escribir Sin Saltar "[ " matriz(i,j) " ] "
		FinPara
		Escribir " "
	FinPara
	Escribir "-----------------------------"
	//hacer la traspuesta
	Para  i=0 hasta m-1 Hacer
		para j =0 hasta n-1 Hacer
			matrizT(i,j)=matriz(j,i) 
		FinPara
		
	FinPara
	para i=0 hasta m-1 Hacer
		para j=0 hasta n-1 Hacer
			Escribir Sin Saltar "[ " matrizT(i,j) " ] "
		FinPara
		Escribir ""
	FinPara
FinAlgoritmo
