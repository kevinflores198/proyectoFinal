//Realizar un programa que pida tres notas y determine si un alumno aprueba o reprueba un
//curso, sabiendo que aprobará el curso si su promedio de tres calificaciones es mayor o
//igual a 70; y reprueba en caso contrario.

Algoritmo ej1guia2_extras
	
	definir nota1,nota2,nota3, prom Como Real
	Escribir "Por favor introduzca la primer nota del alumno"
	Leer nota1
	Escribir "Por favor introduzca la segunda nota del alumno"
	Leer nota2
	Escribir "Por favor introduzca la tercer nota del alumno"
	Leer nota3

	prom = nota1+nota2+nota3/100
	
	Si prom >= 70 Entonces
		Escribir "El alumno ha aprobado el curso"
		SiNo
		Escribir "El alumno no ha aprobado el curso"
	FinSi
FinAlgoritmo
