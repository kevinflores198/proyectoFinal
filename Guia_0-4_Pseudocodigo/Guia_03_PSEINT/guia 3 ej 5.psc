
	Algoritmo sin_titulo
		Definir n1 Como Entero
		Escribir "ingrese un numero"
		leer n1
		Escribir primo(n1)
FinAlgoritmo

Funcion numprimo<-primo(n1)
	definir cont, i Como Entero
	cont=0
	para i=1 Hasta n1 Hacer
		si n1 mod i=0 Entonces
			cont=cont+1
		FinSi
	FinPara
	si cont=2 Entonces
		Escribir "es primo"
	SiNo
		Escribir "no es primo"
	FinSi
FinFuncion

