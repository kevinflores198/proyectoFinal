Algoritmo sin_titulo
//Una empresa de venta de productos por correo desea
//realizar una estad�stica de las ventas
//realizadas de cada uno de sus productos a lo
//largo de una semana. Distribuya luego 5
//productos en los 5 d�as h�biles de la semana. Se 
//desea conocer:
///a) Total de ventas por cada d�a de la semana.
///b) Total de ventas de cada producto a lo largo 
///de la semana.
///c) El producto m�s vendido en cada semana.
///d) El nombre, el d�a de la semana y la cantidad
///del producto m�s vendido.
//El informe final tendr� un formato como el que se m
	//uestra a continuaci�n:
	
	//j columna //i fla
	Definir i,j,matriz,producto, may Como Entero
	Dimension matriz(7,6)
	para i = 0 hasta 4
		para j = 0 hasta 4 Hacer
			matriz(i,j) = Aleatorio(1,9)
		FinPara
	FinPara
	para i = 0 hasta 4
		matriz(i,5) = sumaF(matriz,i,j)
		Escribir matriz(i,j) " "sin saltar
	FinPara

	may = 0
	matriz(6,j) = 0
	
	Para j = 0 hasta 4 Hacer
		matriz(5,j) = sumaC(matriz,i,j)
		Escribir sumaC(matriz,i,j) "  " 
	FinPara
	
	para i = 0 hasta 4 Hacer
		Si matriz(6,j) > may
			may = matriz(i,j)
			matriz(6,j) = may
		FinSi	
	FinPara

	para j = 0 hasta 4
		para j = 0 hasta 4 Hacer
			Escribir matriz(i,j) Sin Saltar " "
		FinPara
		Escribir ""
	FinPara
	
	FinAlgoritmo

	Funcion sum = sumaF(matriz,i,j)
	Definir sum como entero
	sum = 0
	para j = 0 hasta 4 Hacer
		sum = sum + matriz(i,j)
	FinPara
	
	
FinFuncion

Funcion sum = sumaC(matriz,i,j)
	Definir sum como entero
	sum = 0
	para i = 0 hasta 4 Hacer
		sum = sum + matriz(i,j)
	FinPara
FinFuncion


	