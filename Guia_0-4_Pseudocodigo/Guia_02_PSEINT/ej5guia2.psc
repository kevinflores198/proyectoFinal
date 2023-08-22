//Realizar un programa que pida una frase o palabra y si la frase o palabra es de 4
//caracteres de largo, el programa le concatenara un signo de exclamación al final, y si no
//es de 4 caracteres el programa le concatenara un signo de interrogación al final. El
//programa mostrará después la frase final. Nota: investigar la función Longitud() y
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
