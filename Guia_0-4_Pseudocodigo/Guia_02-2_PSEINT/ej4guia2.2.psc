Algoritmo sin_titulo
//Teniendo en cuenta que la clave es "eureka", escribir un programa que nos pida ingresar 
//una clave. S�lo se cuenta con 3 intentos para acertar, si fallamos los 3 intentos se deber� 
//mostrar un mensaje indic�ndonos que hemos agotado esos 3 intentos. Si acertamos la 
//clave se deber� mostrar un mensaje que indique que se ha ingresado al sistema 
	//correctamente
	
	Definir clave Como Caracter
	Definir contador Como Entero
	contador = 1
	Repetir
		Escribir "Ingrese contrase�a"
		Leer clave
		clave = Minusculas(clave)
		contador = contador + 1
	Mientras Que clave <> "eureka" y contador <= 3
	Si clave = "eureka" Entonces
		Escribir "Tu clave es correcta"
	SiNo
		Escribir "haz intentado escribir tu clave 3 veces, tienes un limite hasta 3, intenta en una hora"
	FinSi
FinAlgoritmo
