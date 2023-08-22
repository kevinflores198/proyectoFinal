Algoritmo sin_titulo
//Realizar un programa que lea 10 números reales
//por teclado, los almacene en un arreglo y
//muestre por pantalla la suma, resta y multiplicación
//de todos los números ingresados al
//arreglo.
	
	definir vector, sum, res, mult, i Como Real
	Dimension vector(10)
	
	Para i <- 0 Hasta 9 Con Paso 1 Hacer
		Escribir "Ingrese 1 valor ", i
		Leer vector(i)
	FinPara
	sum=vector(0)
	res=vector(0)
	mult=vector(0)
	
	Para i <- 1 Hasta 9 Con Paso 1 Hacer
		sum=sum+vector(i)
		res=res-vector(i)
		mult=mult*vector(i)
	FinPara
	Escribir "La suma de los valores ingresados es: " sum
	Escribir "La res de los valores ingresados es: " res
	Escribir "La mult de los valores ingresados es: " mult
FinAlgoritmo
