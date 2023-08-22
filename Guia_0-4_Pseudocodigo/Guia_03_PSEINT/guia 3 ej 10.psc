Funcion f <- suma ( n )
	Definir f Como Entero
	si n>0
		f= suma (n-1) + n
	SiNo
		f=0
	FinSi
Fin Funcion

Algoritmo sin_titulo
	Definir n Como Entero
	leer n
	Escribir "suma de los naturales es ", suma(n)
FinAlgoritmo

