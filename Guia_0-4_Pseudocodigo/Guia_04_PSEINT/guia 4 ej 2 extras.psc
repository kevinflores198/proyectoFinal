Algoritmo sin_titulo
//	Realizar un programa que rellene un 
//	vector de tama�o N, con valores 
//	ingresados por el
//	el promedio de la suma de todos 
//	los valores ingresados. 
	
	definir vector, n, i, suma Como Entero
	suma=0
	Escribir "Ingrese el tama�o del vector"
	Leer n
	Dimension vector(n)
	para i=0 hasta n-1 Hacer
		Escribir "Ingrese el valor"
		Leer vector(i)
		suma=suma+vector(i)
	FinPara
	Escribir "El promediod e la suma de valores es ",suma/n
	
FinAlgoritmo
