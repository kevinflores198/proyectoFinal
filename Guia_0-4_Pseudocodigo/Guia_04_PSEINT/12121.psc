//Crear un subproceso que rellene dos arreglos 
//de tama�o n, con n�meros aleatorios. Despu�s,
//hacer una funci�n que reciba los dos 
//arreglos y diga si todos sus valores son iguales o no. La
//funci�n debe devolver el resultado 
//de est� validaci�n, para mostrar el mensaje en el algoritmo.
//Nota: recordar el uso de las variables de
//tipo l�gico.
Algoritmo sin_titulo
	definir ma, mb, n Como Entero
	Escribir "Ingrese el tama�o del vector"
	Leer n
	Dimension ma(n), mb(n)
		llenarvector(ma,n)
		llenarvector(mb,n)
		mostrarvector(ma,n)
		mostrarvector(mb,n)
	si esigual(ma,mb,n) Entonces
		Escribir "Los vectores son iguales"
	SiNo
		Escribir "Los vectores no son iguales"
	FinSi
FinAlgoritmo
///---------------------------------------
SubProceso llenarvector(vector, tam)
		definir i Como entero
		para i=0 hasta tam-1 Hacer
			vector(i) = aleatorio(0,100)
		FinPara
FinSubProceso
///---------------------------------------
SubProceso mostrarvector(vector, tam)
	definir i Como entero
	para i=0 hasta tam-1 Hacer
		Escribir "( ", vector(i) " )"Sin Saltar
	FinPara
	Escribir ""
FinSubProceso
///---------------------------------------
Funcion retorno=esigual(b1,b2,num)
	Definir retorno como logico
	definir i Como Entero
	i=0
	mientras b1(i)=b2(i) y i<n-1 Hacer
		i=i+1
	FinMientras
	retorno=(i==num-1)
FinFuncion