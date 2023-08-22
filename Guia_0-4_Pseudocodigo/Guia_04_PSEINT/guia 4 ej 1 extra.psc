Algoritmo sin_titulo
//	Realizar un programa que rellene dos vectores 
//	al mismo tiempo, con 5 valores aleatorios y los
//	muestre por pantalla.
	
	definir vector, vector1, i Como Entero
	dimension vector(5), vector1(5)
	Para i=0 Hasta 4 Hacer
		vector(i)=Aleatorio(0,20)
		vector1(i)=Aleatorio(21,40)
	FinPara
	para i=0 hasta 4
		Escribir vector(i) Sin Saltar " "
		Escribir ""
	FinPara
	para i=0 hasta 4
		Escribir vector1(i) " "
	FinPara
FinAlgoritmo
