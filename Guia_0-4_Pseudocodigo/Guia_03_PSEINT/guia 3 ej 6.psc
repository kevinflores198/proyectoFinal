Algoritmo sin_titulo
	definir n1, n2 Como Entero
	Escribir "ingrese dos numeros"
	leer n1, n2 
	inter(n1,n2)
	Escribir "el primer numero es: " n1 " y el segundo " n2
FinAlgoritmo

SubProceso inter(n1 Por Referencia,n2 Por Referencia)
	Definir aux Como Entero
	aux=n1
	n1=n2
	n2=aux
FinSubProceso
