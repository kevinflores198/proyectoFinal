//Escriba un programa que pida 3 notas y valide si esas notas est�n entre 1 y 10. Si est�n
//entre esos par�metros se debe poner en verdadero una variable de tipo l�gico y si no
//ponerla en falso. Al final el programa debe decir si las 3 notas son correctas usando la
//variable de tipo l�gico.

Algoritmo Ej6guia2
	
	Definir n1, n2, n3 Como Real
	Definir aux Como Logico
	Escribir "Por favor ingrese 3 notas"
	Leer n1, n2, n3
	aux = (n1>=1) y (n2>=1) y (n3>=1) y (n1 <= 10) y (n2 <= 10) y (n3 <= 10)
	Si aux Entonces
		Escribir "VERDADERO"
		SiNo
		Escribir "FALSO"
	FinSi
FinAlgoritmo
