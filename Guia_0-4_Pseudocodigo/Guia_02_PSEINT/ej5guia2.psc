//Realizar un programa que pida una frase o palabra y si la frase o palabra es de 4
//caracteres de largo, el programa le concatenara un signo de exclamaci�n al final, y si no
//es de 4 caracteres el programa le concatenara un signo de interrogaci�n al final. El
//programa mostrar� despu�s la frase final. Nota: investigar la funci�n Longitud() y
//Concatenar() de PseInt.
Algoritmo sin_titulo
	
	Definir palabra Como Caracter
	Escribir "Por favor ingrese una palabra de 4 o mas caracteres"
	Leer palabra
	
	Si Longitud(palabra) = 4 Entonces
		Escribir Concatenar(palabra, "!")  //concatenar es como unir
		SiNo
		Escribir Concatenar(palabra, "?")
	Fin Si
FinAlgoritmo
