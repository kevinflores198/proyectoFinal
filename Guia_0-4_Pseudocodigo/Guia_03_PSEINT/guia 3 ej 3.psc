//Crea una funci�n EsMultiplo que reciba los dos n�meros pasados por el usuario, validando
//que el primer n�mero m�ltiplo del segundo y devuelva verdadero si el primer n�mero es
//m�ltiplo del segundo, sino es m�ltiplo que devuelva falso.

Algoritmo sin_titulo
	Definir n1, n2, resultado Como Entero
	Definir letra Como Logico
	Escribir "ingrese dos numeros"
	Leer n1, n2
	resultado = divi(n1,n2)
	si resultado = 0 Entonces
		letra = Verdadero
		Escribir "es multiplo " letra
	SiNo
		letra = Falso
		Escribir "no es multiplo" letra
	FinSi
FinAlgoritmo

Funcion multi = divi(n1, n2)
	Definir multi Como Real
	multi = n1 mod n2
FinFuncion
	