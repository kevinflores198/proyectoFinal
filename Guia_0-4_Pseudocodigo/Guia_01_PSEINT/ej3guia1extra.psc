//Escribir un programa que calcule el volumen de un cilindro. Para ello se deberá solicitar al
//	usuario que ingrese el radio y la altura. Mostrar el resultado por pantalla.
//	volumen = n * radio2 * altura 
Algoritmo ej3guia1
	Definir vol, rad, alt, rta Como Real
	Escribir "Por favor ingrese el radio y la altura del cilindro"
	Leer rad, alt
	vol = PI * rad^2 * alt
	Escribir "El cilindro tiene un volumen de ", vol
FinAlgoritmo
