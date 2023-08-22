Algoritmo sin_titulo
	Definir n Como Entero
	leer n
	Escribir "suma de multiplos de n es ", sumaDiv(n)
FinAlgoritmo

Funcion sd= sumaDiv(n)
	Definir sd,acumDiv,i Como Entero
	acumDiv=0
	para i=1 Hasta n-1
		si n mod i = 0
			acumDiv=acumDiv+i
		FinSi
	FinPara
	sd=acumDiv
	
FinFuncion
