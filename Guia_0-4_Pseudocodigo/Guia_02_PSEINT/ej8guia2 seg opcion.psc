//Continuando el ejercicio anterior, ahora se pedirá una frase o palabra y se validara si la
//primera letra de la frase es igual a la última letra de la frase. Se deberá de imprimir un
//mensaje por pantalla que diga "CORRECTO", en caso contrario, se deberá imprimir
//"INCORRECTO".

Algoritmo sin_titulo
	Definir frase Como Caracter
	Escribir "Escriba una frase que comience y termine con la misma letra"
	Leer frase
	
	frase = Mayusculas(frase)
	Si SubCadena(frase,0,0) = SubCadena(frase,Longitud(frase)-1,Longitud(frase)-1) Entonces
	Escribir 'Correcto, la frase comienza y termina con el mismo digito'
	SiNo
		Escribir 'Incorrecto, la frase necesita comenzar con el mismo digito que con el que termina'
	FinSi
	
FinAlgoritmo
