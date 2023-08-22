Algoritmo edades
	Definir edad1,edad2,edad3 Como Entero
	Definir promedio Como Real
	Definir apellido Como Caracter
	definir iguales, mayoredad Como caracter
	
	Escribir "Por favor ingrese el apellido de los hermanos"
	leer apellido
	Escribir "Por favor ingrese las edades de los 3 hermanos"
	leer edad1, edad2, edad3
	promedio = (edad1 + edad2 + edad3 ) / 3
	Escribir "El promedio de la edad de los 3 hermanos ", apellido " es " , promedio
	Si edad1 < promedio Entonces
		Escribir "La edad de hermano 1 es menor a ", promedio
	SiNo
		Escribir "La edad de hermano 1 es mayor a ", promedio
	FinSi
	Si edad2 < promedio Entonces
		Escribir "La edad de hermano 2 es menor a ", promedio
	SiNo
		Escribir "La edad de hermano 2 es mayor a ", promedio
	FinSi
	Si edad3 < promedio Entonces
		Escribir "La edad de hermano 3 es menor a ", promedio
	SiNo
		Escribir "La edad de hermano 3 es mayor a ", promedio
	FinSi
	
FinAlgoritmo
