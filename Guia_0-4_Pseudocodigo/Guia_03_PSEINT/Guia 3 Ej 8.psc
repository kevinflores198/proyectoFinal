Algoritmo sin_titulo
	Definir num1, num2 Como Entero
	Escribir "Ingrese el Dividendo."
	leer num1
	Escribir "Ingrese el Divisor."
	leer num2
	restas(num1, num2)	
FinAlgoritmo

SubProceso restas(num1, num2)
	definir cont Como Entero
	cont = 0
	mientras ((num1 - num2) >= num2) o (num1 >= num2) Hacer
		num1 = num1 - num2 
		cont = cont +1
	FinMientras
	Escribir "El residuo es: " num1
	Escribir "El cociente es: " cont
FinSubProceso
